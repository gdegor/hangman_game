package src;

public class DrawGame {
    private static final String combClear = "\033[H\033[2J";

    public static void clearTerm() {
        System.out.print(combClear);
        System.out.flush();
    }

    public static void printImage(int err, char[] userAnswer) {
        clearTerm();
        System.out.println("errors : " + err);
        System.out.println(StagesOfHangman.getHangman()[err]);
        System.out.println(userAnswer);
    }
}
