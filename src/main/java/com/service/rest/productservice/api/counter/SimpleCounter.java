package com.service.rest.productservice.api.counter;

import org.springframework.stereotype.Component;

@Component
class SimpleCounter implements CounterInterface {
    private long counter;

    public SimpleCounter() {
        counter = 1L;
    }

    @Override
    public Long incrementCounter(long number) {
        return counter + number;
    }

    public Long getCounter() {
        return counter;
    }


}
