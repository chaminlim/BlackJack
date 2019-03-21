//Name: Chamin Lim and Tony Jiang, Date: 2019-03-16, Period: 2

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    private Scanner scan = new Scanner(System.in);
    private String playerName;
    private int move = 0;
    private Deck deck = new Deck();
    ArrayList<Card> player = new ArrayList<Card>();
    ArrayList<Card> dealer = new ArrayList<Card>();

    /**
     * Constructor for BlackJack
     *
     * @param name Player's name
     */
    public BlackJack(String name) {
        playerName = name;
    }

    /**
     * Main codes for our BlackJack
     */
    public void run() throws Exception {
        gameDelay();
        System.out.println("Let's start a game!");

        System.out.println("Dealer is shuffling the deck.");
        gameDelay();
        deck.shuffle();
        System.out.println("Deck is shuffled.");

        player = deck.deal(2);
        dealer = deck.deal(2);
        System.out.print("Dealer: \t\t| ");
        System.out.print(dealer.get(0).toString() + " | ");
        System.out.print("HIDDEN CARD | ");
        System.out.print("\n" + playerName + ": \t\t| ");
        for (Card card : player) {
            System.out.print(card.toString() + " | ");
        }

        int playerTotal = 0;
        int dealerTotal = 0;
        move = moveRequestLoop();

        while (move != 2) {
            if (move == 1) {
                gameDelay();
                playerHit();
                showPlayerCards();
                if (calcHandTotal(player) == 21) {
                    System.out.println("You have blackjack! You have won against the dealer!");
//                    isBlackJackFinished = true;
                    break;
                } else if (calcHandTotal(player) > 21) {
                    System.out.println("You are busted! You lost...");
//                    isBlackJackFinished = true;
                    break;
                }
                move = moveRequestLoop();
            }
        }
        if (move == 2) {
            gameDelay();
            if (calcHandTotal(dealer) == 21) {
                System.out.println("Dealer has blackjack! You lost...");
            }
            do {
                dealerHit();
            } while (calcHandTotal(dealer) < 16);
            if (calcHandTotal(dealer) > 21) {
                System.out.println("Dealer is busted... You won against the dealer!");
            }
            if (calcHandTotal(dealer) == 21) {
                System.out.println("Dealer has blackjack! You lost...");
            }
            showAllCards();
            playerTotal += calcHandTotal(player);
            dealerTotal += calcHandTotal(dealer);
        } else
            System.out.println("Wrong move.");

        gameDelay();
        System.out.println("Player's Card Total: " + playerTotal + " Dealer's Card Total: " + dealerTotal);

        if (playerTotal > dealerTotal) {
            System.out.println("You have won against the dealer!");
        }
        if (playerTotal == dealerTotal) {
            System.out.println("Draw!");
        }
        if (playerTotal < dealerTotal) {
            System.out.println("You lost... Better luck next time!");
        }
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

    /**
     * Similar as betRequestLoop but for moves, checks whether user inputted correct value
     *
     * @throws Exception for gameDelay()
     */
    private int moveRequestLoop() throws Exception {
        Scanner scan = new Scanner(System.in);
        move = 0;
        boolean wrongInput = true;
        while (wrongInput) {
            System.out.println("\nDealer: \"What would you like to do?\"\n** Hit (1) ** Stand (2) **");
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
            return move;
        }
        if (move == 2) {
            System.out.println("You have selected 'Stand (2)'");
            return move;
        }
        return 0;
    }

    private void playerHit() {
        player.add(deck.deal());
    }

    private void dealerHit() {
        dealer.add(deck.deal());
    }

    private int calcHandTotal(ArrayList<Card> hand) {
        int total = 0;
        for (int i = 0; i < hand.size(); i++) {
            total += hand.get(i).getRank();
        }
        return total;
    }

    /**
     * Method that shows only player's cards.
     */
    private void showPlayerCards() {
        System.out.print("Dealer: \t\t| ");
        System.out.print(dealer.get(0).toString() + " | ");
        System.out.print("HIDDEN CARD | ");
        System.out.print("\n" + playerName + ": \t\t| ");
        for (Card card : player) {
            System.out.print(card.toString() + " | ");
        }
        System.out.println();
    }

    /**
     * Method that shows both player's and dealer's cards.
     */
    private void showAllCards() {
        System.out.print("Dealer: \t\t| ");
        for (Card card : dealer) {
            System.out.print(card.toString() + " | ");
        }
        System.out.print("\n" + playerName + ": \t\t| ");
        for (Card card : player) {
            System.out.print(card.toString() + " | ");
        }
        System.out.println();
    }
}
