package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
@Repository
public class MovieRepository {
    private static HashMap<String , Movie> moviemap;
    private static HashMap<String , Director>directormap;
    private  static HashMap<String,List<String>>moviedirectormapping;

    public MovieRepository() {
        this.moviemap = new HashMap<String,Movie>();
        this.directormap= new HashMap<String,Director>();
        this.moviedirectormapping = new HashMap<String ,List<String>>();
    }

    public static void saveMovie(Movie movie) {
        moviemap.put(movie.getName(),movie);
    }

    public static void saveDirector(Director director) {
        directormap.put(director.getName(), director);
    }

    public static void saveMovieDirectorPair(String moive, String director) {
        if(moviemap.containsKey(moive) && directormap.containsKey(director)){
            // moviemap.put(moive,moviemap.get(moive));
            //directormap.put(director,directormap.get(director));
            List<String> currentMovies = new ArrayList<>();
            if(moviedirectormapping.containsKey(director)) currentMovies = moviedirectormapping.get(director);
            currentMovies.add(moive);
            moviedirectormapping.put(director,currentMovies);
        }
    }

    public static Movie findMovie(String movie) {
        return moviemap.get(movie);
    }

    public static Director findDirector(String director) {
        return directormap.get(director);
    }

    public static List<String> findMovieByDirector(String director) {
        List<String> movieList = new ArrayList<>();
        if(moviedirectormapping.containsKey(director)) movieList = moviedirectormapping.get(director);
        return movieList;
    }

    public static List<String> findAllMovies() {
        return new ArrayList<>(moviemap.keySet());
    }

    public static void deleteDirector(String director) {
        List<String> movies = new ArrayList<>();
        if(moviedirectormapping.containsKey(director)) {
            movies = moviedirectormapping.get(director);
            for (String movie : movies) {
                if (moviemap.containsKey(movie)) {
                    moviemap.remove(movie);
                }
            }
            moviedirectormapping.remove(director);
        }

       if(directormap.containsKey(director)){
           directormap.remove(director);
       }
    }


    public static void deleteAllDirectors() {
        HashSet<String>movieset = new HashSet<>();

        for(String director : moviedirectormapping.keySet()){
            for(String movie : moviedirectormapping.get(director)){
                movieset.add(movie);
            }
        }
        for(String movie : movieset){
            if(moviemap.containsKey(movie)){
                moviemap.remove(movie);
            }
        }
    }
}
