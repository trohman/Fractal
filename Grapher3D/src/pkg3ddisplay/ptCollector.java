/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3ddisplay;

import java.util.ArrayList;

/**
 * Point Collector is a class that hold all points on the graph 
 * it can also be used to rotate all of the points about any 
 * of the axis
 * 
 * @author Tim
 */
public class ptCollector {
    
    ArrayList<Point> points = new ArrayList<Point>();       //arraylist of all points on the graph
    final double NULLPOINT[] = {0,0,0};                     // definition of the null point
    
    /**
     * adds a point of the form (x,y,z)
     * @param x     x coordinate     
     * @param y     y coordinate
     * @param z     z coordinate
     */
    public void addPoint(double x, double y, double z){        
        points.add(new Point(x,y,z));        
    }
    
    /**
     * gets the point at given index
     * if an invalid index is given, the 
     * null point will be returned
     * @param i     the index
     * @return the point as a double array {x,y}
     */
    public double[] getPoint(int i){
        if(i < points.size()){
            return points.get(i).getPoint();
        }else{
            return NULLPOINT;
        }        
    }
    
    /**
     * gets all of the points in the point collector
     * @return an ArrayList of all points
     */
    public ArrayList<Point> getAllPoints(){
        return points;
    }
    
    /**
     * gets the number of points in the collector
     * this is the same as the size of the points 
     * ArrayList
     * @return the number of points in the collector
     */
    public int size(){
        return points.size();
    }
    
    
    /**
     * rotates all points in the collector about 
     * one of the axis x, y, or z
     * @param dir   the axis to rotate about - valid entries are 'x' , 'y' , 'z'
     * @param angle number of degrees rotation 
     */
    public void rotate(char dir, int angle){
        MatrixOperator m = new MatrixOperator();
        Matrix operator = new Matrix();
        operator.setDimension(3, 3);
        operator.fill(0);
        double radian = Math.toRadians(angle);
        switch(dir){            
            case 'x':
                operator.setElement(1,0,0);
                operator.setElement(Math.cos(radian),1,1);
                operator.setElement(-Math.sin(radian),1,2);
                operator.setElement(Math.sin(radian),2,1);
                operator.setElement(Math.cos(radian),2,2);                   
            break;
            case 'y':    
                operator.setElement(1,1,1);
                operator.setElement(Math.cos(radian),0,0);
                operator.setElement(-Math.sin(radian),0,2);
                operator.setElement(Math.sin(radian),2,0);
                operator.setElement(Math.cos(radian),2,2);
                    
            break;
            case 'z':       
                operator.setElement(1,2,2);                
                operator.setElement(Math.cos(radian),0,0);
                operator.setElement(-Math.sin(radian),0,1);
                operator.setElement(Math.sin(radian),1,0);
                operator.setElement(Math.cos(radian),1,1);
            
        }
        System.out.println(operator);
        for(Point p : points){
            p.rotate(operator,m);
        }
        
    }
    
}
