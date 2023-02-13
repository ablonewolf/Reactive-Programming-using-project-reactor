package com.arka99.projectreactordemo.service;

import com.arka99.projectreactordemo.domain.Movie;
import com.arka99.projectreactordemo.domain.Review;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class MovieReactiveService {

    private MovieInfoService movieInfoService;
    private ReviewService reviewService;

    public MovieReactiveService(MovieInfoService movieInfoService, ReviewService reviewService) {
        this.movieInfoService = movieInfoService;
        this.reviewService = reviewService;
    }

    public Flux<Movie> getAllMovies() {
        var movieInfoFlux = movieInfoService.retrieveMovieInfosFlux();
        return movieInfoFlux
                .flatMap(movieInfo -> {
                    Mono<List<Review>> reviewsMono = reviewService.retrieveReviewsFlux(movieInfo.getMovieInfoId())
                            .collectList().log();
                    return reviewsMono
                            .map(reviews -> new Movie(movieInfo, reviews)).log();
                }).log();
    }

    public Mono<Movie> getMovieById(Long movieId) {
        var movieInfoMono = movieInfoService.retrieveMovieInfoMonoUsingId(movieId);

        return movieInfoMono
                .flatMap(movieInfo -> {
                    var reviewsMono = reviewService.retrieveReviewsFlux(movieInfo.getMovieInfoId()).collectList().log();
                    return reviewsMono
                            .map(reviews -> new Movie(movieInfo, reviews)).log();
                }).log();
    }
}
