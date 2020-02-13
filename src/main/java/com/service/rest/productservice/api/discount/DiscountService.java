package com.service.rest.productservice.api.discount;

import com.service.rest.productservice.api.TypeProduct;
import com.service.rest.productservice.api.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class DiscountService {
    private final EnumMap<TypeProduct, DiscountStrategy> discounts;

    public DiscountService(List<DiscountStrategy> discountStrategies) {
        this.discounts = discountStrategies.stream()
                .collect(Collectors.toMap(DiscountStrategy::getType,
                        Function.identity(),
                        detectDuplicatedImplementations(),
                        ()->new EnumMap<>(TypeProduct.class)));
    }

    private BinaryOperator<DiscountStrategy> detectDuplicatedImplementations() {
        return (l, r) -> {
            throw new DuplicatedDiscountsStrategyException(l,r);
        };
    }

    private DiscountStrategy getDiscount(TypeProduct type) {
        return Optional.ofNullable(discounts.get(type))
                .orElseThrow(() -> new TypeNotFoundException(type));
    }

    public BigDecimal calcDiscount(BigDecimal price,TypeProduct typeProduct) {
        return getDiscount(typeProduct)
                .calculateDiscount(price);
    }

    public void setDiscount(TypeProduct type,double price){
        getDiscount(type).setDiscount(price);
    }


}