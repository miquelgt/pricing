package com.miquelgt.pricing.services;

import com.miquelgt.pricing.entities.Pricing;
import com.miquelgt.pricing.respositories.PricingRepository;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public class TestPricingRepository implements PricingRepository {
    @Override
    public Flux<Pricing> findPriceBy(Long productId, Long brandId, LocalDateTime applicationDate) {
        return null;
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
