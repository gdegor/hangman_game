package src;

import java.util.*;

public class LogicGame {
    private static final int possibleTries = 6;
    private static int countUserTries = 0;

    public static void setCountUserTries(int x) { countUserTries = x; }

    private static void game() {
        String secretWord = ReadFile.getRandomWordFromFile();
        char[] userAnswer = secretWord.toCharArray();
        Arrays.fill(userAnswer, '_');

        DrawGame.printImage(countUserTries, userAnswer);
        Scanner input = new Scanner(System.in);
        while (countUserTries < possibleTries && new String(userAnswer).contains("_")) {
            String literal = ""+input.next().charAt(0);
            int index = secretWord.indexOf(literal);
            if (index > -1) {
                while (index != -1) {
                    userAnswer[index] = literal.charAt(0);
                    index = secretWord.indexOf(literal, index + 1);
                }
            } else {
                countUserTries++;
            }
            DrawGame.printImage(countUserTries, userAnswer);
        }
        if (countUserTries == possibleTries) {
            System.out.println("you lose, word – " + secretWord);
        } else {
            System.out.println("win!");
        }
        LogicGame.startGame();
    }

    public static void startGame() {
        setCountUserTries(0);
        System.out.println("1 for game, 2 for exit");
        Scanner input2 = new Scanner(System.in);
        switch (input2.next().charAt(0)) {
            case ('1') -> LogicGame.game();
            case ('2') -> System.out.println("bye!");
            default -> startGame();
        }
    }
}
