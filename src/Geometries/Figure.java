/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometries;

import java.awt.Color;

/**
 * abstract code for any feature type
 * @author          Adrián Castelló Martínez; Macarena Parrizas Siles; Benedikt Futterer; Fabian Finkbeiner
 * creation        02.11.2016
 * @version         18.01.2017
 * param geom      feature type
 * param color     color of the feature
 */
//Main class
public abstract class Figure {
    //Variables that will be used by all subclasses (Inheritage)
    protected String geom;
    protected Color color;
    
    //Constructor
    public Figure(String geom, Color color) {
        this.geom=geom;
        this.color=color;
    }
    
    //Getters
    public String getGeom() {
        return this.geom;
    }
    
    public Color getColor() {
        return this.color;
    }
    
    //Setters
    public void setGeom(String geom) {
        this.geom=geom;
    }
    
    public void setColor(Color color) {
        this.color=color;
    }
    
    //abstract method
    public abstract double area();
    
}
