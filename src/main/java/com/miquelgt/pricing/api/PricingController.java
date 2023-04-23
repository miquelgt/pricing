package com.miquelgt.pricing.api;

import com.miquelgt.pricing.api.models.PriceRequest;
import com.miquelgt.pricing.api.models.PriceResponse;
import com.miquelgt.pricing.mappers.PricingMapper;
import com.miquelgt.pricing.services.PricingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pricing")
public class PricingController {
    private final PricingService pricingService;
    private final PricingMapper  pricingMapper;


    @GetMapping
    public Mono<ResponseEntity<PriceResponse>> getPrice(PriceRequest priceRequest) {
        return pricingService.findPriceToApply(priceRequest)
                .map(pricingMapper::toResponse)
                .map(ResponseEntity::ok);
    }



}
