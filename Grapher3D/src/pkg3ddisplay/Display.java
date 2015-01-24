package pkg3ddisplay;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.util.EventListener;

/**
 * Display directly inherits from Java.awt.Canvas and provides the basic framework for the main graphics environment in the program
 * 
 * 
 * @author ROHMANTK12
 */
public abstract class Display extends Canvas implements KeyListener,MouseListener,MouseMotionListener,EventListener{
    
    Image screen;       //      the axis and other stuff
    Image diagram;      //      the graph
    Graphics bufferGraphics;        // graphics for environment
    Graphics mathGraphics;      //plot point in function
    int xCurser;        // x coordinate of curser
    int yCurser;        // y coordinate pf curser
    static boolean updateGraphics = false;      // if  graph needs to be redraw, implies new function or rotation of graph  
    ImageObserver observer;     // Image observer ie this
    static int width;       //graph width
    static int height;      //graph height   
    Font f = new Font("Ariel",Font.BOLD,30);        // Font for graphics    
   
    /*
     * adds various event listeners to this
     */
    public final void init(){
        
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);        
    }

    /**
     * initializes the graphics components
     */
    public final void initPaint(){
            width = getSize().width;
            height = getSize().height;
            screen = createImage(getSize().width,getSize().height);
            bufferGraphics = screen.getGraphics();
            diagram = createImage(getSize().width,getSize().height);
            mathGraphics = diagram.getGraphics();
            observer = this;            
            bufferGraphics.setFont(f);            
    }

    

    /*
     * overridden to draw stuff
     */
    public abstract void draw();


    
    /**
     * called by GUI to repaint Display
     * @param g graphics for component
     */
    @Override
    public void paint(Graphics g)
    {   
        draw();         // all drawing by subclass done here
        g.drawImage(screen, 0, 0, this);
        bufferGraphics.clearRect(0, 0,getSize().width,getSize().height);        // clears buffered image
        
    }

    /*
     * necessary to double-buffer
     */
    @Override
    public void update(Graphics g)
    {
        paint(g);
    }
    
   /**
   * called to start the display and draw it the first time
   */
    public void run()
    {
        repaint();

    }
    
    /*
     * all abstract methods from event listeners 
     * sub classes can overide for necessary functionality
     * 
     */

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


