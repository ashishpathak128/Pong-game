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
public class HumanPaddle implements Paddle {
    double y, yVel;
    boolean accUp, accDown;
    final double Gravity = 0.94;
    int player, x;
    public HumanPaddle(int player){
        accUp = false; 
        accDown = false;
        y = 210; yVel = 0;
        if (player == 1){
            x = 20;
        }else if (player == 2){
            x = 660;
           
        }
    }
    public void move() {
        if (accUp){
            yVel -= 2;
        }else if (accDown){
            yVel += 2;
        }else if (!accUp && !accDown){
            yVel *= Gravity;
        }
        if (yVel >= 5){
            yVel = 5;
        }else if (yVel <= -5){
            yVel = -5;
        }
        y += yVel;
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
    public void setUpAcc( boolean input){
        accUp = input;
    }
    public void setDownAcc(boolean input){
        accDown = input;
    }
    
}
