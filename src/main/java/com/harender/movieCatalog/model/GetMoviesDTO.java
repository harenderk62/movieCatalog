package com.harender.movieCatalog.model;

import java.util.List;
import java.util.Objects;

public class GetMoviesDTO {
    private int responseCode;
    private List<AddMovieModel> data;

    public GetMoviesDTO(int responseCode, List<AddMovieModel> data){
    this.responseCode = responseCode;
    this.data = data;
    }

    public void setResponseCode(int responseCode){
        this.responseCode = responseCode;
    }

    public int getResponseCode(){
        return responseCode;
    }

    public void setData(List<AddMovieModel> data){
        this.data = data;
    }

    public List<AddMovieModel> getData(){
        return this.data;
    }
}
