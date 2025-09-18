package edu.grinnell.csc207.speedreader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.*;


/**
 * A speed reader that displays words
 * from a text file one at a time on a drawing panel.
 */
public class SpeedReader {
/**
 * Demonstrating a drawing panel and drawing
 * a "Hello World!" message on it.
 * @param value the new, non-negative value the counter.
 * @throws IllegalArgumentException if a non-negative value is given.
 */
    public void demonstratePanel() {
        DrawingPanel panel = new DrawingPanel(400, 300);
        Graphics g = panel.getGraphics();
        Font f = new Font("Courier", Font.BOLD, 46);
        g.setFont(f);
        g.drawString("Hello World!", 100, 100);
    }
/**
  * Prints "Hello World!" on the console repeatedly with
  * a 1-second pause between prints.
  *
  * @throws InterruptedException if the thread sleep is interrupted
  *
  */
    public void printStaggered() throws InterruptedException {
        while(true) {
            System.out.println("Hello World!");
            Thread.sleep(1000);
        }
    }
 /**
   * Reads a text file and displays words one at a time on a DrawingPanel 
   * using the specified parameters.
   * @param args the command-line arguments:
   *             <filename>args[0] = filename of the text to display
   *             <width>args[1] = width of the panel
   *             <height>args[2] = height of the panel
   *             <fontsize>args[3] = font size
   *             <wpm>args[4] = words per minute
   * @throws IOException if there is an error reading the input file.
   * @throws InterruptedException if the thread sleep is interrupted.
 */   
     public static void main(String[] args) throws IOException, InterruptedException{
        if(args.length != 5){
            System.out.println("Usage: SpeedReader <filename> <width> <height> <font size> <wpm>");
            return;
        }
        Scanner text = new Scanner(new File(args[0])); 
        WordGenerator test = new WordGenerator();
        test.wordGenerator(args[0]);
        test.text = text;
        // while (test.hasNext()) {
        //  //  System.out.println(test.getWordCount());
        //    test.next();
        //    System.out.println(test.getSentenceCount());
        //    System.out.println(test.getWordCount());
        // }
        int width = Integer.parseInt(args[1]);
        int height = Integer.parseInt(args[2]);
        DrawingPanel panel = new DrawingPanel(width, height);
        Graphics g = panel.getGraphics();
        Font f = new Font("Courier", Font.BOLD, Integer.parseInt(args[3]));
        g.setFont(f);

        while(test.hasNext()) {
            g.drawString(test.next(), width/4, height/2);
            Thread.sleep(60000/(Integer.parseInt(args[4])));
            g.setColor(Color.white);
            g.fillRect(0, 0, Integer.parseInt(args[1])*2, Integer.parseInt(args[2])*2);
            g.setColor(Color.black);
        }
        System.out.println(test.getWordCount());
        System.out.println(test.getSentenceCount());
    }
}
