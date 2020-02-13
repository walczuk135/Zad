package com.service.rest.productservice.api.discount;

import com.service.rest.productservice.api.TypeProduct;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class MaleDiscount implements DiscountStrategy {
    private double discount=0.05;

    @Override
    public BigDecimal calculateDiscount(BigDecimal price) {
        return price.subtract(price.multiply(new BigDecimal(discount)));
    }

    @Override
    public void setDiscount(double discount) {
        this.discount=discount;
    }

    @Override
    public TypeProduct getType() {
        return TypeProduct.MALE;
    }
}
