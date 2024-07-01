package com.shashi.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shashi.beans.OrderBean;
import com.shashi.service.OrderDAO;
import com.shashi.utility.DBUtil;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public List<OrderBean> getAllOrders() {
        List<OrderBean> orders = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.provideConnection();
            String sql = "SELECT * FROM orders";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String orderId = resultSet.getString("orderid");
                String transactionId = resultSet.getString("transaction_id");
                String productId = resultSet.getString("product_id");
                int quantity = resultSet.getInt("quantity");
                int readyForPickup = resultSet.getInt("ready_for_pickup");
                double amount = resultSet.getDouble("amount");
                int shipped = resultSet.getInt("shipped");

                OrderBean order = new OrderBean(orderId, transactionId, productId, quantity, readyForPickup, amount);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }

        return orders;
    }

    @Override
    public OrderBean getOrderByID(String orderId) {
        OrderBean order = null;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.provideConnection();
            String sql = "SELECT * FROM orders WHERE order_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, orderId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String transactionId = resultSet.getString("transaction_id");
                String productId = resultSet.getString("product_id");
                int quantity = resultSet.getInt("quantity");
                int readyForPickup = resultSet.getInt("ready_for_pickup");
                double amount = resultSet.getDouble("amount");
                int shipped = resultSet.getInt("shipped");

                order = new OrderBean(orderId, transactionId, productId, quantity, readyForPickup, amount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }

        return order;
    }

    @Override
    public void updateOrder(OrderBean order) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBUtil.provideConnection();
            String sql = "UPDATE orders SET transaction_id = ?, product_id = ?, quantity = ?, pickup = ?, amount = ?, shipped = ? WHERE order_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, order.getTransactionId());
            statement.setString(2, order.getProductId());
            statement.setInt(3, order.getQuantity());
            statement.setInt(4, order.getPickup());
            statement.setDouble(5, order.getAmount());
            statement.setInt(6, order.getShipped());
            statement.setString(7, order.getOrderId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }
}
