package com.miquelgt.pricing.exceptions;

public class PriceNotFoundException extends RuntimeException {

    public static final String PRICE_NOT_FOUND_EXCEPTION = "Price not found exception";

    public PriceNotFoundException() {
        super(PRICE_NOT_FOUND_EXCEPTION);
    }
}
