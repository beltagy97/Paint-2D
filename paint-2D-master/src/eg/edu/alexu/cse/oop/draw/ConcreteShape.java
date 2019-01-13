/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.cse.oop.draw;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ahmed
 */
public abstract class ConcreteShape implements Shape {

    protected Color fillColor, borderColor;
    protected Point position;
    protected Map<String, Double> prop;

    @Override
    public void setPosition(Point position) {
        this.position = new Point(position);
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setColor(Color color) {
        this.borderColor = new Color(color.getRGB());
    }

    @Override
    public Color getColor() {
        return this.borderColor;
    }

    @Override
    public void setFillColor(Color color) {
         this.fillColor = new Color(color.getRGB());
    }

    @Override
    public Color getFillColor() {
        return this.fillColor;
    }
    
    @Override
    public void setProperties(Map<String, Double> properties) {
        this.prop = new HashMap(properties);
    }

    @Override
    public Map<String, Double> getProperties() {
        return this.prop;
    }
    
    @Override
    public abstract Object clone() throws CloneNotSupportedException;
    
}
