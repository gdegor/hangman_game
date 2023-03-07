package main;

import java.util.Arrays;
import java.util.Scanner;

public class LogicGame {
    private static int countUserTries = 0;
    public static void setCountUserTries(int x) { countUserTries = x; }

    private static void game() {
        final int possibleTries = 6;
        final String symbolMissedLetter = "-";
        String wrongUserLetter = "";
        String secretWord = ReadFile.getRandomWordFromFile();
        char[] userAnswer = secretWord.toCharArray();
        Arrays.fill(userAnswer, symbolMissedLetter.charAt(0));

        DrawGame.printImage(countUserTries, userAnswer, wrongUserLetter);
        Scanner input = new Scanner(System.in);
        while (countUserTries < possibleTries && new String(userAnswer).contains(symbolMissedLetter)) {
            String letter = (input.next().charAt(0)+"").toLowerCase();
            int index = secretWord.indexOf(letter);
            if (index > -1) {
                while (index != -1) {
                    userAnswer[index] = letter.charAt(0);
                    index = secretWord.indexOf(letter, index + 1);
                }
            } else {
                if (!wrongUserLetter.contains(letter) && letter.charAt(0) >= 'а' && letter.charAt(0) <= 'я') {
                    wrongUserLetter += letter.charAt(0);
                    countUserTries++;
                }
            }
            DrawGame.printImage(countUserTries, userAnswer, wrongUserLetter);
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
