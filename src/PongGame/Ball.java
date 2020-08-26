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
public class Ball {
    double xVel, yVel, x, y;
    public Ball(){
        x = 350;
        y = 250;
        xVel = -2;
        yVel =1;
        
    }
     public void draw(Graphics g){
         g.setColor(Color.white);
         g.fillOval((int)x-10, (int)y-10, 20, 20);
     }
    public void move(){
        x += xVel;
        y += yVel;
        if (y <10){
            yVel = -yVel;
        }else if (y > 490){
            yVel = -yVel;
        }
    }
    public void checkPaddleCollision(Paddle p1, Paddle p2){
        if (x <= 50){
            if (y >= p1.getY() && y <= p1.getY()+80){
                xVel = -xVel;
            }
        }else if (x >= 650){
            if (y >= p2.getY() && y <= p2.getY()+80){
                xVel = -xVel;
            }
        }
    }
    public int getX(){
        return (int)x;
    }
    public int getY(){
        return (int) y;
    }
}
