
package expressionevaluator;

/**
 * Expression allow other classes to convert a string representing
 *    a numeric expression to a numeric value of type double
 * 
 *  Valid arguments:
 *  sin()   ---     sin()
 *  cos()   ---     cos()
 *  tan()   ---     tan()
 *  square root     sqrt() or sqt()
 *  absolute value  abs()
 *  log base 10     log()
 *  addition        +
 *  subtraction     - or @
 *  division        /
 *  multiplication  *
 *  modulus         %
 *  exponent        ^
 * 
 * @author Tim
 */
public class Expression {
    
    String mainExpression;      // main expression being evaluated
    String operators[] = {"@","+","/","*","^","%"};
    String parenOperators[] = {"sin","cos","tan","sqt","abs","log"};
    private double x;   
    private double y;
    
    
    public Expression(String newExpression,double tempX, double tempY){
        mainExpression = newExpression;
        mainExpression = mainExpression.replaceAll("sqrt", "sqt");
        y = tempY;
        x = tempX;       
    }
    
    public double resolve() throws Exception{
        try{
            return Double.parseDouble(mainExpression);
            
        }catch(NumberFormatException e){
            if(mainExpression.equals("x") || mainExpression.equals("y") || mainExpression.equals("t")){
               mainExpression = mainExpression.replaceAll("x", Double.toString(x));
               mainExpression = mainExpression.replaceAll("y", Double.toString(y));
               mainExpression = mainExpression.replaceAll("t", Double.toString(x));
               return Double.parseDouble(mainExpression);
            }
            String saveSplit = "";
            for(String split : operators){
                if(mainExpression.contains(split)){
                    saveSplit = split;
                    break;
                }
            }
            
            if(mainExpression.contains("(")){
                //System.out.println("parens:" + mainExpression);
                char chars[] = mainExpression.toCharArray();
                int numOpens = 1;
                int finalIndex = -1;
                for(int i = mainExpression.indexOf("("); i < mainExpression.length(); i++){
                    if(chars[i] == '('){
                        numOpens ++;                        
                    }else if(chars[i] == ')'){
                        numOpens--;
                        if(numOpens == 1){
                            finalIndex = i;
                            break;
                        }
                     }
                }
                
                String subString = mainExpression.substring(mainExpression.indexOf("(")+1,finalIndex);
                Expression inParens = new Expression(subString,x,y);
                String parenOperator = "";
                for(String operator: parenOperators){
                    if(mainExpression.indexOf(operator)==mainExpression.indexOf("(")-3 && mainExpression.indexOf(operator) != -1){
                        parenOperator = operator;
                        break;
                    }
                }
                String newString;
                if(parenOperator.equals("sin")){
                    newString = mainExpression.substring(0,mainExpression.indexOf("(")-3) + Double.toString(Math.sin(inParens.resolve()))+ mainExpression.substring(finalIndex+1);
                }else if(parenOperator.equals("cos")){
                    newString = mainExpression.substring(0,mainExpression.indexOf("(")-3) + Double.toString(Math.cos(inParens.resolve()))+ mainExpression.substring(finalIndex+1);
                }else if(parenOperator.equals("tan")){
                    newString = mainExpression.substring(0,mainExpression.indexOf("(")-3) + Double.toString(Math.tan(inParens.resolve()))+ mainExpression.substring(finalIndex+1);
                }else if (parenOperator.equals("log")){
                    newString = mainExpression.substring(0,mainExpression.indexOf("(")-3) + Double.toString(Math.log(inParens.resolve()))+ mainExpression.substring(finalIndex+1);
                }else if(parenOperator.equals("sqt")){
                    double num = inParens.resolve();
                    if(num>0){                   
                        newString = mainExpression.substring(0,(mainExpression.indexOf("(")-3)) + Double.toString(Math.sqrt(inParens.resolve()))+ mainExpression.substring(finalIndex+1);
                    }else{
                        newString = "0";
                    }                  
                }else if(parenOperator.equals("abs")){
                    newString = mainExpression.substring(0,mainExpression.indexOf("(")-3) + Double.toString(Math.abs(inParens.resolve()))+ mainExpression.substring(finalIndex+1);
                }else{
                    newString = mainExpression.substring(0,mainExpression.indexOf("(")) + Double.toString(inParens.resolve())+ mainExpression.substring(finalIndex+1);
                }
                Expression newExpression = new Expression(newString,x,y);
                return newExpression.resolve();    
            }
            
            String split[];
            
            try{
                split = mainExpression.split("\\"+ saveSplit,2);
            }catch(java.util.regex.PatternSyntaxException error){
                System.out.println("error:" + mainExpression + x + "," + y);
                throw new Exception("Invalid Equation");
                
            }
            
            Expression first = new Expression(split[0],x,y);
            Expression second = new Expression(split[1],x,y);
            switch(saveSplit.charAt(0)){
                    case '^':
                        return Math.pow(first.resolve(),second.resolve());
                    case '*':
                        return first.resolve() * second.resolve();
                    case '/':
                        double numerator = first.resolve();
                        double divisor = second.resolve();
                        if(divisor != 0){
                            return numerator/divisor;
                        }else {
                            return 0;
                        }
                    case '+': 
                        return first.resolve() + second.resolve();
                    case '@': 
                        return first.resolve() - second.resolve();
                    case '%':
                        return first.resolve() - second.resolve();
            }    
            
        }
        return 0;
    }    
}