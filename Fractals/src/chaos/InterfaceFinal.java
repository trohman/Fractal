package chaos;

import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author Rohman
 */
public class InterfaceFinal extends javax.swing.JFrame {

    /** Creates new form Interface */
    public InterfaceFinal() {
        this.setTitle("Orbit Diagrams");
        initComponents();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        display = new Graph(1501,1001);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        setBackground(Color.WHITE);
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.white);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(display, javax.swing.GroupLayout.DEFAULT_SIZE, 1501, Short.MAX_VALUE) //width = 1501
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(display, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)  // height = 1001
        );

        pack();
    }// </editor-fold>

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new InterfaceFinal().setVisible(true);
                    display.initPaint();
                    display.init();
                    display.run();

                
            }
        });
    }


    public Dimension getScreenSize(){
        return getSize();
    }

    // Variables declaration - do not modify
     static Graph display;
    // End of variables declaration

}
