package edu.temple.paletteactivity3;

//Stuff to import
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;

/**
 * Created by seanmcnamara on 3/13/18.
 */


public class MainActivity extends AppCompatActivity implements PaletteFragment.PaletteInterface{
    //Make a global CanvasFragment
    CanvasFragment canvas_frag;

    //onCreate Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //new CanvasFragment called canvas_frag
        canvas_frag = new CanvasFragment();
        //We will make our first frag our palette fragment
        add_frag(new PaletteFragment(), R.id.frag_one);
        //Then make our second fragment the canvas fragment
        add_frag(canvas_frag, R.id.frag_two);
    }

    //Made a function that will add a fragment, takes in the frag and the id of container
    private void add_frag(Fragment frag, int id) {
        getFragmentManager().beginTransaction().replace(id, frag).commit();
    }

    //Function to set the color on the canvas fragment to the color that is chosen.
    @Override
    public void message(String color) {
        canvas_frag.setColor(color);
    }


}
