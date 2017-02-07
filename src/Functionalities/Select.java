package Functionalities;

import java.awt.Color;
import java.awt.Graphics;

/**
 * creating a rectangle for selecting features
 * @author          Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
 * creation        17.11.2016
 * @version         18.01.2017
 * param fromX     x-coordinate of start point
 * param toX       x-coordinate of end point
 * param fromY     y-coordinate of start point
 * param toY       y-coordinate of end point
 * return          black selecting rectangle
 */
public class Select {
    //Own attributes
    public int fromX;
    public int toX;
    public int fromY;
    public int toY;
    int startX, startY;
    int currentX, currentY;
    
    //Constructor
    public Select(int x, int y) {
        startX = x;
        startY = y;
    }
    
    public void moved(int x, int y) {
        currentX = x;
        currentY = y;
    }
    
    //Drawing Method
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        fromX = Math.min(startX, currentX);
        toX = Math.max(startX, currentX);
        fromY = Math.min(startY, currentY);
        toY = Math.max(startY, currentY);
        g.drawRect(fromX, fromY, toX-fromX, toY-fromY);
    }
}
