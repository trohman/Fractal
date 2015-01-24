/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lineartransformation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.EventListener;
import javax.imageio.ImageIO;
 

/**
 *
 * @author Tim Rohman
 */




/**
 *
 * @author Rohman
 */
public class Transformation extends Display implements MouseListener, EventListener{
    
    double xBounds[] = {-1,1};
    double yBounds[]= {-1,1};
    double yInterval = 1;
    double xInterval = 1;
    int graphWidth = 1;
    int graphHeight = 1;
    double xWidth;
    double yWidth;
    int mouse[] = {-5,-5 ,0,0};
    boolean mouseSetVisible = false;
    Image picture;
    Image invertedPicture;
    double matrix[] =  {1,0,0,1,0,1};  
    Vector v1;
    Vector v2; 
    double matrix2[] =  {1,0,0,-1,0,1};
    AffineTransform inverse;
    
    
    
    public Transformation(int width, int height){        
        graphWidth = width;
        graphHeight = height;
        double x[] = {1,4}; // {xMin,xMax}
        double y[] = {0,1}; // {yMin, yMax}
        setBounds(x, y);
        
        setImage("purdue-logo.jpg");
            }

    public Transformation(int width, int height,double x[], double y[]){
        graphWidth = width;
        graphHeight = height;
        setBounds(x,y);
    }
    
    
    
