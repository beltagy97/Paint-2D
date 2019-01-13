/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.cse.oop.draw;


import eg.edu.alexu.cse.oop.draw.Shape;
import java.awt.Graphics;
import java.util.HashMap;


/**
 *
 * @author User
 */
public class Square extends Rectangle {

    public Square()
    {
        prop = new HashMap();
        prop.put("Side", 0.0);
    }
    
    

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(fillColor);
        
        canvas.fillRect(position.x, position.y, 
                (int)(prop.get("Side").doubleValue()), 
                (int)(prop.get("Side").doubleValue()));
        canvas.setColor(borderColor);
        canvas.drawRect(position.x, position.y, 
                (int)(prop.get("Side").doubleValue()), 
                (int)(prop.get("Side").doubleValue()));
    }
    
     @Override
    public Object clone() throws CloneNotSupportedException{
        
        Shape shape = new Square();
        
        shape.setColor(borderColor);
        shape.setFillColor(fillColor);
        shape.setProperties(prop);
        
        
        return shape;
    }
    
}
