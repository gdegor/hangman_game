package main;

import java.util.Arrays;
import java.util.Scanner;

public class LogicGame {
    private static int countUserErrors = 0;

    public static void setCountUserErrors(int x) {
        countUserErrors = x;
    }

    private static boolean userWins(String secretWord, char[] userWord) {
        return secretWord.equals(String.valueOf(userWord));
    }

    private static boolean isRussianLetter(char letter) {
        return letter >= 'а' && letter <= 'я';
    }

    private static void gameLoop() {
        final int maxCountErrors = 6;
        final String symbolMaskedLetter = "-";

        String wrongUserLetters = "";
        String secretWord = ReadFile.getRandomWordFromFile();
        char[] userAnswer = new char[secretWord.length()];
        Arrays.fill(userAnswer, symbolMaskedLetter.charAt(0));

        DrawGame.printImage(countUserErrors, userAnswer, wrongUserLetters);
        Scanner input = new Scanner(System.in);

        while (countUserErrors < maxCountErrors && !userWins(secretWord, userAnswer)) {
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
                    countUserErrors++;
                }
            }
            DrawGame.printImage(countUserErrors, userAnswer, wrongUserLetters);
        }

        if (userWins(secretWord, userAnswer)) {
            System.out.println("you win!");
        } else {
            System.out.println("you lose, word – " + secretWord);
        }
        LogicGame.startGame();
    }

    public static void startGame() {
        setCountUserErrors(0);
        System.out.println("1 for game, 2 for exit");
        Scanner input2 = new Scanner(System.in);
        switch (input2.next().charAt(0)) {
            case ('1') -> LogicGame.gameLoop();
            case ('2') -> System.out.println("bye!");
            default -> startGame();
        }
    }
}
