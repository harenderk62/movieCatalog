package com.harender.movieCatalog.controller;

import com.harender.movieCatalog.model.AddMovieModel;
import com.harender.movieCatalog.model.GetMoviesDTO;
import com.harender.movieCatalog.service.GetMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/getMovies")
public class GetMoviesController {

    @Autowired
    private GetMoviesService service;

    @GetMapping
    public ResponseEntity<GetMoviesDTO> getMovies(){
        try{
            List<AddMovieModel> data = service.getMovies();

            if(data == null || data.isEmpty()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new GetMoviesDTO(204,null));
            }

            return ResponseEntity.ok(new GetMoviesDTO(200,data));


        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GetMoviesDTO(500,null));
        }
    }
}
