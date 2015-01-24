/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressionevaluator;

/**
 *
 * @author Tim
 */
public class Operator {
    
    String type;
    int prec;
    int indent;
    int operands;
    
    public Operator(String _type, int _indent) throws InvalidExpressionException{
        type = _type;
        prec = getPrecedence(type);
        indent = _indent;        
    }
    
    /**
     * returns true if "this" is of higher precedence of
     * the parameter Operator o
     * @param o Operator to be compared to
     * @return is highest precedence
     */
    public boolean isHigher(Operator o){
        if(indent > o.indent){
            return true;
        }else{
            return prec > o.prec;
        }
    }
    
    private int getPrecedence(String type)  throws InvalidExpressionException {
        
        int precedence = 0;
        
        if(type.equals("*")){
            precedence = 2;
            operands = 2;
        }else if(type.equals("/")){
            precedence = 2;
            operands = 2;            
        }else if(type.equals("+")){
            precedence = 1;
            operands = 2;
        }else if(type.equals("-")){
            precedence = 1;
            operands = 2;
        }else if(type.equals("^")){
            precedence = 3;
            operands = 2;
        }else if(type.equals("%")){
            precedence = 2;
            operands = 2;
        }else if(type.equals("sin")){
            precedence = 4;
            operands = 1;
        }else if(type.equals("cos")){
            precedence = 4;
            operands = 1;
        }else if(type.equals("tan")){
            precedence = 4;
            operands = 1;
        }else if(type.equals("ln")){
            precedence = 4;
            operands = 1;
        }else if(type.equals("log")){
            precedence = 4;
            operands = 1;
        }else if(type.equals("sqrt")){
            precedence = 4;
            operands = 1;
        }else if(type.equals("abs")){
            precedence = 4;
            operands = 1;
        }else{
            throw new InvalidExpressionException("Invalid Operator: " + type);
        }
        return precedence;
        
    }
    
    public double evaluate(double x1, double x2){
        if(type.equals("*")){
            return x1 * x2;
        }else if(type.equals("/")){
            return x1 / x2;
        }else if(type.equals("+")){
            return x1 + x2;
        }else if(type.equals("-")){
            return x1 - x2;
        }else if(type.equals("^")){
            return Math.pow(x1, x2);
        }else if(type.equals("%")){
            return x1 % x2;
        }else{
            return Double.NaN;
        }
    }
    
    public double evaluate(double x1){
        if(type.equals("sin")){
            return Math.sin(x1);
        }else if(type.equals("cos")){
           return Math.cos(x1);
        }else if(type.equals("tan")){
            return Math.tan(x1);
        }else if(type.equals("ln")){
            return Math.log(x1);
        }else if(type.equals("log")){
            return Math.log(x1)/Math.log(10);
        }else if(type.equals("sqrt")){
            return Math.sqrt(x1);
        }else if(type.equals("abs")){
           return Math.abs(x1);
        }
        return Double.NaN;
    }
    
    public String toString(){
        return type;
    }
}
