package com.service.rest.productservice.api.dto;


import com.service.rest.productservice.api.TypeProduct;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

public class ProductDto {
    private String name;
    private String description;
    private TypeProduct type;
    @DecimalMin(value="0.01")
    private BigDecimal price;
    private long count;

    public ProductDto(String name, String description, TypeProduct type, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
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
