package pl.edu.agh.hangman;

import java.util.Scanner;

public class Hangman {
    //private static final String slowo = slowa[(int) (Math.random() * slowa.length)];
    static RandomWord randomWord = new RandomWord();
    static String slowo = randomWord.randomWord();
    private static String guessingWord = new String(new char[slowo.length()]).replace("\0", "_");
    private static int count = 0;

    public static final String[] HANGMANPICS = new String[]{
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========"
    };

    public static void main(String[] args) {
        System.out.println(slowo);
        mainLoop();
    }

    public static void mainLoop(){
        Scanner sc = new Scanner(System.in);
        while (count < 7 && guessingWord.contains("_")) {
            System.out.println("guess a letter>>");
            System.out.println(guessingWord);
            String userGuess = sc.next().toUpperCase();
            guessingloop(userGuess);
        }
        sc.close();
    }
    public static void guessingloop(String guess) {
        StringBuilder guessingWordNew = new StringBuilder();
        for (int i = 0; i < slowo.length(); i++) {
            if (slowo.charAt(i) == guess.charAt(0)) {
                guessingWordNew.append(guess.charAt(0));
            } else if (guessingWord.charAt(i) != '_') {
                guessingWordNew.append(slowo.charAt(i));
            } else {
                guessingWordNew.append("_");
            }
        }
        if (guessingWord.equals(guessingWordNew.toString())) {
            count++;
            System.out.println("chlopek"+count);
        } else {
            guessingWord = guessingWordNew.toString();
        }
        if (guessingWord.equals(slowo)) {
            System.out.println("You win! Word was: " + slowo);
        }
    }
}

