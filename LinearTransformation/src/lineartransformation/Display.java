/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lineartransformation;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.util.EventListener;

/**
 *
 * @author ROHMANTK12
 */
public abstract class Display extends Canvas implements KeyListener,MouseListener,MouseMotionListener,EventListener{
    
    Image graph;
    Image image;
    Graphics2D transformGraphics;
    Graphics tempGraphics;
    Graphics graphics;
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
            graph = createImage(getSize().width,getSize().height);
            tempGraphics = graph.getGraphics();
            image = createImage(getSize().width,getSize().height);
            graphics =  image.getGraphics();
            

            observer = this; 
            transformGraphics = (Graphics2D) tempGraphics;
            
    }

    

    
    public abstract void draw();


    
    
    @Override
    public void paint(Graphics g)
    {   //update();
        
        
        
        
        draw();
        //g.clearRect(0, 0, width, height);
        g.drawImage(image, 0, 0, this);
        
            
            
        
        //rotateGraphics.clearRect(0, 0, 5*800, 5*600);
        

    }

    @Override
    public void update(Graphics g)
    {
        paint(g);
    }
    
  
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

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    

   


   

    }


