package edu.infsci2560.services;

import edu.infsci2560.models.Recipe;
import edu.infsci2560.models.Recipe.RecipeType;
import edu.infsci2560.repositories.RecipeRepository;
import edu.infsci2560.repositories.RatingRepository; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/public/api/recipes")
public class RecipeService {

    @Autowired
    private RecipeRepository repository;


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Iterable<Recipe>> list() {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.findAll(), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Recipe> list(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.findOne(id), headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public ResponseEntity<Recipe> create(@RequestBody Recipe recipe) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.save(recipe), headers, HttpStatus.OK);
    }
    
}


