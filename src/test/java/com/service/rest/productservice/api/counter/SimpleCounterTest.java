package com.service.rest.productservice.api.counter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class SimpleCounterTest {
    SimpleCounter simpleCounter;

    @BeforeEach
    public void init(){
        simpleCounter=new SimpleCounter();
    }

    @Test
    void shouldIncrementOne(){
        simpleCounter.incrementCounter(1);
        assertEquals(1,simpleCounter.getCounter());
    }

    @Test
    void shouldIncrementTwo(){
        simpleCounter.incrementCounter(2);
        simpleCounter.incrementCounter(2);
        assertEquals(1,simpleCounter.getCounter());
    }

}