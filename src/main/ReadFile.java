package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReadFile {
    static Path getAbsolutePathText() {
        Path pathCurrentDirectory = Paths.get("").toAbsolutePath();
        Path absolutePath;
        if (pathCurrentDirectory.endsWith("src")) {
            absolutePath = pathCurrentDirectory.resolve(Paths.get("..", "resource"));
        } else {
            absolutePath = pathCurrentDirectory.resolve("resource");
        }
        return Paths.get(String.valueOf(absolutePath), "russian_nouns.txt");
    }

    static String getRandomWordFromFile() {
        List<String> listWords = new ArrayList<>();
        final int minWordLength = 5;
        final int maxWordLength = 10;
        try {
            Path absolutePath = getAbsolutePathText();
            listWords = Files.readAllLines(absolutePath);
        } catch (IOException e) {
            System.out.println("file not exists");
            System.exit(1);
        }
        String word = listWords.get(new Random().nextInt(listWords.size()));
        while (word.length() < minWordLength || word.length() > maxWordLength || word.contains("-")) {
            word = listWords.get(new Random().nextInt(listWords.size()));
        }
        return word;
    }
}
