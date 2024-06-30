package com.shashi.service;

import java.util.List;
import com.shashi.beans.OrderBean;
public interface OrderDAO {
    List<OrderBean> getAllOrders();
    OrderBean getOrderByID(String orderId);
    void updateOrder(OrderBean order);
}
