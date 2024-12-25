package com.harender.movieCatalog.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "MovieTable")
public class AddMovieModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String genre;
    private float rating;
    private LocalDateTime addedOn;

    public void setId(Long id){
        this.id = id;
    }

    public long getId(){
        return this.id;
    }

    public void setTitle(String title){
        this.title = title;
    }

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

    public void setAddedOn(LocalDateTime addedOn){
        this.addedOn = addedOn;
    }

    public LocalDateTime getAddedOn(){
        return this.addedOn;
    }
}
