package com.micro.carlos.ratingsdataservice.controller;

import com.micro.carlos.ratingsdataservice.entity.Rating;
import com.micro.carlos.ratingsdataservice.entity.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {

    @RequestMapping("/{movieId}")

    //Toma el userID y retorna un array de raitings
    public Rating getRating(@PathVariable String movieId){
        return new Rating(movieId, 500);
    }

    //Request para obtener todos los ratings que ha hecho el usuario
    @RequestMapping("users/{userId}")
    //Toma el userID y retorna un array de raitings
    public UserRating getUserRatingList(@PathVariable String userId){
        UserRating userRating = new UserRating();

        List<Rating> ratingList = Arrays.asList(
                new Rating("12", 5),
                new Rating("34", 5),
                new Rating("56", 2)
        );
        userRating.setUserRatingList(ratingList);

        return userRating;
    }
}
