//Name: Chamin Lim and Tony Jiang, Date: 2019-03-16, Period: 2

import java.util.Scanner;

public class BlackJack {
    // TODO: 2019-03-16 I think we need to create Hand class for Player and Dealer.
    private boolean isGameFinished = false;
    private String playerName;
    private int playMoney;

    /**
     * Constructor for BlackJack
     * @param name gets player's name from Game.java
     */
    public BlackJack(String name, int money) {
        playerName = name;
        playMoney = money;
    }

    // TODO: 2019-03-16 Need to work on run() method, this is where main game code will be.

    /**
     * Main codes for our BlackJack
     */
    public void run() throws Exception {
        gameDelay();
        System.out.println("Let's start a game!");

        Scanner scan = new Scanner(System.in);

        System.out.println("Dealer is shuffling the deck.");
        gameDelay();
        Deck deck = new Deck();
        deck.shuffle();


        //When the BlackJack is finished, it sets isGameFinished to true.
        isGameFinished = true; //set as false because I am using it for testing
    }

    /**
     * Tells whether the game is finished or not
     * @return isGameFinished
     */
    public boolean isFinished() {
        return isGameFinished;
    }

    /**
     * Method that shows loading animation
     *
     * @throws Exception Exception for System.out.write()
     */
    private void gameDelay() throws Exception {
        try {
            String anim = "|/-\\";
            for (int x = 0; x < 27; x++) {
                String data = "\r" + anim.charAt(x % anim.length());
                System.out.write(data.getBytes());
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
            System.err.println("Delay Interrupted...");
        }
        System.out.println("----------------");
    }
}
