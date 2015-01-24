/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chaos;

import java.util.ArrayList;

/**
 *
 * @author Rohman
 */
public class Grapher extends InterfaceFinal {



    public Grapher(){
        super();
        
        
    }
    
    public static void main(String args[]){
        Grapher g = new Grapher();
        g.start(args);


    }

    public void start(String args[]){
        System.out.println("running"+display);
        super.main(args);
        setUp();
        run();

    }

    public static void setUp(){
        double x[] = {1,4}; // {xMin,xMax}
        double y[] = {0,1}; // {yMin, yMax}
        display.setBounds(x, y);

    }

    public static void run(){
    //do stuff here
        System.out.println("running");
        LogisticBifurcationDiagram l = new LogisticBifurcationDiagram();
        ArrayList<double[]> orbital = l.drawOrbital(0.847568);
        for(double point[]: orbital){
            display.addPoint(point[0], point[1]);
        }
        System.out.println(orbital);
        display.draw();
    }


}
