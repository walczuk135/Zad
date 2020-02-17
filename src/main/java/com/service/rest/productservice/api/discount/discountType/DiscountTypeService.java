package com.service.rest.productservice.api.discount.discountType;

import com.service.rest.productservice.api.TypeProduct;
import com.service.rest.productservice.api.discount.DiscountResolver;
import com.service.rest.productservice.api.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DiscountTypeService implements DiscountResolver {
    private final EnumMap<TypeProduct, DiscountStrategyType> discounts;

    public DiscountTypeService(List<DiscountStrategyType> discountStrategies) {
        this.discounts = discountStrategies.stream()
                .collect(Collectors.toMap(DiscountStrategyType::getType,
                        Function.identity(),
                        detectDuplicatedImplementations(),
                        ()->new EnumMap<>(TypeProduct.class)));
    }

    private BinaryOperator<DiscountStrategyType> detectDuplicatedImplementations() {
        return (l, r) -> {
            throw new DuplicatedDiscountsStrategyException(l,r);
        };
    }

    private DiscountStrategyType getDiscount(TypeProduct type) {
        return Optional.ofNullable(discounts.get(type))
                .orElseThrow(() -> new TypeNotFoundException(type));
    }

    public BigDecimal calculateDiscount(BigDecimal price, TypeProduct typeProduct) {
        return getDiscount(typeProduct)
                .calculateDiscount(price).setScale (2, RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal calculateProductDiscount(ProductDto productDto) {
        return calculateDiscount(productDto.getPrice(),productDto.getType());
    }
}