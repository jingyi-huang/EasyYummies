/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.infsci2560.controllers;

import edu.infsci2560.models.Recipe;
import edu.infsci2560.repositories.RatingRepository;
import edu.infsci2560.repositories.RecipeRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import edu.infsci2560.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RecipesController {
    @Autowired
    private RecipeRepository repository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserRepository userRepository;

    
    //display all recipes
    @RequestMapping(value = "recipes", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("recipes", "recipes", repository.findAll());
    }


    //details of one recipe
    @RequestMapping(value = "recipes/{id}", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("details");
        Recipe recipe = repository.findOne(id);
        mv.addObject("recipe", recipe);
        mv.addObject("ratings", ratingRepository.findByRatingPkRecipeId(recipe.getId(), new PageRequest(0, 10)));
        return mv;
    }

    
    //create a recipe
    /*@RequestMapping(value = "/saveRecipe", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute @Valid Recipe recipe, BindingResult result) {
        repository.save(recipe);
        return new ModelAndView("recipes", "recipes", repository.findAll());
    }*/

    //create a recipe
    @RequestMapping(value = "/saveRecipe", method = RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute @Valid Recipe recipe, BindingResult result,
                               HttpServletRequest request) {
        String userName = request.getRemoteUser();
        Long userId = userRepository.findByUsername(userName).getUserId();
        recipe.setAuthor(userId);
        repository.save(recipe);
        return new ModelAndView("recipes", "recipes", repository.findAll());
    }







}
