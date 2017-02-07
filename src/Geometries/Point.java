package Geometries;

import DBConnexion.DBConnexion;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * drawing point features
 * inherit from figure.java
 * @author          Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
 * creation        03.11.2016
 * @version         18.01.2017
 * param X         x-coordinate of point
 * param Y         y-coodrinate of point
 * return          coordinates of point
 * return          add point to database
 * return          add point to CSV-file
 * exeption        UnsupportedOperationException
 */
public class Point extends Figure {
    //Own attributes
    public int X;
    public int Y;
    
    //Constructor
    public Point(String geom, Color color, int X, int Y) {
        //inheritated attributes
        super(geom, color);
        //own attributes
        this.X=X;
        this.Y=Y;        
    }
    
    //Getters
    public int getX() {
        return this.X;
    }
    public int getY() {
        return this.Y;
    }
    
    //Setters
    public void setX(int X) {
        this.X=X;
    }
    public void setY(int Y) {
        this.Y=Y;
    }
    
    //Drawing Method
    public void draw(Graphics2D g) {
        int s=10;
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(5));
        g.drawLine(X-s, Y-s, X+s, Y+s);
        g.drawLine(X-s, Y+s, X+s, Y-s);
        g.setColor(color);
        g.fillOval(X-s/2, Y-s/2, s, s);
    }
    
    //toString
    public String toString() {
        return "The point has this coordinates: ("+this.X+", "+this.Y+")";
    }
    
    //insertSQL
    public void insertSQL() {
        //Generates the insert SQL sentence
        String sql= "INSERT INTO table_points VALUES ("+null+", '"+this.geom+"', '"+this.X+"', '"+this.Y+"');";
        //Executes the SQL sentence
        new DBConnexion (sql);
    }
    
    //Save into csv file
    public String toCSV() {
        return "Point,"+this.X+","+this.Y;
    }

    //Area method
    @Override
    public double area() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}