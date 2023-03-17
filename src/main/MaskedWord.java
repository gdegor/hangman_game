package main;

import java.util.Arrays;

public class MaskedWord {
    private final String secretWord;
    private final char[] maskedWord;

    public MaskedWord(String secretWord) {
        this.secretWord = secretWord;
        String symbolMaskedLetter = "-";
        maskedWord = new char[secretWord.length()];
        Arrays.fill(maskedWord, symbolMaskedLetter.charAt(0));
    }

    public char[] getMaskedWord() {
        return maskedWord;
    }

    public boolean openLetter(int index, String letter) {
        boolean open = false;
        while (index != -1) {
            open = true;
            maskedWord[index] = letter.charAt(0);
            index = secretWord.indexOf(letter, index + 1);
        }
        return open;
    }
}
