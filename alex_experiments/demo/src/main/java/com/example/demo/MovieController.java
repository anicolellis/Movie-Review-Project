package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping(path="/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path="/")
    public @ResponseBody String addNewMovie (@RequestBody Movie m) {
        //Movie m = new Movie();
        //m.setTitle(title);
        //m.setDirector(director);
        movieRepository.save(m);
        return "Success";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping(path="/health")
    public String healthCheck() {
        return "Healthy";
    }
}
