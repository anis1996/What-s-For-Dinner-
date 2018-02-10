package edu.sjsu.anis.whatsfordinner;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;

/**
 * Created by anisdhapa on 2/8/18.
 */

public class pop extends Activity{

    //need to change background color for pop window
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = (int) (dm.widthPixels * 0.7);
        int height = (int) (dm.heightPixels * 0.30);

        getWindow().setLayout(width ,height );
    }
}
