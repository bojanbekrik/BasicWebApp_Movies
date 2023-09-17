package com.example.crudmovies.controller;

import com.example.crudmovies.entity.Movies;
import com.example.crudmovies.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/register")
    public String register() {
        return "movieRegister";
    }

    @GetMapping("/movies")
    public ModelAndView showAllMovies() {
        List<Movies> list = moviesService.getAllMovies();
        return new ModelAndView("movieList","movies",list);
    }

    @PostMapping("/save")
    public String addMovie(@ModelAttribute Movies m) {
        moviesService.save(m);
        return "redirect:/movies";
    }

    @RequestMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable("id") int id) {
        moviesService.deleteById(id);
        return "redirect:/movies";
    }

    @RequestMapping("/editMovie/{id}")
    public String edtiMovie(@PathVariable("id") int id, Model model) {
        Movies m = moviesService.getMovieById(id);
        model.addAttribute("movie", m);
        return "movieEdit";
    }

}
