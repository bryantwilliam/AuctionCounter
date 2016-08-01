package com.gmail.gogobebe2.auctioncounter;


import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        CounterFrame frame = new CounterFrame();
    }

    private static class CounterFrame extends JFrame {
        private CounterFrame() {
            setTitle("Auction Counter");

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel priceLabel = new JLabel("$0.00");
            add(priceLabel);
            pack();

            setVisible(true);
        }
    }
}
