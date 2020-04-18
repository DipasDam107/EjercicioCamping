package IntGrafica;

import Logica.*;
import Parametros.Param;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import static Parametros.Param.*;
import static Ficheros.Ficheros.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class mainFrame extends javax.swing.JFrame {

    Param parametros;
    Camping camp;
    ArrayList<Parcela> parcelas;
    JButton[] botonera;

    public mainFrame() {
        initComponents();
        JFrame frame=this;
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(frame, "Estas cerrando la aplicacion. ¿Estas seguro de que quieres salir?","Salir", JOptionPane.OK_CANCEL_OPTION);
        if (respuesta == JOptionPane.OK_OPTION) {
            guardarCamping(parcelas);
            System.exit(0);
        }
            }
        });
        parametros = new Param(rutaProperties);
        camp = new Camping();
        parcelas = camp.getCamping();
        botonera = new JButton[TOTAL_PARCELAS];
        for (int i = 0; i < botonera.length; i++) {
            botonera[i] = new JButton();
            if (parcelas.get(i).isOcupado()) {
                botonera[i].setBackground(Color.red);
            }
            if (parcelas.get(i) instanceof Bungalow) {
                botonera[i].setText("" + parcelas.get(i).getNumero());
                botonera[i].setIcon(new javax.swing.ImageIcon("img/bungalow.png"));
            } else if (parcelas.get(i) instanceof Caravana) {
                botonera[i].setText("" + parcelas.get(i).getNumero());
                botonera[i].setIcon(new javax.swing.ImageIcon("img/caravana.png"));
            } else {
                botonera[i].setText("" + parcelas.get(i).getNumero());
                botonera[i].setIcon(new javax.swing.ImageIcon("img/tienda.png"));
            }
            botonera[i].setVerticalTextPosition(SwingConstants.CENTER);
            botonera[i].setHorizontalTextPosition(SwingConstants.CENTER);
            botonera[i].setFont(new Font("Tahoma",Font.BOLD,20));
            botonera[i].setName("" + i);
            botonera[i].addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    FActionPerformed(evt);
                }
            });
            PanelCentral.add(botonera[i]);
        }
    }

    public void FActionPerformed(java.awt.event.MouseEvent evt) {
        int pos = Integer.valueOf(((JButton) evt.getSource()).getName());
        Parcela parcela = parcelas.get(pos);
        if (parcela.isOcupado()) {
            if (parcela instanceof Caravana && ChronoUnit.DAYS.between(parcela.getFechaOcupado(), LocalDateTime.now()) < parametros.CARAVANA_MINIMO_DIAS_ESTANCIA) {
                JOptionPane.showConfirmDialog(null, "Se debe permanecer un minimo de "+ parametros.CARAVANA_MINIMO_DIAS_ESTANCIA +" dias en la Caravana", "Error ",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            } else {
                int input = JOptionPane.showConfirmDialog(null, "¿Quieres hacer Check Out de la parcela?", "Aviso",
                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (input == JOptionPane.YES_OPTION) {
                    double importe = parcela.checkOut(parametros);
                    if(importe==-1){
                        JOptionPane.showConfirmDialog(null, "Se ha producido un error en el checkout", "Error",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                    }else{
                    JOptionPane.showConfirmDialog(null, "Se ha procedido al checkout de la parcela "+ parcela.getNumero()+". El importe asciende a " + importe + " €", "Check Out Exitoso",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (!parcela.isOcupado()) {
                            ((JButton) evt.getSource()).setBackground(Color.lightGray);
                            guardarCamping(parcelas);
                        }
                    }
                        
                }
            }
        } else {
            if (parcela instanceof Bungalow) {
                AlquilarBungalow dialog = new AlquilarBungalow(new javax.swing.JFrame(), true, parcela, parametros);
                dialog.setVisible(true);
            } else {
                AlquilarParcela dialog = new AlquilarParcela(new javax.swing.JFrame(), true, parcela);
                dialog.setVisible(true);
            }
            if (parcela.isOcupado()) {
                ((JButton) evt.getSource()).setBackground(Color.red);
                JOptionPane.showMessageDialog(this, "Se ha alquilado la parcela numero " + parcela.getNumero() + " al cliente " + parcela.getCliente().getNombre(), "Aviso",JOptionPane.INFORMATION_MESSAGE);
                guardarCamping(parcelas);
            }
        }

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
        jButton1 = new javax.swing.JButton();
        BotonAyuda = new javax.swing.JButton();
        BotonAbout = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();
        PanelSuperior = new javax.swing.JPanel();
        LabelTitulo = new javax.swing.JLabel();
        PanelCentral = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Camping");
        setMinimumSize(new java.awt.Dimension(600, 600));

        PanelInferior.setBackground(new java.awt.Color(153, 255, 204));
        PanelInferior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 7, 5));

        BotonParametros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BotonParametros.setForeground(new java.awt.Color(0, 153, 153));
        BotonParametros.setText("Edit Param");
        BotonParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonParametrosActionPerformed(evt);
            }
        });
        PanelInferior.add(BotonParametros);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 153));
        jButton1.setText("Cargar Param");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PanelInferior.add(jButton1);

        BotonAyuda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BotonAyuda.setForeground(new java.awt.Color(0, 153, 153));
        BotonAyuda.setText("Ayuda");
        BotonAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAyudaActionPerformed(evt);
            }
        });
        PanelInferior.add(BotonAyuda);

        BotonAbout.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BotonAbout.setForeground(new java.awt.Color(0, 153, 153));
        BotonAbout.setText("About");
        BotonAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAboutActionPerformed(evt);
            }
        });
        PanelInferior.add(BotonAbout);

        BotonSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BotonSalir.setForeground(new java.awt.Color(0, 153, 153));
        BotonSalir.setText("Salir");
        BotonSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonSalirMouseClicked(evt);
            }
        });
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });
        PanelInferior.add(BotonSalir);

        getContentPane().add(PanelInferior, java.awt.BorderLayout.PAGE_END);

        PanelSuperior.setBackground(new java.awt.Color(153, 255, 204));

        LabelTitulo.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(0, 153, 153));
        LabelTitulo.setText("CAMPING DE DDP");
        PanelSuperior.add(LabelTitulo);

        getContentPane().add(PanelSuperior, java.awt.BorderLayout.PAGE_START);

        PanelCentral.setBackground(new java.awt.Color(153, 255, 204));
        PanelCentral.setMinimumSize(new java.awt.Dimension(400, 400));
        PanelCentral.setPreferredSize(new java.awt.Dimension(400, 500));
        PanelCentral.setLayout(new java.awt.GridLayout(10, 8));
        getContentPane().add(PanelCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonSalirMouseClicked
        int respuesta = JOptionPane.showConfirmDialog(this, "Estas cerrando la aplicacion. ¿Estas seguro de que quieres salir?","Salir", JOptionPane.OK_CANCEL_OPTION);
        if (respuesta == JOptionPane.OK_OPTION) {
            guardarCamping(parcelas);
            System.exit(0);
        }


    }//GEN-LAST:event_BotonSalirMouseClicked

    private void BotonAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAboutActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, " Autor: Daniel Di Pasqua\n Fecha:10/04/2020\n Version: 1.0\n GitHub: https://github.com/DipasDam107/EjercicioCamping", "About",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BotonAboutActionPerformed

    private void BotonParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonParametrosActionPerformed
        Runtime rs = Runtime.getRuntime();
		try {
                        
			JOptionPane.showConfirmDialog(this, "Edita el archivo parametros.txt con los parametros deseados y luego dale a 'Cargar Param'","Parametros", JOptionPane.DEFAULT_OPTION);
                        rs.exec("notepad data\\parametros.txt");
                        
		}
		catch (IOException e) {
			System.out.println(e);
		}
    }//GEN-LAST:event_BotonParametrosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean bien=true;
        try{
        File archivo = new File(rutaProperties);
        Properties config = new Properties();
        cargarParam(parametros,config);
        if(bien)
            JOptionPane.showMessageDialog(this, " Los parametros se han cargado correctamente ", " Cargar Paranetros ",JOptionPane.INFORMATION_MESSAGE);
    
        }catch(Exception e){
            bien=false;
            JOptionPane.showConfirmDialog(null, "Se ha producido un error al cargar el archivo Param", "Error",
                        JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BotonAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAyudaActionPerformed
         JOptionPane.showMessageDialog(this, " Con este programa usted puede alquilar las parcelas de su camping. \n\nInstrucciones: \n - Las parcelas ocupadas se marcan con color rojo, mientras que las desocupadas se marcan en blanco \n - Las parcelas pueden ser Tiendas, Bungalos o Caravanas, cada una marcada con su respectiva imagen y numero\n - Para hacer Check In simplemente debe pulsar en una parcela desocupada, sea del tipo que sea, y rellenar los datos solicitados (Hay validaciones)\n - Para hacer Checkout debe pulsar en una parcela desocupada y se calculara el importe segun los dias de estadía\n - El programa utiliza parametros que se pueden editar (Edit Param), tras lo cual deberan ser cargados al programa (Cargar Param)", " Ayuda ",JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_BotonAyudaActionPerformed

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonSalirActionPerformed

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
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
