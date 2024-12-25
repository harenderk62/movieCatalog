package com.harender.movieCatalog.service;

import com.harender.movieCatalog.model.AddMovieModel;
import com.harender.movieCatalog.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GetMoviesService {

    @Autowired
    public MovieRepository repository;

    public List<AddMovieModel> getMovies(){
    List<AddMovieModel> data =  repository.findAll();
    return data;
    }
}
