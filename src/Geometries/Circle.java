package Geometries;

import DBConnexion.DBConnexion;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * drawing circle features
 * inherit from figure.java
 * @author          Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
 * creation        27.12.2016
 * @version         18.01.2017
 * param center.X  x-coordinate of center
 * param center.Y  y-coordinate of center
 * param radius    radius of circle
 * return          coordinates of circle (center + radius)
 * return          add circle to database
 * return          add circle to CSV-file
 */
public class Circle extends Figure {
    //Own attributes
    protected Point center;
    protected Point end;
    protected int radius;
    
    //Constructor
    public Circle(String geom, Color color, Point center, Point end) {
        //inheritated attributes
        super(geom, color);
        //Own attributes
        this.center=center;
        this.end=end;
        //Calculate the radius
        int minX = Math.min(center.X, end.X);
        int maxX = Math.max(center.X, end.X);
        this.radius=maxX-minX;
    }
    
    //Getters
    public Point getCenter(){
        return this.center;
    }
    public int getRadius(){
        return this.radius;
    }
    
    //Setters
    public void setCenter(Point center) {
        this.center=center;
    }
    public void setRadius(int radius) {
        this.radius=radius;
    }
    
    //Drawing method
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.setStroke(new BasicStroke(5));
        g.drawOval(center.X-this.radius/2, center.Y-this.radius/2, this.radius, this.radius);
    }
    
    //toString
    public String toString() {
        return "The Circle has this coordinates of the center: ("+this.center.X+", "+this.center.Y+", "+this.end.X+", "+this.end.Y+")";
    }
    
    //insertSQL
    public void insertSQL() {
        int minX = Math.min(center.X, end.X);
        int maxX = Math.max(center.X, end.X);
        radius=maxX-minX;
        //Generates the insert SQL sentence
        String sql= "INSERT INTO table_circles VALUES ("+null+", '"+this.geom+"', '"+this.center.X+"', '"+this.center.Y+"', '"+this.radius+"');";
        //Executes the SQL sentence
        new DBConnexion (sql);
    }
    
    //Save into csv file
    public String toCSV() {
        return "Circle,"+this.center.X+","+this.center.Y+","+this.end.X+","+this.end.Y;
    }

    //Area method
    @Override
    public double area() {
        return radius*radius*Math.PI;
    }
}