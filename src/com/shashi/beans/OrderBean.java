package com.shashi.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrderBean implements Serializable {

	private String orderId;
	private String transactionId;
	private String productId;
	private int quantity;
	private Double amount;
	private int shipped;
	private int pickup;
	private String customerEmail;

	public OrderBean() {
		super();
	}

	public OrderBean(String transactionId, String productId, int quantity, Double amount) {
		super();
		this.transactionId = transactionId;
		this.productId = productId;
		this.quantity = quantity;
		this.amount = amount;
		this.shipped = 0;
	}

	public OrderBean(String orderId, String transactionId, String productId, int quantity, int pickup,
					 double amount, String customerEmail){
		super();
		this.orderId = orderId;
		this.transactionId = transactionId;
		this.productId = productId;
		this.quantity = quantity;
		this.pickup = pickup;
		this.amount = amount;
		this.customerEmail = customerEmail;
	}
	public OrderBean(String transactionId, String productId, int quantity, Double amount, int shipped) {
		super();
		this.transactionId = transactionId;
		this.productId = productId;
		this.quantity = quantity;
		this.amount = amount;
		this.shipped = shipped;
	}
	public OrderBean(String orderId, String transactionId, String productId, int quantity, int pickup,
					 double amount){
		super();
		this.orderId = orderId;
		this.transactionId = transactionId;
		this.productId = productId;
		this.quantity = quantity;
		this.pickup = pickup;
		this.amount = amount;
	}
	public OrderBean(String orderId, String transactionId, String productId, int quantity, double amount,
					 int shipped, int pickup, String customerEmail){
		super();
		this.orderId = orderId;
		this.transactionId = transactionId;
		this.productId = productId;
		this.quantity = quantity;
		this.amount = amount;
		this.shipped = shipped;
		this.pickup = pickup;
		this.customerEmail = customerEmail;
	}


	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getOrderId() { return orderId; }

	public String getCustomerEmail(){
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail){
		this.customerEmail = customerEmail;
	}

	public int getShipped() {
		return shipped;
	}

	public void setShipped(int shipped) {
		this.shipped = shipped;
	}

	public int getPickup() {return pickup; }

	public void setPickup(int pickup){
		this.pickup = pickup;
	}

}
