package Geometries;

import DBConnexion.DBConnexion;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 * drawing polygon features
 * inherit from figure.java
 * @author          Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
 * creation        30.12.2016
 * @version         18.01.2017
 * param xend      x-coordinate of an edge of the polygon
 * param yend      y-coordinate of an edge of the polygon
 * edges are added to an arrayList
 * return          add polygon to database
 * return          add polygon to CSV-file
 * exeption        UnsupportedOperationException
 */
public class Polygon extends Figure {
    //Own attributes
    protected List<Point> pointList;
    private int xend=0;
    private int yend=0;
    private String coordinates="";
    
    //Constructor
    public Polygon(String geom, Color color) {
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
    
    //Add a point to the Polygon
    public void addPoint(Point coord, Graphics2D g) {
        pointList.add(coord);
        System.out.println(pointList.size());  
    }
    
    //Drawing Method
    public void draw(Graphics2D g, boolean finish) {
        if (pointList.size()>1){
            for (int i=0; i<pointList.size()-1; i++){
                System.out.println("Line: "+i);
                g.setColor(color);
                g.setStroke(new BasicStroke(5));
                g.drawLine(pointList.get(i).getX(), pointList.get(i).getY(), pointList.get(i+1).getX(), pointList.get(i+1).getY());
                g.setColor(Color.BLACK);
                g.fillOval(pointList.get(i).getX()-10/2, pointList.get(i).getY()-10/2, 10, 10);
                g.fillOval(pointList.get(i+1).getX()-10/2, pointList.get(i+1).getY()-10/2, 10, 10);
            }
        }
        if (finish==true) {
            g.setColor(color);
            g.drawLine(pointList.get(0).getX(), pointList.get(0).getY(), pointList.get(pointList.size()-1).getX(), pointList.get(pointList.size()-1).getY());
            g.setColor(Color.BLACK);
            g.fillOval(pointList.get(pointList.size()-1).getX()-10/2, pointList.get(pointList.size()-1).getY()-10/2, 10, 10);
            g.fillOval(pointList.get(0).getX()-10/2, pointList.get(0).getY()-10/2, 10, 10);
        }
    }
    
    //Draw Motion method that draws a temporal line that follows the mouse
    public void drawMotion(Point coord, Color color, Graphics2D g) {
        g.setColor(color);
        xend=coord.getX();
        yend=coord.getY();
        g.setStroke(new BasicStroke(5));
        g.drawLine(pointList.get(pointList.size()-1).getX(), pointList.get(pointList.size()-1).getY(), xend, yend);
    }
    
    //insertSQL
    public void insertSQL() {
        for (int i=0; i<pointList.size(); i++){
            coordinates+=Integer.toString(pointList.get(i).getX())+","+Integer.toString(pointList.get(i).getY())+";";
        }
        String coord=coordinates.substring(0, coordinates.length()-1);
        //Generates the insert SQL sentence
        String sql= "INSERT INTO table_polygons VALUES ("+null+", '"+this.geom+"', '"+coord+"');";
        //Executes the SQL sentence
        new DBConnexion (sql);
    }
    
    //Save into csv file
    public String toCSV() {
        coordinates="";
        for (int i=0; i<pointList.size(); i++){
            coordinates+=Integer.toString(pointList.get(i).getX())+";"+Integer.toString(pointList.get(i).getY())+",";
        }
        String coord="Polygon,"+coordinates.substring(0, coordinates.length()-1);
        return coord;
    }
    
    //Area method
    @Override
    public double area() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}