package edu.temple.paletteactivity3;

//import stuff
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.TextView;

/**
 * Created by seanmcnamara on 3/13/18.
 */

public class PaletteAdapter extends BaseAdapter{
    //Made this array so help display background color on each of the "cells" for grid view
    static final String[] color_array = {"Red", "Blue", "Yellow", "Green", "Gray"};
    Context context;
    String[] colors;

    //My PaletteAdapter function
    public PaletteAdapter (Context c, String[] colors) {
        this.context = c;
        this.colors = colors;
    }

    //Override functions that we use for adapters are down below
    @Override
    //getCount returns amount of colors
    public int getCount() {
        return colors.length;
    }

    @Override
    //getItem returns a specific color in the colors array
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    //They dont have id's so return 0
    public long getItemId(int position) {
        return 0;
    }

    @Override
    //Out getView function to allow us to make changes to fragments
    public View getView(int position, View convertView, ViewGroup parent) {
        //Make a new GridLayout with our context
        GridLayout grid_layout = new GridLayout(context);
        //Make a new TextView with context
        TextView text_view = new TextView(context);
        //Put in the text of the colors that we are using
        text_view.setText(colors[position]);
        //Setting the size of the text
        text_view.setTextSize(30);
        //Adding our text view of colors to our grid layout
        grid_layout.addView(text_view);
        //Setting the background color of each 'cell' to the color that is on it
        grid_layout.setBackgroundColor(Color.parseColor(color_array[position]));
        //Return grid_layout at the end
        return grid_layout;
    }
}
