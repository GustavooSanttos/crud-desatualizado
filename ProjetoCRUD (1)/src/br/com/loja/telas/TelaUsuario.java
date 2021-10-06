package br.com.loja.telas;

import java.sql.*;
import br.com.loja.dal.ModuloConexao;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JInternalFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

   private void consultar(){
        String sql = "SELECT * FROM usuarios WHERE iduser=?";
        try {
           pst = conexao.prepareStatement(sql);
           pst.setString(1, txtId.getText());
           rs = pst.executeQuery();
           
           if (rs.next()){
               txtNome.setText(rs.getString(2));
               txtTelefone.setText(rs.getString(3));
               txtLogin.setText(rs.getString(4));
               txtSenha.setText(rs.getString(5));
               comboPerfil.setSelectedItem(rs.getString(6));
               
           }else{
               JOptionPane.showMessageDialog(null, "Usuário não cadastrado.");
               txtNome.setText(null);
               txtTelefone.setText(null);
               txtLogin.setText(null);
               txtSenha.setText(null);
               comboPerfil.setSelectedItem(null);
               
           }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
       }
        
   }
   
   private void adicionar(){
       String sql = "INSERT INTO usuarios (iduser, usuario, fone, login, senha, perfil) VALUES (?,?,?,?,?,?)";
       try {
           pst = conexao.prepareStatement(sql);
           pst.setString(1, txtId.getText());
           pst.setString(2, txtNome.getText());
           pst.setString(3, txtTelefone.getText());
           pst.setString(4, txtLogin.getText());
           //String captura_senha = new String(txtSenha.getPassword());
           pst.setString(5,  txtSenha.getText());
           pst.setString(6, comboPerfil.getSelectedItem().toString());
           
           
           //Validação de campos obrigatórios
           if (txtId.getText().isEmpty() || txtNome.getText().isEmpty() || txtTelefone.getText().isEmpty() || 
               txtLogin.getText().isEmpty() || txtSenha.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
           
            }else{   
                int adicionado = pst.executeUpdate();

                if(adicionado>0){
                    JOptionPane.showMessageDialog(null, "Usuario Adcionado com sucesso");
                    txtId.setText(null);
                    txtNome.setText(null);
                    txtTelefone.setText(null);
                    txtLogin.setText(null);
                    txtSenha.setText(null);
                    comboPerfil.setSelectedItem(null);
                }
               
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
}
   
   private void alterar(){
       String sql = "UPDATE set usuarios usuario =?, fone=?, login=?, senha=?,"+ "perfil = perfil WHERE iduser=?";
       try {
           pst = conexao.prepareStatement(sql);
          
           pst.setString(1, txtNome.getText());
           pst.setString(2, txtTelefone.getText());
           pst.setString(3, txtLogin.getText());
           //String captura_senha = new String(txtSenha.getPassword());
           pst.setString(4,  txtSenha.getText());
           pst.setString(5, comboPerfil.getSelectedItem().toString());
           pst.setString(6, txtId.getText());
           
           //Validação de campos obrigatórios
           if (txtId.getText().isEmpty() || txtNome.getText().isEmpty() || txtTelefone.getText().isEmpty() || 
               txtLogin.getText().isEmpty() || txtSenha.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
           
            }else{   
                int adicionado = pst.executeUpdate();

                if(adicionado>0){
                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                    txtId.setText(null);
                    txtNome.setText(null);
                    txtTelefone.setText(null);
                    txtLogin.setText(null);
                    txtSenha.setText(null);
                    comboPerfil.setSelectedItem(null);
                }
               
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
}
   
   private void remover(){
       int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja remover esse usuário?","ATENÇÃO", JOptionPane.YES_NO_OPTION);
       if (confirma == JOptionPane.YES_OPTION){
           String sql = "DELETE FROM usuarios WHERE iduser=?";
           try {
               pst = conexao.prepareStatement(sql);
               pst.setString(1,txtId.getText());
               int apagado = pst.executeUpdate();
               if(apagado>0) {
                   JOptionPane.showMessageDialog(null,"Usúario removido com sucesso!");
                   txtId.setText(null);
                   txtNome.setText(null);
                   txtTelefone.setText(null);
                   txtLogin.setText(null);
                   txtSenha.setText(null);     
               }
           }catch (Exception e) {
               JOptionPane.showMessageDialog(null,e);
           }
       }
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTelefone = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNome = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtSenha = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtId = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtLogin = new javax.swing.JTextPane();
        comboPerfil = new javax.swing.JComboBox<>();
        btnAdicionar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("TELA DE USUÁRIO");

        jLabel1.setFont(new java.awt.Font("Tekton Pro Ext", 1, 11)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Tekton Pro Ext", 1, 11)); // NOI18N
        jLabel2.setText("NOME");

        jLabel3.setFont(new java.awt.Font("Tekton Pro Ext", 1, 11)); // NOI18N
        jLabel3.setText("TELEFONE");

        jLabel4.setFont(new java.awt.Font("Tekton Pro Ext", 1, 11)); // NOI18N
        jLabel4.setText("SENHA");

        jLabel5.setFont(new java.awt.Font("Tekton Pro Ext", 1, 11)); // NOI18N
        jLabel5.setText("LOGIN");

        jLabel6.setFont(new java.awt.Font("Tekton Pro Ext", 1, 11)); // NOI18N
        jLabel6.setText("PERFIL");

        jScrollPane1.setViewportView(txtTelefone);

        jScrollPane2.setViewportView(txtNome);

        jScrollPane3.setViewportView(txtSenha);

        jScrollPane4.setViewportView(txtId);

        jScrollPane5.setViewportView(txtLogin);

        comboPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icones/create.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAdicionar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icones/pesquisar.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPesquisar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icones/update.png"))); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAtualizar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icones/delete.png"))); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDeletar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(comboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        remover();
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        consultar();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
      alterar();
    }//GEN-LAST:event_btnAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> comboPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextPane txtId;
    private javax.swing.JTextPane txtLogin;
    private javax.swing.JTextPane txtNome;
    private javax.swing.JTextPane txtSenha;
    private javax.swing.JTextPane txtTelefone;
    // End of variables declaration//GEN-END:variables
}
