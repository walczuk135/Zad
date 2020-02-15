package com.service.rest.productservice.web;

import com.service.rest.productservice.api.ProductService;
import com.service.rest.productservice.api.dto.ProductDto;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ProductDto getProductById(@RequestParam(value = "id") Long id){
        return productService.findProductById(id);
    }

}
