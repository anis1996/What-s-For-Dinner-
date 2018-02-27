package edu.sjsu.anis.whatsfordinner;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;


public class GroceriesPage extends AppCompatActivity {

     ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries_page);


//
        final SwipeMenuListView listView = (SwipeMenuListView) findViewById(R.id.listView);

//        ArrayAdapter adapter = null;
//        if(!RecipeData.getSingleton().getIngreds().isEmpty()) {
              adapter = new ArrayAdapter<String>(GroceriesPage.this, android.R.layout.simple_list_item_1, RecipeData.getSingleton().displayIngri());
            listView.setAdapter(adapter);
//        }


        // got this sources code from this link https://github.com/baoyongzhang/SwipeMenuListView
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth(170);
                // set item title
                openItem.setTitle("--");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(170);
                // set a icon
                deleteItem.setIcon(R.drawable.ic_addbutton);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

// set creator
        listView.setMenuCreator(creator);




        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                String item = (String) adapter.getItem(position);

                switch (index) {
                    case 0:
                        // open
                        RecipeData.getSingleton().removeIngredients(item);
                        adapter.notifyDataSetChanged();

//                        Log.d(item.substring(0,item.indexOf("-")-1), "onMenuItemClick: ");
//                        Log.d(RecipeData.getSingleton().displayIngri().get(0), "onMenuItemClick: ");
                        break;
                    case 1:
                        // delete
                        RecipeData.getSingleton().addIngredients(item);
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });
    }


}
