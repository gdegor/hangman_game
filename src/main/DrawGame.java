package main;

public class DrawGame {
    private static void clearTerm() {
        final String combClear = "\033[H\033[2J";
        System.out.print(combClear);
        System.out.flush();
    }

    public static void printImage(Game game, MaskedWord maskedWord) {
        clearTerm();
        System.out.println("errors : " + game.getCountUserErrors());
        System.out.println(game.getWrongUserLetters());
        System.out.println(StagesOfHangman.hangman[game.getCountUserErrors()]);
        System.out.println(maskedWord.getMaskedWord());
    }
}
