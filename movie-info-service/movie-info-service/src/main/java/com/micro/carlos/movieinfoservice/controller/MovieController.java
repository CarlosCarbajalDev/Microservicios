package com.micro.carlos.movieinfoservice.controller;

import com.micro.carlos.movieinfoservice.entity.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable String movieId){
        return new Movie(movieId, "Test name from Movie:ID "+movieId, "Just another description from Movie");
    }
}
