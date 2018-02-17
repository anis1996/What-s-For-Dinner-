package edu.sjsu.anis.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashSet;

public class NewDishPage extends AppCompatActivity {


    ArrayList<AutoCompleteTextView> texts ;

    RecipeData data;


    Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dish_page);

        texts = new ArrayList<>();

        AutoCompleteTextView firstACTV = (AutoCompleteTextView) findViewById(R.id.ing1);
        texts.add(firstACTV);
        AutoCompleteTextView secondACTV = (AutoCompleteTextView) findViewById(R.id.ing2);
        texts.add(secondACTV);
        AutoCompleteTextView thirdACTV = (AutoCompleteTextView) findViewById(R.id.ing3);
        texts.add(thirdACTV);
        AutoCompleteTextView fourthACTV = (AutoCompleteTextView) findViewById(R.id.ing4);
        texts.add(fourthACTV);
        AutoCompleteTextView fifthACTV = (AutoCompleteTextView) findViewById(R.id.ing5);
        texts.add(fifthACTV);
        AutoCompleteTextView sixthACTV = (AutoCompleteTextView) findViewById(R.id.ing6);
        texts.add(sixthACTV);
        AutoCompleteTextView sevenACTV = (AutoCompleteTextView) findViewById(R.id.ing7);
        texts.add(sevenACTV);
        AutoCompleteTextView eightACTV = (AutoCompleteTextView) findViewById(R.id.ing8);
        texts.add(eightACTV);
        AutoCompleteTextView nineACTV = (AutoCompleteTextView) findViewById(R.id.ing9);
        texts.add(nineACTV);
        AutoCompleteTextView tenACTV = (AutoCompleteTextView) findViewById(R.id.ing10);
        texts.add(tenACTV);




        for (AutoCompleteTextView actv : texts)
        {
           // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item, drop);
           // actv.setAdapter(adapter);
            actv.setThreshold(0);

        }
       // second.setAdapter(new SearchSuggestionsAdapter(this, second.getText().toString()));

    }




    public void saveRecipe(View view) {
        ArrayList<String> ingrid = new ArrayList<>();

        String recName = ((EditText)findViewById(R.id.recipeNameET)).getText().toString();
        for (AutoCompleteTextView actv : texts)
        {
                ingrid.add(actv.getText().toString());
        }

        String dir = ((EditText) findViewById(R.id.directionEdit)).getText().toString();
        recipe = new Recipe(recName,ingrid,dir);

        data = RecipeData.getSingleton();
        data.addRecipe(recipe);

        Intent intent = new Intent(this,MainScreen.class);
        startActivity(intent);


    }
}
