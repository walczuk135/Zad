package com.service.rest.productservice.api;

import com.service.rest.productservice.api.counter.CounterService;
import com.service.rest.productservice.api.discount.DiscountResolver;
import com.service.rest.productservice.data.ProductRow;
import com.service.rest.productservice.data.ProductRepository;
import com.service.rest.productservice.api.dto.ProductDto;
import com.service.rest.productservice.api.dto.ProductMapper;
import com.service.rest.productservice.web.exception.ProductIdNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private DiscountResolver discountResolver;
    private CounterService counterService;

    public ProductService(ProductRepository productRepository, CounterService counterService, @Qualifier("discountRangeService") DiscountResolver discountResolver) {
        this.productRepository = productRepository;
        this.counterService=counterService;
        this.discountResolver=discountResolver;

    }


    @Transactional
    public ProductDto findProductById(Long id) {
        ProductRow productRow = productRepository
                .findById(id)
                .orElseThrow(() -> new ProductIdNotFoundException(id));

        productRow.setCount(counterService.incrementCount(productRow.getCount()));

        ProductDto productDto=ProductMapper.productRowToProductDto(productRow);

        BigDecimal bigDecimal=discountResolver.calculateProductDiscount(productDto);
        productDto.setPrice(bigDecimal);

        return productDto;
    }

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(ProductMapper::productRowToProductDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductDto save(ProductDto productDto) {
        productRepository.save(ProductMapper.productDtoToProductRow(productDto));
        return productDto;
    }



//    @PostConstruct
//    public void init() {
//        save(new ProductDto("lego", "Lego bricks", TypeProduct.KID, new BigDecimal("500.00")));
//        save(new ProductDto("ball", "recreational ball", TypeProduct.MALE, new BigDecimal("2000.99")));
//        save(new ProductDto("lipstick", "Beauty and medicine", TypeProduct.FEMALE, new BigDecimal("700.99")));
//        save(new ProductDto("testosterone", "diet supplement", TypeProduct.MALE, new BigDecimal("150.99")));
//        save(new ProductDto("bag", "accessories", TypeProduct.FEMALE, new BigDecimal("25.99")));
//        save(new ProductDto("AK-47", "Automatic gun", TypeProduct.MALE, new BigDecimal("3000.99")));
//    }

}
