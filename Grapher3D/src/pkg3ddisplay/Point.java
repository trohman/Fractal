/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3ddisplay;


/**
 *
 * @author Tim
 */
public class Point {
    Matrix point = new Matrix();
    
    public Point(double x, double y, double z){
        
        point.setDimension(1, 3);
        point.setElement(x, 0, 0);
        point.setElement(y, 0, 1);
        point.setElement(z, 0, 2);
    }
    
    public double[] getPoint(){
        double temp[] = {point.getElement(0, 0),point.getElement(0, 1),point.getElement(0, 2)};
        return temp;
    }
    
    public void rotate(Matrix operator, MatrixOperator m){
        point = m.multiply(point, operator);
        
                
    }
    
}
