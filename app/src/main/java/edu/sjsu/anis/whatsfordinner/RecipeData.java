package edu.sjsu.anis.whatsfordinner;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by anisdhapa on 2/17/18.
 */

public class RecipeData {
    private static final RecipeData singleton = new RecipeData();
    private ArrayList<Recipe> recipes = new ArrayList<>();
    private ArrayList<String> recipeNames = new ArrayList<>();
    private HashMap<String, Integer> ingredients = new HashMap<String, Integer>();
    private ArrayList<String> mealsString = new ArrayList<String>();


    static RecipeData getSingleton()
    {
        return singleton;
    }

    private RecipeData()
    {
        mealsString.add("Eating Outside");
    }


    public void addRecipe(Recipe re) {
        recipes.add(re);
        recipeNames.add(re.getRecipeName());
        addIngredients(re.getIngredients());
    }

    public void deletRecipe(Recipe r)
    {
        recipes.remove(r);
        recipeNames.remove(r.getRecipeName());

    }


    public Recipe getRecipeFromName(String s)
    {
        for(Recipe r: recipes)
        {
            if(r.getRecipeName().equals(s))
            {
                return r;
            }
        }

        return null;
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


    public void addIngredients(String ing) {
        ing = ing.toLowerCase();

        if (ingredients.containsKey(ing)) {
            int newVal = ingredients.get(ing) + 1;
            ingredients.put(ing, newVal);
        }
        else {
            ingredients.put(ing, 1);
        }

    }

    public void addIngredients(ArrayList<String> ss) {
        for (String s : ss) {
            s = s.toLowerCase();
            addIngredients(s);
        }
    }

    public void removeIngredients(String ing) {
        ing = ing.toLowerCase();

        if (ingredients.containsKey(ing)) {
            if (ingredients.get(ing) < 1) {
                ingredients.remove(ing);
            }
            else {
                int newV = ingredients.get(ing) - 1;
                ingredients.put(ing, newV);
            }
        }
    }
    public HashMap<String, Integer> getIngredients() {
        return ingredients;
    }

    public ArrayList<String> getIngreds() {
        ArrayList<String> ingreds = new ArrayList<String>();
        for (String s : ingredients.keySet()) {
            if (ingredients.get(s) > 0) {
                ingreds.add(s);
            }
        }
        return ingreds;
    }

    public void addtoMeals(Recipe r)
    {
        mealsString.add(r.getRecipeName());
    }

    public void deleteFromMeals(String meal)
    {
        mealsString.remove(meal);
    }


    public ArrayList<String> getMeals()
    {
        return mealsString;
    }


}
