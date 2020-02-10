package com.service.rest.productservice;

import com.service.rest.productservice.db.ProductRow;
import com.service.rest.productservice.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{name}")
    public ProductDto getProductByName(@PathVariable String name){
        return productService.findProductByName(name);
    }

    @GetMapping("/product/id/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        return productService.findProductById(id);
    }

    @GetMapping("/product/getAll")
    public List<ProductDto> getAllProduct(){
        return productService.findAll();
    }

    @PostMapping("/product/")
    public ProductDto saveProduct(@RequestBody ProductDto productDto){
        productService.save(productDto);
        return productDto;
    }

    @DeleteMapping("/product/{name}")
    public ProductDto deleteProduct(@PathVariable String name){
        productService.deleteProduct(name);
        return productService.findProductByName(name);
    }
}
