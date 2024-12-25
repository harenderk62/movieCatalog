package com.harender.movieCatalog.repository;

import com.harender.movieCatalog.model.AddMovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<AddMovieModel,Long> {
    List<AddMovieModel> findByGenreAndRatingGreaterThanEqual(String genre, float rating);
    List<AddMovieModel> findByGenre(String genre);
    List<AddMovieModel> findByRatingGreaterThanEqual(float rating);
}
