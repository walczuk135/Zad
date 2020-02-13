package com.service.rest.productservice.api.discount;

import com.service.rest.productservice.api.TypeProduct;

import java.math.BigDecimal;

interface DiscountStrategy {
    BigDecimal calculateDiscount(BigDecimal price);
    void setDiscount(double discount);//Zakładamy że rabat kiedyś może się zmienić
    TypeProduct getType();
}
