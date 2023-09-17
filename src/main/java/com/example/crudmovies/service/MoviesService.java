package com.example.crudmovies.service;

import com.example.crudmovies.entity.Movies;
import com.example.crudmovies.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    public void save(Movies m) {
        moviesRepository.save(m);
    }

    public List<Movies> getAllMovies() {
        return moviesRepository.findAll();
    }

    public void deleteById(int id) {
        moviesRepository.deleteById(id);
    }

    public Movies getMovieById(int id) {
        return moviesRepository.findById(id).get();
    }

}
