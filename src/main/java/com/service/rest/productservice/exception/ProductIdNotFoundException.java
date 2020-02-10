package com.service.rest.productservice.exception;

public class ProductIdNotFoundException extends RuntimeException {
    public ProductIdNotFoundException(Long id) {
        super("Could not find product by id "+id);
    }
}
