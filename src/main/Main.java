package main;

public class Main {
    public static void main(String[] args) {
        String filename = "russian_nouns.txt";
        Dictionary dictionary = new Dictionary(filename);
        Game game = new Game();

        dictionary.getListWordsFromFile();

        while (true) {
            game.startGame(dictionary.getRandomWordFromList());
        }
    }
}
