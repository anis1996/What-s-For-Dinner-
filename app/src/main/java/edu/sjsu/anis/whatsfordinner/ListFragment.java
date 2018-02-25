package edu.sjsu.anis.whatsfordinner;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    ListView listview;
    String selectedRecipeName;
    RecipeData data = RecipeData.getSingleton();
    Recipe selectedRecipe;
    private onItemSelectedListners listner;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View view = inflater.inflate(R.layout.list_fragment, container, false);

        listview = (ListView) view.findViewById(R.id.recipelist);
        ArrayAdapter adapter= new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_activated_1, RecipeData.getSingleton().getRecipeNames());
        listview.setAdapter(adapter);
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                selectedRecipeName = (String) arg0.getItemAtPosition(pos);

                selectedRecipe = data.getRecipeFromName(selectedRecipeName);
                Intent i = new Intent(getActivity(), NewDishPage.class);


                i.putExtra("information", selectedRecipe.getRecipeName());
                startActivity(i);
                return true;

            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               selectedRecipeName = (String) adapterView.getItemAtPosition(i);

               selectedRecipe = data.getRecipeFromName(selectedRecipeName);
               update();

            }
        });

        return view;

    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if(context instanceof onItemSelectedListners)
        {
            listner = (onItemSelectedListners) context;
        }
    }

    public interface onItemSelectedListners
    {
        public void onMenuItemSelected(Recipe rec);
    }

    public void update()
    {
        listner.onMenuItemSelected(selectedRecipe);
    }


}
