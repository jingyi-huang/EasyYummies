package edu.infsci2560.services;


import edu.infsci2560.models.RatingPk;
import edu.infsci2560.models.Rating;
import edu.infsci2560.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;


public class RatingService{
    
    @Autowired
    private RatingRepository repository;
    
    /*
    //create a rating for a recipe    
    @RequestMapping(method = RequestMethod.PUT, consumes="application/json", produces="application/json")
    public ResponseEntity<Rating> create(Long recipeId, Long userId, Integer score, String comment){
        HttpHeaders headers = new HttpHeaders();
        Rating rating = repository.findByPkRecipeIdAndPkUserId(recipeId, userId);
        if(rating==null){
            rating = new Rating(new RatingPk(recipeId, userId),score,comment);
        }else{
            rating.setScore(score);
            rating.setComment(comment);
        }
        return new ResponseEntity<>(repository.save(rating), headers, HttpStatus.OK);     
    }
    
    //find all ratings for a recipe
    @RequestMapping(method = RequestMethod.GET, produces="application/jason")
    public ResponseEntity<Iterable<Rating>> findAllRatingsForOne(Long recipeId){
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.findByPkRecipeId(recipeId),headers, HttpStatus.OK);
    }*/
        
        
    
}
