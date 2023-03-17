package main;

import java.util.Scanner;

public class Game {
    private int countUserErrors = 0;
    private String wrongUserLetters = "";

    public String getWrongUserLetters() {
        return wrongUserLetters;
    }

    public int getCountUserErrors() {
        return countUserErrors;
    }

    private boolean userWins(String secretWord, char[] userWord) {
        return secretWord.equals(String.valueOf(userWord));
    }

    private void gameLoop(String secretWord) {
        final int maxCountErrors = 6;
        countUserErrors = 0;
        wrongUserLetters = "";

        MaskedWord maskedWord = new MaskedWord(secretWord);
        DrawGame drawGame = new DrawGame();

        drawGame.printImage(this, maskedWord);
        Scanner input = new Scanner(System.in);
        while (countUserErrors < maxCountErrors && !userWins(secretWord, maskedWord.getMaskedWord())) {
            String letter = (String.valueOf(input.next().charAt(0))).toLowerCase();
            int index = secretWord.indexOf(letter);
            if (!maskedWord.openLetter(index, letter) && isCorrectLetter(letter)) {
                wrongUserLetters += letter.charAt(0);
                countUserErrors++;
            }
            drawGame.printImage(this, maskedWord);
        }

        if (userWins(secretWord, maskedWord.getMaskedWord())) {
            System.out.println("you win!");
        } else {
            System.out.println("you lose, word – " + secretWord);
        }
    }

    public void startGame(String secretWord) {
        System.out.println("1 for game, 2 for exit");
        Scanner input2 = new Scanner(System.in);
        switch (input2.next().charAt(0)) {
            case ('1') -> gameLoop(secretWord);
            case ('2') -> {
                System.out.println("bye!");
                System.exit(0);
            }
            default -> startGame(secretWord);
        }
    }

    private boolean isCorrectLetter(String letter) {
        return (letter.charAt(0) >= 'а' && letter.charAt(0) <= 'я') && !wrongUserLetters.contains(letter);
    }
}
