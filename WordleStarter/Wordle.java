/*
 * File: Wordle.java
 * -----------------
 * This module is the starter file for the Wordle assignment.
 * BE SURE TO UPDATE THIS COMMENT WHEN YOU COMPLETE THE CODE.
 */

import edu.willamette.cs1.wordle.WordleDictionary;
import edu.willamette.cs1.wordle.WordleGWindow;

public class Wordle {

    public void run() {
        correctWord = WordleDictionary.FIVE_LETTER_WORDS[(int) (5778 * Math.random())];
        gw = new WordleGWindow();
        gw.addEnterListener((s) -> enterAction(s));
    }

/*
 * Called when the user hits the RETURN key or clicks the ENTER button,
 * passing in the string of characters on the current row.
 */

    public void enterAction(String s) {
        // gw.showMessage("You have to implement this method.");
        if (s.length() > 5) s = s.substring(0,5);
        String word = s.toLowerCase();
        boolean run = isWord(word);

        if (run == true) {

            for (int i = 0; i < word.length(); i++) {
                String letter = word.substring(i, i+1);
                String correctLetter = correctWord.substring(i, i+1);
                gw.setSquareLetter(gw.getCurrentRow(), i, letter.toUpperCase());

                if (letter.equals(correctLetter)) { 
                    gw.setSquareColor(gw.getCurrentRow(), i, WordleGWindow.CORRECT_COLOR); 
                } else if (correctWord.indexOf(letter) < 0) { 
                    gw.setSquareColor(gw.getCurrentRow(), i, WordleGWindow.MISSING_COLOR);
                } else { 
                    gw.setSquareColor(gw.getCurrentRow(), i, WordleGWindow.PRESENT_COLOR);
                } 
            }

            if (gw.getCurrentRow() == 5) { 
                gw.showMessage(correctWord.toUpperCase());
                gw.setCurrentRow(gw.getCurrentRow() + 1);
            } else {
                gw.setCurrentRow(gw.getCurrentRow() + 1);
            }

        } else {
            if (s.length() < 5) gw.showMessage("Not enough letters");
            else gw.showMessage("Not in word list");
        }

        
        
    }

    private static boolean isWord(String s) {
        String[] dictionary = WordleDictionary.FIVE_LETTER_WORDS;
        for (int i = 0; i < dictionary.length; i++) {
            if (s.equals(dictionary[i])) return true;
        }
        return false;
    }

/* Startup code */

    public static void main(String[] args) {
        new Wordle().run();
        
    }

/* Private instance variables */

    private WordleGWindow gw;
    private String correctWord;

}
