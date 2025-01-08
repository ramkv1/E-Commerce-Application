package com.ecommerce.entity.enums;

public enum ProductAvailability {
    IN_STOCK,        // Product is available in stock
    OUT_OF_STOCK,    // Product is currently unavailable
    LIMITED_STOCK,   // Product is available but in limited quantity
    PRE_ORDER,       // Product is not yet available but can be pre-ordered
    DISCONTINUED;    // Product is no longer available for sale

    // Optionally, add a user-friendly message or additional methods
    public String getFriendlyMessage() {
        switch (this) {
            case IN_STOCK:
                return "The product is available for purchase.";
            case OUT_OF_STOCK:
                return "The product is currently out of stock.";
            case LIMITED_STOCK:
                return "Hurry! Only a few items left in stock.";
            case PRE_ORDER:
                return "The product is available for pre-order.";
            case DISCONTINUED:
                return "This product is no longer available.";
            default:
                return "Unknown availability status.";
        }
    }
}

