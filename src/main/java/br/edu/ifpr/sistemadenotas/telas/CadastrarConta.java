/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.ifpr.sistemadenotas.telas;

import br.edu.ifpr.sistemadenotas.estilizacao.CpfUtils;
import br.edu.ifpr.sistemadenotas.modelo.AuxiliarAdministrativo;
import br.edu.ifpr.sistemadenotas.operacoes.OperacoesNotas;
import javax.swing.JOptionPane;

/**
 *
 * @author Lukinhas
 */
public class CadastrarConta extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarConta
     */
    public CadastrarConta() {
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

        lblImagemCadastro = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtSenha = new javax.swing.JTextField();
        lblImagemTelaCompleta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar Conta");
        setMinimumSize(new java.awt.Dimension(516, 440));
        setResizable(false);
        getContentPane().setLayout(null);

        lblImagemCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadastrotop.png"))); // NOI18N
        getContentPane().add(lblImagemCadastro);
        lblImagemCadastro.setBounds(50, 30, 110, 90);

        lblCpf.setText("CPF:");
        getContentPane().add(lblCpf);
        lblCpf.setBounds(30, 120, 102, 16);

        lblEmail.setText("Email:");
        getContentPane().add(lblEmail);
        lblEmail.setBounds(30, 180, 124, 16);

        lblSenha.setText("Senha:");
        getContentPane().add(lblSenha);
        lblSenha.setBounds(30, 240, 148, 16);

        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });
        getContentPane().add(txtCpf);
        txtCpf.setBounds(30, 140, 140, 22);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(30, 200, 140, 22);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(340, 320, 96, 23);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formatarCpf(txtCpf);
            }
        });

        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(220, 320, 103, 23);

        getContentPane().add(txtSenha);
        txtSenha.setBounds(30, 260, 140, 22);

        lblImagemTelaCompleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/[500, 400](4).png"))); // NOI18N
        getContentPane().add(lblImagemTelaCompleta);
        lblImagemTelaCompleta.setBounds(0, 0, 500, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formatarCpf(javax.swing.JTextField campoCpf) {
        String cpf = CpfUtils.formatarCpf(campoCpf.getText()); // Usa o método da classe CpfUtils
        campoCpf.setText(cpf);
    }

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.dispose(); // Fecha a tela de cadastro

        // Abre a tela de login
        Login telaLogin = new Login(); // Supondo que a classe de login se chama Login
        telaLogin.setVisible(true); // Torna a tela de login visível

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

        // Captura os dados da interface gráfica
        String cpf = txtCpf.getText();
        String email = txtEmail.getText();
        String senha = new String(txtSenha.getText());

        // Cria um objeto AuxiliarAdministrativo para armazenar os dados
        AuxiliarAdministrativo auxiliar = new AuxiliarAdministrativo();
        auxiliar.setCpf(cpf);
        auxiliar.setSenha(senha);

        // Insere os dados no banco usando o método inserção
        try {
            OperacoesNotas.inserirAuxiliarAdministrativo(auxiliar);
            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
            this.dispose(); // Fecha a tela de cadastro após o sucesso
            // Abre a tela de login
            Login telaLogin = new Login(); // Supondo que a classe de login se chama Login
            telaLogin.setVisible(true); // Torna a tela de login visível
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário: " + e.getMessage());
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblImagemCadastro;
    private javax.swing.JLabel lblImagemTelaCompleta;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
