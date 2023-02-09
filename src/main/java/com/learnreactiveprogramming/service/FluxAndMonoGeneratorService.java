package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {

    public Flux<String> namesFlux() {
        return Flux.fromIterable(List.of("Arka","Farhan","Akif","Nipa","Zareen","Mosfikur")).log();
    }

    public Mono<String> nameMono() {
        return Mono.just("Arka Bhuiyan").log();
    }

    public Mono<String> monoMap() {
        return Mono
                .just("Arka Bhuiyan")
                .map(String::toUpperCase)
                .log();
    }

    public Flux<String> nameFlux_map() {
        return Flux
                .fromIterable(List.of("Arka","Farhan","Akif","Nipa","Zareen","Mosfikur"))
                .filter(name -> name.length() > 4)
                .map(String::toUpperCase)
                .log();
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
