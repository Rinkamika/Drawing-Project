package Geometries;

import DBConnexion.DBConnexion;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * drawing rectangle features
 * inherit from figure.java
 * @author          Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
 * creation        05.11.2016
 * @version         18.01.2017
 * param initial.X x-coordinate of start point
 * param initial.Y y-coordinate of start point
 * param end.X     x-coordinate of end point
 * param end.Y     y-coordinate of end point
 * return          coordinates of rectangle
 * return          add rectangle to database
 * return          add rectangle to CSV-file
 * exeption        UnsupportedOperationException
 */
public class Rectangle extends Figure {
    //Own attributes
    protected Point initial;
    protected Point end;
    
    //Constructor
    public Rectangle(String geom, Color color, Point initial, Point end) {
        //inheritated attributes
        super(geom, color);
        //Own attributes
        this.initial=initial;
        this.end=end;
    }
    
    //Getters
    public Point getInitialPoint(){
        return this.initial;
    }    
    public Point getEndPoint(){
        return this.end;
    }
    
    //Setters
    public void setInitial(Point initial) {
        this.initial=initial;
    }    
    public void setEnd(Point end) {
        this.end=end;
    }
    
    //Drawing method
    public void draw(Graphics2D g) {
        int minX = Math.min(initial.X, end.X);
        int minY = Math.min(initial.Y, end.Y);
        int maxX = Math.max(initial.X, end.X);
        int maxY = Math.max(initial.Y, end.Y);
        int width=maxX-minX;
        int height=maxY-minY;
        g.setColor(color);
        g.setStroke(new BasicStroke(5));
        g.drawRect(minX, minY, width, height);
        g.setColor(Color.BLACK);
        g.fillOval(minX-10/2, minY-10/2, 10, 10);
        g.fillOval(maxX-10/2, maxY-10/2, 10, 10);
        g.fillOval(minX-10/2, maxY-10/2, 10, 10);
        g.fillOval(maxX-10/2, minY-10/2, 10, 10);
    }
    
    //toString
    public String toString() {
        return "The Rectangle has this coordinates: ("+this.initial.X+", "+this.initial.Y+", "+this.end.X+", "+this.end.Y+")";
    }
    
    //insertSQL
    public void insertSQL() {
        //Generates the insert SQL sentence
        String sql= "INSERT INTO table_rectangles VALUES ("+null+", '"+this.geom+"', '"+this.initial.X+"', '"+this.initial.Y+"', '"+this.end.X+"', '"+this.end.Y+"');";
        //Executes the SQL sentence
        new DBConnexion (sql);
    }
    
    //Save into csv file
    public String toCSV() {
        return "Rectangle,"+this.initial.X+","+this.initial.Y+","+this.end.X+","+this.end.Y;
    }

    //Area method
    @Override
    public double area() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
