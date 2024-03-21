package com.mobileapp.lightsgame;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class GameFragment extends Fragment {

    View view;

    String colorString = "yellow";
    int moves = 0;

    lightGame game;
    TextView moveCounter;

    Button b11;
    Button b12;
    Button b13;

    Button b21;
    Button b22;
    Button b23;

    Button b31;
    Button b32;
    Button b33;

    //Colors the button the appropriate color for "on"
    //depending on what color is chosen from the color fragment.
    //If it is not on, the button is colored gray instead.
    public void checkOn(lightGame game, Button button, int i, int j){
        if(game.getStatus(i,j)){
            int colorC = Color.parseColor(colorString);
            button.setBackgroundTintList(ColorStateList.valueOf(colorC));
        }
        else{
            int colorC = Color.parseColor("gray");
            button.setBackgroundTintList(ColorStateList.valueOf(colorC));
        }
    }

    //Function that goes through each light in the game board
    //and its corresponding button. It lights up the button
    //if the gameboard light is on.
    public void updateBoard(){
        moves = game.getMoves();
        moveCounter.setText(String.valueOf(moves));

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                switch(i) {
                    case 0:
                        switch(j) {
                            case 0:
                                checkOn(game, b11, i, j);
                                break;

                            case 1:
                                checkOn(game, b12, i, j);
                                break;

                            case 2:
                                checkOn(game, b13, i, j);
                                break;
                        }
                        break;

                    case 1:
                        switch (j) {
                            case 0:
                                checkOn(game, b21, i, j);
                                break;

                            case 1:
                                checkOn(game, b22, i, j);
                                break;

                            case 2:
                                checkOn(game, b23, i, j);
                                break;
                        }
                        break;

                    case 2:
                        switch(j) {
                            case 0:
                                checkOn(game, b31, i, j);
                                break;

                            case 1:
                                checkOn(game, b32, i, j);
                                break;

                            case 2:
                                checkOn(game, b33, i, j);
                                break;
                        }
                        break;
                }
            }
        }

    }

    public void win(){
        if(game.winCondition()){
            GameFragmentDirections.ActionGameFragmentToWinnerFragment action = GameFragmentDirections.actionGameFragmentToWinnerFragment().setMoves(game.getMoves());
            Navigation.findNavController(view).navigate(action);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_game, container, false);
        //initiate new game
        game = new lightGame();
        game.gameBoard();

        //obtain references to button array
        b11 = view.findViewById(R.id.button11);
        b12 = view.findViewById(R.id.button12);
        b13 = view.findViewById(R.id.button13);

        b21 = view.findViewById(R.id.button21);
        b22 = view.findViewById(R.id.button22);
        b23 = view.findViewById(R.id.button23);

        b31 = view.findViewById(R.id.button31);
        b32 = view.findViewById(R.id.button32);
        b33 = view.findViewById(R.id.button33);

        //obtain reference to other features
        Button NGButton = view.findViewById(R.id.NGButton);
        moveCounter = view.findViewById(R.id.MovesCounter);

        //getmoves
        moves = game.getMoves();
        moveCounter.setText(String.valueOf(moves));

        //get color for lights
        colorString = GameFragmentArgs.fromBundle(requireArguments()).getColorType();

        updateBoard();
        //Resets game when button is pressed
        NGButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.resetMoves();
                moveCounter.setText(String.valueOf(0));
                game.gameBoard();
                updateBoard();
            }
        });

        //check through all buttons and light them up if
        //corresponding button is lit up in game board
        //class object
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.click(0,0);
                updateBoard();
                win();
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.click(0,1);
                updateBoard();
                win();
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.click(0,2);
                updateBoard();
                win();
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.click(1,0);
                updateBoard();
                win();
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.click(1,1);
                updateBoard();
                win();
            }
        });
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.click(1,2);
                updateBoard();
                win();
            }
        });
        b31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.click(2,0);
                updateBoard();
                win();
            }
        });
        b32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.click(2,1);
                updateBoard();
                win();
            }
        });
        b33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.click(2,2);
                updateBoard();
                win();
            }
        });

        return view;
    }
}