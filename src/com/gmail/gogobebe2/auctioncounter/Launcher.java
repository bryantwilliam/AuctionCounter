package com.gmail.gogobebe2.auctioncounter;

import javax.swing.*;
import java.awt.*;

public class Launcher {
    public static void main(String[] args) {
        //1. Create the frame.
        JFrame frame = new JFrame("FrameDemo");

        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.
        //...create emptyLabel...
        JLabel label = new JLabel("BLABAL");
        frame.getContentPane().add(label, BorderLayout.CENTER);

        //4. Size the frame.
        frame.pack();

        //5. Show it.
        frame.setVisible(true);
    }
}
