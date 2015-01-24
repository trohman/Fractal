/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg3ddisplay;

/**
 * Rotation is performed by matrix multiplication
 * The matrix class allows for the creation of matrixes that 
 * can be used to rotate the graph
 * 
 * @author Rohman
 */
public class Matrix {
    
    double matrix[][] = new double[0][0];   // array containing all of the elements of the matrix
    int lastRow = -1;   

    /**
     * initializes a matrix and sets its dimension to a default 
     * of 2X2
     */
    public Matrix(){
        setDimension(2,2);
    }

    
    /**
     * sets the dimensions of the matrix. For all elements that exist in both matrixes,
     * the values will be copied into the new matrix
     * @param rows  new number of rows
     * @param cols  new number if columns
     */
    public final void setDimension(int rows, int cols){
        double oldMatrix[][] = matrix.clone();
        matrix = new double[rows][cols];
        for(int row = 0; row < oldMatrix.length && row < matrix.length; row++){
            for(int col = 0; col < oldMatrix[0].length && col < matrix[0].length;col++){
                matrix[row][col] = oldMatrix[row][col];
            }
        }
    }
    
    public int getLastRow(){
        return lastRow;
    }

    /**
     * get the number of rows 
     * @return the number of rows
     */
    public int numRows(){
        return matrix.length;
    }

    /**
     * get the number of columns 
     * @return the number of columns
     */
    public int numColumns(){
        return matrix[0].length;
    }

    /**
     * sets the matrix equal the size and values of a 
     * two - dimensional array 
     * 
     * Note that the array is cloned
     * 
     * @param newMatrix the new matrix
     */
    public void setMatrix(double newMatrix[][]){
        matrix = newMatrix.clone();
    }
    
    /**
     * returns the element at row row and column column
     * @param row the row
     * @param column the column
     * @return the element of the matrix
     */
    public double getElement(int row, int column){
       return matrix[row][column];
    }

    /**
     * sets the value of the element at row row and column column
     * @param row the row
     * @param column the column
     * @return the value of the element
     */
    public void setElement(double value, int row, int column){
        matrix[row][column] = value;
        
        lastRow++;
        lastRow = row;
    }
    
    /**
     * provides a readable string representation of 
     * the matrix
     * @return String representation of the matrix
     */
    @Override
    public String toString(){
        String output = "";
        
        for(int row = 0; row < matrix.length; row++){
            output += "[";
            for(int col = 0; col < matrix[0].length;col++){
                output+= matrix[row][col];
                if(col != matrix[0].length-1){
                    output+= "\t";
                }

            }output+="]\n";
        }
        return output;

    }

    /**
     * fills the matrix with the same value 
     * @param num the new value of all elements of the matrix
     */
    public void fill(double num){
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0;  col < matrix[0].length;col++){
                matrix[row][col] = num;
            }
        }

    }



}
