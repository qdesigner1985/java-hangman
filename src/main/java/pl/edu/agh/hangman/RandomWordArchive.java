package pl.edu.agh.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomWordArchive {

    private String word;
    private List<String> words = new ArrayList<>();


    public String randomWord(){
        try {
            File file = new File("src/main/resources/slowa.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String text = scanner.nextLine();
                words.add(text);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Random random = new Random();
        int randomNum = random.nextInt(words.size());

        return words.get(randomNum).toUpperCase();
    }
}
