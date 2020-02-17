package com.service.rest.productservice.api.discount;


import java.math.BigDecimal;

public interface DiscountStrategy {
    BigDecimal calculateDiscount(BigDecimal price);
}
