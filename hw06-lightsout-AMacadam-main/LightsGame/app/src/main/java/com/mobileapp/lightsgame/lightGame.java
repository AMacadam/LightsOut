package com.mobileapp.lightsgame;

public class lightGame {

    //The game board is a 2 dimensional array of light objects
    private light[][] board;
    private int moves = 0;

    //creates lights in an array for the board
    //so that they can be randomly turned on or
    //off in the gameBoard function
    private void createBoard()
    {
        board = new light[3][3];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board [i][j] = new light();
                board[i][j].setOn(false);
            }
        }
    }

    //Creates an empty board using createBoard()
    //and then fills the board with lights that
    //are already on so there is no automatic win.
    //The lowest number of moves I got from this set up was 8.
    public void gameBoard(){
        createBoard();

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == 0 && j == 0){
                    board[i][j].setOn(true);
                }
                if(i == 1 && j == 2){
                    board[i][j].setOn(true);
                }
                if(i == 2 && j == 0){
                    board[i][j].setOn(true);
                }
            }
        }
    }

    //adds a move and toggles on adjacent lights
    //as well as the light clicked
    public void click(int height, int width){
        moves++;
        board[height][width].toggle();
        //Each if statement checks for null errors
        //to prevent crashes.
        if(height - 1 >= 0 && board[height - 1][width] != null){
            board[height - 1][width].toggle();
        }
        if(height + 1 <= 2 && board[height + 1][width] != null){
            board[height + 1][width].toggle();
        }
        if(width - 1 >= 0 && board[height][width - 1] != null){
            board[height][width - 1].toggle();
        }
        if(width + 1 <= 2 && board[height][width + 1] != null){
            board[height][width + 1].toggle();
        }
    }

    //iterates through board to find light that is on
    //if one is on, the game is not won yet
    public boolean winCondition(){
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j].getOn()){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean getStatus(int i, int j){
        return board[i][j].getOn();
    }

    public int getMoves(){
        return moves;
    }
    public void resetMoves(){moves = 0;}
}
