package main;

import java.util.Scanner;

public class Main {
    private static final String filename = "russian_nouns.txt";
    private static final Dictionary dictionary = new Dictionary(filename);
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1 for game, 2 for exit");
            switch (input.next().charAt(0)) {
                case ('1') -> startGame();
                case ('2') -> {
                    System.out.println("bye!");
                    System.exit(0);
                }
                default -> {
                }
            }
        }
    }

    private static void startGame() {
        Game game = new Game(dictionary.getRandomWordFromList());
        game.gameLoop();
    }
}
