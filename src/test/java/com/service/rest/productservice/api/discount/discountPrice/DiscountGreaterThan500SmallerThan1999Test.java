package com.service.rest.productservice.api.discount.discountPrice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class DiscountGreaterThan500SmallerThan1999Test {

    DiscountStrategyPrice discountGreaterThan500SmallerThan1999;

    @BeforeEach
    public void init(){
        discountGreaterThan500SmallerThan1999=new DiscountGreaterThan500SmallerThan1999();
    }

    @Test
    void shouldCalculateSmaller500(){
        assertAll(
                ()->assertEquals(BigDecimal.valueOf(1),discountGreaterThan500SmallerThan1999.calculateDiscount(BigDecimal.valueOf(1))),
                ()->assertEquals(BigDecimal.valueOf(250),discountGreaterThan500SmallerThan1999.calculateDiscount(BigDecimal.valueOf(250))),
                ()->assertEquals(BigDecimal.valueOf(499),discountGreaterThan500SmallerThan1999.calculateDiscount(BigDecimal.valueOf(499)))
        );
    }

    @Test
    void shouldCalculateGreater500(){
        assertAll(
                ()->assertEquals(new BigDecimal("485.97"),discountGreaterThan500SmallerThan1999.calculateDiscount(new BigDecimal("501")).setScale (2, RoundingMode.HALF_EVEN)),
                ()->assertEquals(new BigDecimal("1164.00"),discountGreaterThan500SmallerThan1999.calculateDiscount(new BigDecimal("1200")).setScale (2, RoundingMode.HALF_EVEN)),
                ()->assertEquals(new BigDecimal("1939.03"),discountGreaterThan500SmallerThan1999.calculateDiscount(new BigDecimal("1999")).setScale (2, RoundingMode.HALF_EVEN))
        );
    }

    @Test
    void shouldCalculateGreater1999(){
        assertAll(
                ()->assertEquals(new BigDecimal("2000.00"),discountGreaterThan500SmallerThan1999.calculateDiscount(new BigDecimal("2000")).setScale (2, RoundingMode.HALF_EVEN)),
                ()->assertEquals(new BigDecimal("5552.00"),discountGreaterThan500SmallerThan1999.calculateDiscount(new BigDecimal("5552")).setScale (2, RoundingMode.HALF_EVEN))
        );
    }


}