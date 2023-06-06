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

import javax.print.attribute.SetOfIntegerSyntax;

public class Wordle {

    public void run() {
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
        
        if(isWord) {
            // implement 

            gw.setCurrentRow(gw.getCurrentRow() + 1);
        } else {
            gw.showMessage("Not in word list");
        }

    }

    public static int letCount(String let, String word) {
        int letCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.substring(i, i+1).equalsIgnoreCase(let)) letCount++;
        }
        return letCount;
    }

/* Startup code */

    public static void main(String[] args) {
        new Wordle().run();
        
    }

/* Private instance variables */

    private WordleGWindow gw;
    private String correctWord;
    String checkedString;

}
