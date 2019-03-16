//Name: Chamin Lim and Tony Jiang, Date: 2019-03-16, Period: 2

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter you name...");
        String playerName = scanner.nextLine();
        System.out.println("Hello, Welcome to BlackJack, " + playerName + "!");

        BlackJack blackjack = new BlackJack(playerName);
        while (blackjack.isFinished()) {
            blackjack.run();
        }
        System.exit(0);
    }
}
