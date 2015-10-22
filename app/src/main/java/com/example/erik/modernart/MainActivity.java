package com.example.erik.modernart;

import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SeekBar mSeekBar;
    private List<Rectangle> mColoredRectangles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // fill mColoredRectangles
        for (View view : getColoredRectangleViews()) {
            int initColor = ((ColorDrawable) view.getBackground()).getColor();
            int finalColor =  Math.min(initColor + 100, 225);
            mColoredRectangles.add(new Rectangle(view, initColor, finalColor));
        }

        mSeekBar = (SeekBar) findViewById(R.id.seekBar);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                for (Rectangle rect : mColoredRectangles) {

                    // get initial color of the current rectangle
                    int initialColor = rect.getInitialColor();

                    // determine ratio of change in the progress bar
                    double ratio = (0.0 + progress)/ mSeekBar.getMax();

                    // calculate the components of the new color
                    int red = (int) (Color.red(initialColor) + rect.getRedGradient() * ratio);
                    int green = (int) (Color.green(initialColor) + rect.getGreenGradient() * ratio);
                    int blue = (int) (Color.blue(initialColor) + rect.getBlueGradient() * ratio);

                    // set the new color
                    rect.setColor(Color.argb(Color.alpha(initialColor), red, green, blue));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    private List<View> getColoredRectangleViews() {
        List<View> rectViews = new ArrayList<>();

        rectViews.add(findViewById(R.id.colored_rect1));
        rectViews.add(findViewById(R.id.colored_rect2));
        rectViews.add(findViewById(R.id.colored_rect3));

        return rectViews;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.more_info) {
            DialogFragment dialog = new MoreInfoDialogFragment();
            dialog.show(getFragmentManager(), "fragment_edit_name");
        }

        return super.onOptionsItemSelected(item);
    }
}
