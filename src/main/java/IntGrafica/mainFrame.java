/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntGrafica;

/**
 *
 * @author User
 */
public class mainFrame extends javax.swing.JFrame {

    /**
     * Creates new form mainFrame
     */
    public mainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelInferior = new javax.swing.JPanel();
        BotonParametros = new javax.swing.JButton();
        BotonAyuda = new javax.swing.JButton();
        BotonAbout = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();
        PanelSuperior = new javax.swing.JPanel();
        LabelTitulo = new javax.swing.JLabel();
        PanelCentral = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelInferior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 7, 5));

        BotonParametros.setText("Parametros");
        PanelInferior.add(BotonParametros);

        BotonAyuda.setText("Ayuda");
        PanelInferior.add(BotonAyuda);

        BotonAbout.setText("About");
        PanelInferior.add(BotonAbout);

        BotonSalir.setText("Salir");
        PanelInferior.add(BotonSalir);

        getContentPane().add(PanelInferior, java.awt.BorderLayout.PAGE_END);

        LabelTitulo.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(0, 153, 153));
        LabelTitulo.setText("CAMPING DE DDP");
        PanelSuperior.add(LabelTitulo);

        getContentPane().add(PanelSuperior, java.awt.BorderLayout.PAGE_START);

        PanelCentral.setLayout(new java.awt.GridLayout(10, 8));
        getContentPane().add(PanelCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAbout;
    private javax.swing.JButton BotonAyuda;
    private javax.swing.JButton BotonParametros;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JPanel PanelCentral;
    private javax.swing.JPanel PanelInferior;
    private javax.swing.JPanel PanelSuperior;
    // End of variables declaration//GEN-END:variables
}
