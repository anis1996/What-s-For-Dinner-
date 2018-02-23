package edu.sjsu.anis.whatsfordinner;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;

public class NewDishPage extends AppCompatActivity {


    ArrayList<AutoCompleteTextView> texts ;

    RecipeData data;


    String recName;
    Recipe recipe;
    boolean hasRecipe = false;

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

        ImageView imageViewPick = (ImageView) findViewById(R.id.imagePick);
        imageViewPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                photoPickerIntent.putExtra(Intent.EXTRA_LOCAL_ONLY, true); // this is the flag that does the trick
                startActivityForResult(photoPickerIntent, 1);


// this goes in onActivityResult(int requestCode, int resultCode, Intent data)

            }
        });



        for (AutoCompleteTextView actv : texts)
        {

            data = RecipeData.getSingleton();
            if(data.getIngredients().size() != 0) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, data.getIngreds());
                actv.setAdapter(adapter);
            }
            actv.setThreshold(0);

        }
       // second.setAdapter(new SearchSuggestionsAdapter(this, second.getText().toString()));

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent f)
    {

        if(resultCode == Activity.RESULT_OK){
            Uri imageUri = f.getData();
            ImageView userImage = (ImageView) findViewById(R.id.imagePick);
            userImage.setImageURI(imageUri);
            // do stuff with the imageUri
        }
    }



    public void saveRecipe(View view) {
        ArrayList<String> ingrid = new ArrayList<>();

         recName = ((EditText)findViewById(R.id.recipeNameET)).getText().toString();
        for (AutoCompleteTextView actv : texts)
        {
                ingrid.add(actv.getText().toString());
        }

        String dir = ((EditText) findViewById(R.id.directionEdit)).getText().toString();
        recipe = new Recipe(recName,ingrid,dir);

        // check if recipe is already exit in data
        for (String r : data.getSingleton().getRecipeNames()) {
            if (r.equalsIgnoreCase(recName)) {
                hasRecipe = true;
            }
        }

        if(!hasRecipe) {
            data = RecipeData.getSingleton();
            data.addRecipe(recipe);
            Toast.makeText(NewDishPage.this, "Recipe Saved", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainScreen.class);
            startActivity(intent);
        }else
        {
            Toast deny = Toast.makeText(NewDishPage.this, "Recipe name already exists, please enter a new one", Toast.LENGTH_LONG);
            deny.show();
            hasRecipe = false;
        }


    }
}
