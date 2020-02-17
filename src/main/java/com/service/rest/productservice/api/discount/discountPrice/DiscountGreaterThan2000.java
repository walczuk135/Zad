package com.service.rest.productservice.api.discount.discountPrice;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class DiscountGreaterThan2000 implements DiscountStrategyPrice{
    private final String discount="0.05";

    @Override
    public BigDecimal calculateDiscount(BigDecimal price) {
        return price.compareTo(new BigDecimal("1999")) > 0 ? price.subtract(new BigDecimal(discount).multiply(price)): price;
    }


}
