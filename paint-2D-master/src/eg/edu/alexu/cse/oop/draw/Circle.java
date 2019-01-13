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
 * @author User
 */
public class Circle extends ConcreteShape{
      
    public Circle()
    {
     prop = new HashMap();
     prop.put("Radius", 0.0);
     
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(fillColor);
        canvas.fillOval(position.x, position.y, 
                (int)(prop.get("Radius").doubleValue()), 
                (int)(prop.get("Radius").doubleValue()));
        canvas.setColor(borderColor);
        canvas.drawOval(position.x, position.y, 
                (int)(prop.get("Radius").doubleValue()), 
                (int)(prop.get("Radius").doubleValue()));
    }
    
     @Override
    public Object clone() throws CloneNotSupportedException{
        
        Shape shape = new Circle();
        
        shape.setColor(borderColor);
        shape.setFillColor(fillColor);
        shape.setProperties(prop);
        
        return shape;
    }
    
}
