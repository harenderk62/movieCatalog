package com.harender.movieCatalog.controller;

import com.harender.movieCatalog.model.AddMovieModel;
import com.harender.movieCatalog.model.GetMoviesDTO;
import com.harender.movieCatalog.service.FilterMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filter")
public class FilterMoviesController {

    @Autowired
    private FilterMoviesService service;

    @GetMapping
    public ResponseEntity<GetMoviesDTO> getFilterResult(@RequestParam(required = false) String genre,@RequestParam(required = false) Float rating ){

        try{
            List<AddMovieModel> filteredData = service.getFilteredMovies(genre,rating);

            if(filteredData == null || filteredData.isEmpty()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new GetMoviesDTO(204,null));
            }

            return ResponseEntity.ok(new GetMoviesDTO(200,filteredData));
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GetMoviesDTO(500,null));
        }
    }
}
