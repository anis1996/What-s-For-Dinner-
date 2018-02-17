package edu.sjsu.anis.whatsfordinner;

import java.util.ArrayList;

/**
 * Created by anisdhapa on 2/17/18.
 */

public class RecipeData {
    private static final RecipeData singleton = new RecipeData();
    private ArrayList<Recipe> recipes = new ArrayList<>();
    private ArrayList<String> recipeNames = new ArrayList<>();


    static RecipeData getSingleton()
    {
        return singleton;
    }

    public void addRecipe(Recipe re) {
        recipes.add(re);
        recipeNames.add(re.getRecipeName());
    }


    public ArrayList<Recipe> getRecipeList() {
        return recipes;
    }
    public void removeRecipe(Recipe r) {
        if (recipes.contains(r)) {
            recipes.remove(r);
        }
    }
    public ArrayList<String> getRecipeNames()
    {
        return recipeNames;
    }





}
