/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg3ddisplay;

/**
 *
 * contains a method that multiplies two matrixes
 * 
 * @author Rohman
 */
public class MatrixOperator {


    /**
     * multiplies the two provided matrixes
     * If the dimensions of the matrixes are incompatible
     * a new matrix is returned 
     * 
     * @param matrix1 first matrix
     * @param matrix2 second matrix
     * @return the product of the matrixes
     */
    public static Matrix multiply(Matrix matrix1, Matrix matrix2){
        
        Matrix newMatrix = new Matrix();
        newMatrix.setDimension(matrix1.numRows(), matrix2.numColumns());
        
        if(matrix1.numColumns() == matrix2.numRows()){
            for(int row = 0; row < matrix1.numRows(); row++){
                for(int col = 0;  col < matrix2.numColumns();col++){
                    double sum = 0;
                    for(int element = 0; element < matrix2.numRows(); element++){
                        sum += matrix1.getElement(row, element)*matrix2.getElement(element, col);
                    }
                    newMatrix.setElement(sum,row,col);
                }
            }
            return newMatrix;

        }else{
           return new Matrix();
        }   
    }

}
