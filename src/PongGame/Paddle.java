/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PongGame;

import java.awt.Graphics;

/**
 *
 * @author Ashish
 */
public interface Paddle {
    public void move();
    public void draw(Graphics g);
    public int getY();
}
