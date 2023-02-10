package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.List;

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

    @Test
    void nameFluxFlatMap() {
        Integer stringLength = 4;
        var fluxFlatMap = fluxAndMonoGeneratorService.nameFluxFlatMap(stringLength);

        StepVerifier.create(fluxFlatMap)
                .expectNextCount(20)
                .verifyComplete();
    }

    @Test
    void nameFluxFlatMapDefaultIfEmpty() {
        Integer stringLength = 8;
        var fluxFlatMap = fluxAndMonoGeneratorService.nameFluxFlatMap(stringLength);

        StepVerifier.create(fluxFlatMap)
                .expectNext("default String")
                .verifyComplete();
    }


    @Test
    void nameMonoFlatMap() {
        var monoFlatMap = fluxAndMonoGeneratorService.nameMonoFlatMap();

        StepVerifier.create(monoFlatMap)
                .expectNext(List.of("A","R","K","A"," ","B","H","U","I","Y","A","N"))
                .verifyComplete();
    }

    @Test
    void nameFluxFlatMapAsync() {
        var fluxFlatMapAsync = fluxAndMonoGeneratorService.nameFluxFlatMapAsync(4);

        StepVerifier.create(fluxFlatMapAsync)
                .expectNextCount(20)
                .verifyComplete();
    }

    @Test
    void nameFluxConcatMap() {
        var fluxConcatMap = fluxAndMonoGeneratorService.nameFluxConcatMap(4);

        StepVerifier.create(fluxConcatMap)
                .expectNextCount(20)
                .verifyComplete();
    }

    @Test
    void testNameMonoFlatMapMany() {
        var monoFlatMapMany = fluxAndMonoGeneratorService.nameMonoFlatMapMany();

        StepVerifier.create(monoFlatMapMany)
                .expectNext("A")
                .expectNextCount(10)
                .verifyComplete();
    }

    @Test
    void nameFluxTransform() {
        var nameFluxTransform = fluxAndMonoGeneratorService.nameFluxTransform(4);

        StepVerifier.create(nameFluxTransform)
                .expectNext("F")
                .expectNextCount(19)
                .verifyComplete();
    }

    @Test
    void nameFluxTransformSwitchIfEmpty() {
        var nameFluxTransform = fluxAndMonoGeneratorService.nameFluxTransform(8);

        StepVerifier.create(nameFluxTransform)
                .expectNext("D")
                .expectNextCount(12)
                .verifyComplete();
    }

    @Test
    void monoMapWithFilter() {
        var monoMapWithFilter = fluxAndMonoGeneratorService.monoMapWithFilter(3);

        StepVerifier.create(monoMapWithFilter)
                .expectNext("ARKA")
                .verifyComplete();
    }

    @Test
    void monoMapWithFilterDefaultIfEmpty() {
        var monoMapWithFilter = fluxAndMonoGeneratorService.monoMapWithFilter(4);

        StepVerifier.create(monoMapWithFilter)
                .expectNext("default String")
                .verifyComplete();
    }

    @Test
    void nameMonoTransformWithFilter() {
        var nameMonoTransform = fluxAndMonoGeneratorService.nameMonoTransformWithFilter(3);

        StepVerifier.create(nameMonoTransform)
                .expectNext(List.of("A","R","K","A"))
                .verifyComplete();
    }

    @Test
    void nameMonoTransformWithFilterSwitchIfEmpty() {
        var nameMonoTransform = fluxAndMonoGeneratorService.nameMonoTransformWithFilter(4);

        StepVerifier.create(nameMonoTransform)
                .expectNext(List.of("D","E","F","A","U","L","T"))
                .verifyComplete();
    }
}
