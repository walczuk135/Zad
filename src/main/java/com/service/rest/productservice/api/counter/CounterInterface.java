package com.service.rest.productservice.api.counter;

interface CounterInterface {
    Long incrementCounter(long number);
    Long decrementCounter(Long number);
}
