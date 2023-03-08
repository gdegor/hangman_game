package main;

import java.util.Arrays;
import java.util.Scanner;

public class LogicGame {
    private static int countUserTries = 0;
    public static void setCountUserTries(int x) { countUserTries = x; }

    private static boolean userWins(String winWord, char[] userWord) {
        return winWord.equals(String.valueOf(userWord));
    }

    private static boolean isRussianLetter(char letter) {
        return letter >= 'а' && letter <= 'я';
    }

    private static void game() {
        final int possibleTries = 6;
        final String symbolMissedLetter = "-";

        String wrongUserLetters = "";
        String secretWord = ReadFile.getRandomWordFromFile();
        char[] userAnswer = new char[secretWord.length()];
        Arrays.fill(userAnswer, symbolMissedLetter.charAt(0));

        DrawGame.printImage(countUserTries, userAnswer, wrongUserLetters);
        Scanner input = new Scanner(System.in);

        while (countUserTries < possibleTries && !userWins(secretWord, userAnswer)) {
            String letter = (String.valueOf(input.next().charAt(0))).toLowerCase();
            int index = secretWord.indexOf(letter);
            if (index > -1) {
                while (index != -1) {
                    userAnswer[index] = letter.charAt(0);
                    index = secretWord.indexOf(letter, index + 1);
                }
            } else {
                if (!wrongUserLetters.contains(letter) && isRussianLetter(letter.charAt(0))) {
                    wrongUserLetters += letter.charAt(0);
                    countUserTries++;
                }
            }
            DrawGame.printImage(countUserTries, userAnswer, wrongUserLetters);
        }

        if (userWins(secretWord, userAnswer)) {
            System.out.println("you win!");
        } else {
            System.out.println("you lose, word – " + secretWord);
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
