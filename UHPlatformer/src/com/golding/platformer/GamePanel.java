
package com.golding.platformer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import com.golding.platformer.gameStates.GameStateManager;
import com.golding.platformer.ressources.Images;

public class GamePanel extends JPanel implements Runnable, KeyListener
{
    private static final long serialVersionUID = 1L;
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WIDTH = screenSize.width ;		//1280
    public static final int HEIGHT = screenSize.height;		//720
    @SuppressWarnings("unused")
	private Thread thread;
    private boolean isRunning;
    private int FPS;
    private long targetTime;
    private GameStateManager gsm;
    
    public GamePanel() {
        this.isRunning = false;
        this.FPS = 60;
        this.targetTime = 1000 / this.FPS;
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.addKeyListener(this);
        this.setFocusable(true);
        new Images();
        this.start();
    }
    
    private void start() {
        this.isRunning = true;
        (this.thread = new Thread(this)).start();
    }
    
    @Override
    public void keyPressed(final KeyEvent e) {
        this.gsm.keyPressed(e.getKeyCode());
    }
    
    @Override
    public void keyReleased(final KeyEvent e) {
        this.gsm.keyReleased(e.getKeyCode());
    }
    
    @Override
    public void keyTyped(final KeyEvent e) {
    }
    
    @Override
    public void run() {
        this.gsm = new GameStateManager();
        while (this.isRunning) {
            final long start = System.nanoTime();
            this.tick();
            this.repaint();
            final long elapsed = System.nanoTime() - start;
            long wait = this.targetTime - elapsed / 1000000L;
            if (wait <= 0L) {
                wait = 5L;
            }
            try {
                Thread.sleep(wait);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void tick() {
        this.gsm.tick();
    }
    
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, 1280, 720);
        this.gsm.draw(g);
    }
}
