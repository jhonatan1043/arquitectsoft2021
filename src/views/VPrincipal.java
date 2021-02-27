/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.ComponenteController;
import controllers.ComponenteEspecialController;
import controllers.ProyectoController;
import controllers.SubComponenteController;
import generals.ValidForm;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Programador 1
 */
public class VPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form vPrincipal
     */
    public VPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Desktop.setSize(screenSize.width, screenSize.height);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        Desktop = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemComponente = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        itemSubComponente = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        itemIniciar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ArquitectSoft");

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );

        jLayeredPane1.setLayer(Desktop, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );

        jMenu1.setText("Opciones");

        itemComponente.setText("Nuevo Componente ");
        itemComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemComponenteActionPerformed(evt);
            }
        });
        jMenu1.add(itemComponente);
        jMenu1.add(jSeparator1);

        jMenuItem1.setText("Nuevo Componente Especial");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator4);

        itemSubComponente.setText("Nuevo Subcomponentes");
        itemSubComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSubComponenteActionPerformed(evt);
            }
        });
        jMenu1.add(itemSubComponente);

        jMenuBar2.add(jMenu1);

        jMenu4.setText("Proyecto");

        itemIniciar.setText("Nuevo Proyecto");
        itemIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemIniciarActionPerformed(evt);
            }
        });
        jMenu4.add(itemIniciar);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemIniciarActionPerformed
        VProyecto viewComponente = new VProyecto();
        ProyectoController perfilComponenteCont = new ProyectoController(viewComponente, this);
        this.Desktop.add(viewComponente);
        ValidForm.centeForm(viewComponente, Desktop);
        viewComponente.show();
    }//GEN-LAST:event_itemIniciarActionPerformed

    private void itemSubComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSubComponenteActionPerformed
        VSubComponente viewSubcomponente = new VSubComponente();
        SubComponenteController subComponenteCont = new SubComponenteController(viewSubcomponente, this);
        this.Desktop.add(viewSubcomponente);
        ValidForm.centeForm(viewSubcomponente, Desktop);
        viewSubcomponente.show();
    }//GEN-LAST:event_itemSubComponenteActionPerformed

    private void itemComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemComponenteActionPerformed
        VComponente viewcomponente = new VComponente();
        ComponenteController ComponenteCont = new ComponenteController(viewcomponente, this);
        this.Desktop.add(viewcomponente);
        ValidForm.centeForm(viewcomponente, Desktop);
        viewcomponente.show();
    }//GEN-LAST:event_itemComponenteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        VComponenteEspecial viewcomponenteEspecial = new VComponenteEspecial();
        ComponenteEspecialController ComponenteCont = new ComponenteEspecialController(viewcomponenteEspecial, this);
        this.Desktop.add(viewcomponenteEspecial);
        ValidForm.centeForm(viewcomponenteEspecial, Desktop);
        viewcomponenteEspecial.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuItem itemComponente;
    public javax.swing.JMenuItem itemIniciar;
    public javax.swing.JMenuItem itemSubComponente;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
