package com.service.rest.productservice.api.discount.discountType;

import com.service.rest.productservice.api.TypeProduct;
import com.service.rest.productservice.api.discount.DiscountStrategy;

interface DiscountStrategyType extends DiscountStrategy {
    TypeProduct getType();
}
