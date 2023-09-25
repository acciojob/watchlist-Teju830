package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public static void addMovie(Movie movie) {
        MovieRepository.saveMovie(movie);
    }

    public static void addDirector(Director director) {
        MovieRepository.saveDirector(director);
    }

    public static void createMovieDirectorPair(String movie, String director) {
        MovieRepository.saveMovieDirectorPair(movie,director);
    }

    public static Movie findMovie(String moviename) {
       return MovieRepository.findMovie(moviename);
    }

    public static Director findDirector(String directorname) {
       return  MovieRepository.findDirector(directorname);
    }

    public static List<String> findMovieByDirector(String director) {
        return MovieRepository.findMovieByDirector(director);
    }

    public static List<String> findAllMoives() {
        return  MovieRepository.findAllMovies();
    }

    public static void deleteDirector(String director) {
        MovieRepository.deleteDirector(director);
    }

    public static void deleteAllDirectors() {
        MovieRepository.deleteAllDirectors();
    }
}
