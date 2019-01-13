/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.cse.oop.draw;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


/**
 *
 * @author ahmed
 */
public class Actions implements DrawingEngine {

    private static List<Class<? extends Shape>> classes = new ArrayList<>(); 
    private static ArrayList<Shape> shapesList = new ArrayList<>();
    private String methodUndo,location,pluginName;
    private int count,capacity;
    private Shape[] shapes;
    private Shape shape;
    private Map<Shape,Actions> MapUndo,MapRedo;

    private Stack<Map<Shape,Actions>> StackRedo = new Stack<>();
    private Stack<Map<Shape,Actions>> StackUndo;
     
    public Actions() {
    }
    
    public void init(String methodCalled, int val) { 
        methodUndo = methodCalled;
        count = val;
    }
     
    public String getMethod() {
        return methodUndo;
    }
    public int getCount() {
        return count;
    }
    
    public void setStackUndo(Stack<Map<Shape, Actions>> StackUndo) {
        this.StackUndo = StackUndo;
    }
    
    public Stack<Map<Shape, Actions>> getStackRedo() {
        return StackRedo;
    }
    

    @Override
    public void addShape(Shape shape) {

        shapesList.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        shapesList.remove(shape);
    }

    @Override
    public Shape[] getShapes() {
        Shape shapesArr[] = shapesList.toArray(new Shape[shapesList.size()]);
        return shapesArr;
    }

    @Override
    public void refresh(Graphics canvas) {
        
        canvas.clearRect(0, 0, 1000, 1000);    //to clear the screen
        //It must be of type array not array list
        Shape shapesArr[] = shapesList.toArray(new Shape[shapesList.size()]); 


        for (Shape shapesArr1 : shapesArr) {
            shapesArr1.draw(canvas);
        }

    }
public List<Class<? extends Shape>> initSupportedShapes() throws ClassNotFoundException{
    classes.add((Class<? extends Shape>) Class.forName(Circle.class.getName()));
    classes.add((Class<? extends Shape>) Class.forName(Square.class.getName()));
    classes.add((Class<? extends Shape>) Class.forName(Rectangle.class.getName()));
    classes.add((Class<? extends Shape>) Class.forName(Ellipse.class.getName()));
    classes.add((Class<? extends Shape>) Class.forName(LineSegment.class.getName()));
    classes.add((Class<? extends Shape>) Class.forName(Triangle.class.getName()));
    return classes;
}
    @Override
    public java.util.List<Class<? extends Shape>> getSupportedShapes() {
        return classes;
    }
 
    @Override
    public void installPluginShape(Class<? extends Shape> shapeClass) {
        classes.add(shapeClass);

    }
    
    @Override
    public void undo() {
        MapUndo = new LinkedHashMap(StackUndo.pop());
        capacity = MapUndo.size();
        shapes = MapUndo.keySet().toArray(new Shape[capacity]);
        
        StackRedo.push(MapUndo);
        
        if ("add".equals(MapUndo.get(shapes[capacity-1]).getMethod()) ){
            removeShape(shapes[capacity-1]); 
        }
        else{
            addShape(shapes[capacity-1]);
        }
    }
    
    @Override
    public void redo() {
        
        MapRedo = new LinkedHashMap(StackRedo.pop());
        MapUndo = new LinkedHashMap();

        capacity = MapRedo.size();
        shapes = MapRedo.keySet().toArray(new Shape[capacity]);
        
        StackUndo.push(MapRedo);

        MapUndo.put(shapes[capacity-1], MapRedo.get(shapes[capacity-1]));
        
        if ("add".equals(MapRedo.get(shapes[capacity-1]).getMethod()) ){
            addShape(shapes[capacity-1]); 
        }
        else{
            removeShape(shapes[capacity-1]);
        }
               
    }

}