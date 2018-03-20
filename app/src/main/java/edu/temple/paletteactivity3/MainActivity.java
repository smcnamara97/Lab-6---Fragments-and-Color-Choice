package edu.temple.paletteactivity3;

//Stuff to import
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * Created by seanmcnamara on 3/13/18.
 */


public class MainActivity extends AppCompatActivity implements PaletteFragment.PaletteInterface{
    //Make a global CanvasFragment
    CanvasFragment canvas_frag;
    static final String[] color_array = {"Red", "Blue", "Yellow", "Green", "Gray"};
    //Boolean to check if we have to fragments
    boolean two_frags;

    //onCreate Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //We want to check if we have the canvas_fragment
        two_frags = (findViewById(R.id.canvas_fragment) != null);
        //Make fragment manager
        FragmentManager fm = getFragmentManager();
        //We beging our transaction
        FragmentTransaction ft = fm.beginTransaction();
        //add our palette_fragment
        ft.add(R.id.palette_fragment, new PaletteFragment());
        //commit
        ft.commit();

    }

    @Override
    public void onColorChosen(int position) {
        if(two_frags) {
            canvas_frag.setColor(color_array[position]);
        } else {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.palette_fragment, new CanvasFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }



}
