package com.service.rest.productservice.dto;


import com.service.rest.productservice.TypeProduct;

import java.math.BigDecimal;

public class ProductDto {
    private String name;
    private String description;
    private TypeProduct type;
    private BigDecimal price;
    private int count;

    public ProductDto(String name, String description, TypeProduct type, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ProductDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.lang.String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeProduct getType() {
        return type;
    }

    
    public void setType(TypeProduct type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
