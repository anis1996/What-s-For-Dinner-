package edu.sjsu.anis.whatsfordinner;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ImageButton wfd = ( ImageButton)   (findViewById(R.id.mainScreen));


        wfd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainScreen.this, pop.class));
            }
        });
    }

    public void startMealsPage(View view) {
        Intent intent = new Intent(this, MealsPage.class);
        startActivity(intent);
    }

    public void startRecipes(View view) {
        Intent intent = new Intent(this, RecipesList.class);
        startActivity(intent);
    }

    public void startGroceries(View view) {
        Intent intent = new Intent(this, GroceriesPage.class);
        startActivity(intent);
    }

    public void startNewDish(View view) {
        Intent intent = new Intent(this, NewDishPage.class);
        startActivity(intent);
    }
}
