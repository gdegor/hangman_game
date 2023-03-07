package main;

public class StagesOfHangman {
    private static final String[] hangman = {
                                            "    +---+\n" +
                                            "    |   |\n" +
                                            "    |\n" +
                                            "    |\n" +
                                            "    |\n" +
                                            "    |\n" +
                                            "    =========",

                                            "    +---+\n" +
                                            "    |   |\n" +
                                            "    |   O\n" +
                                            "    |\n" +
                                            "    |\n" +
                                            "    |\n" +
                                            "    =========",

                                            "    +---+\n" +
                                            "    |   |\n" +
                                            "    |   O\n" +
                                            "    |   |\n" +
                                            "    |\n" +
                                            "    |\n" +
                                            "    =========",

                                            "    +---+\n" +
                                            "    |   |\n" +
                                            "    |   O\n" +
                                            "    |  /|\n" +
                                            "    |\n" +
                                            "    |\n" +
                                            "    =========",

                                            "    +---+\n" +
                                            "    |   |\n" +
                                            "    |   O\n" +
                                            "    |  /|\\\n" +
                                            "    |\n" +
                                            "    |\n" +
                                            "    =========",

                                            "    +---+\n" +
                                            "    |   |\n" +
                                            "    |   O\n" +
                                            "    |  /|\\\n" +
                                            "    |  /\n" +
                                            "    |\n" +
                                            "    =========",

                                            "    +---+\n" +
                                            "    |   |\n" +
                                            "    |   O\n" +
                                            "    |  /|\\\n" +
                                            "    |  / \\\n" +
                                            "    |\n" +
                                            "    =========" };

    public static String[] getHangman() {
        return hangman;
    }
}
