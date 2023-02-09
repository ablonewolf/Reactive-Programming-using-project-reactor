package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {

    public Flux<String> namesFlux() {
        return Flux.fromIterable(List.of("Arka","Farhan","Akif","Nipa","Zareen","Mosfikur"));
    }

    public Mono<String> nameMono() {
        return Mono.just("Arka Bhuiyan");
    }

    public static void main(String[] args) {
        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();
//        subscribing to the name flux
        fluxAndMonoGeneratorService.namesFlux()
                .subscribe(System.out::println);
        System.out.println();
//        subscribing to the name mono
        fluxAndMonoGeneratorService.nameMono()
                .subscribe(System.out::println);

    }
}
