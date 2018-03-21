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
    PaletteFragment palette_frag;
    static final String[] color_array = {"Red", "Blue", "Yellow", "Green", "Gray"};
    //Boolean to check if we have to fragments
    boolean two_frags;

    //onCreate Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        two_frags = (findViewById(R.id.canvas_fragment) != null);
        canvas_frag = new CanvasFragment();
        palette_frag = new PaletteFragment();
        if(two_frags){
            addFragment(palette_frag, R.id.palette_fragment);
            addFragment(canvas_frag, R.id.canvas_fragment);
        }else{
            addFragment(palette_frag, R.id.palette_fragment);
        }



    }



    @Override
    public void sendColor(String color) {

        if(two_frags) {
            canvas_frag.setColor(color);
        } else {
            palette_frag.setColor(color);
        }

    }

    private void addFragment (Fragment fragment, int containerId) {
        getFragmentManager().beginTransaction().replace(containerId, fragment).commit();
    }



}
