/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PongGame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Ashish
 */
public class AIPaddle implements Paddle {
    double y, yVel;
    boolean accUp, accDown;
    final double Gravity = 0.94;
    int player, x;
    Ball b1;
    public AIPaddle(int player, Ball b){
        accUp = false; 
        accDown = false;
        b1 = b;
        y = 210; yVel = 0;
        if (player == 1){
            x = 20;
        }else if (player == 2){
            x = 660;
           
        }
    }
    public void move() {
        
        y = b1.getY() - 40;
        if (y < 0 ){
            y =0;
        }else if (y > 420){
            y = 420;
        }
    }
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, (int)y, 20, 80);
    }
    public int getY() {
        return (int)y;
    
    }
    
}
