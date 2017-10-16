package edu.infsci2560.controllers;

import edu.infsci2560.models.User;
import edu.infsci2560.repositories.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;







@Controller
public class UserController {
    
    @Autowired
    private UserRepository repository;

    @Autowired
    RecipeRepository recipeRepository;

    
    //user list
    @RequestMapping(value="/users",method=RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("users","users",repository.findAll());
    }
    
    //find user by userId
    /*@RequestMapping(value="/users/{userId}",method=RequestMethod.GET)
    public ModelAndView index(@PathVariable("userId") Long userId){
        
        return new ModelAndView("users","users",repository.findOne(userId));
    }*/
    
    /*//find users in the same city
    @RequestMapping(value="users/{city}",method = RequestMethod.GET)
    public ModelAndView userByCity(@PathVariable("city") String city){
        return new ModelAndView("users", "users", repository.findByCity(city));
    }*/
    
    //add a user
    @RequestMapping(value="/users/add", method = RequestMethod.POST,consumes="application/x-www-form-urlencoded", produces = "application/json")
    public ModelAndView create(@ModelAttribute @Valid User user, BindingResult result){
        repository.save(user);
        return new ModelAndView("users","users",repository.findAll());
    }



    //get user profile
    @RequestMapping(value="/users/{userId}",method=RequestMethod.GET)
    public ModelAndView index2(@PathVariable("userId") Long userId){
        ModelAndView mv = new ModelAndView("userprofile");
        User user = repository.findOne(userId);
        mv.addObject("users",user);
        mv.addObject("recipe",recipeRepository.findByAuthor(user.getUserId(),new PageRequest(0,10)));
        return mv;

    }
    //get my profile
    @RequestMapping(value = "/myprofile", method = RequestMethod.GET)
    public ModelAndView user(HttpServletRequest request) {
        String userName = request.getRemoteUser();
        Long userId = repository.findByUsername(userName).getUserId();
        ModelAndView mv = new ModelAndView("userEdit");
        User user = repository.findOne(userId);
        mv.addObject("user", user);
        return mv;
    }



    //update user profile
    @RequestMapping(value="/users/{userId}/edit", method = RequestMethod.PUT,consumes="application/x-www-form-urlencoded", produces = "application/json")
    public String update(@RequestParam("password") String password,
                               @RequestParam("city") String city,
                               @RequestParam("email") String email,@PathVariable("userId") Long userId){
        User currentUser = repository.findOne(userId);
        currentUser.setCity(city);
        currentUser.setPassword(password);
        currentUser.setEmail(email);
        repository.save(currentUser);
        return "redirect:/users/"+userId;
    }

    
}
