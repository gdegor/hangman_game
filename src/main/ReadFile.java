package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReadFile {
    static String getRandomWordFromFile() {
        List<String> listWords = new ArrayList<>();
        String path = new File("../resource/russian_nouns.txt").getAbsolutePath();
        try {
            listWords = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            System.out.println("file not exists");
            System.exit(1);
        }
        return listWords.get(new Random().nextInt(listWords.size()));
    }
}
