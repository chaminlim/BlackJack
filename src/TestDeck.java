//Case Study 11.1: Test a deck
//Listman
//December 2010

import java.util.ArrayList;


public class TestDeck {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        int count = 0;

        Deck deck2 = new Deck();

        ArrayList<Card> player1 = new ArrayList<Card>();

/*         while (!deck.isEmpty())
         {
            count++;
            Card card = deck.deal();
            System.out.println(count + ": " + card);
         }
			*/

        player1 = deck.deal(5);

        System.out.println("Player 1's cards: ");
        for (Card card : player1)
            System.out.println(card);
    }
}