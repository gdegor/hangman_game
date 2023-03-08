package main;

public class DrawGame {
    public static void clearTerm() {
        final String combClear = "\033[H\033[2J"; // for start program in terminal
        System.out.print(combClear);
        System.out.flush();
    }

    public static void printImage(int err, char[] userAnswer, String wrongUserLiteral) {
        clearTerm();
        System.out.println("errors : " + err);
        System.out.println(wrongUserLiteral);
        System.out.println(StagesOfHangman.getHangman()[err]);
        System.out.println(userAnswer);
    }
}
