package Geometries;

import DBConnexion.DBConnexion;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 * drawing triangle features
 * inherit from figure.java
 * @author          Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
 * creation        10.11.2016
 * @version         18.01.2017
 * return          a list with edges of the triangles
 * return          add triangle to database
 * return          add triangle to CSV-file
 * exeption        UnsupportedOperationException
 */
public class Triangle extends Figure {
    //Own attributes
    protected List<Point> pointList;
    boolean digit;
    private int xend=0;
    private int yend=0;    
    private String coordinates="";
    
    //Constructor
    public Triangle(String geom, Color color) {
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
    
    //Add a point to this Triangle
    public void addPoint(Point coord, Graphics2D g) {
        pointList.add(coord);
        System.out.println(pointList.size());
        digit=true;   
    }
    
    //Drawing Method
    public void draw(Graphics2D g) {
        //This first case draws the first line
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
        //This seccond case draws two lines from the new point to the others
        if (pointList.size()>2) {
            g.setColor(color);
            g.drawLine(pointList.get(0).getX(), pointList.get(0).getY(), pointList.get(2).getX(), pointList.get(2).getY());
            g.setColor(Color.BLACK);
            g.fillOval(pointList.get(2).getX()-10/2, pointList.get(2).getY()-10/2, 10, 10);
        }
    }
    
    //Draw Motion method that draws a temporal line that follows the mouse
    public void drawMotion(Point coord, Color color, Graphics2D g) {
        if (digit==true) { //Draw itself
            //This first case draws one temporal line
            g.setColor(color);
            xend=coord.getX();
            yend=coord.getY();
            g.setStroke(new BasicStroke(5));
            g.drawLine(pointList.get(pointList.size()-1).getX(), pointList.get(pointList.size()-1).getY(), xend, yend);
            //This seccond case draws two temporal lines from the new point to the others
            if (pointList.size()>1){
                g.drawLine(pointList.get(pointList.size()-2).getX(), pointList.get(pointList.size()-2).getY(), xend, yend);
            }
        }
    }
    
    //insertSQL
    public void insertSQL() {
        for (int i=0; i<pointList.size(); i++){
            coordinates+=Integer.toString(pointList.get(i).getX())+","+Integer.toString(pointList.get(i).getY())+";";
        }
        String coord=coordinates.substring(0, coordinates.length()-1);
        //Generates the SQL sentence
        String sql= "INSERT INTO table_triangles VALUES ("+null+", '"+this.geom+"', '"+coord+"');";
        //Executes the SQL sentence
        new DBConnexion (sql);
    }
    
    //Save into CSV file
    public String toCSV() {
        coordinates="";
        for (int i=0; i<pointList.size(); i++){
            coordinates+=Integer.toString(pointList.get(i).getX())+";"+Integer.toString(pointList.get(i).getY())+",";
        }
        String coord="Triangle,"+coordinates.substring(0, coordinates.length()-1);
        return coord;
    }
    
    //Area method
    @Override
    public double area() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}