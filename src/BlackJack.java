//Name: Chamin Lim and Tony Jiang, Date: 2019-03-16, Period: 2

import java.util.Scanner;

public class BlackJack {
    // TODO: 2019-03-16 I think we need to create Hand class for Player and Dealer.
    private boolean isGameFinished = false;
    private String playerName;

    /**
     * Constructor for BlackJack
     *
     * @param name gets player's name from Game.java
     */
    public BlackJack(String name) {
        playerName = name;
    }

    // TODO: 2019-03-16 Need to work on run() method, this is where main game code will be.

    /**
     * Main codes for our BlackJack
     */
    public void run() {
        Scanner scan = new Scanner(System.in);
        Deck deck = new Deck();

        //When the BlackJack is finished, it sets isGameFinished to true.
        isGameFinished = false; //set as false because I am using it for testing
    }

    /**
     * Tells whether the game is finished or not
     *
     * @return isGameFinished
     */
    public boolean isFinished() {
        return isGameFinished;
    }
}
