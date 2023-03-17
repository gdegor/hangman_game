package main;

import java.util.Scanner;

public class Game {
    private int countUserErrors = 0;
    private String wrongUserLetters = "";
    private final MaskedWord maskedWord;
    private final static Scanner input = new Scanner(System.in);

    public Game(String secretWord) {
        maskedWord = new MaskedWord(secretWord);
    }

    public String getWrongUserLetters() {
        return wrongUserLetters;
    }

    public int getCountUserErrors() {
        return countUserErrors;
    }

    private boolean userWins(String secretWord, char[] userWord) {
        return secretWord.equals(String.valueOf(userWord));
    }

    public void gameLoop() {
        final int maxCountErrors = 6;

        DrawGame.printImage(this, maskedWord);

        while (countUserErrors < maxCountErrors && !userWins(maskedWord.getSecretWord(), maskedWord.getMaskedWord())) {
            String letter = (String.valueOf(input.next().charAt(0))).toLowerCase();
            int index = maskedWord.getSecretWord().indexOf(letter);
            if (!maskedWord.openLetter(index, letter) && isCorrectLetter(letter)) {
                wrongUserLetters += letter.charAt(0);
                countUserErrors++;
            }
            DrawGame.printImage(this, maskedWord);
        }

        if (userWins(maskedWord.getSecretWord(), maskedWord.getMaskedWord())) {
            System.out.println("you win!");
        } else {
            System.out.println("you lose, word – " + maskedWord.getSecretWord());
        }
    }

    private boolean isCorrectLetter(String letter) {
        return (letter.charAt(0) >= 'а' && letter.charAt(0) <= 'я') && !wrongUserLetters.contains(letter);
    }
}
