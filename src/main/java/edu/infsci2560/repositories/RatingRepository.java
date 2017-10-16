package edu.infsci2560.repositories;

import edu.infsci2560.models.RatingPk;
import edu.infsci2560.models.Rating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface RatingRepository extends PagingAndSortingRepository<Rating, RatingPk> {

    //List<Rating> findByPkRecipeId(Long recipeId);

    //Rating findByPkRecipeIdAndPkUserId(Long recipeId, Long userId);

    Page<Rating> findByRatingPkRecipeId(Long recipeId, Pageable pageable);
    
}
