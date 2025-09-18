package edu.grinnell.csc207.speedreader;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * A generator that provides words one by one from a given text file.
 * It tracks the number of words and sentences read so far.
 */

public class WordGenerator {
    public Scanner text;
    public String filename;
    public int wordCount = 0;
    public int sentenceCount = 0;

/**
 * Sets the filename of the text source.
 * @param filename the name of the file to read.
 */
    public void wordGenerator(String filename) {
        this.filename = filename;
    }
/**
 * Determines whether there are more words available in the text.
 *
 * @return True if there are more words to read; False otherwise.
 * @throws IOException if an error occurs while reading the file.
 */
    public boolean hasNext() throws IOException{
        return (text.hasNext());
    }
/**
 * Returns the next word from the text and updates counters.
 * Increments the word count, and if the word ends with '.', '!', or '?',
 * also increments the sentence count.
 *
 * @return the next word in the text
 * @throws IOException if an error occurs while reading the file
 */
    public String next() throws IOException{
        this.wordCount++;
        String word = text.next();
        if(word.endsWith(".") || word.endsWith("!") || word.endsWith("?")){
            this.sentenceCount++;
        }
        return (word);
    } 
/**
 * Returns the total number of words read so far.
 *
 * @return the number of words read.
 * @throws IOException if an error occurs while reading.
 */
    public int getWordCount() throws IOException{
         return wordCount;
    }
/**
 * Returns the total number of sentences read so far.
 * @return the number of sentences read.
 * @throws IOException if an error occurs while reading.
 */
    public int getSentenceCount() throws IOException{
        return sentenceCount;
    }

    // public static void main(String[] args) throws IOException {
    //     Scanner text = new Scanner(new File(args[0])); 
    //     WordGenerator test = new WordGenerator();
    //     test.wordGenerator(args[0]);
    //     test.text = text;
    //     if (text.hasNext()) {
    //         System.out.println(test.next());
    //         System.out.println(test.getWordCount());
    //         System.out.println(test.getSentenceCount());
    //     }
    // }

}
