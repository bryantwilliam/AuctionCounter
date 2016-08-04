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
            setUndecorated(true); // Removes buttons/borders.
            setAlwaysOnTop(true);
            //setBackground(new Color(0, 0, 0, 0)); // Transparent.
        }

        private void addJLabel(String price) {
            priceLabel = new JLabel(price);
            priceLabel.setFont(new Font(priceLabel.getFont().getName(), Font.PLAIN, 100)); // Set font size.
            priceLabel.setForeground(Color.BLUE);

            add(priceLabel);
            // Makes the JFrame resize to fit it's content - This needs to be infront of the add(priceLabel) call.
            pack();

            setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getSize().width / 2, 0); // Top center
        }

        private void setPrice(double price) {
            frame.remove(priceLabel);
            frame.revalidate();
            frame.repaint();
            System.out.println(price);

            DecimalFormat formatter = new DecimalFormat("#,###");

            addJLabel("$" + formatter.format(price));
        }
    }


    private static class AuctionCounterKeyListener implements KeyListener {
        private StringBuilder priceStringBuilder = new StringBuilder();

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
            switch (e.getKeyCode()) {
                case KeyEvent.VK_ENTER:
                    try {
                        frame.setPrice(Double.parseDouble(priceStringBuilder.toString()));
                    } catch (NumberFormatException ignored) {}
                    priceStringBuilder = new StringBuilder();
                    break;
                case KeyEvent.VK_BACK_SPACE:
                    if (priceStringBuilder.length() > 0) priceStringBuilder.deleteCharAt(priceStringBuilder.length() - 1);
                    break;
                default: priceStringBuilder.append(e.getKeyChar());
            }
            System.out.println("Debug: key released: " + e.getKeyChar());
        }
    }
}
