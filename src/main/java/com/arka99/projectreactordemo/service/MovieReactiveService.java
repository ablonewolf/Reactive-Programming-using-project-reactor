package com.arka99.projectreactordemo.service;

import com.arka99.projectreactordemo.domain.Movie;
import com.arka99.projectreactordemo.domain.Review;
import com.arka99.projectreactordemo.exception.MovieException;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Function;

@Slf4j
public class MovieReactiveService {

    private MovieInfoService movieInfoService;
    private ReviewService reviewService;

    public MovieReactiveService(MovieInfoService movieInfoService, ReviewService reviewService) {
        this.movieInfoService = movieInfoService;
        this.reviewService = reviewService;
    }

    public Flux<Movie> getAllMovies() {
        var movieInfoFlux = movieInfoService.retrieveMovieInfosFlux();
        Function<Throwable, Throwable> convertToMovieException = ex ->
        {
            log.error("Error message is : {}", ex.getMessage());
            throw new MovieException(ex.getMessage());
        };
        return movieInfoFlux
                .flatMap(movieInfo -> {
                    Mono<List<Review>> reviewsMono = reviewService.retrieveReviewsFlux(movieInfo.getMovieInfoId())
                            .collectList().log();
                    return reviewsMono
                            .map(reviews -> new Movie(movieInfo, reviews)).log();
                })
                .retry(5)
                .onErrorMap(convertToMovieException)
                .log();
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
