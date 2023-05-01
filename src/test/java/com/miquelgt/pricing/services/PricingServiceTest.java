package com.miquelgt.pricing.services;

import com.miquelgt.pricing.api.models.PriceRequest;
import com.miquelgt.pricing.entities.Pricing;
import com.miquelgt.pricing.exceptions.PriceNotFoundException;
import com.miquelgt.pricing.respositories.PricingRepository;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

import java.time.LocalDateTime;

class PricingServiceTest {

    private final TestPublisher<Pricing> testPublisher = TestPublisher.create();

    private final PricingService pricingService = new PricingService(new TestPricingRepository(testPublisher.mono()));

    private static PriceRequest priceRequestBuilder() {
        PriceRequest priceRequest = new PriceRequest();
        priceRequest.setBrandId(1L);
        priceRequest.setProductId(1L);
        priceRequest.setApplicationDate(LocalDateTime.now());
        return priceRequest;
    }

    @Test
    void given_a_request_when_pricing_found_in_db_then_return_an_price() {
        StepVerifier.create(pricingService.findPriceToApply(priceRequestBuilder()))
                .then(() -> testPublisher.emit(buiildPricing()))
                .expectNextMatches(pricing -> pricing.getPriceId().equals(1L))
                .verifyComplete();
    }

    @Test
    void given_a_request_when_no_pricing_found_in_db_then_return_an_error() {
        StepVerifier.create(pricingService.findPriceToApply(priceRequestBuilder()))
                .then(testPublisher::emit)
                .expectErrorMatches(throwable -> throwable instanceof PriceNotFoundException)
                .verify();

    }

    private Pricing buiildPricing() {
        Pricing pricing = new Pricing();
        pricing.setPriceId(1L);
        pricing.setEndDate(LocalDateTime.now());
        pricing.setBrandId(1L);
        return pricing;
    }


    private record TestPricingRepository(Mono<Pricing> mono) implements PricingRepository {


        @Override
            public Mono<Pricing> findPriceBy(Long productId, Long brandId, LocalDateTime applicationDate) {
                return mono;
            }
    
            @Override
            public <S extends Pricing> Mono<S> save(S entity) {
                return null;
            }
    
            @Override
            public <S extends Pricing> Flux<S> saveAll(Iterable<S> entities) {
                return null;
            }
    
            @Override
            public <S extends Pricing> Flux<S> saveAll(Publisher<S> entityStream) {
                return null;
            }
    
            @Override
            public Mono<Pricing> findById(Long aLong) {
                return null;
            }
    
            @Override
            public Mono<Pricing> findById(Publisher<Long> id) {
                return null;
            }
    
            @Override
            public Mono<Boolean> existsById(Long aLong) {
                return null;
            }
    
            @Override
            public Mono<Boolean> existsById(Publisher<Long> id) {
                return null;
            }
    
            @Override
            public Flux<Pricing> findAll() {
                return null;
            }
    
            @Override
            public Flux<Pricing> findAllById(Iterable<Long> longs) {
                return null;
            }
    
            @Override
            public Flux<Pricing> findAllById(Publisher<Long> idStream) {
                return null;
            }
    
            @Override
            public Mono<Long> count() {
                return null;
            }
    
            @Override
            public Mono<Void> deleteById(Long aLong) {
                return null;
            }
    
            @Override
            public Mono<Void> deleteById(Publisher<Long> id) {
                return null;
            }
    
            @Override
            public Mono<Void> delete(Pricing entity) {
                return null;
            }
    
            @Override
            public Mono<Void> deleteAllById(Iterable<? extends Long> longs) {
                return null;
            }
    
            @Override
            public Mono<Void> deleteAll(Iterable<? extends Pricing> entities) {
                return null;
            }
    
            @Override
            public Mono<Void> deleteAll(Publisher<? extends Pricing> entityStream) {
                return null;
            }
    
            @Override
            public Mono<Void> deleteAll() {
                return null;
            }
        }
}