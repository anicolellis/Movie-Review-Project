package com.nicolellis.moviedb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;


@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("")
    public @ResponseBody Movie addNewMovie (@RequestBody Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    @GetMapping("")
    public @ResponseBody Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Movie getMovieById(@PathVariable int id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    @PutMapping("/{id}")
    public @ResponseBody Movie replaceMovie(@PathVariable int id, @RequestBody Movie newMovie) {
        return movieRepository.save(newMovie);
    }
    
    @DeleteMapping("/{id}")
    public @ResponseBody Movie deleteMovie(@PathVariable int id) {
        Movie m = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
        movieRepository.delete(m);
        return m;
    }
    
}
