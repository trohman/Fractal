package fractals;
import java.applet.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.*;
import java.util.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Interface2 extends Applet implements MouseListener,KeyListener {

    Image offscreen;
    Image fractal;
    public static Graphics bufferGraphics;
    public static Graphics fractalGraphics;
    Dimension dim;
    public static boolean buttonPressed = false;
    public static int xpos = 0;
    public static int ypos = 0;
    public static double xInit = -2;
    public static double yInit = 1.5;
    public static double interval = .004;
    public static int power = -3;
    public static int integer = 4;


            

    public void init()
    {
        this.setSize(1300, 1300);
        dim = this.getSize();
        offscreen = createImage(dim.width,dim.height);
        fractal = createImage(dim.width,dim.height);
        bufferGraphics = offscreen.getGraphics();
        fractalGraphics = fractal.getGraphics();
        addKeyListener(this);
        addMouseListener(this);
        
    }
    public boolean redraw =true;
    @Override
    public void paint(Graphics g)
    {
       

        

        if(redraw)
        {
        drawFract(bufferGraphics);
        redraw = false;
        }

        
        g.drawImage(offscreen, 0, 0, this);
    }

    @Override
    public void update(Graphics g)
     {
          paint(g);
     }

    public void drawFract (Graphics f)
    {
        for(int real = 50; real <= 1200;real++)
        {
            for(int imaginary = 50 ; imaginary <= 800; imaginary++)
            {
                setColor(Main.fractal(((real-50)*interval + xInit), ( yInit - ((imaginary-50)*interval) )),bufferGraphics);

                

                bufferGraphics.drawLine(real, imaginary, real,imaginary);
            }

        }
        System.out.println("Calculations: " + Main.calcs);
        Main.calcs=0;
    }


    public static void setColor(int iterations, Graphics d)
    {
        if(iterations >= 50)
        {
            d.setColor(Color.BLACK);
        }
        if(iterations >= 16 && iterations < 50)
        {
            d.setColor(Color.YELLOW);
        }
        if(iterations >= 11 && iterations < 16)
        {
            d.setColor(Color.GREEN);
        }
        if(iterations == 10)
        {
            d.setColor(Color.ORANGE);
        }
        if(iterations == 9)
        {
            d.setColor(Color.RED);
        }
        if(iterations == 8)
        {
            d.setColor(Color.PINK);
        }
        if(iterations == 7)
        {
            d.setColor(Color.darkGray);
        }
        if(iterations == 6)
        {
            d.setColor(Color.MAGENTA);
        }
        if(iterations == 5)
        {
            d.setColor(Color.BLUE);
        }
        if(iterations == 4)
        {
            d.setColor(Color.CYAN);
        }if(iterations == 3)
        {
            d.setColor(Color.RED);
        }
        if(iterations <= 2)
        {
            d.setColor(Color.MAGENTA);
        }
    }


    int mouseX = 0;
    int mouseY = 0;
    boolean dragMouse;

    public void mouseClicked(MouseEvent e) {


        repaint();
    }

    public void mousePressed(MouseEvent e) {
       dragMouse = true;
       bufferGraphics.clearRect(0,0,520,50);
       bufferGraphics.setColor(Color.black);

       bufferGraphics.drawString("Real:       "+ (double)((e.getX()-50)*interval + xInit) , 85, 20);
       bufferGraphics.drawString("Imaginary:      "+ (double)(yInit - (e.getY()-50)*interval),85,35);

       repaint(0,0,520,50);
       mouseX = e.getX();
       mouseY = e.getY();


         System.out.println("Mouse Pressed"+ ((e.getX()-50)*interval + xInit)+","+(yInit - (e.getY()-50)*interval ));
         if( e.isShiftDown())
         {
             System.out.println("set point");
             xInit = (e.getX()-50)*interval + xInit;
             yInit = yInit - (e.getY()-50)*interval ;
             redraw = true;
             repaint();

       }
        
        }
       

    public void mouseReleased(MouseEvent e) {
        dragMouse = false;
        buttonPressed = false;
    }
    public void mouseDragged(MouseEvent e){
        bufferGraphics.setColor(Color.black);
       bufferGraphics.drawRect(mouseX, mouseY, e.getX()-mouseX, e.getY()-mouseY);
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
        
    }

    public void keyPressed(KeyEvent e) {
        int a = e.getKeyCode();
        System.out.println(a);
        /*
         * 61 - ( + )
         * 45 - ( - )
         * 32 - (   )
         * 57 - ( ( )
         * 48 - ( ) )
         */
        if(a == 81)
        {
            redraw = true;
            repaint();
        }


        if (a == 32 && e.isShiftDown())
        {
            xInit = -2;
            yInit = 1.5;
            interval = .004;
            redraw = true;
            repaint();
           
        }
        if( a == 61 && power >= -15)
        {
            power --;
            interval = integer * Math.pow(10, power);
            redraw = true;
            repaint();
        }
        if( a == 45 && power <= -3)
        {
            power ++;
            interval = integer * Math.pow(10, power);
            redraw = true;
            repaint();
        }
        if( a == 57 && integer < 9 )
        {
            integer  ++;
            interval = integer * Math.pow(10, power);
            redraw = true;
            repaint();
        }
        if( a == 48 && integer > 1)
        {
            integer --;
            interval = integer * Math.pow(10, power);
            redraw = true;
            repaint();
        }
        /*
        if( a == 57 && integer == 9 )
        {
            power++;
            integer = 9;
            interval = integer * Math.pow(10, power);
            repaint();
        }
        if( a == 48 && integer == 1)
        {
            power --;
            integer = 1;
            interval = integer * Math.pow(10, power);
            repaint();
        }
         * */

                              
        
    }

    public void keyReleased(KeyEvent e) {
        
    }
}

   