package chaos;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rohman
 */
public class Graph extends Display{
    
    double xBounds[] = {-1,1};
    double yBounds[]= {-1,1};
    double yInterval = 1;
    double xInterval = 1;
    int graphWidth = 1;
    int graphHeight = 1;
    double xWidth;
    double yWidth;
    int mouse[] = {-5,-5};
    boolean mouseSetVisible = false;
    ArrayList<int[]> points = new ArrayList<int[]>();


    
    
    
    public Graph(int width, int height){        
        graphWidth = width;
        graphHeight = height;
        double x[] = {1,4}; // {xMin,xMax}
        double y[] = {0,1}; // {yMin, yMax}
        setBounds(x, y);
        double pt1[] = {1,0};
        double pt2[] = {4,1};
        windows.add(pt1);
        windows.add(pt2);
        
    }

    public Graph(int width, int height,double x[], double y[]){
        graphWidth = width;
        graphHeight = height;
        setBounds(x,y);

    }
    
    public void setBounds(double x[], double y[]){
        setXBounds(x);
        setYBounds(y);
        
    }
    
    
    
    public void setYBounds(double y[]){
        yBounds = y;
        yInterval = (y[1] - y[0])/graphWidth;
        yWidth = y[1] - y[0];
    }

    public void setXBounds(double x[]){
        xBounds = x;
        xInterval = (x[1] - x[0])/graphWidth;
        xWidth = x[1] - x[0];

    }

    public void addPoint(double x, double y){
        points.add(ptToPxl(x,y));
    }
    
    public int[] ptToPxl(double[] pt){
        return ptToPxl(pt[0],pt[1]);
    }
    
    public int[] ptToPxl(double x, double y){
        
        int xCord = (int) Math.round(((double)graphWidth/xWidth)*(x-xBounds[0]));
        int yCord = (int) Math.round(((double)graphHeight/yWidth)*(yBounds[1]-y));
        
        int point[] = {xCord,yCord};
        return point;
        
    }
    
    public double[] pxlToPt(int x, int y){
        double xPxl = (x/((double)graphWidth/xWidth)+xBounds[0]);
        double yPxl = yBounds[1] - (y/((double)graphHeight/yWidth));

        double pxl[] = {xPxl,yPxl};
        return pxl;
    }

    
    
    public void clearGraph(){
         points = new ArrayList<int[]>();
    }



    public void setWindow(){
        double pt1[] = windows.get(windows.size()-1);
        double pt2[] = windows.get(windows.size()-2);
        double x[] = new double[2];
        double y[] = new double[2];
        if(pt1[0] < pt2[0]){
            x[0] = pt1[0];  
            x[1] = pt2[0];
        }else{
            x[1] = pt1[0];  
            x[0] = pt2[0];
        }
        
        if(pt1[1] < pt2[1]){
            y[0] = pt1[1];  
            y[1] = pt2[1];
        }else{
            y[1] = pt1[1];  
            y[0] = pt2[1];
        }
        
        
        
        redraw = true;
        setBounds(x,y);
        
        //  1       yWidth
        //  3       xWidth
       
        if((xWidth/yWidth) > 3){
            double yW = (xWidth * 1) / 3;
            y[0] = y[1] - yW;
        }else{
            double xW = (yWidth * 3) ;
            x[1] = x[0] + xW;
        }
        
        setBounds(x,y);
        //
        System.out.println(xWidth / yWidth);
    }


    boolean redraw = true;
    
    @Override
    public void draw(){
        bufferGraphics.clearRect(0,0,2000,2000);

        // Math Part

        if(redraw){
            
        mathGraphics.clearRect(0,0,2000,2000);
        clearGraph();
         LogisticBifurcationDiagram l = new LogisticBifurcationDiagram();
        ArrayList<double[]> orbital = l.drawOrbital(0.847568,xBounds[0],xBounds[1],xInterval);
        for(double point[]: orbital){
            addPoint(point[0], point[1]);
            
        }
        

        for(int[] pt: points){
            //System.out.println((pt[0]+","+ pt[1]));
           mathGraphics.drawRect(pt[0],pt[1],0,0);
        }
        redraw = false;
        }

        bufferGraphics.drawImage(diagram, 0, 0, this);
        
        if(pressed){
        int minX,maxY;
        if(box[0] > box[2]){
            minX = box[2]; 
        }else{
            minX = box[0];
        }
        
        if(box[1] < box[3]){
            maxY = box[1]; 
        }else{
            maxY = box[3];
        }
        
        bufferGraphics.drawRect(minX, maxY,Math.abs(box[0] - box[2]),Math.abs(box[1] - box[3]));
        
        
        
        
        }


        
    }


    ArrayList<double[]> windows = new ArrayList<double[]>();
    boolean pressed = false;

    @Override
     public void mousePressed(MouseEvent e) {
        pressed = true;
        windows.add(pxlToPt(e.getX(),e.getY()));
        
     
    }

    @Override
     public void mouseReleased(MouseEvent e) {
        pressed = false;
        double[] pxlToPt = pxlToPt(e.getX(),e.getY());
        if(((Math.abs(pxlToPt[0] - windows.get(windows.size()-1)[0]))/graphWidth) > 0){
            windows.add(pxlToPt);
            setWindow();
        }else{
            windows.remove(windows.size()-1);
        }
       
        repaint();
    }

    //this.k

    @Override
    public boolean keyDown(Event evt, int key) {
        return super.keyDown(evt, key);
    }
    @Override
    public void keyPressed(KeyEvent e){
        System.out.println(e.getKeyCode());
        if(e.getKeyCode() == 8 && windows.size() >2){
            windows.remove(windows.size()-1);
            windows.remove(windows.size()-1);
            
            setWindow();
            repaint();
        }
        


    }
    
    int box[] = new int[4];
    @Override
    public void mouseDragged(MouseEvent e){
        int pxl[] = ptToPxl(windows.get(windows.size()-1));
        box[0] = pxl[0];
        box[1] = pxl[1];
        box[2] = e.getX();
        box[3] = e.getY();
        repaint();
    }



}
