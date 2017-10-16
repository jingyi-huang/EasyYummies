package edu.infsci2560.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {



    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Long userId;



    @Column(length = 30, unique = true)
    public String username;

    @Column
    public String city;

    @Column
    public String email;

    @Column
    private String password;

    //@OneToMany
    //public Set<Recipe> recipes = new HashSet<>();

    public User() {}

    public User(String username, String password, String email, String city) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d, username='%s', password='%s', email='%s', city='%s']", getUserId(), getUserName(), getPassword(),getEmail(), getCity());
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the id to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return username
     */
    public String getUserName() {
        return username;
    }

    /**
     * @param username
     */
    public void setUserName(String username) {
        this.username = username;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password=password;
    }

    /*public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }*/
}
