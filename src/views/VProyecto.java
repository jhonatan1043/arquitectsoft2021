/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

public class VProyecto extends javax.swing.JInternalFrame {
  /**
     * Creates new form VPerfilComponente
     */
    public VProyecto() {
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        btnOpenTxt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTabComponentes = new javax.swing.JTabbedPane();
        jPnPerfilMetalico = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbPerfilMetalico = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbComponente = new javax.swing.JTable();
        jPnVidrioPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbVidrioPanele = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbComponenteVidrioPanel = new javax.swing.JTable();
        jPnUnionVidrio = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbUnionVidrio = new javax.swing.JTable();
        jPnPuerta = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbPuerta = new javax.swing.JTable();
        jPnUnionPanele = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbUnionPaneles = new javax.swing.JTable();
        jPnTuboMetalico = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbTuboMetalico = new javax.swing.JTable();
        jPnMamparas = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbMampara = new javax.swing.JTable();
        btnCalcular = new javax.swing.JButton();
        pnlButton = new javax.swing.JPanel();
        btnGenerar = new javax.swing.JButton();

        setClosable(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        btnOpenTxt.setBackground(new java.awt.Color(102, 255, 102));
        btnOpenTxt.setText("...Cargar...");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(431, 431, 431)
                .addComponent(btnOpenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOpenTxt)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Proyecto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbPerfilMetalico.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbPerfilMetalico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbPerfilMetalico.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(tbPerfilMetalico);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbComponente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbComponente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdComponente", "Codigo", "Descripción", "Cantidad", "Medida", "Medida Calculada", "Se Calcula por."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbComponente.setEnabled(false);
        tbComponente.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbComponente);
        if (tbComponente.getColumnModel().getColumnCount() > 0) {
            tbComponente.getColumnModel().getColumn(0).setResizable(false);
            tbComponente.getColumnModel().getColumn(1).setResizable(false);
            tbComponente.getColumnModel().getColumn(2).setResizable(false);
            tbComponente.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbComponente.getColumnModel().getColumn(3).setResizable(false);
            tbComponente.getColumnModel().getColumn(4).setResizable(false);
            tbComponente.getColumnModel().getColumn(5).setResizable(false);
            tbComponente.getColumnModel().getColumn(5).setHeaderValue("Medida Calculada");
            tbComponente.getColumnModel().getColumn(6).setResizable(false);
            tbComponente.getColumnModel().getColumn(6).setHeaderValue("Se Calcula por.");
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPnPerfilMetalicoLayout = new javax.swing.GroupLayout(jPnPerfilMetalico);
        jPnPerfilMetalico.setLayout(jPnPerfilMetalicoLayout);
        jPnPerfilMetalicoLayout.setHorizontalGroup(
            jPnPerfilMetalicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPnPerfilMetalicoLayout.setVerticalGroup(
            jPnPerfilMetalicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnPerfilMetalicoLayout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabComponentes.addTab("PERFIL METALICO", jPnPerfilMetalico);

        tbVidrioPanele.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbVidrioPanele.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbVidrioPanele);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbComponenteVidrioPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbComponenteVidrioPanel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdComponente", "Codigo", "Descripción", "Medida", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbComponenteVidrioPanel.setEnabled(false);
        tbComponenteVidrioPanel.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbComponenteVidrioPanel);
        if (tbComponenteVidrioPanel.getColumnModel().getColumnCount() > 0) {
            tbComponenteVidrioPanel.getColumnModel().getColumn(0).setResizable(false);
            tbComponenteVidrioPanel.getColumnModel().getColumn(1).setResizable(false);
            tbComponenteVidrioPanel.getColumnModel().getColumn(2).setResizable(false);
            tbComponenteVidrioPanel.getColumnModel().getColumn(2).setPreferredWidth(300);
            tbComponenteVidrioPanel.getColumnModel().getColumn(3).setResizable(false);
            tbComponenteVidrioPanel.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPnVidrioPanelLayout = new javax.swing.GroupLayout(jPnVidrioPanel);
        jPnVidrioPanel.setLayout(jPnVidrioPanelLayout);
        jPnVidrioPanelLayout.setHorizontalGroup(
            jPnVidrioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnVidrioPanelLayout.createSequentialGroup()
                .addGroup(jPnVidrioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPnVidrioPanelLayout.setVerticalGroup(
            jPnVidrioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnVidrioPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabComponentes.addTab("VIDRIOS Y PANELES", jPnVidrioPanel);

        tbUnionVidrio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbUnionVidrio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbUnionVidrio);

        javax.swing.GroupLayout jPnUnionVidrioLayout = new javax.swing.GroupLayout(jPnUnionVidrio);
        jPnUnionVidrio.setLayout(jPnUnionVidrioLayout);
        jPnUnionVidrioLayout.setHorizontalGroup(
            jPnUnionVidrioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1042, Short.MAX_VALUE)
            .addGroup(jPnUnionVidrioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE))
        );
        jPnUnionVidrioLayout.setVerticalGroup(
            jPnUnionVidrioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
            .addGroup(jPnUnionVidrioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
        );

        jTabComponentes.addTab("UNION DE VIDRIOS", jPnUnionVidrio);

        tbPuerta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbPuerta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tbPuerta);

        javax.swing.GroupLayout jPnPuertaLayout = new javax.swing.GroupLayout(jPnPuerta);
        jPnPuerta.setLayout(jPnPuertaLayout);
        jPnPuertaLayout.setHorizontalGroup(
            jPnPuertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1042, Short.MAX_VALUE)
            .addGroup(jPnPuertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE))
        );
        jPnPuertaLayout.setVerticalGroup(
            jPnPuertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
            .addGroup(jPnPuertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
        );

        jTabComponentes.addTab("PUERTAS", jPnPuerta);

        tbUnionPaneles.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbUnionPaneles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tbUnionPaneles);

        javax.swing.GroupLayout jPnUnionPaneleLayout = new javax.swing.GroupLayout(jPnUnionPanele);
        jPnUnionPanele.setLayout(jPnUnionPaneleLayout);
        jPnUnionPaneleLayout.setHorizontalGroup(
            jPnUnionPaneleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1042, Short.MAX_VALUE)
            .addGroup(jPnUnionPaneleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE))
        );
        jPnUnionPaneleLayout.setVerticalGroup(
            jPnUnionPaneleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
            .addGroup(jPnUnionPaneleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
        );

        jTabComponentes.addTab("UNION DE PANELES", jPnUnionPanele);

        tbTuboMetalico.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbTuboMetalico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(tbTuboMetalico);

        javax.swing.GroupLayout jPnTuboMetalicoLayout = new javax.swing.GroupLayout(jPnTuboMetalico);
        jPnTuboMetalico.setLayout(jPnTuboMetalicoLayout);
        jPnTuboMetalicoLayout.setHorizontalGroup(
            jPnTuboMetalicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1042, Short.MAX_VALUE)
            .addGroup(jPnTuboMetalicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE))
        );
        jPnTuboMetalicoLayout.setVerticalGroup(
            jPnTuboMetalicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
            .addGroup(jPnTuboMetalicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
        );

        jTabComponentes.addTab("TUBOS METALICOS", jPnTuboMetalico);

        tbMampara.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbMampara.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(tbMampara);

        javax.swing.GroupLayout jPnMamparasLayout = new javax.swing.GroupLayout(jPnMamparas);
        jPnMamparas.setLayout(jPnMamparasLayout);
        jPnMamparasLayout.setHorizontalGroup(
            jPnMamparasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1042, Short.MAX_VALUE)
            .addGroup(jPnMamparasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE))
        );
        jPnMamparasLayout.setVerticalGroup(
            jPnMamparasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
            .addGroup(jPnMamparasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
        );

        jTabComponentes.addTab("MAMPARAS", jPnMamparas);

        btnCalcular.setBackground(new java.awt.Color(102, 204, 255));
        btnCalcular.setText("Calcular");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabComponentes))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCalcular))
        );

        pnlButton.setBackground(new java.awt.Color(51, 255, 51));
        pnlButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnGenerar.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnGenerar.setText("Generar");

        javax.swing.GroupLayout pnlButtonLayout = new javax.swing.GroupLayout(pnlButton);
        pnlButton.setLayout(pnlButtonLayout);
        pnlButtonLayout.setHorizontalGroup(
            pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlButtonLayout.setVerticalGroup(
            pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLayeredPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(pnlButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(465, 465, 465))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCalcular;
    public javax.swing.JButton btnGenerar;
    public javax.swing.JButton btnOpenTxt;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPnMamparas;
    public javax.swing.JPanel jPnPerfilMetalico;
    public javax.swing.JPanel jPnPuerta;
    public javax.swing.JPanel jPnTuboMetalico;
    public javax.swing.JPanel jPnUnionPanele;
    public javax.swing.JPanel jPnUnionVidrio;
    public javax.swing.JPanel jPnVidrioPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JTabbedPane jTabComponentes;
    public javax.swing.JPanel pnlButton;
    public javax.swing.JTable tbComponente;
    public javax.swing.JTable tbComponenteVidrioPanel;
    public javax.swing.JTable tbMampara;
    public javax.swing.JTable tbPerfilMetalico;
    public javax.swing.JTable tbPuerta;
    public javax.swing.JTable tbTuboMetalico;
    public javax.swing.JTable tbUnionPaneles;
    public javax.swing.JTable tbUnionVidrio;
    public javax.swing.JTable tbVidrioPanele;
    // End of variables declaration//GEN-END:variables
}
