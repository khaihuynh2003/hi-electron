package com.shashi.service.impl;

import com.shashi.beans.OrderBean;
import com.shashi.service.OrderDAO;
import com.shashi.service.PickupService;
import com.shashi.utility.DBUtil;
import com.shashi.utility.JavaMailUtil;
import com.shashi.utility.MailMessage;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PickupServiceImpl implements PickupService {

    private OrderDAO orderDAO;
    public PickupServiceImpl(){
        this.orderDAO = orderDAO;
    }
    @Override
    public boolean updatePickupStatus(String orderId, boolean isReadyForPickup){
        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;
        boolean isUpdated = false;

        try {
            ps = con.prepareStatement("UPDATE orders SET readyForPickup = ? WHERE orderId = ?");
            ps.setBoolean(1, isReadyForPickup);
            ps.setString(2, orderId);
            int rowsUpdated = ps.executeUpdate();
            isUpdated = (rowsUpdated > 0);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(con);
        }
        return isUpdated;
    }
    public void notifyCustomerForPickup(String orderId){
        String subject = "Your order is ready for pickup";
        String customerEmail = retrieveCustomerEmail(orderId);
        String htmlTextMessage = "Dear customer,<br>"
                + "Your order with the ID " + orderId + " is ready for pickup at our store.<br>"
                + "We're open from 08:00 to 16:30.<br>"
                + "Thank you for choosing Exotic Electronics.";

        MailMessage.sendMessage(customerEmail, subject, htmlTextMessage);
    }
    private String retrieveCustomerEmail(String orderId){
        OrderBean order = orderDAO.getOrderByID(orderId);
        String customerEmail = order.getCustomerEmail();

        return customerEmail;
    }
}

