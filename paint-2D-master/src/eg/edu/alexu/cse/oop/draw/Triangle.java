/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.cse.oop.draw;


import eg.edu.alexu.cse.oop.draw.ConcreteShape;
import eg.edu.alexu.cse.oop.draw.Shape;
import java.awt.Graphics;
import java.util.HashMap;


import static java.lang.Math.abs;

/**
 *
 * @author User
 */
public class Triangle extends ConcreteShape {
    
    public Triangle()
    {
        prop = new HashMap();
        prop.put("Base", 0.0);
        prop.put("Height", 0.0);
    
    }

    @Override
    public void draw(Graphics canvas) {
        int [] x = new int[3];
        int [] y = new int[3];
        x[0] = position.x;
        x[1] = position.x+(int)(prop.get("Base").doubleValue());
        x[2] = position.x+((int)(prop.get("Base").doubleValue())/2);
        y[0] = position.y;
        y[1] = position.y;
        y[2] = abs(position.y+(int) (prop.get("Height").doubleValue()));
        
        canvas.setColor(fillColor);
        canvas.fillPolygon(x,y,3);
        canvas.setColor(borderColor);
        canvas.drawPolygon(x,y,3);
          
    }
    
    
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        
        Shape shape = new Triangle();
        
        shape.setColor(borderColor);
        shape.setFillColor(fillColor);
        shape.setProperties(prop);
        
        return shape;
    }
    
}
