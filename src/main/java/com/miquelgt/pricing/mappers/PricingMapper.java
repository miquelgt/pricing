package com.miquelgt.pricing.mappers;

import com.miquelgt.pricing.api.models.PriceResponse;
import com.miquelgt.pricing.entities.Pricing;
import org.mapstruct.Mapper;

@Mapper
public interface PricingMapper {

    PriceResponse toResponse(Pricing pricing);
}
