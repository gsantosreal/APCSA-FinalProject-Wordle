/*
 * File: Wordle.java
 * -----------------
 * This module is the starter file for the Wordle assignment.
 * BE SURE TO UPDATE THIS COMMENT WHEN YOU COMPLETE THE CODE.
 */


 import edu.willamette.cs1.wordle.WordleDictionary;
 import edu.willamette.cs1.wordle.WordleGWindow;
 import java.awt.Color;
 
 
 public class Wordle {
     int guesses;
     String word;
     String checked;
     String alphabet = "abcdefghijklmnopqrstuvwxyz";
     Color[] rainbow = { Color.RED, Color.ORANGE, Color.YELLOW, Color.CYAN, Color.BLUE, Color.MAGENTA };
 
 
     public void run() {
         gw = new WordleGWindow();
         gw.addEnterListener((s) -> enterAction(s));
         word = WordleDictionary.FIVE_LETTER_WORDS[(int) (Math.random() *
                 WordleDictionary.FIVE_LETTER_WORDS.length)];
         word = word.toUpperCase();
         // for(int i = 0; i < 5; i++){
         // gw.setSquareLetter(0, i, word.substring(i, i+1));
         // }
         for (int i = 0; i < alphabet.length(); i++) {
             gw.setKeyColor(alphabet.substring(i, i + 1), Color.WHITE);
         }
     }
     public void endGame(){
         gw.setCurrentRow(8);
     }
     /*
      * Called when the user hits the RETURN key or clicks the ENTER button,
      * passing in the string of characters on the current row.
      */
 
 
     public void enterAction(String s) {
         if (guesses >= 6) {
            gw.showMessage("Game over! The hidden word was: " + word);
            endGame();
         }
        int index;
        checked = word;
        boolean b = false;
        for (int i = 0; i < WordleDictionary.FIVE_LETTER_WORDS.length; i++) {
            if ((WordleDictionary.FIVE_LETTER_WORDS[i].equalsIgnoreCase(s))) {
                b = true;
            }
        }
        if (b) {
            guesses++;
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
            if (checked.equals("11111")) {
                gw.showMessage("CORRECT!");                
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
 
 
 
 