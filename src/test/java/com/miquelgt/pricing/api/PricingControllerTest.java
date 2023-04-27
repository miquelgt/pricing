package com.miquelgt.pricing.api;

import com.miquelgt.pricing.api.models.PriceResponse;
import com.miquelgt.pricing.exceptions.ErrorDTO;
import com.miquelgt.pricing.mappers.PricingMapper;
import com.miquelgt.pricing.services.PricingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.function.Function;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PricingControllerTest {

    @Autowired
    private PricingMapper  pricingMapper;
    @Autowired
    private PricingService pricingService;
    @Autowired
    private WebTestClient  webClient;

    private static Function<UriBuilder, URI> getUriBuilderURIFunction(String applicationDate) {
        return uriBuilder -> uriBuilder.path("/pricing")
                .queryParam("brandId", "1")
                .queryParam("productId", "35455")
                .queryParam("applicationDate", applicationDate)
                .build();
    }

    @Test
    void given_a_date_when_returns_only_one_result_return_then_return_this_price() {
        Long princeId = getPriceId("2020-06-14T10:00:00");

        Assertions.assertEquals(1, princeId);

    }

    @Test
    void given_a_date_when_returns_multiple_results_then_return_the_higher_priority() {
        Long princeId = getPriceId("2020-06-14T16:00:00");

        Assertions.assertEquals(2, princeId);
    }


    @Test
    void given_a_date_only_prices_between_dates_should_be_returned() {
        Long princeId = getPriceId("2020-06-14T21:00:00");

        Assertions.assertEquals(1, princeId);
    }

    @Test
    void given_a_date_when_returns_multiple_results_between_date_ranges_then_return_the_higher_priority() {
        Long princeId = getPriceId("2020-06-15T10:00:00");

        Assertions.assertEquals(3, princeId);
    }

    @Test
    void given_a_date_when_returns_multiple_results_between_date_time_ranges_then_return_the_higher_priority() {
        Long princeId = getPriceId("2020-06-16T21:00:00");

        Assertions.assertEquals(4, princeId);

    }

    @Test
    void given_a_request_when_not_return_prices_then_we_should_get_an_error() {
        ErrorDTO result = webClient.get()
                .uri(getUriBuilderURIFunction("2025-06-16T21:00:00"))
                .exchange()
                .expectBody(ErrorDTO.class)
                .returnResult()
                .getResponseBody();
        Assertions.assertEquals(500, result.getStatus());
        Assertions.assertEquals("Price not found exception", result.getMessage());
    }


    private Long getPriceId(String date) {
        return webClient.get()
                .uri(getUriBuilderURIFunction(date))
                .exchange()
                .expectBody(PriceResponse.class)
                .returnResult()
                .getResponseBody()
                .getPriceId();
    }


}