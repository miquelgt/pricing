package com.miquelgt.pricing.services;


import com.miquelgt.pricing.api.models.PriceRequest;
import com.miquelgt.pricing.entities.Pricing;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;
import java.util.List;

class PricingServiceTest {


    private static Pricing buildPricing(long priceId, long priority) {
        Pricing pricing = new Pricing();
        pricing.setPriceId(priceId);
        pricing.setPriority(priority);
        return pricing;
    }

    @Test
    void given_pricing_request_when_repository_returns_two_prices_then_return_the_one_with_higher_priority() {

        TestRepository pricingRepository = new TestRepository(
                List.of(buildPricing(1L, 0L), buildPricing(2L, 1L))
        );

        PricingService pricingService = new PricingService(pricingRepository);

        StepVerifier.create(pricingService.findPriceToApply(new PriceRequest()))
                .expectNextMatches(pricing -> pricing.getPriceId().equals(2L))
                .verifyComplete();
    }

    private static class TestRepository extends TestPricingRepository {

        private final List<Pricing> prices;

        private TestRepository(List<Pricing> prices) {
            this.prices = prices;
        }

        @Override
        public Flux<Pricing> findPriceBy(Long productId, Long brandId, LocalDateTime applicationDate) {
            return Flux.fromIterable(prices);
        }
    }
}