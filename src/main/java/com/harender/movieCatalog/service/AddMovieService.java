package com.harender.movieCatalog.service;

import com.harender.movieCatalog.model.AddMovieModel;
import com.harender.movieCatalog.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddMovieService {

    @Autowired
    private MovieRepository repository;

    public boolean addMovie(String title,String genre, float rating){
        try {
            AddMovieModel movie = new AddMovieModel();
            movie.setTitle(title);
            movie.setGenre(genre);
            movie.setRating(rating);
            repository.save(movie);
            return true;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Fail to add movie");
        }
    }
}
