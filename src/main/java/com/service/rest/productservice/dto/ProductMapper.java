package com.service.rest.productservice.dto;

import com.service.rest.productservice.TypeProduct;
import com.service.rest.productservice.db.ProductRow;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;

public class ProductMapper {
    public static ProductRow productDtoToProductRow(ProductDto productDto){
        ProductRow productRow=new ProductRow();
        productRow.setName(productDto.getName());
        productRow.setDescription(productDto.getDescription());
        productRow.setPrice(productDto.getPrice());
        productRow.setType(productDto.getType());
        productRow.setCreateDate(LocalDate.now());
        productRow.setCount(productDto.getCount());
        return productRow;
    }

    public static ProductDto productRowToProductDto(ProductRow productRow){
        ProductDto productDto=new ProductDto();
        productDto.setName(productRow.getName());
        productDto.setDescription(productRow.getDescription());
        productDto.setPrice(productRow.getPrice().subtract(new BigDecimal(productRow.getType().discount/100).multiply(productRow.getPrice())).round(new MathContext(4)));
        productDto.setType(productRow.getType());
        productDto.setCount(productRow.getCount());
        return productDto;
    }


}
