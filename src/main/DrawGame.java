package main;

public class DrawGame {
    private void clearTerm() {
        final String combClear = "\033[H\033[2J";
        System.out.print(combClear);
        System.out.flush();
    }

    public void printImage(Game game, MaskedWord maskedWord) {
        StagesOfHangman stagesOfHangman = new StagesOfHangman();
        clearTerm();
        System.out.println("errors : " + game.getCountUserErrors());
        System.out.println(game.getWrongUserLetters());
        System.out.println(stagesOfHangman.getHangman()[game.getCountUserErrors()]);
        System.out.println(maskedWord.getMaskedWord());
    }
}
