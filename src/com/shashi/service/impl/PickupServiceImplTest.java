package com.shashi.service.impl;

import org.junit.jupiter.api.*;

import java.sql.SQLException;

//import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PickupServiceImplTest {

    private PickupServiceImpl pickupService;

    @BeforeAll

    @Test
    public void testUpdatePickupStatus() throws SQLException {
        String orderId = "123";
        boolean isReadyForPickup = pickupService.updatePickupStatus(orderId, true);
        assertTrue(isReadyForPickup);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void updatePickupStatus() {
    }

    @Test
    void notifyCustomerForPickup() {
    }
}