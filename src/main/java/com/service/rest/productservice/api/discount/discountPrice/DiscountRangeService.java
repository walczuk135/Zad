package com.service.rest.productservice.api.discount.discountPrice;


import com.service.rest.productservice.api.discount.DiscountResolver;
import com.service.rest.productservice.api.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


@Service
class DiscountRangeService implements DiscountResolver {
    private List<DiscountStrategyPrice> discounts;

    public DiscountRangeService( List<DiscountStrategyPrice> discounts) {
        this.discounts = Arrays.asList(new DiscountGreaterThan2000(),new DiscountGreaterThan500SmallerThan1999());
    }

    public BigDecimal calcDiscount(BigDecimal price) {
        BigDecimal bigDecimal=BigDecimal.ZERO;
        for (DiscountStrategyPrice discount : discounts) {
            bigDecimal=discount.calculateDiscount(price);
            if(!bigDecimal.equals(price)) break;
        }
        return bigDecimal.setScale (2, RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal calculateProductDiscount(ProductDto productDto) {
        return calcDiscount(productDto.getPrice());
    }
}
