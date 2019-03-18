//Name: Chamin Lim and Tony Jiang, Date: 2019-03-16, Period: 2

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private static int playMoney;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter you name...");
        String playerName = scanner.nextLine();
        System.out.println("Welcome to BlackJack, " + playerName + "!");
        System.out.println("How much do you want to start with?");

        // User input request loop, checks if the input is either 500, 1000, or 2000
        // and is an integer, otherwise it will ask for it again.
        boolean wrongInput = true;
        while (wrongInput) {
            System.out.println("You can only start with $500, $1000, or $2000.");
            try {
                String temp = scanner.nextLine();
                playMoney = Integer.parseInt(temp);
                if (playMoney == 500 || playMoney == 1000 || playMoney == 2000)
                    wrongInput = false;
            } catch (NumberFormatException e) {
                System.err.println("Entered value is not an integer.");
            }
        }

        System.out.println("You are starting with $" + playMoney + ", Good Luck!");

        BlackJack blackjack = new BlackJack(playerName, playMoney);
        while (!blackjack.isFinished()) {
            blackjack.run();
        }
        System.exit(0);
    }
}
