package com.miquelgt.pricing.api.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PriceRequest {
    private LocalDateTime applicationDate;
    private Long          productId;
    private Long          brandId;

}
