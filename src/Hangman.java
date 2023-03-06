import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Hangman {
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


    private static final int tries = 6;

    public static String[] getHangman() {
        return hangman;
    }

    public static void printImage(int err, char[] userAnswer) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("err = "+err);
        System.out.println(Hangman.getHangman()[err]);
        System.out.println(userAnswer);
    }

    public static String getRandomWordFromFile() {
        List<String> listWords = new ArrayList<>();
        String path = new File("words.txt").getAbsolutePath();
        try {
            listWords = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            System.out.println("file not exists");
            System.exit(1);
        }
        Random random = new Random();
        return listWords.get(random.nextInt(listWords.size()));
    }

    public static void game() {
        String word = Hangman.getRandomWordFromFile();
        int err = 0;
        char[] userAnswer = word.toCharArray();
        Arrays.fill(userAnswer, '_');

        Hangman.printImage(err, userAnswer);
        Scanner input = new Scanner(System.in);
        while (err < tries && new String(userAnswer).contains("_")) {
            String literal = ""+input.next().charAt(0);
            int index = word.indexOf(literal);
            if (index > -1) {
                while (index != -1) {
                    userAnswer[index] = literal.charAt(0);
                    index = word.indexOf(literal, index + 1);
                }
            } else {
                err++;
            }
            Hangman.printImage(err, userAnswer);
        }
        if (err == tries) {
            System.out.println("lose, word – "+word);
        } else {
            System.out.println("win");
        }
        Hangman.startGame();
    }

    public static void startGame() {
        System.out.println("1 for game, 2 for exit");
        Scanner input2 = new Scanner(System.in);
        switch (input2.nextInt()) {
            case (1) -> Hangman.game();
            case (2) -> System.out.println("bye!");
            default -> System.out.println("1 for game, 2 for exit");
        }
    }

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        Hangman.startGame();
    }
}
