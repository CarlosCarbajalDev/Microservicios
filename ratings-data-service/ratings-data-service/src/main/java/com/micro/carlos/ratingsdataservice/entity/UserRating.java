package com.micro.carlos.ratingsdataservice.entity;

import java.util.List;

public class UserRating {

    private List<Rating> userRatingList;


    public UserRating() {
    }



    public UserRating(List<Rating> userRatingList) {
        this.userRatingList = userRatingList;
    }

    public List<Rating> getUserRatingList() {
        return userRatingList;
    }

    public void setUserRatingList(List<Rating> userRatingList) {
        this.userRatingList = userRatingList;
    }
}
