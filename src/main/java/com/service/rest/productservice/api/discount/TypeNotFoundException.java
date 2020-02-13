package com.service.rest.productservice.api.discount;

import com.service.rest.productservice.api.TypeProduct;

public class TypeNotFoundException extends RuntimeException {
    public TypeNotFoundException(TypeProduct type) {
        super("Discount for: " + type + " has not been found.");
    }
}
