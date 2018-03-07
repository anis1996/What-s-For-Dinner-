package edu.sjsu.anis.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Nutrition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);
    }



    public void saveGoals(View view)
    {
        HashMap<String, Integer> nutrition = new HashMap<>();



try {
    Integer caloriesInt = Integer.parseInt((((EditText) findViewById(R.id.caloriesEdit)).getText().toString()));
    nutrition.put("Calories", caloriesInt);
    Integer carbohydratesInt = Integer.parseInt((((EditText) findViewById(R.id.carbohydratesEdit)).getText().toString()));
    nutrition.put("Carbohydrates", carbohydratesInt);
    Integer mineralsInt = Integer.parseInt((((EditText) findViewById(R.id.mineralsEdit)).getText().toString()));
    nutrition.put("Minerals", mineralsInt);
    Integer vitaminsInt = Integer.parseInt((((EditText) findViewById(R.id.vitaminsEdit)).getText().toString()));
    nutrition.put("Vitamins", vitaminsInt);
    Integer fatsInt = Integer.parseInt((((EditText) findViewById(R.id.fatsEdit)).getText().toString()));
    nutrition.put("Fats", fatsInt);
    Integer sugarsInt = Integer.parseInt((((EditText) findViewById(R.id.sugarsEdit)).getText().toString()));
    nutrition.put("Sugars", sugarsInt);
    Integer sodiumInt = Integer.parseInt((((EditText) findViewById(R.id.sodiumEdit)).getText().toString()));
    nutrition.put("Sodium", sodiumInt);
    Integer proteinInt = Integer.parseInt((((EditText) findViewById(R.id.proteinEdit)).getText().toString()));
    nutrition.put("Protein", proteinInt);

}catch (Exception s)
{

}
        RecipeData.getSingleton().setGoalNutrition(nutrition);

        Toast.makeText(this, "Set Nutrition Goal", Toast.LENGTH_LONG).show();
    }

}
