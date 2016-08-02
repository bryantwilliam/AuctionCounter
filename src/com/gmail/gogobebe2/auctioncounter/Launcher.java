/**
 * ########## Auction Counter ##########
 * A counter used in real estate auctions which displays the current bidding price on a monitor during bidding.
 * As a new bid is made, someone types out the new price and presses the 'enter' key; changing the price on-screen. You
 * can not see them type in order to create a professional feeling of automatic updating prices.
 * <p>
 * Coded by William Bryant.
 * Started development on Tuesday, 2nd of August.
 * Finished development on TBD.
 **/

package com.gmail.gogobebe2.auctioncounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

public class Launcher {
    private static AuctionCounterFrame frame = new AuctionCounterFrame();

    public static void main(String[] args) {
        frame.setVisible(true);
    }

    private static class AuctionCounterFrame extends JFrame {
        private JLabel priceLabel;

        private AuctionCounterFrame() {
            setTitle("Auction Counter"); // Probably pointless.

            setUpJFrameAesthetics();

            addJLabel("0");

            addKeyListener(new AuctionCounterKeyListener());
        }

        private void setUpJFrameAesthetics() {
            //setLocation(Toolkit.getDefaultToolkit().getScreenSize().width, 0); // Top right corner.
            setAlwaysOnTop(true);
            setUndecorated(true); // Removes buttons/borders.
            //setBackground(new Color(0, 0, 0, 0)); // Transparent.
        }

        private void addJLabel(String price) {
            priceLabel = new JLabel(price);
            priceLabel.setFont(new Font(priceLabel.getFont().getName(), Font.PLAIN, 100)); // Set font size.
            priceLabel.setForeground(Color.BLUE);

            add(priceLabel);
            // Makes the JFrame resize to fit it's content - This needs to be infront of the add(priceLabel) call.
            pack();
        }

        private void setPrice(String price) {
            frame.remove(priceLabel);
            frame.revalidate();
            frame.repaint();
            System.out.println(price);

            DecimalFormat formatter = new DecimalFormat("#,###");

            addJLabel("$" + formatter.format(Double.parseDouble(price)));
        }
    }

    private static class AuctionCounterKeyListener implements KeyListener {
        private StringBuilder priceStringBuilder = new StringBuilder();

        // TODO: add Shortcut: "q key" to escape.
        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("Debug: key typed: " + e.getKeyChar());
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("Debug: key pressed: " + e.getKeyChar());
        }

        @Override
        public void keyReleased(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                frame.setPrice(priceStringBuilder.toString());
                priceStringBuilder = new StringBuilder();
            }
            else priceStringBuilder.append(e.getKeyChar());

            System.out.println("Debug: key released: " + e.getKeyChar());
        }
    }
}
