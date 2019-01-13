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


/**
 *
 * @author ahmed
 */
public class Rectangle extends ConcreteShape{

    public Rectangle() {
        prop = new HashMap();
        prop.put("Width", 0.0);
        prop.put("Length",0.0);
        
    }

    @Override
    public void draw(Graphics canvas) {
       
        canvas.setColor(fillColor);
        
        canvas.fillRect(position.x, position.y, 
                (int)(prop.get("Width").doubleValue()), 
                (int)(prop.get("Length").doubleValue()));
        canvas.setColor(borderColor);
        canvas.drawRect(position.x, position.y, 
                (int)(prop.get("Width").doubleValue()), 
                (int)(prop.get("Length").doubleValue()));
        
    }
            
    @Override
    public Object clone() throws CloneNotSupportedException{
        
        Shape shape = new Rectangle();
        
        shape.setColor(borderColor);
        shape.setFillColor(fillColor);
        shape.setProperties(prop);
        
        
        return shape;
    }

   
}
