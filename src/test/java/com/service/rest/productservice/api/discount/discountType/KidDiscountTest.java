package com.service.rest.productservice.api.discount.discountType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class KidDiscountTest {
    DiscountStrategyType discountStrategyType;

    @BeforeEach
    public void init(){
        discountStrategyType=new KidDiscount();
    }

    @Test
    void shouldCalculate(){
        assertAll(
                ()->assertEquals(new BigDecimal("1800.00"),discountStrategyType.calculateDiscount(new BigDecimal("2000.00")).setScale (2, RoundingMode.HALF_EVEN)),
                ()->assertEquals(new BigDecimal("4988.70"),discountStrategyType.calculateDiscount(new BigDecimal("5543.00")).setScale (2, RoundingMode.HALF_EVEN)),
                ()->assertEquals(new BigDecimal("69110.10"),discountStrategyType.calculateDiscount(new BigDecimal("76789.00")).setScale (2, RoundingMode.HALF_EVEN))
        );
    }
}