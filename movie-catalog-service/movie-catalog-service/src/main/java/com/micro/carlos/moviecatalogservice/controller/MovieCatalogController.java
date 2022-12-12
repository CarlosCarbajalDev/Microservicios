package com.micro.carlos.moviecatalogservice.controller;

import com.micro.carlos.moviecatalogservice.MovieCatalogServiceApplication;
import com.micro.carlos.moviecatalogservice.entity.CatalogItem;
import com.micro.carlos.moviecatalogservice.entity.Movie;
import com.micro.carlos.moviecatalogservice.entity.Rating;
import com.micro.carlos.moviecatalogservice.entity.UserRating;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient; //Reactive Java

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {

        //get all rated movie IDs
        List<Rating> ratingsold = Arrays.asList(
                new Rating("12", 5),
                new Rating("34", 4),
                new Rating("56", 3)
        );

        UserRating ratingsNew = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"+userId, UserRating.class);


        //For each movie ID, call movie info service an get details
        return ratingsNew.getUserRatingList().stream().map(movieRating -> {
            //Reactive programming WebClient
            /*Movie movie = webClientBuilder.build() //Create a new instance of  WebClienteBuilder everytime make a call
                    .get()
                    .uri("http://localhost:8082/movies/"+ movieRating.getMovieId())
                    .retrieve() //fetch the data
                    .bodyToMono(Movie.class) //Lo que sea que sea que hagas fetch conviertelo a Movie.class (Como una promesa de JS, cuando ya este listo va a seguir el proceso)
                    .block(); //Return a <T> instance of movie //Regresa cuando ya lo tiene listo

                    return new CatalogItem(movie.getName(), movie.getDescription(), movieRating.getRating());
                })
                .collect(Collectors.toList()); //change the stream to a List<CatalogItem>
                */

            //RestTemplate
                    Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+movieRating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), movie.getDescription(), movieRating.getRating());

        })
        .collect(Collectors.toList()); //Retorna un List<CatalogItem> para el método principal
        //List<CatalogItem> catalogItemList = Collections.singletonList(
                //new CatalogItem("Transformes 1", "Transformers Desc", 4)
        //);
        //return catalogItemList;

    }
}
