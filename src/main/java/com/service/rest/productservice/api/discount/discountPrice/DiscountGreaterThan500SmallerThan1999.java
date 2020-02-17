package com.service.rest.productservice.api.discount.discountPrice;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class DiscountGreaterThan500SmallerThan1999 implements DiscountStrategyPrice {
    private String discount="0.03";

    @Override
    public BigDecimal calculateDiscount(BigDecimal price) {
        return price.compareTo(new BigDecimal("500")) > 0
                && price.compareTo(new BigDecimal("1999"))<0 ? price.subtract(new BigDecimal(discount).multiply(price)) : price;
    }




}
