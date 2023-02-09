package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();
    @Test
    void namesFlux() {
        var namesFlux = fluxAndMonoGeneratorService.namesFlux();

        StepVerifier.create(namesFlux)
                .expectNext("Arka")
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    void nameMono() {
        var nameMono = fluxAndMonoGeneratorService.nameMono();

        StepVerifier.create(nameMono)
                .expectNext("Arka Bhuiyan")
                .verifyComplete();
    }

    @Test
    void nameFlux_map() {
        var nameFluxMap = fluxAndMonoGeneratorService.nameFlux_map();

        StepVerifier.create(nameFluxMap)
                .expectNext("FARHAN")
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void monoMap() {
        var monoMap = fluxAndMonoGeneratorService.monoMap();

        StepVerifier.create(monoMap)
                .expectNext("ARKA BHUIYAN")
                .verifyComplete();
    }
}
