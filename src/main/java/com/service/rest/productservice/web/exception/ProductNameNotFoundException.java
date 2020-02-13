package com.service.rest.productservice.web.exception;

public class ProductNameNotFoundException extends RuntimeException {
    public ProductNameNotFoundException(String name) {
        super("Could not find product by name " + name);
    }
}
