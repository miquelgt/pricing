package com.miquelgt.pricing.exceptions;

public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException() {
        super("Price not found exception");
    }
}
