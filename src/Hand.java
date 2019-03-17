import java.util.ArrayList;

public class Hand {
    public static void main(String[] args) {


    }

    private int calcHandTotal(ArrayList<Card> hand) {
        int total = 0;
        for (int i = 0; i < hand.size(); i++) {
            total += hand.get(i).getRank();
        }
        return total;
    }
}
