/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chaos;

import java.awt.Color;

/**
 *
 * @author Tim
 */
public class SmallPlot extends Display{
    int h;
    int w;
    boolean SPLIT = false;
    public SmallPlot(int height, int width){
        h = height;
        w = width;
    
    }

    @Override
    public void draw() {
        if(SPLIT){
        double r =3.9;
        double val = .34;
        int x =0;
        bufferGraphics.setColor(Color.red);
        while(x<width){
            double oldVal = val;
            val = (val*r)*(1-val);
            bufferGraphics.drawLine(x,height(oldVal)+(height/2),x+=10,height(val)+(height/2));
            //bufferGraphics.fillRect(x-2, height(val),5,5);
        }
        bufferGraphics.setColor(Color.blue);
        val = .34 + Math.pow(10, -14);
        x =0;
        while(x<width){
            double oldVal = val;
            val = (val*r)*(1-val);
            bufferGraphics.drawLine(x,height(oldVal) ,x+=10,height(val) );
            //bufferGraphics.fillRect(x-2, height(val),5,5);
        }
        
        }else{
            double r =3.92;
        double val = .34;
        int x =0;
        bufferGraphics.setColor(Color.red);
        while(x<width){
            double oldVal = val;
            val = (val*r)*(1-val);
            bufferGraphics.drawLine(x,height(oldVal),x+=10,height(val));
            //bufferGraphics.fillRect(x-2, height(val),5,5);
        }
        bufferGraphics.setColor(Color.blue);
        val = .34 + Math.pow(10, -14);
        x =0;
        while(x<width){
            double oldVal = val;
            val = (val*r)*(1-val);
            bufferGraphics.drawLine(x,height(oldVal) ,x+=10,height(val) );
            //bufferGraphics.fillRect(x-2, height(val),5,5);
            
            
            
        }
        }
    }
    
    int height(double d){
        if(SPLIT){
            return (int) Math.round(d * (height/2));
        }else{
                        return (int) Math.round(d * (height));

            
        }
    }
    
    
    
}
