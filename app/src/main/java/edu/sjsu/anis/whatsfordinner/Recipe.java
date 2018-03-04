package edu.sjsu.anis.whatsfordinner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by anisdhapa on 2/13/18.
 */

public class Recipe implements Serializable{
    private Drawable image;
    private String recipeName;
    private ArrayList<String> ingredients;
    private String direction;
    private HashMap<String, Integer> nutrition ;


    public Recipe(String name, ArrayList<String> ingredients, String directions) {
        this.recipeName = name;
        this.ingredients = ingredients;
        this.direction = directions;
        nutrition = new HashMap<>();
    }

    public String getRecipeName() {
        return recipeName;
    }
    public void setNutrition(HashMap<String,Integer> n)
    {
        nutrition = n;
    }

    public HashMap<String, Integer> getNutrition()
    {
        return nutrition;
    }


    public void setRecipeName(String name) {
        this.recipeName = name;
    }
    public ArrayList<String> getIngredients() {
        return ingredients;
    }
    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return getRecipeName();
    }



    @Override
    public boolean equals(Object obj) {
        Recipe r = (Recipe) obj;
        if (this.recipeName.equals(r.getRecipeName())) {
            return true;
        }else{
            return false;
        }
    }



}
