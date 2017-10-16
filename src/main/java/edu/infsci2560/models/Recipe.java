/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.infsci2560.models;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;


@Entity
public class Recipe{

    private static final long serialVersionUID = 1L;

    public enum RecipeType {
        Meat,
        Pasta,
        Soup,
        Salad,
        Vegetarian,
        Unknown
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected String name;

    protected RecipeType recipeType;

    protected String calories;

    //protected String ingredients;
    @ElementCollection(targetClass=String.class)
    protected List<String> ingredients;

    //protected String  description;
    @ElementCollection(targetClass=String.class)
    protected List<String> description;

    protected String  timeNeed;

    protected Long   author;

    //protected float average;

    public Recipe() {
        this.id = Long.MAX_VALUE;
        this.name = null;
        this.recipeType = RecipeType.Unknown;
        this.calories = null;
        this.description = null;
        this.timeNeed = null;
        this.author = null;
    }


    public Recipe(Long id, String name, RecipeType recipeType, String calories, List<String> ingredients, List<String> description, String timeNeed) {
        this.id = id;
        this.name = name;
        this.recipeType = recipeType;
        this.calories = calories;
        this.ingredients = ingredients;
        this.description = description;
        this.timeNeed = timeNeed;
    }

    @Override
    public String toString() {
        return "[ id=" + this.id + ", name=" + this.name + ", recipeType=" + this.recipeType + ", calories=" +this.calories+", timeNeed=" +this.timeNeed+", ingredients="+this.ingredients+", description="+this.description+", author="+this.author+" ]";
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the recipeType
     */
    public RecipeType getRecipeType() {
        return recipeType;
    }

    /**
     * @param recipeType the recipeType to set
     */
    public void setRecipeType(RecipeType recipeType) {
        this.recipeType = recipeType;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * @return the calories
     */
    public String getCalories() {
        return calories;
    }

    /**
     * @param calories the calories to set
     */
    public void setCalories(String calories) {
        this.calories = calories;
    }

    /**
     * @return the description
     */

    //public String getDescription() {
        //return description;
    //}

    /**
     * @param description the description to set
     */
    //public void setDescription(String description) {
        //this.description = description;
    //}

    /**
     * @return the timeNeed
     */
    public String getTimeNeed() {
        return timeNeed;
    }

    /**
     * @param timeNeed the timeNeed to set
     */
    public void setTimeNeed(String timeNeed) {
        this.timeNeed = timeNeed;
    }


    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    /*public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }*/
}
