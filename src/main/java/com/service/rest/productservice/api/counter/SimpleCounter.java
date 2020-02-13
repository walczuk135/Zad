package com.service.rest.productservice.api.counter;

import org.springframework.stereotype.Component;

@Component
class SimpleCounter implements Counter {
    private final long counter;

    public SimpleCounter() {
        counter = 1L;
    }

    @Override
    public Long incrementCounter(long number) {
        return counter + number;
    }


    @Override
    public Long decrementCounter(Long number) {
        return number - counter;
    }

    public Long getCounter() {
        return counter;
    }


}
