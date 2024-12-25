package com.harender.movieCatalog.service;

import com.harender.movieCatalog.model.AddMovieModel;
import com.harender.movieCatalog.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterMoviesService {

    @Autowired
    private MovieRepository repository;

    public List<AddMovieModel> getFilteredMovies(String genre, Float rating){
        try {

            if(genre == null || genre.isEmpty()){
                genre = null;
            }

            if(rating == null || rating.isNaN()){
                rating = null;
            }

            List<AddMovieModel> filteredData;
            if(genre != null && rating != null){
                filteredData = repository.findByGenreAndRatingGreaterThanEqual( genre,  rating);
            }else if( genre != null ){
                filteredData = repository.findByGenre(genre);
            }else if( rating != null){
                filteredData = repository.findByRatingGreaterThanEqual(rating);
            }else{
                filteredData = repository.findAll();
            }

            return filteredData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
