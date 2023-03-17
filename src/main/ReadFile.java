package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class ReadFile {
    private List<String> listWords;

    protected void getListWordsFromFile(String filename) {
        InputStream resource = this.getClass().getClassLoader().getResourceAsStream(filename);
        assert resource != null;
        listWords = new BufferedReader(new InputStreamReader(resource)).lines().toList();
    }

    protected String getRandomWordFromFile() {
        final int minWordLength = 5;
        final int maxWordLength = 10;
        String word = listWords.get(new Random().nextInt(listWords.size()));
        while (word.length() < minWordLength || word.length() > maxWordLength || word.contains("-")) {
            word = listWords.get(new Random().nextInt(listWords.size()));
        }
        return word;
    }
}
