package edu.sjsu.anis.whatsfordinner;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipesList extends AppCompatActivity {
    Recipe rec ;
    TextView t1;
    RecipeData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_list);

        Configuration config = getResources().getConfiguration();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();

        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            LandscapeFragment landscapeFragment = new LandscapeFragment();
            fragmentTransaction.replace(android.R.id.content,landscapeFragment);
        } else {
            PortraitFragment portraitFragment = new PortraitFragment();
            fragmentTransaction.replace(android.R.id.content, portraitFragment);
        }
        fragmentTransaction.commit();


       
    }





}
