package com.harender.movieCatalog.model;


public class AddMovieRequestDTO {
    private String title;
    private String genre;
    private float rating;

    public void setTitle(String title){
    this.title = title;}

    public String getTitle(){
        return this.title;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getGenre(){
        return this.genre;
    }

    public void setRating(float rating){
        this.rating = rating;
    }

    public float getRating(){
        return this.rating;
    }
}
