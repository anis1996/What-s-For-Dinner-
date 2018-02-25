package edu.sjsu.anis.whatsfordinner;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecipesList extends AppCompatActivity implements ListFragment.onItemSelectedListners{
    Recipe rec ;
    TextView t1;
    RecipeData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

    }

    public void onMenuItemSelected(Recipe rec)
    {
        InformationFragment informationFragment = (InformationFragment) getFragmentManager().findFragmentById(R.id.informationLand);


        if(informationFragment != null && informationFragment.isInLayout())
        {
            informationFragment.changeRecipe(rec);
        }else
        {
            RecipeData.getSingleton().addtoMeals(rec);
           Toast.makeText(this, "Recipe added to Meals", Toast.LENGTH_LONG).show();
        }
    }



}
