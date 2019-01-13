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
public class LineSegment extends ConcreteShape {

    
    public LineSegment()
    {
        prop = new HashMap();
        prop.put("Length", 0.0);
        
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(borderColor);
        canvas.drawLine(position.x, position.y, 
                position.x + (int) prop.get("Length").doubleValue(), 
                position.y + (int) prop.get("Length").doubleValue());
    }
    
    
    
     @Override
    public Object clone() throws CloneNotSupportedException{
        
        Shape shape = new LineSegment();
        
        shape.setColor(borderColor);
        shape.setProperties(prop);
        
        
        return shape;
    }
}
