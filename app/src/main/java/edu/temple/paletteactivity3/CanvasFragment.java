package edu.temple.paletteactivity3;

//import stuff
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CanvasFragment extends Fragment {

    //Make a view called layout
    View layout;
    public CanvasFragment() {
        //Need an empty constructer
    }
    //My override functions
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //onCreateView function
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_canvas, container, false);
        return layout;
    }

    //Function to set the background color of the CanvasFragment to the color specified
    public void setColor(String color) {
        layout.setBackgroundColor(Color.parseColor(color));
    }

}
