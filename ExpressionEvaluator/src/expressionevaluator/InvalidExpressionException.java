/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expressionevaluator;

/**
 *
 * @author Tim
 */
@SuppressWarnings("serial")
public class InvalidExpressionException extends Exception{
    
    
    public InvalidExpressionException(String message){
        super(message);
    }
}
