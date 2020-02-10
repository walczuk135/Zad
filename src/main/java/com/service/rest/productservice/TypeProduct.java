package com.service.rest.productservice;

public enum TypeProduct {
    MALE("MALE",5),FEMALE("FEMALE",5),KID("KID",10);


    TypeProduct(String type, double discount) {
        this.type = type;
        this.discount = discount;
    }

    public String type;
    public double discount;

}
