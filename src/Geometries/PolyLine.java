package Geometries;

import DBConnexion.DBConnexion;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

/**
 * drawing line features
 * inherit from figure.java
 * @author          Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
 * creation        06.11.2016
 * @version         18.01.2017
 * param xend      x-coordinate of an edge of the line
 * param yend      y-coordinate of an edge of the line
 * edges are added to an arrayList
 * return          add line to database
 * return          add line to CSV-file
 * exeption        UnsupportedOperationException
 */
public class PolyLine extends Figure{
    //Own attributes
    //Array of points
    protected List<Point> pointList;
    private int xend=0;
    private int yend=0;
    private String coordinates="";
    
    //Constructor
    public PolyLine(String geom, Color color) {
        //inheritated attributes
        super(geom, color);
        //own attributes
        pointList=new ArrayList<Point>();
    }
    
    //Getters
    public int getSize(){
        return pointList.size();
    }
    public List<Point> getPointList() {
        return pointList;
    }
    
    //Add a point to this PolyLine
    public void addPoint(Point coord, Graphics2D g) {
        pointList.add(coord);
        System.out.println(pointList.size());
    }
    
    //Drawing Method
    public void draw(Graphics2D g) {
        if (pointList.size()>1){
            for (int i=0; i<pointList.size()-1; i++){
                g.setColor(color);
                g.setStroke(new BasicStroke(5));
                g.drawLine(pointList.get(i).getX(), pointList.get(i).getY(), pointList.get(i+1).getX(), pointList.get(i+1).getY());
                g.setColor(Color.BLACK);
                g.fillOval(pointList.get(i).getX()-10/2, pointList.get(i).getY()-10/2, 10, 10);
                g.fillOval(pointList.get(i+1).getX()-10/2, pointList.get(i+1).getY()-10/2, 10, 10);
            }
        }
    }
    
    //Draw Motion method that draws a temporal line that follows the mouse
    public void drawMotion(Point coord, Graphics2D g) {
        g.setColor(color);
        g.setStroke(new BasicStroke(5));
        xend=coord.getX();
        yend=coord.getY();
        g.drawLine(pointList.get(pointList.size()-1).getX(), pointList.get(pointList.size()-1).getY(), xend, yend);
    }
    
    //insertSQL
    public void insertSQL() {
        for (int i=0; i<pointList.size(); i++){
            coordinates+=Integer.toString(pointList.get(i).getX())+","+Integer.toString(pointList.get(i).getY())+";";
        }
        String coord=coordinates.substring(0, coordinates.length()-1);
        //Generation of insert SQL sentence
        String sql= "INSERT INTO table_lines VALUES ("+null+", '"+this.geom+"', '"+coord+"');";
        //Execute the SQL sentence
        new DBConnexion (sql);
    }
    
    //Save into csv file
    public String toCSV() {
        coordinates="";
        System.out.println(pointList.size());
        for (int i=0; i<pointList.size(); i++){
            coordinates+=Integer.toString(pointList.get(i).getX())+";"+Integer.toString(pointList.get(i).getY())+",";
        }
        String coord="PolyLine,"+coordinates.substring(0, coordinates.length()-1);
        return coord;
    }
    
    //Area Method
    @Override
    public double area() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
