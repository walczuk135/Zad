package com.service.rest.productservice.api.discount.discountPrice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class DiscountGreaterThan2000Test {
    DiscountStrategyPrice discountGreaterThan2000Test;

    @BeforeEach
    public void init(){
        discountGreaterThan2000Test=new DiscountGreaterThan2000();
    }

    @Test
    void shouldCalculateSmaller2000(){
        assertAll(
                ()->assertEquals(new BigDecimal("501.00"),discountGreaterThan2000Test.calculateDiscount(new BigDecimal("501.00")).setScale (2, RoundingMode.HALF_EVEN)),
                ()->assertEquals(new BigDecimal("1200.00"),discountGreaterThan2000Test.calculateDiscount(new BigDecimal("1200.00")).setScale (2, RoundingMode.HALF_EVEN)),
                ()->assertEquals(new BigDecimal("1999.00"),discountGreaterThan2000Test.calculateDiscount(new BigDecimal("1999.00")).setScale (2, RoundingMode.HALF_EVEN))
        );
    }

    @Test
    void shouldCalculateGreater2000(){
        assertAll(
                ()->assertEquals(new BigDecimal("1900.00"),discountGreaterThan2000Test.calculateDiscount(new BigDecimal("2000.00")).setScale (2, RoundingMode.HALF_EVEN)),
                ()->assertEquals(new BigDecimal("5265.85"),discountGreaterThan2000Test.calculateDiscount(new BigDecimal("5543.00")).setScale (2, RoundingMode.HALF_EVEN)),
                ()->assertEquals(new BigDecimal("72949.55"),discountGreaterThan2000Test.calculateDiscount(new BigDecimal("76789.00")).setScale (2, RoundingMode.HALF_EVEN))
        );
    }



}