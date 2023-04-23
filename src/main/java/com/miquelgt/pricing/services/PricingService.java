package com.miquelgt.pricing.services;

import com.miquelgt.pricing.api.models.PriceRequest;
import com.miquelgt.pricing.entities.Pricing;
import com.miquelgt.pricing.respositories.PricingRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@Service
public class PricingService {
    private final PricingRepository pricingRepository;

    public PricingService(PricingRepository pricingRepository) {
        this.pricingRepository = pricingRepository;
    }

    public Mono<Pricing> findPriceToApply(PriceRequest priceRequest) {
        return pricingRepository.findPriceBy(priceRequest.getProductId(), priceRequest.getBrandId(), priceRequest.getApplicationDate())
                .sort(higher())
                .next();
    }

    private static Comparator<Pricing> higher() {
        return (o1, o2) -> o2.getPriority().compareTo(o1.getPriority());
    }

}
