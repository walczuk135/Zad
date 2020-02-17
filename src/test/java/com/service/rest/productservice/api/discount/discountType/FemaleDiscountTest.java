package com.service.rest.productservice.api.discount.discountType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class FemaleDiscountTest {
    DiscountStrategyType discountStrategyType;

    @BeforeEach
    public void init(){
        discountStrategyType=new FemaleDiscount();
    }

    @Test
    void shouldCalculate(){
        assertAll(
                ()->assertEquals(new BigDecimal("1900.00"),discountStrategyType.calculateDiscount(new BigDecimal("2000.00")).setScale (2, RoundingMode.HALF_EVEN)),
                ()->assertEquals(new BigDecimal("5265.85"),discountStrategyType.calculateDiscount(new BigDecimal("5543.00")).setScale (2, RoundingMode.HALF_EVEN)),
                ()->assertEquals(new BigDecimal("72949.55"),discountStrategyType.calculateDiscount(new BigDecimal("76789.00")).setScale (2, RoundingMode.HALF_EVEN))
        );
    }

}