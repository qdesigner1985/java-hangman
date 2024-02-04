package pl.edu.agh.hangman;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;

public class RandomWord {

    private String word;

    public String randomWord(List<String> words){

        Random random = new Random();
        int randomNum = random.nextInt(words.size());

        return words.get(randomNum).toUpperCase();
    }
}