   public String setImage(String file){
       
       
       first = true;
       try {
            invertedPicture = ImageIO.read(new File(file));
            
        } catch (IOException ex) {
           return "Image Failed to Load";
        }
       return "";
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

   
    public int[] ptToPxl(double x, double y){
        
        int xCord = (int) Math.round(((double)graphWidth/xWidth)*(x));
        int yCord = (int) Math.round(((double)graphHeight/yWidth)*(y));
        
        int point[] = {xCord,yCord};
        return point;
        
    }
    
    public double[] pxlToPt(int x, int y){
        double xPxl = (x/((double)graphWidth/xWidth)+xBounds[0]);
        double yPxl = yBounds[1] - (y/((double)graphHeight/yWidth));

        double pxl[] = {xPxl,yPxl};
        return pxl;
    }

    
    
   





    static boolean redraw = true;
    static boolean isLine = false;
    static double window[] = {-3,3,-2,2}; // {xMin,xMax,yMin,yMax}
    static String equations[] ={"","","",""};
    static double x[] = {-1,1,.02};
    static double y[] = {-1,1,.02};
    static double t[] = {-1,1,.001};
    
    public String lengthString(int length, String s){
        String newString = "";
        for(int i = 0; i < length && i < s.length(); i++){
            newString += s.charAt(i);
        }
        return newString;
    }
    
    
    
    boolean first = true;
    @Override
    public void draw(){
        
        double x[] = {-6,6}; // {xMin,xMax}
        double y[] = {-6,6}; // {yMin, yMax}
        int pxl[] = ptToPxl(1,0);
        
        setBounds(x, y);
        if (first){
            first = false;
            picture = createImage(200,200);
            Graphics2D flip = (Graphics2D) picture.getGraphics();
            flip.setTransform(new AffineTransform(matrix2));
            flip.drawImage(invertedPicture.getScaledInstance(200, 200, 1), 0, -199, observer);
            v1 = new Vector(transformGraphics);
            v2 = new Vector(transformGraphics);
        }
        
        if(redraw){
        double[] identity = {1,0,0,1,0,0};
        transformGraphics.setTransform(new AffineTransform(identity));
        transformGraphics.clearRect(0, 0,getSize().width,getSize().height);
        
        transformGraphics.drawRect(-width/2, -height/2,getSize().width,getSize().height);
        transformGraphics.drawRect(-width/2, -height/2,getSize().width,getSize().height);

        tempGraphics.setColor(Color.black);
        tempGraphics.drawRect(0,0,599,599);
        tempGraphics.setColor(Color.white);
        tempGraphics.fillRect(01, 1, 598, 598);
        int  e1[] = ptToPxl(1,0);
        int  e2[] = ptToPxl(0,1);
        AffineTransform trans = new AffineTransform(identity);        
        trans.translate(-xBounds[0]*(1/xInterval), yBounds[1]*(1/yInterval));
                transformGraphics.setTransform(trans);
        transformGraphics.setTransform(trans);
        
        
        
        
       

        
        trans.concatenate(new AffineTransform(matrix2));
        transformGraphics.setTransform(trans);
        
        trans.concatenate(new AffineTransform(matrix));

        transformGraphics.setTransform(trans);
        
        AffineTransform imageTrans = new AffineTransform(identity);
        imageTrans.translate(-100, -100);
        for(int col = -10; col <= 10; col++){
            for(int row = -10; row <= 10; row++){
                int[] pxl2 = ptToPxl(row,col);
                transformGraphics.setColor(Color.lightGray);
                transformGraphics.drawLine(pxl2[1], pxl2[0], pxl2[1], -pxl2[0]);
                transformGraphics.drawLine(pxl2[1], pxl2[0], -pxl2[1], pxl2[0]);

            }            
        }
                transformGraphics.drawImage(picture,imageTrans,observer);
                

        transformGraphics.setColor(Color.BLACK);        
        
        trans = new AffineTransform(identity);        
        trans.translate(-xBounds[0]*(1/xInterval), yBounds[1]*(1/yInterval));
                transformGraphics.setTransform(trans);
        transformGraphics.setTransform(trans);
        v1.setColor(Color.red);
        v1.setVector(matrix[0], matrix[1]);
        v1.draw(xInterval);
        v2.setColor(Color.blue);
        v2.setVector(matrix[2], matrix[3]);
        v2.draw(xInterval);
        //for(Point p: points.getAllPoints()){
        
        graphics.clearRect(0,0,getWidth(),getHeight());
        graphics.drawImage(graph, 0, 0, observer);
        graphics.drawRect(0,0,599,599);
        writeMatrix();
        redraw = false;
        }

        if(pressed){
            v1.setColor(Color.red);
            v1.setVector(matrix[0], matrix[1]);
            v1.draw(xInterval);
            v2.setColor(Color.blue);
            v2.setVector(matrix[2], matrix[3]);
            v2.draw(xInterval);
            graphics.clearRect(0,0,getWidth(),getHeight());
            graphics.drawImage(graph, 0, 0, observer);
            graphics.drawRect(0,0,599,599);
            writeMatrix();
        }
    }

    public void writeMatrix(){
        graphics.fillRect(10, 10, 10, 3);
        graphics.fillRect(10, 10, 3 , 40);
        graphics.fillRect(10, 50, 10, 3);
        graphics.drawString(lengthString(5, Double.toString(matrix[0])), 15, 25);
        graphics.drawString(lengthString(5, Double.toString(matrix[1])), 15, 45);
        graphics.drawString(lengthString(5, Double.toString(matrix[2])), 55, 25);
        graphics.drawString(lengthString(5, Double.toString(matrix[3])), 55, 45);
        graphics.fillRect(80, 10, 10, 3);
        graphics.fillRect(90, 10, 3 , 43);
        graphics.fillRect(80, 50, 10, 3);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    double[] mouseCord ={0,0};
    boolean pressed = false;
    boolean vHit[] = {false,false};
    
    @Override
     public void mousePressed(MouseEvent e) {
        pressed = true;
        System.out.println("Press");
        mouseCord = pxlToPt(e.getX(),e.getY());
       if(v1.distance(mouseCord[0], mouseCord[1]) < .2){
           System.out.println("v1");
           vHit[0] = true;
       }else if(v2.distance(mouseCord[0], mouseCord[1]) < .2){
           System.out.println("v2");
           vHit[1] = true;
       }
       
         
        
    }

    @Override
     public void mouseEntered(MouseEvent e) {
       
    }
    
    @Override
     public void mouseReleased(MouseEvent e) {
                vHit[0] = false;
                vHit[1] = false;
                redraw = true;
                pressed = false;
                repaint();
    }

    @Override
    public void keyPressed(KeyEvent e){
        

    }
    
    double finalX = -1;
    double finalY = -1;
    int dragCount =0; 
    @Override
    public void mouseDragged(MouseEvent e){
        dragCount %= 5;
        dragCount++;
        //System.out.println("Moved");
        if(pressed && dragCount == 1){
            mouse[0] = e.getX();
            mouse[1] = e.getY();
            mouseCord = pxlToPt(e.getX(),e.getY());
            if(Math.abs(mouseCord[0] - Math.round(mouseCord[0])) < .3 && (Math.round(mouseCord[0]) ==1 || 0 ==Math.round(mouseCord[0]))){
                mouseCord[0] = Math.round(mouseCord[0]);
            }
            if(Math.abs(mouseCord[1] - Math.round(mouseCord[1])) < .3 && (Math.round(mouseCord[1]) ==1 || 0 ==Math.round(mouseCord[1]))){
                mouseCord[1] = Math.round(mouseCord[1]);    
            }
            
            
            
            
            
            
            if(vHit[0]){
                matrix[0] = mouseCord[0];
                matrix[1] = mouseCord[1];
                redraw=true;
            }else if(vHit[1]){
                matrix[2] = mouseCord[0];
                matrix[3] = mouseCord[1];
                redraw=true;

            }
            repaint();
            
            
        }
        
    }


}
