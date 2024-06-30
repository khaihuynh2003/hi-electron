package com.shashi.service;

public interface PickupService {
    boolean updatePickupStatus(String orderId, boolean isReadyforPickup);
    void notifyCustomerForPickup(String orderId);
}
