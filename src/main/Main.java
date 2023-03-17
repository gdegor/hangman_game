package main;

public class Main {
    public static void main(String[] args) {
        String filename = "russian_nouns.txt";

        ReadFile readFile = new ReadFile();
        readFile.getListWordsFromFile(filename);

        DrawGame.clearTerm();
        while (true) {
            LogicGame.startGame(readFile);
        }
    }
}
