package pl.edu.agh.hangman;

import java.util.Scanner;

public class Hangman {
    FileReader fileReader = new FileReader();
    RandomWord randomWord = new RandomWord();

    String slowo = randomWord.randomWord(fileReader.readFile("src/main/resources/slowa.txt"));
    private String guessingWord = new String(new char[slowo.length()]).replace("\0", "_");
    private static int count = 0;

    public void mainLoop(){
        Scanner sc = new Scanner(System.in);
        System.out.println(slowo);
        while (count < 6 && guessingWord.contains("_")) {
            System.out.println("guess a letter>>");
            System.out.println(guessingWord);
            String userGuess = sc.next().toUpperCase();
            guessingloop(userGuess);
        }
        sc.close();
    }
    public void guessingloop(String guess) {
        PrinterHangman printerHangman = new PrinterHangman();
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
        if (guessingWord.contentEquals(guessingWordNew)) {
            count++;
            printerHangman.printHangman(count);
        } else {
            guessingWord = guessingWordNew.toString();
            printerHangman.printHangman(count);
        }
        if (guessingWord.equals(slowo)) {
            System.out.println("You win! Word was: " + slowo);
        }
    }
}

