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
        boolean run = isWord(s.toLowerCase());

        if (run == true) {
            for (int i = 0; i < s.length(); i++) {
                String letter = s.substring(i, i+1);
                gw.setSquareLetter(gw.getCurrentRow(), i, letter);
            }
            gw.setCurrentRow(gw.getCurrentRow() + 1);
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

}
