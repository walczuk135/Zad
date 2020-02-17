package com.service.rest.productservice.api.discount.discountType;

import com.service.rest.productservice.api.TypeProduct;

class TypeNotFoundException extends RuntimeException {
    public TypeNotFoundException(TypeProduct type) {
        super("Discount for: " + type + " has not been found.");
    }
}
