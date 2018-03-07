package edu.sjsu.anis.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MealsPage extends AppCompatActivity {

    int totalCalories = 0;
    int totalCarbohydrates = 0;
    int totalMinerals = 0;
    int totalVitamins =  0;
    int totalFats = 0;
    int totalSugars =0;
    int totalSodium = 0;
    int totalProtein=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_page);
        ArrayList<Spinner> mealSpinner = new ArrayList<Spinner>();

        mealSpinner.add( (Spinner)findViewById(R.id.subreakfast));
        mealSpinner.add( (Spinner) findViewById(R.id.sulunch));
        mealSpinner.add( (Spinner) findViewById(R.id.sudinner));
        mealSpinner.add(  (Spinner) findViewById(R.id.mbreakfast));
        mealSpinner.add( (Spinner) findViewById(R.id.mlunch));
        mealSpinner.add( (Spinner) findViewById(R.id.mdinner));
        mealSpinner.add(  (Spinner) findViewById(R.id.tbreakfast));
        mealSpinner.add(  (Spinner) findViewById(R.id.tlunch));
        mealSpinner.add(  (Spinner) findViewById(R.id.tdinner));
        mealSpinner.add(  (Spinner) findViewById(R.id.wbreakfast));
        mealSpinner.add( (Spinner) findViewById(R.id.wlunch));
        mealSpinner.add(  (Spinner) findViewById(R.id.wdinner));
        mealSpinner.add(  (Spinner) findViewById(R.id.thbreakfast));
        mealSpinner.add( (Spinner) findViewById(R.id.thlunch));
        mealSpinner.add( (Spinner) findViewById(R.id.thdinner));
        mealSpinner.add(  (Spinner) findViewById(R.id.fbreakfast));
        mealSpinner.add(  (Spinner) findViewById(R.id.flunch));
        mealSpinner.add( (Spinner) findViewById(R.id.fdinner));
        mealSpinner.add(  (Spinner) findViewById(R.id.sabreakfast));
        mealSpinner.add(  (Spinner) findViewById(R.id.salunch));
        mealSpinner.add(  (Spinner) findViewById(R.id.sadinner));


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, RecipeData.getSingleton().getMeals());

        for (final Spinner spi : mealSpinner) {

            spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    // your code here

                   String meal = (String) parentView.getItemAtPosition(position);
                    Recipe r = RecipeData.getSingleton().getRecipeFromName(meal);

                    String finalShowingStirng = "";
                    try {

                        if (r != null) {

                            HashMap<String, Integer> recipeNutrition = r.getNutrition();
                            HashMap<String, Integer> nutritionGoal = RecipeData.getSingleton().getGoalNutrition();

                            //Calories
                            String Calories = "Calories(Goal: " + nutritionGoal.get("Calories") + ") ";
                            String RecipeCalories = "" + (recipeNutrition.get("Calories") + totalCalories);
                            Log.d(RecipeCalories, "onFocusChange: ");
                            Calories = Calories + RecipeCalories;
                            if ((recipeNutrition.get("Calories") + totalCalories) > nutritionGoal.get("Calories")) {
                                Calories = Calories + " GOAL IS MET";
                            }
                            finalShowingStirng += Calories + "\n";
                            totalCalories = totalCalories + recipeNutrition.get("Calories");
                            //Carbohydrates
                            String Carbohydrates = "Carbohydrates(Goal: " + nutritionGoal.get("Carbohydrates") + ") ";
                            String RecipeCarbohydrates = "" + (recipeNutrition.get("Carbohydrates") + totalCarbohydrates);
                            Carbohydrates = Carbohydrates + RecipeCarbohydrates;
                            if ((recipeNutrition.get("Carbohydrates") + totalCarbohydrates) > nutritionGoal.get("Carbohydrates")) {
                                Carbohydrates = Carbohydrates + " GOAL IS MET";
                            }
                            finalShowingStirng += Carbohydrates + "\n";
                            totalCarbohydrates = totalCarbohydrates + recipeNutrition.get("Carbohydrates");
                            //Minerals
                            String Minerals = "Minerals(Goal: " + nutritionGoal.get("Minerals") + ") ";
                            String RecipeMinerals = "" + (recipeNutrition.get("Minerals") + totalMinerals);
                            Minerals = Minerals + RecipeMinerals;
                            if ((recipeNutrition.get("Minerals") + totalMinerals) > nutritionGoal.get("Minerals")) {
                                Minerals = Minerals + " GOAL IS MET";
                            }
                            finalShowingStirng += Minerals + "\n";
                            totalMinerals = totalMinerals + recipeNutrition.get("Minerals");

                            //Vitamins
                            String Vitamins = "Vitamins(Goal: " + nutritionGoal.get("Vitamins") + ") ";
                            String RecipeVitamins = "" + (recipeNutrition.get("Vitamins") + totalVitamins);
                            Vitamins = Vitamins + RecipeVitamins;
                            if ((recipeNutrition.get("Vitamins") + totalVitamins > nutritionGoal.get("Vitamins"))) {
                                Vitamins = Vitamins + " GOAL IS MET";
                            }
                            finalShowingStirng += Vitamins + "\n";
                            totalVitamins = totalVitamins + recipeNutrition.get("Vitamins");

                            //Fats
                            String Fats = "Fats(Goal: " + nutritionGoal.get("Fats") + ") ";
                            String RecipeFats = "" + (recipeNutrition.get("Fats") + totalFats);
                            Fats = Fats + RecipeFats;
                            if ((recipeNutrition.get("Fats") + totalFats > nutritionGoal.get("Fats"))) {
                                Fats = Fats + " GOAL IS MET";
                            }
                            finalShowingStirng += Fats + "\n";
                            totalFats = totalFats + recipeNutrition.get("Fats");

                            //Sugars
                            String Sugars = "Sugars(Goal: " + nutritionGoal.get("Sugars") + ") ";
                            String RecipeSugars = "" + (recipeNutrition.get("Sugars") + totalSugars);
                            Sugars = Sugars + RecipeSugars;
                            if ((recipeNutrition.get("Sugars") + totalSugars > nutritionGoal.get("Sugars"))) {
                                Sugars = Sugars + " GOAL IS MET";
                            }
                            finalShowingStirng += Sugars + "\n";
                            totalSugars = totalSugars + recipeNutrition.get("Sugars");

                            //Sodium
                            String Sodium = "Sodium(Goal: " + nutritionGoal.get("Sodium") + ") ";
                            String RecipeSodium = "" + (recipeNutrition.get("Sodium") + totalSodium);
                            Sodium = Sodium + RecipeSodium;
                            if ((recipeNutrition.get("Sodium") + totalSodium > nutritionGoal.get("Sodium"))) {
                                Sodium = Sodium + " GOAL IS MET";
                            }
                            finalShowingStirng += Sodium + "\n";
                            totalSodium = totalSodium + recipeNutrition.get("Sodium");

                            //Protein
                            String Protein = "Protein(Goal: " + nutritionGoal.get("Protein") + ") ";
                            String RecipeProtein = "" + (recipeNutrition.get("Protein") + totalProtein);
                            Protein = Protein + RecipeProtein;
                            if ((recipeNutrition.get("Protein") + totalProtein > nutritionGoal.get("Protein"))) {
                                Protein = Protein + " GOAL IS MET";
                            }
                            finalShowingStirng += Protein + "\n";
                            totalProtein = totalProtein + recipeNutrition.get("Protein");




                        }
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    TextView detail = (TextView) findViewById(R.id.detailsofNutrition);
                    detail.setText(finalShowingStirng);
                    if (!meal.equalsIgnoreCase("Eating outside")) {

                        RecipeData.getSingleton().deleteFromMeals(meal);



                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // your code here
                }

            });


            spi.setAdapter(arrayAdapter); // setting adapter for each spineer
            spi.setSelection(0);
            spi.setFocusable(true);
            spi.setFocusableInTouchMode(true);
        }
    }

    public void clickNutrition(View view )
    {
        Intent i = new Intent(this, Nutrition.class);
        startActivity(i);
    }

}
