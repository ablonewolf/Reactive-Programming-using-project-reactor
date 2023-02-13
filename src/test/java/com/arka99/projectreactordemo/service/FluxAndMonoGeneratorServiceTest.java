package com.arka99.projectreactordemo.service;

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
                .expectNext(List.of("A", "R", "K", "A", " ", "B", "H", "U", "I", "Y", "A", "N"))
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
                .expectNext(List.of("A", "R", "K", "A"))
                .verifyComplete();
    }

    @Test
    void nameMonoTransformWithFilterSwitchIfEmpty() {
        var nameMonoTransform = fluxAndMonoGeneratorService.nameMonoTransformWithFilter(4);

        StepVerifier.create(nameMonoTransform)
                .expectNext(List.of("D", "E", "F", "A", "U", "L", "T"))
                .verifyComplete();
    }

    @Test
    void testFluxConcat() {
        var fluxConcat = fluxAndMonoGeneratorService.fluxConcat();

        StepVerifier.create(fluxConcat)
                .expectNext("A")
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    void testMonoConcatWith() {
        var monoConcatWith = fluxAndMonoGeneratorService.monoConcatWith();

        StepVerifier.create(monoConcatWith)
                .expectNext("Arka")
                .expectNext("Bhuiyan")
                .verifyComplete();
    }

    @Test
    void testFluxConcatWith() {
        var fluxConcatWith = fluxAndMonoGeneratorService.fluxConcatWith();

        StepVerifier.create(fluxConcatWith)
                .expectNext("Arka")
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void fluxMerge() {
        var mergedFlux = fluxAndMonoGeneratorService.fluxMerge();

        StepVerifier.create(mergedFlux)
                .expectNext("Arka")
                .expectNext("Mosfik")
                .expectNextCount(4)
                .verifyComplete();
    }


    @Test
    void monoMerge() {
        var mergedFlux = fluxAndMonoGeneratorService.monoMerge();

        StepVerifier.create(mergedFlux)
                .expectNext("Arka Bhuiyan")
                .expectNext("Farhan Zaman")
                .verifyComplete();
    }

    @Test
    void monoMergeWith() {
        var mergedFlux = fluxAndMonoGeneratorService.monoMergeWith();

        StepVerifier.create(mergedFlux)
                .expectNext("Arka Bhuiyan")
                .expectNext("Farhan Zaman")
                .verifyComplete();
    }

    @Test
    void monoZip() {
        var zippedMono = fluxAndMonoGeneratorService.monoZip();

        StepVerifier.create(zippedMono)
                .expectNext("Arka Bhuiyan")
                .verifyComplete();
    }

    @Test
    void fluxZip() {
        var zippedFlux = fluxAndMonoGeneratorService.fluxZip();

        StepVerifier.create(zippedFlux)
                .expectNext("Arka Bhuiyan, ID : 11512")
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void monoZipWith() {
        var zippedWithMono = fluxAndMonoGeneratorService.monoZipWith();

        StepVerifier.create(zippedWithMono)
                .expectNext("Arka Bhuiyan")
                .verifyComplete();
    }


    @Test
    void fluxZipWith() {
        var zippedWithFlux = fluxAndMonoGeneratorService.fluxZipWith();

        StepVerifier.create(zippedWithFlux)
                .expectNext("Arka Bhuiyan")
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void exceptionFlux() {
        var exceptionFlux = fluxAndMonoGeneratorService.exceptionFlux();

        StepVerifier.create(exceptionFlux)
                .expectNext("A", "B", "C")
                .expectErrorMessage("An Exception Occurred.")
                .verify();
    }

    @Test
    void exploreOnErrorReturn() {
        var onErrorReturnFlux = fluxAndMonoGeneratorService.exploreOnErrorReturn();

        StepVerifier.create(onErrorReturnFlux)
                .expectNext("a", "b", "c", "d")
                .verifyComplete();
    }

    @Test
    void exploreOnErrorResume() {
        var onErrorResume = fluxAndMonoGeneratorService.exploreOnErrorResume(new RuntimeException("A Runtime Exception"));

        StepVerifier.create(onErrorResume)
                .expectNext("a","b","c")
                .expectNext("A Runtime Exception")
                .verifyComplete();
    }
}
