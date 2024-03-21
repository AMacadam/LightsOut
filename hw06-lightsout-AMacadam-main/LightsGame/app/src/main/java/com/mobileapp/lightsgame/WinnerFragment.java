package com.mobileapp.lightsgame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WinnerFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_winner, container, false);

        //Gets the moves from gamefragment and displays them
        int moves = WinnerFragmentArgs.fromBundle(requireArguments()).getMoves();
        TextView text = view.findViewById(R.id.movesCounter);
        text.setText(String.valueOf(moves));


        return view;
    }
}