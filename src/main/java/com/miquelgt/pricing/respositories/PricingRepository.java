package com.miquelgt.pricing.respositories;

import com.miquelgt.pricing.entities.Pricing;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Repository
public interface PricingRepository extends ReactiveCrudRepository<Pricing, Long> {

    @Query("""
            SELECT * FROM PRICING P
            WHERE P.BRAND_ID = :brandId
            AND P.PRODUCT_ID = :productId
            AND :applicationDate BETWEEN P.START_DATE AND P.END_DATE
            ORDER BY P.PRIORITY DESC
            LIMIT 1
            """)
    Mono<Pricing> findPriceBy(Long productId, Long brandId, LocalDateTime applicationDate);
}
