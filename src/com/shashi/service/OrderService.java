package com.shashi.service;

import java.util.List;

import com.shashi.beans.OrderBean;
import com.shashi.beans.OrderDetails;
import com.shashi.beans.TransactionBean;

public interface OrderService {

	public String paymentSuccess(String userName, double paidAmount, boolean pickup);

	public boolean addOrder(OrderBean order);

	public boolean addTransaction(TransactionBean transaction);

	public int countSoldItem(String prodId);

	public List<OrderBean> getAllOrders();

	public List<OrderBean> getOrdersByUserId(String emailId);

	public List<OrderDetails> getAllOrderDetails(String userEmailId);

	public String shipNow(String orderId, String prodId);

	public void updatePickupSelected(String orderId, String prodId);

//	public OrderBean getOrderByID(int orderID);

//	void updateOrderPickupStatus(int orderID, boolean isReadyForPickup);
}
