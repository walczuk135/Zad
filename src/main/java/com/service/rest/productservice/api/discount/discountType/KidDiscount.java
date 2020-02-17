package com.service.rest.productservice.api.discount.discountType;

import com.service.rest.productservice.api.TypeProduct;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class KidDiscount implements DiscountStrategyType {
    private String discount="0.10";

    @Override
    public BigDecimal calculateDiscount(BigDecimal price) {
        return price.subtract(price.multiply(new BigDecimal(discount)));
    }



    @Override
    public TypeProduct getType() {
        return TypeProduct.KID;
    }
}
