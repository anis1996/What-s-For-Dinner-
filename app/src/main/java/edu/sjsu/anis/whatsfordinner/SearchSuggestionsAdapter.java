package edu.sjsu.anis.whatsfordinner;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anisdhapa on 2/13/18.
 */
public class SearchSuggestionsAdapter extends ArrayAdapter<String> {

    List<String> types = new ArrayList<>();
    protected static final String TAG = "SuggestionAdapter";
    private List<String> suggestions;
    private Context context;

    public SearchSuggestionsAdapter(Activity context, String nameFilter) {
        super(context, android.R.layout.simple_dropdown_item_1line);
        suggestions = new ArrayList<String>();
        this.context = context;
    }

    @Override
    public int getCount() {
        return suggestions.size();
    }

    @Override
    public String getItem(int index) {
        return suggestions.get(index);
    }

    @Override
    public Filter getFilter() {
        Filter myFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();

                if (constraint != null) {

                    //Get new results from backend
                    //searchItemsFromServer is the method that returns the data
                    //new data is successfully sent. no problem there


                    filterResults.values = suggestions;
                    filterResults.count = suggestions.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence contraint,
                                          FilterResults results) {
                if (results != null && results.count > 0) {
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };
        return myFilter;
    }
}