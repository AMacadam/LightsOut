package com.mobileapp.lightsgame;

public class light {
    private boolean on;

    //creates cell on or off based on boolean value
    public light(boolean lit){
        on = lit;
    }

    //creates new off cell
    public light(){
        on = false;
    }

    //toggles button to be on or off
    public void toggle(){
        if(on){
            on = false;
        }
        else{
            on = true;
        }
    }

    //returns true if light is on
    public boolean getOn(){
        return on;
    }

    public void setOn(boolean var){
        on = var;
    }
}
