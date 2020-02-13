package com.service.rest.productservice.api;

public enum TypeProduct {
    MALE("MALE"),FEMALE("FEMALE"),KID("KID");


    TypeProduct(String type) {
        this.type = type;
    }

    public String type;

}
