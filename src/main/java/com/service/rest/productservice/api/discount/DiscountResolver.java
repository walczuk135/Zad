package com.service.rest.productservice.api.discount;

import com.service.rest.productservice.api.dto.ProductDto;

import java.math.BigDecimal;

@FunctionalInterface
public interface DiscountResolver {
    BigDecimal calculateProductDiscount(ProductDto productDto);

}
