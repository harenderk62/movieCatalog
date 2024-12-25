package com.harender.movieCatalog.controller;

import com.harender.movieCatalog.model.AddMovieRequestDTO;
import com.harender.movieCatalog.model.AddMovieResponseDTO;
import com.harender.movieCatalog.service.AddMovieService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addMovie")
public class AddMovieController {

    @Autowired
    private AddMovieService addMovieService;

    @PostMapping
    public ResponseEntity<AddMovieResponseDTO> addMovie(@RequestBody AddMovieRequestDTO addMovieDTO, HttpServletRequest request){
       try {
           String title = addMovieDTO.getTitle();
           String genre = addMovieDTO.getGenre();
           float rating = addMovieDTO.getRating();
           boolean isAdded= addMovieService.addMovie(title,genre,rating);

           return ResponseEntity.ok(new AddMovieResponseDTO("Movie Added to DB",200));
       }catch(IllegalArgumentException e){
           return ResponseEntity.status(HttpStatus.CONFLICT).body(new AddMovieResponseDTO(e.getMessage(),400));
       }
    }
}
