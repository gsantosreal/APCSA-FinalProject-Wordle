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
        r = 0;
        correctWord = WordleDictionary.FIVE_LETTER_WORDS[(int) (5778 * Math.random())];
        gw = new WordleGWindow();
        gw.addEnterListener((s) -> enterAction(s));
    }

/*
 * Called when the user hits the RETURN key or clicks the ENTER button,
 * passing in the string of characters on the current row.
 */

    public void enterAction(String s) {
        checked = correctWord;
        boolean isWord = false;
        for (int i = 0; i < WordleDictionary.FIVE_LETTER_WORDS.length; i++) {
            if(WordleDictionary.FIVE_LETTER_WORDS[i].equalsIgnoreCase(s)) isWord = true;
        }
        
        if (isWord) {
            gw.showMessage("isWord is true!");
            for (int i = 0; i < 5; i++) {
                
                if (s.substring(i, i+1).equalsIgnoreCase(correctWord.substring(i, i+1))) {
                    gw.setSquareColor(r, i, WordleGWindow.CORRECT_COLOR);
                }
                
                else if (correctWord.indexOf(s.substring(i,i+1)) < 0) {
                    gw.setSquareColor(r, i, WordleGWindow.MISSING_COLOR);
                }

                else {
                    gw.setSquareColor(r, i, WordleGWindow.PRESENT_COLOR);
                }
                
            }

            r++;
            if (r < 6) 
                gw.setCurrentRow(r);
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
    private String checked;
    private int r;

}
