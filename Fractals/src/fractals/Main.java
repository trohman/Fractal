/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fractals;

/**
 *
 * @author ROHMANTK12
 */
public class Main {

    static double distance;
    static int counter;
    static int calcs = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }

    //       For Ai + B
    public static int fractal( double constantReal,double constantImaginary )
    {

        // For a julius set modify a and b
        double a = 0;
        double b = 0;
        double real = constantReal+a;
        double imaginary = constantImaginary+b;
        distance = 0;

        for(counter = 0; counter < 50 && distance < 2; counter ++)
        {

            double temp1 = Math.pow(real, 2) - Math.pow(imaginary,2) + constantReal;
            double temp2 = 2*real*imaginary + constantImaginary;

            real = temp1;
            imaginary = temp2;

            

            distance = Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary,2));
            calcs++;
        }


        //System.out.println("Counter: " +Integer.toString(retCounter) + "\nReal: " +Double.toString(real)+"\nImaginary: " + Double.toString(imaginary) + "\nDistance: " + Double.toString(distance) );
        return counter;
    }
}
