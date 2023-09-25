package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")



public class MovieController {
    @Autowired
    MovieService movieService;
  @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
      MovieService.addMovie(movie);
      return new ResponseEntity<>("new moive added successfully", HttpStatus.CREATED);
  }
  @PostMapping("/add-director")
  public ResponseEntity<String> addDirector(@RequestBody Director director){
      MovieService.addDirector(director);
      return new ResponseEntity<>("new director added successfully", HttpStatus.CREATED);
  }
  @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
      MovieService.createMovieDirectorPair(movie,director);
      return new ResponseEntity<>("new movie-director pair added successfully",HttpStatus.CREATED);
  }
 @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie>getMovieByName(@PathVariable String moviename){
      Movie movie = MovieService.findMovie(moviename);
      return new ResponseEntity<>(movie, HttpStatus.CREATED);
 }
 @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director>getDirectorByName(@PathVariable String directorname){
      Director director = MovieService.findDirector(directorname);
      return new ResponseEntity<>(director,HttpStatus.CREATED);
 }
 @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>>getMoviesByDirectorName(@PathVariable String director){
      List<String> movies = MovieService.findMovieByDirector(director);
      return new ResponseEntity<>(movies,HttpStatus.CREATED);
 }
 @GetMapping("/get-all-movies")
    public  ResponseEntity<List<String>> findAllMovies(){
      List<String> moives = MovieService.findAllMoives();
      return new ResponseEntity<>(moives,HttpStatus.CREATED);
 }
 @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String>deleteDirectorByName(@RequestParam String director){
      MovieService.deleteDirector(director);
      return new ResponseEntity<>(director + "Removed Successfully",HttpStatus.CREATED);
 }
 @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String>deleteAllDirectors(){
      MovieService.deleteAllDirectors();
      return new ResponseEntity<>("All director deleted successfully",HttpStatus.CREATED);
 }
}

