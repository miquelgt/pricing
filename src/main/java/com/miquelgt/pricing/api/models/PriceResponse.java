package com.miquelgt.pricing.api.models;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PriceResponse {
    private Long          priceId;
    private Long          brandId;
    private BigDecimal    price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    
}
