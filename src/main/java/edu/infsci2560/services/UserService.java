package edu.infsci2560.services;

import edu.infsci2560.models.User;
import edu.infsci2560.models.Rating;
import edu.infsci2560.repositories.UserRepository;
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
@RequestMapping(value="/users")
public class UserService {

    @Autowired
    private UserRepository repository;

    /*@RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Iterable<User>> list() {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.findAll(), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<User> list(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.findOne(id), headers, HttpStatus.OK);
    }*/

    /*@RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity <User> findByUserName(@PathVariable("username") String username) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.findByUserName(username), headers, HttpStatus.OK);
    }*/

    /*@RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public ResponseEntity<User> create(@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.save(user), headers, HttpStatus.OK);
    }
    
    @RequestMapping(value ="/{city}", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Iterable<User>> findByCity(@PathVariable("city") String city){
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(repository.findByCity(city),headers, HttpStatus.OK);
    }*/


    
    
}
