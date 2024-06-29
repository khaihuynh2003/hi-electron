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
	private boolean readyForPickup;
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

	public OrderBean(String transactionId, String productId, int quantity, Double amount, int shipped) {
		super();
		this.transactionId = transactionId;
		this.productId = productId;
		this.quantity = quantity;
		this.amount = amount;
		this.shipped = shipped;
	}
	public OrderBean(String orderId, String transactionId, String productId, int quantity, boolean readyForPickup,
					 double amount){
		super();
		this.orderId = orderId;
		this.transactionId = transactionId;
		this.productId = productId;
		this.quantity = quantity;
		this.readyForPickup = readyForPickup;
		this.amount = amount;
	}
	public OrderBean(String orderId, String transactionId, String productId, int quantity, boolean readyForPickup,
					 double amount, String customerEmail){
		super();
		this.orderId = orderId;
		this.transactionId = transactionId;
		this.productId = productId;
		this.quantity = quantity;
		this.readyForPickup = readyForPickup;
		this.amount = amount;
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

	public String getOrderId() { return orderId;}

	public boolean getPickupStatus() {return readyForPickup; }

	public void setReadyForPickup(boolean readyForPickup){
		this.readyForPickup = readyForPickup;
	}

	public String getCustomerEmail(){
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail){
		this.customerEmail = customerEmail;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public int getShipped() {
		return shipped;
	}
	public void setShipped(int shipped) {
		this.shipped = shipped;
	}

}
