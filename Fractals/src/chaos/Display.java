/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chaos;

import java.applet.AppletContext;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;
import java.util.EventListener;

/**
 *
 * @author ROHMANTK12
 */
public abstract class Display extends Canvas implements KeyListener,MouseListener,MouseMotionListener,EventListener{
    
    Image screen;
    Image diagram;
    Graphics bufferGraphics;
    Graphics mathGraphics;
    Graphics2D rotateGraphics;
    int xCurser;
    int yCurser;
    static boolean updateGraphics = false;
   boolean running = true;
    int counter = 0;
    double seed = 0;
    long time;
    int oldY;
    
    ImageObserver observer;
    static int width;
    static int height;
    
    
    Font f = new Font("Ariel",Font.BOLD,30);
    
    long startTime = System.currentTimeMillis();
    short updates=0;
    



    public Display(){
        
    }



    public final void init(){
        
        
        
        
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        System.out.println("add");       
        
        
        
         
    }

    public final void initPaint(){
            width = getSize().width;
            height = getSize().height;
            screen = createImage(getSize().width,getSize().height);
            bufferGraphics = screen.getGraphics();
            diagram = createImage(getSize().width,getSize().height);
            mathGraphics = diagram.getGraphics();
            rotateGraphics = (Graphics2D)bufferGraphics;
            observer = this;            
            bufferGraphics.setFont(f);
            
    }

    

    public void update(){
        updates++;
        


        if(running){
        long start = System.currentTimeMillis();

        updates++;
        

        long period = 5;
        
        int differance = (int)(System.currentTimeMillis()-startTime) ;
        if(differance >= 100){
            
            updates = 0;
            startTime = System.currentTimeMillis();
            
        }
        

            
            
            
        long sleep = period -(System.currentTimeMillis()-start);
            if(sleep > 0){
                try{
                    Thread.sleep(sleep);
                }catch(InterruptedException e){}
            }else{
                try{
                    Thread.sleep(9);
                }catch(InterruptedException e){System.out.println("Time Out");}
            }
        }
    }
    public abstract void draw();


    
    
    @Override
    public void paint(Graphics g)
    {   //update();
        long period = 30; // normal - 7
        long start = System.currentTimeMillis();
        draw();
        g.drawImage(screen, 0, 0, this);
        bufferGraphics.clearRect(0, 0,getSize().width,getSize().height);
        
            
            long sleep = period -(System.currentTimeMillis()-start);
            if(sleep > 0){
                try{
                    Thread.sleep(sleep);
                }catch(InterruptedException e){}
            }else{
                try{
                    Thread.sleep(5);
                }catch(InterruptedException e){System.out.println("Time Out");}
            }
         //repaint();
        
        //rotateGraphics.clearRect(0, 0, 5*800, 5*600);
        

    }

    /**
     * necessary to double buffer
     * @param g 
     */
    @Override
    public void update(Graphics g)
    {
        paint(g);
    }
    
  
    /**
     * starts the GUI
     */
    public void run()
    {
        repaint();

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        
    }
    

   


   

    }


