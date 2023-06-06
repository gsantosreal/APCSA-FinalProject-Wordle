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
            for (int i = 0; i < 5; i++) {
                String let = s.substring(i, i+1);
                int letCount = letCount(let, word);

                if (letCount != 0) {
                    for (int j = 0; j < letCount; j++) {
                        for (int k = 0; k < word.length(); k++) {
                            if (let.equals(word.substring(k, k+1))) {
                                gw.setSquareColor(gw.getCurrentRow(), i, gw.CORRECT_COLOR);
                                gw.setKeyColor(let, gw.CORRECT_COLOR);
                            } else {
                                gw.setSquareColor(gw.getCurrentRow(), i, gw.PRESENT_COLOR);
                                if (!(gw.getKeyColor(let).equals(gw.CORRECT_COLOR))) gw.setKeyColor(let, gw.PRESENT_COLOR);
                            }
                        }
                    }
                }
            }

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
    private int r;
    String checkedString;

}
