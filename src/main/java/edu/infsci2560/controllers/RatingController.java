package edu.infsci2560.controllers;

import edu.infsci2560.models.RatingPk;
import edu.infsci2560.models.Rating;
import edu.infsci2560.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import edu.infsci2560.models.Recipe;
import edu.infsci2560.repositories.RecipeRepository;
import edu.infsci2560.repositories.RatingRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.PageRequest;

@Controller
public class RatingController {


    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserRepository userRepository;


    /*@RequestMapping(value = "recipes/edit/{id}",
            method = RequestMethod.PUT,
            consumes="application/x-www-form-urlencoded",
            produces = "application/json")
    public String update( @Valid Recipe recipe, BindingResult result) {
        recipeRepository.save(recipe);
        return "redirect:/recipes";
    }*/

    //rate a recipe
    @RequestMapping(value="/recipes/{id}/rate",method=RequestMethod.POST, consumes="application/x-www-form-urlencoded", produces = "application/json")
    public String create(@PathVariable Long id, @RequestParam("score") int score,HttpServletRequest request ){
        String userName = request.getRemoteUser();
        Long userId = userRepository.findByUsername(userName).getUserId();
        Rating myRating = new Rating(new RatingPk(id,userId),score);
        ratingRepository.save(myRating);
        return "redirect:/recipes/"+id;
    }



}
