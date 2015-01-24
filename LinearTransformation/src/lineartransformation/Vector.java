/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lineartransformation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Tim
 */
public class Vector {
    
    Graphics2D graphics;
    double x = 1;
    double y = 0;

    
    public Vector(Graphics g){
        graphics = (Graphics2D)g;
    }
    
    public void setColor(Color c){
        graphics.setColor(c);
    }
    
    public void setVector(double newX, double newY){
        x = newX;
        y = newY;
    }
    
    public void draw(double xInterval){
        double angle;
        if(x != 0){
             angle = -Math.atan(y/x);
        }else{
            if(y >0){
                angle = -Math.toRadians(90);
            }else{
                angle = Math.toRadians(90);
            }
        }
        System.out.println("\t\tAngle:"  + Math.toDegrees(angle));
        if( x< 0){
            System.out.println("angle !!!!!" + angle);
            angle += Math.toRadians(180);
        }
        graphics.rotate(angle);
        double length = 1/xInterval * Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
        graphics.fillRect(0,0,(int)Math.round(length), 3);
        for(int i=0; i <= 5; i++){
            graphics.drawLine((int)Math.round(length)+i, (5-i)+1 , (int)Math.round(length)+i, -(5-i)+1);
        } 
        graphics.rotate(-angle);
        
    }
    
    public double distance(double x1, double y1){
        return Math.sqrt(Math.pow((x1-x),2) + Math.pow((y1-y),2));
    }
}
