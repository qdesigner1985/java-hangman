package pl.edu.agh.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class InternalTestClass {

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        RandomWord randomWord = new RandomWord();

        List<String> words = fileReader.readFile("src/main/resources/slowa.txt");
        System.out.println(randomWord.randomWord(words));



    }


}
