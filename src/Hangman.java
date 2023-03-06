package src;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Hangman {
    private static final String combClear = "\033[H\033[2J";
    private static final int possibleTries = 6;
    private static int countUserTries = 0;

    public static void setCountUserTries(int x) { countUserTries = x; }

    public static void clearTerm() {
        System.out.print(combClear);
        System.out.flush();
    }

    private static void printImage(int err, char[] userAnswer) {
        clearTerm();
        System.out.println("errors : " + err);
        System.out.println(StagesOfHangman.getHangman()[err]);
        System.out.println(userAnswer);
    }

    private static String getRandomWordFromFile() {
        List<String> listWords = new ArrayList<>();
        String path = new File("resource/words.txt").getAbsolutePath();
        try {
            listWords = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            System.out.println("file not exists");
            System.exit(1);
        }
        Random random = new Random();
        return listWords.get(random.nextInt(listWords.size()));
    }

    private static void game() {
        String secretWord = Hangman.getRandomWordFromFile();
        char[] userAnswer = secretWord.toCharArray();
        Arrays.fill(userAnswer, '_');

        Hangman.printImage(countUserTries, userAnswer);
        Scanner input = new Scanner(System.in);
        while (countUserTries < possibleTries && new String(userAnswer).contains("_")) {
            String literal = ""+input.next().charAt(0);
            int index = secretWord.indexOf(literal);
            if (index > -1) {
                while (index != -1) {
                    userAnswer[index] = literal.charAt(0);
                    index = secretWord.indexOf(literal, index + 1);
                }
            } else {
                countUserTries++;
            }
            Hangman.printImage(countUserTries, userAnswer);
        }
        if (countUserTries == possibleTries) {
            System.out.println("you lose, word – " + secretWord);
        } else {
            System.out.println("win!");
        }
        Hangman.startGame();
    }

    public static void startGame() {
        setCountUserTries(0);
        System.out.println("1 for game, 2 for exit");
        Scanner input2 = new Scanner(System.in);
        switch (input2.next().charAt(0)) {
            case ('1') -> Hangman.game();
            case ('2') -> System.out.println("bye!");
            default -> startGame();
        }
    }
}
