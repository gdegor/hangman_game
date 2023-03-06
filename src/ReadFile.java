package src;

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
}
