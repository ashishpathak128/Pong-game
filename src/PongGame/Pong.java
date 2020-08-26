/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PongGame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ashish
 */
public class Pong extends Applet implements Runnable,KeyListener {
    final int WIDTH = 700, HEIGHT = 500;
    Thread thread;
    HumanPaddle p1;
    AIPaddle p2;
    Ball b1;
    boolean gameStarted;
    public void init(){
        gameStarted = false;
        this.resize(WIDTH, HEIGHT);
        this.addKeyListener(this);
        p1 = new HumanPaddle(1);
        b1 = new Ball();
        p2 = new AIPaddle(2, b1);
        thread = new Thread(this);
        thread.start();
        
    }
    
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        if (b1.getX() < -10 || b1.getX() > 710){
            g.setColor(Color.red);
            g.drawString("Game Over", 350, 250);
        }else {
            p1.draw(g);
            b1.draw(g);
            p2.draw(g);
        }
        if(!gameStarted){
        g.setColor(Color.white);
        g.drawString("Welcome to Pong Game in Java", 270, 220);
        g.setColor(Color.BLUE);
        g.drawString("Press enter to start the game", 270, 240);
    }
    }
    public void update(Graphics g){
     paint(g);   
    }

   
    public void run() {
        for(;;){
          
            if (gameStarted){
                p1.move();
                p2.move();
                b1.move();
                b1.checkPaddleCollision(p1, p2);
            }
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pong.class.getName()).log(Level.SEVERE, null, ex);
            }
      }  
    }

    
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

  
    public void keyPressed(KeyEvent e) { 
        if (e.getKeyCode() == KeyEvent.VK_UP){
            p1.setUpAcc(true);
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            p1.setDownAcc(true);
        }else if (e.getKeyCode() == KeyEvent.VK_ENTER){
            gameStarted = true;
        }
    }

    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            p1.setUpAcc(false);
            
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            p1.setDownAcc(false);
        }
    }
}
