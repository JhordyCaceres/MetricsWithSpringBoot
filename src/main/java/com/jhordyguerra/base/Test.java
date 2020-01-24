package com.jhordyguerra.base;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;


@RestController
public class Test {
    
    private final Counter contador;
    public Test(MeterRegistry meterRegistry) {

        // Crear el contador utilizando el método de ayudante en el compilador
        contador = meterRegistry.counter("services.start.counter");

    }
    
    @GetMapping("/")
    public String getDato() {
        contador.increment(1);
        return "Por ser el usuario " + contador.count() + " has sido premiado con un IPhone X,"
        + "haz click <a href='http://jhordycaceres.github.io/website' target='blank'>aquí</a>.";
    }
}