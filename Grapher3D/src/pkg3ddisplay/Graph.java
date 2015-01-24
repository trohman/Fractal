package pkg3ddisplay;

import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


/**
 * Graph is a subclass of Display and is responsible for plotting all points
 * 
 * @author Rohman
 */
public class Graph extends Display implements MouseListener{
    
    double xBounds[];      // bounds of x axis
    double yBounds[];       // bounds of y axis
    double yInterval;       // x displacement of one pxl
    double xInterval;       // y displacement of one pxl 
    int graphWidth;         // pxl width of graph
    int graphHeight;        //pxl hight of graph
    double xWidth;      // pxls wide
    double yWidth;      // pxls high
    int mouse[] = {-5,-5};      // mouse coordinates
    static ptCollector points = new ptCollector();      // holds all points in the graph
    static boolean redraw = true;       // if the graph needs to be redrawn
    static boolean isLine = false;      // true draws line, false draws plane
    static double window[] = {-3,3,-2,2}; // {xMin,xMax,yMin,yMax}
    static String equations[] ={"","","",""};   // equations -- F(x,y) , X(t) , Y(t) , Z(t)
    static double x[] = {-1,1,.02};     // x interval
    static double y[] = {-1,1,.02};     // y interval
    static double t[] = {-1,1,.001};    // t interval
    
    /**
     * Constructor for graph 
     * sets default x && y bounds since none were provided
     * @param width     pxl width of graph
     * @param height    pxl hight of graph
     */
    public Graph(int width, int height){        
        graphWidth = width;
        graphHeight = height;
        double x[] = {1,4}; // {xMin,xMax}
        double y[] = {0,1}; // {yMin, yMax}
        setBounds(x, y);
        editor.runEditor();
    }

    /**
     * Constructor for graph
     * used when caller provides bounds
     * @param width     pxl width of graph
     * @param height    pxl hight of graph
     * @param x         x bounds 
     * @param y         y bounds
     */
    public Graph(int width, int height,double x[], double y[]){
        graphWidth = width;
        graphHeight = height;
        setBounds(x,y);
        editor.runEditor();
    }
    
    /**
     * Sets the bounds provided
     * @param x     new x bounds 
     * @param y     new y bounds
     */
    public void setBounds(double x[], double y[]){
        setXBounds(x);
        setYBounds(y);
        
    }
    
    /**
     * sets the y bounds of the graph
     * @param y new y bounds
     */
    public void setYBounds(double y[]){
        yBounds = y;
        yInterval = (y[1] - y[0])/graphWidth;
        yWidth = y[1] - y[0];
    }

    /**
     * sets the x bounds of the graph
     * @param x  new x bounds
     */
    public void setXBounds(double x[]){
        xBounds = x;
        xInterval = (x[1] - x[0])/graphWidth;
        xWidth = x[1] - x[0];

    }

    /**
     * adds a new point (x,y,z) to the point collector
     * @param x     x coordinate 
     * @param y     y coordinate
     * @param z     z coordinate
     */
    public static void addPoint(double x, double y, double z){
        points.addPoint(x,y,z);
    }
    
    /**
     * Converts a point (x,y) to its equivalent pixel
     * @param x x coordinate
     * @param y y coordinate
     * @return the pair (x,y) of the pixel coordinates
     */
    public int[] ptToPxl(double x, double y){
        
        int xCord = (int) Math.round(((double)graphWidth/xWidth)*(x-xBounds[0]));
        int yCord = (int) Math.round(((double)graphHeight/yWidth)*(yBounds[1]-y));
        
        int point[] = {xCord,yCord};
        return point;
        
    }
    
    /**
     * Converts a pixel (x,y) to its equivalent point
     * @param x x coordinate
     * @param y y coordinate
     * @return the pair (x,y) of the coordinates on the graph
     */
    public double[] pxlToPt(int x, int y){
        double xPxl = (x/((double)graphWidth/xWidth)+xBounds[0]);
        double yPxl = yBounds[1] - (y/((double)graphHeight/yWidth)+yBounds[0]);

        double pxl[] = {xPxl,yPxl};
        return pxl;
    }

    
    /**
     * clears the graph by removing all points 
     * from the point collector
     */
    public void clearGraph(){
         points = new ptCollector();
    }
    
    /**
     * does all of the math for plotting the points
     */
    public static void doMath(){
        redraw=true;
        Boolean stop = false;
        points = new ptCollector();
        if(isLine){
            // x & y are not used in this loop so hiding field is ok
            for(double t1 = t[0]; t1 < t[1] && !stop; t1+=t[2]){
                Expression x = new Expression(equations[1],t1,0);
                Expression y = new Expression(equations[2],t1,0);
                Expression z = new Expression(equations[3],t1,0);
                try{
                addPoint(x.resolve(),y.resolve(),z.resolve());
                }catch(Exception e){
                    Error.runError();
                    stop = true;
                }
                
            }
            
        }else{
            for(double x1 = x[0]; x1 < x[1] && !stop; x1+=x[2]){
                for(double y1 = y[0]; y1 < y[1] && !stop; y1+=y[2]){
                    
                    Expression z = new Expression(equations[0],x1,y1);
                    
                    try {    
                        addPoint(x1,y1,z.resolve());
                    } catch (Exception ex) {
                        Error.runError();
                        stop = true;
                        
                    }
                }
           }
            
            
            
        }
               
        for(double num = 0; num < 1; num += .01){
            addPoint(num,0,0);
            addPoint(0,num,0);
            addPoint(0,0,num);
        }        
    }
    
    /**
     * overrides draw method in display 
     * all actual plotting of points and 
     * drawing the axis occurs here
     */
    @Override
    public void draw(){
        
        // Math Part
        if(redraw){
        
            double x[] = {-3,3}; // {xMin,xMax}
            double y[] = {-2,2}; // {yMin, yMax}
            setBounds(x, y);
            ArrayList<Point> allPoints = points.getAllPoints();

            for(int i = 0; i < allPoints.size()-1; i++ ){
                double pt1[] = allPoints.get(i).getPoint();
                int pxl1[] = ptToPxl(pt1[0],pt1[1]);
            
                mathGraphics.drawLine(pxl1[0],pxl1[1],pxl1[0],pxl1[1]);
            }
        
            redraw = false;
        }

        bufferGraphics.drawImage(diagram, 0, 0, this);      
    }


   
    /**
     * Interprets key presses and rotates the graph by 
     * an angle of 5 degrees in the appropriate direction
     * @param e key event
     * 
     * Note : all keys are on numpad
     * 
     */
    @Override
    public void keyPressed(KeyEvent e){
        mathGraphics.clearRect(0, 0, 3000, 3000);
        
        int angle = 5;
        switch(e.getKeyCode()){
            
            case 98:
                editor.runEditor();
                break;
            case 100:
                points.rotate('y', -angle);                
                break;
            case 101:
                points.rotate('x', -angle);                
                break;
            case 102:
                points.rotate('y', angle);                
                break;
            case 103:
                points.rotate('z', -angle);                
                break;
            case 104:
                points.rotate('x', angle);                
                break;
            case 105:
                points.rotate('z', angle);   
        }
        redraw = true;
        draw();
        repaint();

    }



}
