package com.miquelgt.pricing.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Pricing {
    @Id
    @Column("PRICE_LIST")
    private Long          priceId;
    @Column("BRAND_ID")
    private Long          brandId;
    @Column("START_DATE")
    private LocalDateTime startDate;
    @Column("END_DATE")
    private LocalDateTime endDate;
    @Column("PRODUCT_ID")
    private Long          productId;
    @Column("PRIORITY")
    private Long          priority;
    @Column("PRICE")
    private BigDecimal    price;
    @Column("CURR")
    private String        currency;
}
