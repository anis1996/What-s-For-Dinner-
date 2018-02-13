package edu.sjsu.anis.whatsfordinner;
import java.util.ArrayList;
import android.graphics.drawable.Drawable;

/**
 * Created by anisdhapa on 2/13/18.
 */

public class Recipe {
    private Drawable image;
    private String recipeName;
    private ArrayList<String> ingredients;
    private String direction;

    public Recipe(String name, ArrayList<String> ingredients, String directions, Drawable img) {
        this.recipeName = name;
        this.ingredients = ingredients;
        this.image= img;
        this.direction = directions;
    }

    public String getRecipeName() {
        return recipeName;
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
