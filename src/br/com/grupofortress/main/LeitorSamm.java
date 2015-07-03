package br.com.grupofortress.main;

import br.com.grupofortress.controller.Universal;
import br.com.grupofortress.dao.LeitorDao;
import br.com.grupofortress.model.Evento;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author informatica
 */
public class LeitorSamm extends javax.swing.JFrame {

    private DefaultTableModel tabelaEventos;

    public LeitorSamm() {
        initComponents();
        setLocationRelativeTo(null);
        verificaEventosBD();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEventosRecebidos = new javax.swing.JTable();
        jmMenuPrincipal = new javax.swing.JMenuBar();
        mArquivo = new javax.swing.JMenu();
        mSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpPrincipal.setBackground(new java.awt.Color(51, 51, 51));

        tbEventosRecebidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Data", "Hora", "Conta/Grupo da Receptora", "Codigo do Cliente", "Protocolo", "Evento", "Partição", "Usuário/zona"
            }
        ));
        jScrollPane1.setViewportView(tbEventosRecebidos);

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        mArquivo.setText("Arquivo");

        mSair.setText("Sair");
        mSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSairActionPerformed(evt);
            }
        });
        mArquivo.add(mSair);

        jmMenuPrincipal.add(mArquivo);

        setJMenuBar(jmMenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mSairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar jmMenuPrincipal;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JMenu mArquivo;
    private javax.swing.JMenuItem mSair;
    private javax.swing.JTable tbEventosRecebidos;
    // End of variables declaration//GEN-END:variables

    public void verificaEventosBD() {
        tabelaEventos = (DefaultTableModel) tbEventosRecebidos.getModel();
        //Evento evento = new Evento();
        LeitorDao leitorDao = new LeitorDao();

        for (Evento evento : leitorDao.getEventosRecebidos()) {
            tabelaEventos.addRow(new Object[]{Universal.getInstance().calendarToString(evento.getEve_data_hora()), evento.getEve_hora(), evento.getEve_conta_grupo_receptor(), evento.getEve_codigo_cliente(), evento.getEve_protocolo(), evento.getEve_codigo_evento(),
                evento.getEve_particao(), evento.getEve_usuario_zona()});
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeitorSamm().setVisible(true);
            }
        });
    }

}
