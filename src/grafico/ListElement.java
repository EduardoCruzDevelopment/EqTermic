
package grafico;

import database.ElementsDao;
import entidades.Elemento;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListElement extends javax.swing.JFrame {

    public List<Elemento> lista = new ArrayList();
    
    public ListElement() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("livropreto.png")));
        this.setLocationRelativeTo(null);
        amont("todos");
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtTermo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Elementos");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        txtTermo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTermo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTermoKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Pesquisar");

        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Pressione Del para excluir um registro.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 421, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTermo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTermoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTermoKeyPressed
        amont("termo");
    }//GEN-LAST:event_txtTermoKeyPressed

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        if(evt.getKeyCode() == 127 || evt.getKeyCode() == 110){
            
            try{
                
                System.out.println("Deletar item");
                
                Elemento el = lista.get(table.getSelectedRow());
                
                int r  =  JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro?","InternalSystem", JOptionPane.YES_NO_OPTION);    
            
                if (r == JOptionPane.YES_OPTION) {
                    
                    System.out.println("Deleção confirmada");
                    ElementsDao ed = new ElementsDao();
                    ed.deletar(el.getId());
                    System.out.println("Excluido com sucesso!");
                    JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!","InternalSystem",JOptionPane.INFORMATION_MESSAGE);
                    amont("todos");

                }else{
                    System.out.println("Abortado");
                }
                
            }catch(ArrayIndexOutOfBoundsException e){
                
                System.out.println("Nenhum item selecionado! - "+e.getMessage());
                JOptionPane.showMessageDialog(null, "Nenhum item selecionado! ","InternalSystem",JOptionPane.ERROR_MESSAGE);
                
            }catch(SQLException esql){
                
                System.out.println("Erro no BD! - "+esql.getMessage());
                JOptionPane.showMessageDialog(null, "Erro de conexão com o banco de dados!","InternalSystem",JOptionPane.ERROR_MESSAGE);
         
            }
            
        }
        
    }//GEN-LAST:event_tableKeyPressed

  
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
            java.util.logging.Logger.getLogger(ListElement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListElement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListElement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListElement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListElement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtTermo;
    // End of variables declaration//GEN-END:variables
public void amont(String tipo){

    ElementsDao dao = new ElementsDao();
    try {
        if(tipo.equals("todos")){
            System.out.println("Atualizando...");
            lista = dao.listar();
            
        }else if(tipo.equals("termo")){
            System.out.println("Pesquisando...");                
            lista = dao.pesquisar(txtTermo.getText());

        }
        
    } catch (SQLException ex) {
        System.out.println("Erro de busca!");
        System.out.println(ex.getMessage());
        JOptionPane.showMessageDialog(null, "Erro de busca!","InternalSystem",JOptionPane.ERROR_MESSAGE);
    }
    
    DefaultTableModel modelo = new DefaultTableModel();
        
    modelo.addColumn("Nome");
    modelo.addColumn("Calor específico estado Solido (cal/g°C)");
    modelo.addColumn("Calor específico estado Liquido (cal/g°C)");
    modelo.addColumn("Calor específico estado Gasoso (cal/g°C)");
    modelo.addColumn("Calor latente de Fusão (cal/g)");
    modelo.addColumn("Calor latente de Vaporização (cal/g)");
    modelo.addColumn("Temperatura de Fusão (°C)");
    modelo.addColumn("Temperatura de Vaporização (°C)");
        
        for (Elemento e : lista) {
            modelo.addRow(new Object[]{
                e.getNome(),
                e.getcSolido(),
                e.getcLiquido(),
                e.getcGasoso(),
                e.getlFusao(),
                e.getlVapor(),
                e.getTempF(),
                e.getTempV()
            });
        }
        
    table.setModel(modelo);


}

}
