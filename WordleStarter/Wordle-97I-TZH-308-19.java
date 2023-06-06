/*
 * File: Wordle.java
 * -----------------
 * This module is the starter file for the Wordle assignment.
 * BE SURE TO UPDATE THIS COMMENT WHEN YOU COMPLETE THE CODE.
 */

import java.awt.Color;

import edu.willamette.cs1.wordle.WordleDictionary;
import edu.willamette.cs1.wordle.WordleGWindow;
import java.util.concurrent.TimeUnit;

public class Wordle {

    public void run() {
        r = 0;
        correctWord =  WordleDictionary.FIVE_LETTER_WORDS[(int) (5778 * Math.random())];
        gw = new WordleGWindow();
        gw.addEnterListener((s) -> enterAction(s));
    }

/*
 * Called when the user hits the RETURN key or clicks the ENTER button,
 * passing in the string of characters on the current row.
 */

    public void enterAction(String s) {
        String word = correctWord;
        boolean isWord = false;
        for (int i = 0; i < WordleDictionary.FIVE_LETTER_WORDS.length; i++) {
            if(WordleDictionary.FIVE_LETTER_WORDS[i].equalsIgnoreCase(s)) isWord = true;
        }
        
        if (isWord) {
            for 
                String let = s.substring

            r++;
            if (r < 6) 
                gw.setCurrentRow(r);
            else {
                gw.showMessage(correctWord.toUpperCase());
                gw.setCurrentRow(7);
            }
        }
        else {
            gw.showMessage("Not in word list");
        }
    }


/* Startup code */

    public static void main(String[] args) {
        new Wordle().run();
        
    }

/* Private instance variables */

    private WordleGWindow gw;
    private String correctWord;
    private int r;
    String checkedString;

}
