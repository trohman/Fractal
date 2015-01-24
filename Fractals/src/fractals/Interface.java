package fractals;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseMotionAdapter;
import java.io.*;
import java.util.*;

public class Interface extends Applet implements MouseListener {

    Image offscreen;
    public static Graphics bufferGraphics;
    Dimension dim;
    public static boolean buttonPressed = false;
    public static int xpos = 0;
    public static int ypos = 0;

    public void init()
    {
        this.setSize(1300, 1300);
        dim = this.getSize();
        offscreen = createImage(dim.width,dim.height);
        bufferGraphics = offscreen.getGraphics();
        addMouseListener(this);
        
    }

    public void paint(Graphics g)
    {
        g.drawImage(offscreen,0,0,this);
        drawFract(bufferGraphics);
        g.drawImage(offscreen, 0, 0, this);
    }

    public void update(Graphics g)
     {
          paint(g);
     }

    public void drawFract (Graphics f)
    {
        // 101+x _______ 101 - Y
        for(double real =-2.1; real <= 1.5; real += .0050000000)
        {
            real = Math.rint(real*1000)/1000;
            for(double imaginary =-1.2; imaginary <= 1.2; imaginary += .00500000000)
        {
          imaginary=Math.rint(imaginary*1000)/1000;
          int space = 1;
          f.drawOval((int)Math.rint((500+200*real)*space), (int)Math.rint((300+200*imaginary)*space), 0, 0);
          setColor(Main.fractal(real, imaginary),bufferGraphics);
          }}}


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
        if(iterations == 2)
        {
            d.setColor(Color.MAGENTA);
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
       buttonPressed = true;
       xpos = e.getX();
       ypos = e.getY();
       Interface.bufferGraphics.setColor(Color.black);
       System.out.println(xpos);
       Interface.bufferGraphics.clearRect(0,0,520,50);
       Interface.bufferGraphics.drawString("Real:       "+ (double)(xpos-500)/200 , 85, 20);
       Interface.bufferGraphics.drawString("Imaginary:      "+ (double)(300-ypos)/200,85,35);
       repaint(0,0,520,50);
       }

    public void mouseReleased(MouseEvent e) {
        buttonPressed = false;       
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}