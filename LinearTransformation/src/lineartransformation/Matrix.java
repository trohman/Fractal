/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lineartransformation;

/**
 *
 * @author Rohman
 */
public class Matrix {
    
    double matrix[][] = new double[0][0];
    int lastRow = -1;

    public Matrix(){
        setDimension(2,2);

    }

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

    public int numRows(){
        return matrix.length;
    }

    public int numColumns(){
        return matrix[0].length;
    }

    public void setMatrix(double newMatrix[][]){
        matrix = newMatrix.clone();
    }

    public double getElement(int row, int column){
       return matrix[row][column];
    }

    public void setElement(double value, int row, int column){
        matrix[row][column] = value;
        
        lastRow++;
        lastRow = row;
    }
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

            }output+="]\n";}
        return output;

    }

    public void fill(double num){
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0;  col < matrix[0].length;col++){
                matrix[row][col] = num;
            }
        }

    }
    
    public Matrix multiply(Matrix arg){
        Matrix newMatrix = new Matrix();
        newMatrix.setDimension(arg.numRows(), this.numColumns());
        if(arg.numColumns() == this.numRows()){
            for(int row = 0; row < arg.numRows(); row++){
                for(int col = 0;  col < this.numColumns();col++){
                    double sum = 0;
                    for(int element = 0; element < this.numRows(); element++){
                        sum += arg.getElement(row, element)*this.getElement(element, col);
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
