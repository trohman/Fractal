/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chaos;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Rohman
 */
public class LogisticBifurcationDiagram {
    
    

    public LogisticBifurcationDiagram(){
        
        
    }
    
    ArrayList<double[]> points = new ArrayList<double[]>();

    public void drawPoint(double x, double y){
        
        double point[] = {x,y};
        points.add(point);
    }

    public ArrayList<double[]> drawOrbital(double seed){
        for(double x = 1; x<=4; x+=.002){
            drawR(seed,x);
        }

        return points;
    }

    public ArrayList<double[]> drawOrbital(double seed, double xMin, double xMax, double interval){
        for(double x = xMin; x<=xMax; x+=interval){
            drawR(seed,x);
        }

        return points;
    }

    public void drawR(double seed, double r){
        double num = seed;
        for(int iterations = 0; iterations < 1000; iterations ++){
            num = r*num*(1-num);
            if(iterations > 150){
                drawPoint(r, num);
            }
        }

    }

}
