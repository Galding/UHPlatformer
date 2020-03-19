 

package com.golding.platformer;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Main
{
    public static void main(final String[] args) {
        final GamePanel g = new GamePanel();
        final JFrame frame = new JFrame("Platformer");
        frame.setDefaultCloseOperation(3);
        frame.setResizable(true);
        frame.setLayout(new BorderLayout());
        frame.add(g, "Center");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
