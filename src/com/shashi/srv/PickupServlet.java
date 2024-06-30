package com.shashi.srv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashi.service.PickupService;
//import com.shashi.service.impl.PickupServiceImpl;

/**
 * Servlet implementation class PickupServlet
 */
@WebServlet("/PickupServlet")
public class PickupServlet extends HttpServlet {
    private PickupService pickupService;

    public PickupServlet() {
        super(); // Inject an instance of PickupServiceImpl
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Handle GET requests
        String orderId = request.getParameter("orderId");
        boolean isReadyForPickup = pickupService.updatePickupStatus(orderId, true);
        if (isReadyForPickup) {
            pickupService.notifyCustomerForPickup(orderId);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Handle POST requests
        String orderId = request.getParameter("orderId");
        boolean isReadyForPickup = Boolean.parseBoolean(request.getParameter("isReadyForPickup"));
        pickupService.updatePickupStatus(orderId, isReadyForPickup);
    }
}