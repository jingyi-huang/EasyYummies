package edu.infsci2560.repositories;

import edu.infsci2560.models.User;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    
    User findByUsername(String username);
    //List<User> findByCity(String city);
}
