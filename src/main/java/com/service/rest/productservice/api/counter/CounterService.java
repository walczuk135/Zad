package com.service.rest.productservice.api.counter;

import org.springframework.stereotype.Component;

@Component
public class CounterService {
    SimpleCounter simpleCounter;

    public CounterService(SimpleCounter simpleCounter) {
        this.simpleCounter = simpleCounter;
    }

    public long incrementCount(Long number){
        return simpleCounter.incrementCounter(number);
    }

//    public void resetCount(){
//        simpleCounter.resetCounter();
//    }
}
