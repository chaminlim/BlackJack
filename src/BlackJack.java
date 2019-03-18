//Name: Chamin Lim and Tony Jiang, Date: 2019-03-16, Period: 2

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    private boolean isBlackJackFinished = false;
    private String playerName;
    private int playMoney, move;
    private int betMoney = 0;
    ArrayList<Card> player = new ArrayList<Card>();
    ArrayList<Card> dealer = new ArrayList<Card>();

    /**
     * Constructor for BlackJack
     * @param name Player's name
     * @param money PLayer's money
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
        boolean isOneGameOver = false;
        gameDelay();
        System.out.println("Let's start a game!");
        while (playMoney > 0) {
            while (!isOneGameOver) {
                Scanner scan = new Scanner(System.in);

                System.out.println("Dealer is shuffling the deck.");
                gameDelay();
                Deck deck = new Deck();
                deck.shuffle();
                System.out.println("Deck is shuffled.");

                playerStatus();
                betRequestLoop();

                player = deck.deal(2);
                dealer = deck.deal(2);
                System.out.print("Dealer: \t\t| ");
                System.out.print(dealer.get(0).toString() + " | ");
                System.out.print("HIDDEN CARD | ");
                System.out.print("\n" + playerName + ": \t\t| ");
                for (Card card : player) {
                    System.out.print(card + " | ");
                }

                moveRequestLoop();

                // TODO: 2019-03-17 Need to work on switch statement for user's play, 1 means hit and 2 means stand
                switch (move) {
                    case 1:
                        playerHit();
                    case 2:
                        playerStand();
                    default:
                        System.err.println("Wrong Move.");
                }

                //When the BlackJack is finished, it sets isGameFinished to true.
                playMoney = 0;
                isOneGameOver = true;
                isBlackJackFinished = true; //set as false because I am using it for testing
            }
        }
    }

    /**
     * Tells whether the game is finished or not
     *
     * @return isGameFinished
     */
    public boolean isFinished() {
        return isBlackJackFinished;
    }

    /**
     * Method that shows loading animation
     *
     * @throws Exception for System.out.write()
     */
    private void gameDelay() throws Exception {
        try {
            String anim = "|/-\\";
            //Change 1 to 27.
            for (int x = 0; x < 1; x++) {
                String data = "\r" + anim.charAt(x % anim.length());
                System.out.write(data.getBytes());
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
            System.err.println("Delay Interrupted...");
        }
        System.out.println("----------------");
    }

    /**
     * Method that prints out player's status: name and money
     */
    private void playerStatus() {
        System.out.println("You(" + playerName + ") have $" + playMoney + ".");
    }

    /**
     * Request loop for betting, checks whether user inputted correct value
     *
     * @throws Exception for gameDelay()
     */
    private void betRequestLoop() throws Exception {
        Scanner scan = new Scanner(System.in);
        boolean wrongInput = true;
        while (wrongInput) {
            System.out.println("Dealer: \"How much do you want to bet?\" (Maximum bet: $" + playMoney + ")");
            try {
                String temp = scan.nextLine();
                betMoney = Integer.parseInt(temp);
                if (betMoney <= playMoney && betMoney > 0) {
                    wrongInput = false;
                    playMoney -= betMoney;
                }
            } catch (NumberFormatException e) {
                System.err.println("Wrong Input.");
            }
        }
        gameDelay();
        System.out.println("You have bet $" + betMoney + ".");
    }

    /**
     * Similar as betRequestLoop but for moves, checks whether user inputted correct value
     *
     * @throws Exception for gameDelay()
     */
    private void moveRequestLoop() throws Exception {
        Scanner scan = new Scanner(System.in);
        move = 0;
        boolean wrongInput = true;
        while (wrongInput) {
            System.out.println("Dealer: \"What would you like to do?\"\n** Hit (1) ** Stand (2) **");
            try {
                String temp = scan.nextLine();
                int tempMove = Integer.parseInt(temp);
                if (tempMove == 1 || tempMove == 2) {
                    wrongInput = false;
                    move += tempMove;
                }
            } catch (NumberFormatException e) {
                System.err.println("Wrong Input.");
            }
        }
        gameDelay();
        if (move == 1) {
            System.out.println("You have selected 'Hit (1)'");
        }
        if (move == 2) {
            System.out.println("You have selected 'Stand (2)'");
        }
    }

    // TODO: 2019-03-17 Need to work these 4 methods.
    private void playerHit() {

    }

    private void playerStand() {
        dealerHit();
        dealStand();
    }

    private void dealerHit() {

    }

    private void dealStand() {

    }

}
