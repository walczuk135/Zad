package com.service.rest.productservice.api.discount;

public class DuplicatedDiscountsStrategyException extends RuntimeException {
    public DuplicatedDiscountsStrategyException(Object l, Object r) {
        super("Found duplicated strategies assigned to one discount type value: " + l.getClass() + " " + r.getClass());
    }
}
