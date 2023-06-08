/*
 * File: Wordle.java
 * -----------------
 * This module is the starter file for the Wordle assignment.
 * BE SURE TO UPDATE THIS COMMENT WHEN YOU COMPLETE THE CODE.
 */


import java.awt.Color;

import edu.willamette.cs1.wordle.WordleDictionary;
import edu.willamette.cs1.wordle.WordleGWindow;

public class Wordle {
    String word;
    String checked;
    int r;
 
 
    public void run() {
        gw = new WordleGWindow();
        gw.addEnterListener((s) -> enterAction(s));
        word = WordleDictionary.FIVE_LETTER_WORDS[(int) (Math.random() * WordleDictionary.FIVE_LETTER_WORDS.length)];
        word = word.toUpperCase();
         
    }
     
    public void endGame(){
        gw.setCurrentRow(8);
    }
    /*
    * Called when the user hits the RETURN key or clicks the ENTER button,
    * passing in the string of characters on the current row.
    */
 
 
    public void enterAction(String s) {
        int index;
        checked = word;
        boolean isWord = false;
        for (int i = 0; i < WordleDictionary.FIVE_LETTER_WORDS.length; i++) {
            if ((WordleDictionary.FIVE_LETTER_WORDS[i].equalsIgnoreCase(s))) {
                isWord = true;
            }
        }
        
        if (isWord) {
            r++;
            for (int i = 0; i < 5; i++) {
                index = checked.indexOf(s.substring(i, i + 1));
                if (index < 0) {
                    gw.setSquareColor(gw.getCurrentRow(), i, WordleGWindow.MISSING_COLOR);
                    gw.setKeyColor(s.substring(i, i + 1), WordleGWindow.MISSING_COLOR);
                }
            }
            for (int i = 0; i < 5; i++) {
                index = checked.indexOf(s.substring(i, i + 1));
                if (s.substring(i, i + 1).equals(checked.substring(i, i + 1))) {
                    gw.setSquareColor(gw.getCurrentRow(), i, WordleGWindow.CORRECT_COLOR);
                    gw.setKeyColor(s.substring(i, i + 1), WordleGWindow.CORRECT_COLOR);
                    s = s.substring(0, i) + "2" + s.substring(i + 1);
                    checked = checked.substring(0, i) + "1" + checked.substring(i + 1);
                }
            }
            for (int i = 0; i < 5; i++) {
                index = checked.indexOf(s.substring(i, i + 1));
                if (index >= 0 && s.indexOf(s.substring(i, i + 1)) >= 0) {
                    gw.setSquareColor(gw.getCurrentRow(), i, WordleGWindow.PRESENT_COLOR);
                    if (gw.getKeyColor(s.substring(i, i + 1).toUpperCase()) != WordleGWindow.CORRECT_COLOR) {
                        gw.setKeyColor(s.substring(i, i + 1), WordleGWindow.PRESENT_COLOR);
                    }
                    s = s.substring(0, i) + "2" + s.substring(i + 1);
                    checked = (checked.substring(0, index) + "1" + checked.substring(index + 1));
                }
            }

            System.out.println(s + " " + checked);
            System.out.println(gw.getSquareColor(gw.getCurrentRow(), 3) + " " + gw.getSquareColor(gw.getCurrentRow(), 4));

            // for (int i = 0; i < checked.length(); i++) {
            //     if (checked.substring(i, i+1).equalsIgnoreCase("1")) {
            //         gw.setSquareColor(gw.getCurrentRow(), i, gw.CORRECT_COLOR);
            //     } else if (checked.substring(i, i+1).equalsIgnoreCase("2")) {
            //         gw.setSquareColor(gw.getCurrentRow(), i, gw.PRESENT_COLOR);
            //     } else {
            //         gw.setSquareColor(gw.getCurrentRow(), i, gw.MISSING_COLOR);
            //     }
            // }

            if (checked.equals("11111")) {
                gw.setKeyColor("Q", new Color(255,215,0));
                gw.setKeyColor("W", new Color(255,215,0));
                gw.setKeyColor("A", new Color(255,215,0));
                gw.setKeyColor("S", new Color(255,215,0));
                gw.setKeyColor("Z", new Color(255,215,0));
                gw.setKeyColor("E", new Color(255,215,0));
                gw.setKeyColor("D", new Color(255,215,0));
                gw.setKeyColor("X", new Color(255,215,0));
                gw.setKeyColor("R", new Color(255,215,0));
                gw.setKeyColor("F", new Color(255,215,0));
                gw.setKeyColor("C", new Color(255,215,0));
                gw.setKeyColor("T", new Color(255,215,0));
                gw.setKeyColor("Y", new Color(255,215,0));
                gw.setKeyColor("G", new Color(255,215,0));
                gw.setKeyColor("V", new Color(255,215,0));
                gw.setKeyColor("U", new Color(255,215,0));
                gw.setKeyColor("H", new Color(255,215,0));
                gw.setKeyColor("B", new Color(255,215,0));
                gw.setKeyColor("I", new Color(255,215,0));
                gw.setKeyColor("J", new Color(255,215,0));
                gw.setKeyColor("N", new Color(255,215,0));
                gw.setKeyColor("O", new Color(255,215,0));
                gw.setKeyColor("P", new Color(255,215,0));
                gw.setKeyColor("K", new Color(255,215,0));
                gw.setKeyColor("L", new Color(255,215,0));
                gw.setKeyColor("M", new Color(255,215,0));
                gw.showMessage("Great");                
                endGame();
            }

            if (r > 5) {
                gw.showMessage(word);
                endGame();
            }

            gw.setCurrentRow(gw.getCurrentRow() + 1);
        } else {
            gw.showMessage("Not in word list");
        }
     }
 
 
     /* Startup code */
     public static void main(String[] args) {
         new Wordle().run();
     }
 
 
     /* Private instance variables */
 
 
     private WordleGWindow gw;
 
 
 }
 
 
 
 