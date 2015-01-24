/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chaos;

/**
 *
 * @author Rohman
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        InterfaceFinal.main(args);
        //System.out.println(test());

        
    }
    
    @SuppressWarnings("empty-statement")
    public static double test(){
        
        int i = 0;
        final int c = 3;
        while(c != (c+Math.pow(10,i--)));
        return ++i;
    
    }

}
