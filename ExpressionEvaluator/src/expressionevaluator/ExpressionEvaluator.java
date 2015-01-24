/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressionevaluator;

/**
 *
 * @author Tim
 */
public class ExpressionEvaluator {

    String basic[] = {"*","/","=","-"};
    Stack<Double> numbers = new Stack<Double>();
    Stack<Operator> operators = new Stack<Operator>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        String exp = "2+3*7";
        Expression exx = new Expression(exp,0,0);
        System.out.println(exp);
        //exp = exp.replaceAll("[0-9a-zA-z]+", " $0 ");
        //exp = exp.replaceAll("[()]", " $0 ");
        //System.out.println(exp);
        ExpressionEvaluator e = new ExpressionEvaluator();
        try {
            System.out.println(exx.resolve());
            System.out.println(e.evaluate(exp));
        } catch (InvalidExpressionException ex) {
            ex.printStackTrace();
        }catch(Exception eee){
            eee.printStackTrace();
        }
    }
    
    public double evaluate(String expression) throws InvalidExpressionException{
        expression = expression.replaceAll("[0-9a-zA-z]+", " $0 ");
        expression = expression.replaceAll("[()]", " $0 ");
        //System.out.println(expression);
        
        String terms[] = expression.split("[ \n\t]+");
        int precedence = 0;
        for(String s : terms){
            System.out.println(s + " : " + numbers.toString() + " : " + operators.toString());
            
            
            if(s.matches("[0-9]+")){
                numbers.push(Double.parseDouble(s));
            }else if(s.equalsIgnoreCase("(")){
                precedence++;
            }else if(s.equalsIgnoreCase(")")){
                precedence--;
            }else if(s.matches("[ \t\n]*")){
                
            }else{
                try{
                    Operator o = new Operator(s,precedence);
                    if(operators.peek() != null && operators.peek().isHigher(o)){
                        exOperator(operators.pop());
                        operators.push(o);
                    }else{
                        operators.push(o);
                    }
                }catch(InvalidExpressionException e){
                    e.printStackTrace();
                }catch(StackEmptyException e){
                    e.printStackTrace();
                }
            }
            
        }
        while(operators.numberOfEntries()>0){
            
            try {
                System.out.println(operators.peek().type + " : " + numbers.toString() + " : " + operators.toString());
                exOperator(operators.pop());
            } catch (StackEmptyException ex) {
            }
        }
        try {
            return numbers.pop();
        } catch (StackEmptyException ex) {
            return Double.NaN;
        }
    }
    
    public void exOperator(Operator o) throws StackEmptyException{
        if(o.operands == 1){
            numbers.push(o.evaluate(numbers.pop()));
        }else{
            numbers.push(o.evaluate(numbers.pop(), numbers.pop()));
        }
            
    }
    
    public String insertWhiteSpace(String exp){
        for(int i = 0; i < 10; i++){
            exp = exp.replaceAll("^[0-9]2", " " + 2);
        }
        
        return exp;
    }    
}
