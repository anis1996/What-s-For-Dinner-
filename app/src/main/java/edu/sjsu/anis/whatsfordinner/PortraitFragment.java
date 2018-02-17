package edu.sjsu.anis.whatsfordinner;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PortraitFragment extends Fragment {

    ListView listview;

    public PortraitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View view = inflater.inflate(R.layout.fragment_portrait, container, false);

        listview = (ListView) view.findViewById(R.id.recipelist);
        ArrayAdapter adapter= new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_activated_1, RecipeData.getSingleton().getRecipeNames());
        listview.setAdapter(adapter);
        return view;





    }

}
