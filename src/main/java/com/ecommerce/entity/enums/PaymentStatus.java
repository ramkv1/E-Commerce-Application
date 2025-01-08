package com.ecommerce.entity.enums;

public enum PaymentStatus {
    PENDING,    // Payment is yet to be completed
    COMPLETED,  // Payment is successfully completed
    FAILED,     // Payment failed during processing
    CANCELLED,  // Payment was cancelled by the user
    REFUNDED;   // Payment was refunded to the user

    // Optionally, you can add custom behavior, like a user-friendly message.
    public String getPaymentMessage() {
        switch (this) {
            case PENDING:
                return "Your payment is pending.";
            case COMPLETED:
                return "Your payment was successful.";
            case FAILED:
                return "Payment processing failed. Please try again.";
            case CANCELLED:
                return "Your payment was cancelled.";
            case REFUNDED:
                return "Your payment has been refunded.";
            default:
                return "Unknown payment status.";
        }
    }
}

