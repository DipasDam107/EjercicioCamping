/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntGrafica;

import Logica.Parcela;
import java.time.LocalDate;
import Excepciones.*;
import static Excepciones.Comprobaciones.*;
import Logica.Cliente;
import java.time.LocalDateTime;

public class AlquilarParcela extends javax.swing.JDialog {

   
    Parcela parcela;
    
    public AlquilarParcela(java.awt.Frame parent, boolean modal, Parcela parcela) {
        super(parent, modal);
        initComponents();
        this.parcela=parcela;
        LabelSistema.setText(this.parcela.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelSuperior = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelInferior = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        BotonConfirmar = new javax.swing.JButton();
        BotonCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        LabelSistema = new javax.swing.JLabel();
        PanelCentral = new javax.swing.JPanel();
        LabelNombre = new javax.swing.JLabel();
        TextNombre = new javax.swing.JTextField();
        LabelTelefono = new javax.swing.JLabel();
        TextTelefono = new javax.swing.JTextField();
        LabelDNI = new javax.swing.JLabel();
        TextDNI = new javax.swing.JTextField();
        LabelFecha = new javax.swing.JLabel();
        TextFecha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Aharoni", 1, 24)); // NOI18N
        jLabel1.setText("Alquiler Parcela");
        PanelSuperior.add(jLabel1);

        getContentPane().add(PanelSuperior, java.awt.BorderLayout.PAGE_START);

        PanelInferior.setLayout(new java.awt.BorderLayout());

        BotonConfirmar.setText("Confirmar");
        BotonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonConfirmar);

        BotonCancelar.setText("Cancelar");
        BotonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonCancelar);

        PanelInferior.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.add(LabelSistema);

        PanelInferior.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(PanelInferior, java.awt.BorderLayout.PAGE_END);

        PanelCentral.setLayout(new java.awt.GridLayout(4, 2, 50, 10));

        LabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LabelNombre.setLabelFor(TextNombre);
        LabelNombre.setText("Nombre:");
        PanelCentral.add(LabelNombre);
        PanelCentral.add(TextNombre);

        LabelTelefono.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LabelTelefono.setLabelFor(TextTelefono);
        LabelTelefono.setText("Telefono:");
        PanelCentral.add(LabelTelefono);
        PanelCentral.add(TextTelefono);

        LabelDNI.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LabelDNI.setLabelFor(TextDNI);
        LabelDNI.setText("DNI:");
        PanelCentral.add(LabelDNI);
        PanelCentral.add(TextDNI);

        LabelFecha.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LabelFecha.setLabelFor(TextFecha);
        LabelFecha.setText("Fecha de Nacimiento:");
        PanelCentral.add(LabelFecha);

        TextFecha.setText("aaaa-mm-dd");
        TextFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFechaActionPerformed(evt);
            }
        });
        PanelCentral.add(TextFecha);

        getContentPane().add(PanelCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_BotonCancelarActionPerformed

    private void TextFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFechaActionPerformed

    private void BotonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonConfirmarActionPerformed
        String nombre="", telefono="", dni="", fecNac="";
        
        boolean correcto=true;
        try{
            nombre=TextNombre.getText();
            if(!comprobarNombre(nombre)) throw new NombreException(); 
            telefono=TextTelefono.getText();
            if(!comprobarTelefono(telefono)) throw new TelefonoException();
            dni=TextDNI.getText();
            if(!comprobarDNI(dni)) throw new DNIException();
            fecNac=TextFecha.getText();
            if(!comprobarEdad(fecNac)) throw new EdadInvalidaException();
        }catch(Exception e){
            LabelSistema.setText(e.getMessage());
            correcto=false;
        }finally{
            if(correcto){
                parcela.checkIn(new Cliente(nombre, dni, telefono, LocalDate.parse(fecNac)));
                dispose();
            }
        }
    }//GEN-LAST:event_BotonConfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(AlquilarParcela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlquilarParcela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlquilarParcela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlquilarParcela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AlquilarParcela dialog = new AlquilarParcela(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCancelar;
    private javax.swing.JButton BotonConfirmar;
    private javax.swing.JLabel LabelDNI;
    private javax.swing.JLabel LabelFecha;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelSistema;
    private javax.swing.JLabel LabelTelefono;
    private javax.swing.JPanel PanelCentral;
    private javax.swing.JPanel PanelInferior;
    private javax.swing.JPanel PanelSuperior;
    private javax.swing.JTextField TextDNI;
    private javax.swing.JTextField TextFecha;
    private javax.swing.JTextField TextNombre;
    private javax.swing.JTextField TextTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
