package edu.temple.paletteactivity3;

//import stuff
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


public class PaletteFragment extends Fragment {


    static final String[] color_array = {"Red", "Blue", "Yellow", "Green", "Gray"};

    public PaletteFragment() {
        //Need an empty constructer
    }

    //My override functions
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //My onCreateView function
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_palette, container, false);
        //Make a GridView and give it the layout of our grid view with id grid_view
        GridView grid_view = (GridView)layout.findViewById(R.id.grid_view);
        //Getting the resources
        Resources res = getResources();
        //get the string array from strings.xml and put i
        String[] color_array = res.getStringArray(R.array.colors);
        //Use the PaletteAdapter we made to make a PaletteAdapter object
        final PaletteAdapter palette_adapter = new PaletteAdapter(getActivity(), color_array);
        //Setting our adapter for grid_view to the palette_adapter
        grid_view.setAdapter(palette_adapter);
        //Have onItemClickListener so we can interact with fragments when "cells" are clicked
        grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Set text_color to the color that we chose
                String text_color = PaletteFragment.color_array[position];
                //Send out the message
                ((PaletteInterface) getActivity()).message(text_color);
            }
        });
        return layout;
    }


    public interface PaletteInterface {
        void message(String color);

    }

}
