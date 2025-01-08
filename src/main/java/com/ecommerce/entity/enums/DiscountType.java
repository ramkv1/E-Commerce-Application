package com.ecommerce.entity.enums;

public enum DiscountType {
    NO_DISCOUNT,        // No discount is available
    PERCENTAGE,         // Discount is based on a percentage of the product price
    FLAT_AMOUNT,        // A fixed amount is reduced from the product price
    BUY_ONE_GET_ONE,    // Buy one product and get another free
    SEASONAL,           // Seasonal discount (e.g., during festivals or sales events)
    CLEARANCE;          // Discount for clearance or end-of-stock sales

    // Optionally, add a user-friendly message or additional methods
    public String getDescription() {
        switch (this) {
            case NO_DISCOUNT:
                return "No discounts available on this product.";
            case PERCENTAGE:
                return "Enjoy a percentage-based discount!";
            case FLAT_AMOUNT:
                return "Get a fixed discount on this product.";
            case BUY_ONE_GET_ONE:
                return "Buy one and get one free offer.";
            case SEASONAL:
                return "Limited-time seasonal discount!";
            case CLEARANCE:
                return "Clearance sale! Discounts for stock clearance.";
            default:
                return "Unknown discount type.";
        }
    }
}

