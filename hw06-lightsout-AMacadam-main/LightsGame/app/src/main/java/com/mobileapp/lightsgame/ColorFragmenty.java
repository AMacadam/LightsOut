package com.mobileapp.lightsgame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ColorFragmenty extends Fragment {

    String colorString = "yellow";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_color_fragmenty, container, false);
        RadioGroup colSelect = view.findViewById(R.id.colorChoices);
        RadioButton redButton = view.findViewById(R.id.redButton);
        RadioButton blueButton = view.findViewById(R.id.blueButton);
        RadioButton yellowButton = view.findViewById(R.id.yellowButton);
        Button changeButton = view.findViewById(R.id.changeButton);

        //determine color via selection of radiobuttons
        colSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                //if red is selected, change the color string to "red"
                //and likewise for the other colors
                if(i == R.id.redButton){
                    Object currentColor = redButton.getText();
                    colorString = currentColor.toString();
                }
                if(i == R.id.blueButton){
                    Object currentColor = blueButton.getText();
                    colorString = currentColor.toString();
                }
                if(i == R.id.yellowButton){
                    Object currentColor = yellowButton.getText();
                    colorString = currentColor.toString();
                }

            }
        });

        //Gets the colorstring and sends it to game fragment
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorFragmentyDirections.ActionColorFragmentyToGameFragment action = ColorFragmentyDirections.actionColorFragmentyToGameFragment().setColorType(colorString);
                Navigation.findNavController(view).navigate(action);
            }
        });



        return view;
    }
}