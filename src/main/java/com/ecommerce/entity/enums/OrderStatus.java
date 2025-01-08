package com.ecommerce.entity.enums;

public enum OrderStatus {
    NEW,          // Order has been created but not yet processed
    PROCESSING,   // Order is currently being processed
    SHIPPED,      // Order has been shipped to the customer
    DELIVERED,    // Order has been delivered successfully
    CANCELLED,    // Order was cancelled
    RETURNED;     // Order was returned by the customer

    // Optionally, you can add a user-friendly message or additional methods
    public String getFriendlyMessage() {
        switch (this) {
            case NEW:
                return "Your order is created and will be processed soon.";
            case PROCESSING:
                return "Your order is currently being processed.";
            case SHIPPED:
                return "Your order is on its way!";
            case DELIVERED:
                return "Your order has been delivered successfully.";
            case CANCELLED:
                return "Your order has been cancelled.";
            case RETURNED:
                return "Your order has been returned.";
            default:
                return "Unknown order status.";
        }
    }
}

