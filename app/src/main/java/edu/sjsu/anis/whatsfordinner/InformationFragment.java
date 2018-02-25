package edu.sjsu.anis.whatsfordinner;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InformationFragment extends Fragment {


    public InformationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.information_fragment, container, false);
    }


    public void changeRecipe(Recipe r)
    {
        TextView recipeNameText = (TextView) getView().findViewById(R.id.recipeNameInInformation);
        recipeNameText.setText(r.getRecipeName());
        ListView listOfIngri = (ListView) getView().findViewById(R.id.ingInInformation) ;
        ArrayAdapter adapter= new ArrayAdapter<String>(getView().getContext(), android.R.layout.simple_list_item_activated_1,r.getIngredients());
        listOfIngri.setAdapter(adapter);
        TextView descriptionInformation = (TextView) getView().findViewById(R.id.descriptionInInformation);
        descriptionInformation.setText(r.getDirection());
        ImageView imageInInformation = (ImageView) getView().findViewById(R.id.imageViewInInformation);
        imageInInformation.setImageDrawable(r.getImage());
    }


}
