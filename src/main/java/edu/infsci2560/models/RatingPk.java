package edu.infsci2560.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.util.Objects;

@Embeddable
public class RatingPk implements Serializable {
    


    private Long recipeId;

    private Long userId;

    public RatingPk() {
    }

    /**
     * Fully initialize a Rating Pk
     *
     * @param recipeId
     * @param userId
     */
    public RatingPk(Long recipeId, Long userId) {
        this.recipeId = recipeId;
        this.userId = userId;
    }
    @Override
    public String toString() {
                return "[ recipeId =" + this.recipeId + ", userId=" + this.userId +" ]";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RatingPk other = (RatingPk) obj;
        if ( !Objects.equals(other.recipeId, recipeId) )
            return false;

        return Objects.equals(other.getUserId(), getUserId());

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.getRecipeId());
        hash = 29 * hash + Objects.hashCode(this.getUserId());
        return hash;
    }



    public Long getRecipeId() {
        return recipeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setRecipeId(Long recipeId){
        this.recipeId = recipeId;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }


}
