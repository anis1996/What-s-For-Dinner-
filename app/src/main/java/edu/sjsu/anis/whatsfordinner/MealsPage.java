package edu.sjsu.anis.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MealsPage extends AppCompatActivity {

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
            //issue : have to double click on spinner in order to open list
            spi.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if (!b) {
                        String meal = (String) spi.getSelectedItem();
                        if (!meal.equalsIgnoreCase("Eating outside")) {
                            RecipeData.getSingleton().deleteFromMeals(meal);
                        }
                    }

                }
            });

            spi.setAdapter(arrayAdapter);


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
