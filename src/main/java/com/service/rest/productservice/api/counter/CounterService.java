package com.service.rest.productservice.api.counter;

import org.springframework.stereotype.Service;

@Service
public class CounterService {
    CounterInterface simpleCounterInterface;

    public CounterService(CounterInterface simpleCounterInterface) {
        this.simpleCounterInterface = simpleCounterInterface;
    }

    public long incrementCount(Long number){
        return simpleCounterInterface.incrementCounter(number);
    }


}
