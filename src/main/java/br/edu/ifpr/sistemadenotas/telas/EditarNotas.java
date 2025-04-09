/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.ifpr.sistemadenotas.telas;

import br.edu.ifpr.sistemadenotas.estilizacao.CpfUtils;
import br.edu.ifpr.sistemadenotas.modelo.Notas;
import br.edu.ifpr.sistemadenotas.operacoes.OperacoesNotas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author Lukinhas
 */
public class EditarNotas extends javax.swing.JFrame {

    private TabelaNotas tabelaNotas; // Atributo para armazenar a referência da tabela
    private Notas nota; // Atributo para armazenar a nota a ser editada

    private JLabel lblNome;
    private JTextField txtNome;
    private JLabel lblNota;
    private JTextField txtNota;
    private JButton btnSalvar;
    private JButton btnCancelar;

    /**
     * Creates new form EditarNotas
     */
    public EditarNotas(Notas nota) {
        initComponents();
        this.nota = nota; // Inicializa a nota a ser editada
        this.tabelaNotas = tabelaNotas; // Armazena a referência da tabela
        preencherCampos(); // Preenche os campos com os dados da nota

        // Adicionando o KeyListener para formatação instantânea
        txtCpfComprador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String cpfComprador = txtCpfComprador.getText();
                txtCpfComprador.setText(CpfUtils.formatarCpf(cpfComprador));
            }
        });

        txtCpfVendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String cpfVendedor = txtCpfVendedor.getText();
                txtCpfVendedor.setText(CpfUtils.formatarCpf(cpfVendedor));
            }
        });

        txtCpfConjuge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String cpfConjuge = txtCpfConjuge.getText();
                txtCpfConjuge.setText(CpfUtils.formatarCpf(cpfConjuge));
            }
        });

        // Adicionando ActionListeners para controle de visibilidade
        btnSolteiro.addActionListener(evt -> atualizarVisibilidadeConjuge());
        btnViuvo.addActionListener(evt -> atualizarVisibilidadeConjuge());
        btnCasado.addActionListener(evt -> atualizarVisibilidadeConjuge());

        btnVendaEstado.addActionListener(evt -> atualizarVisibilidadeIcms());
        btnVendaForaEstado.addActionListener(evt -> atualizarVisibilidadeIcms());

        btnProprietario.addActionListener(evt -> atualizarVisibilidadePorcentagem());
        btnArrendatario.addActionListener(evt -> atualizarVisibilidadePorcentagem());
        btnParceiro.addActionListener(evt -> atualizarVisibilidadePorcentagem());

        // Chama os métodos de visibilidade para definir o estado inicial
        atualizarVisibilidadeConjuge();
        atualizarVisibilidadeIcms();
        atualizarVisibilidadePorcentagem();
    }

    public EditarNotas(Notas nota, TabelaNotas tabelaNotas) {
        initComponents();
        this.nota = nota; // Inicializa a nota a ser editada
        this.tabelaNotas = tabelaNotas; // Armazena a referência da tabela
        preencherCampos(); // Preenche os campos com os dados da nota

        // Adicionando o KeyListener para formatação instantânea
        txtCpfComprador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String cpfComprador = txtCpfComprador.getText();
                txtCpfComprador.setText(CpfUtils.formatarCpf(cpfComprador));
            }
        });

        txtCpfVendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String cpfVendedor = txtCpfVendedor.getText();
                txtCpfVendedor.setText(CpfUtils.formatarCpf(cpfVendedor));
            }
        });

        txtCpfConjuge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String cpfConjuge = txtCpfConjuge.getText();
                txtCpfConjuge.setText(CpfUtils.formatarCpf(cpfConjuge));
            }
        });

        // Adicionando ActionListeners para controle de visibilidade
        btnSolteiro.addActionListener(evt -> atualizarVisibilidadeConjuge());
        btnViuvo.addActionListener(evt -> atualizarVisibilidadeConjuge());
        btnCasado.addActionListener(evt -> atualizarVisibilidadeConjuge());

        btnVendaEstado.addActionListener(evt -> atualizarVisibilidadeIcms());
        btnVendaForaEstado.addActionListener(evt -> atualizarVisibilidadeIcms());

        btnProprietario.addActionListener(evt -> atualizarVisibilidadePorcentagem());
        btnArrendatario.addActionListener(evt -> atualizarVisibilidadePorcentagem());
        btnParceiro.addActionListener(evt -> atualizarVisibilidadePorcentagem());

        // Chama os métodos de visibilidade para definir o estado inicial
        atualizarVisibilidadeConjuge();
        atualizarVisibilidadeIcms();
        atualizarVisibilidadePorcentagem();
    }

    private void preencherCampos() {
        // Preenche os campos com os dados da nota
        txtNomeVendedor.setText(nota.getNomeVendedor());
        txtCpfVendedor.setText(nota.getCpfVendedor());
        txtNomePropriedadeVendedor.setText(nota.getNomePropriedadeVendedor());
        txtEnderecoVendedor.setText(nota.getEnderecoVendedor());
        txtIncra.setText(nota.getIncra());
        txtCpfComprador.setText(nota.getCpfComprador());
        txtNomeComprador.setText(nota.getNomeComprador());
        txtNomePropriedadeComprador.setText(nota.getNomePropriedadeComprador());
        txtEnderecoComprador.setText(nota.getEnderecoComprador());
        txtPorcentagem.setText(String.valueOf(nota.getPorcentagem()));
        txtValorIcms.setText(String.valueOf(nota.getValorIcms()));
        txtEstado.setText(nota.getEstado());
        txtCpfConjuge.setText(nota.getCpfConjuge());

        // Definindo o estado civil
        String estadoCivil = nota.getEstadoCivil().trim(); // Remove espaços em branco
        if (estadoCivil.equalsIgnoreCase("Solteiro")) {
            btnSolteiro.setSelected(true);
        } else if (estadoCivil.equalsIgnoreCase("Casado")) {
            btnCasado.setSelected(true);
        } else if (estadoCivil.equalsIgnoreCase("Viúvo")) { // Corrigido para "Viúvo"
            btnViuvo.setSelected(true);
        }

        // Definindo o tipo de posse
        if (nota.getTipoDePosse().equals("Proprietário")) {
            btnProprietario.setSelected(true);
        } else if (nota.getTipoDePosse().equals("Arrendatário")) {
            btnArrendatario.setSelected(true);
        } else if (nota.getTipoDePosse().equals("Parceiro")) {
            btnParceiro.setSelected(true);
        }

        // Definindo o estado da venda
        if (nota.getEstadoDestino().equals("VendaEstado")) {
            btnVendaEstado.setSelected(true);
        } else if (nota.getEstadoDestino().equals("VendaForaEstado")) {
            btnVendaForaEstado.setSelected(true);
        }
    }

    private void atualizarVisibilidadeConjuge() {
        boolean mostrarConjuge = btnCasado.isSelected();
        lblConjuge.setVisible(mostrarConjuge);
        lblCpfConjuge.setVisible(mostrarConjuge);
        txtCpfConjuge.setVisible(mostrarConjuge);
    }

    private void atualizarVisibilidadeIcms() {
        boolean vendaParaEstado = btnVendaEstado.isSelected();
        lblEstado.setVisible(!vendaParaEstado);
        txtEstado.setVisible(!vendaParaEstado);
        lblValorIcms.setVisible(!vendaParaEstado);
        txtValorIcms.setVisible(!vendaParaEstado);
    }

    private void atualizarVisibilidadePorcentagem() {
        boolean mostrarPorcentagem = btnArrendatario.isSelected() || btnParceiro.isSelected();
        lblPorcentagem.setVisible(mostrarPorcentagem);
        txtPorcentagem.setVisible(mostrarPorcentagem);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupoDeTiposPosse = new javax.swing.ButtonGroup();
        jTextField4 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        btnGrupoEstadoCivil = new javax.swing.ButtonGroup();
        jSpinner1 = new javax.swing.JSpinner();
        btnGrupoTipoVenda = new javax.swing.ButtonGroup();
        btnProprietario = new javax.swing.JRadioButton();
        btnArrendatario = new javax.swing.JRadioButton();
        btnParceiro = new javax.swing.JRadioButton();
        lblPorcentagem = new javax.swing.JLabel();
        txtPorcentagem = new javax.swing.JTextField();
        lblVendedor = new javax.swing.JLabel();
        lblNomeVendedor = new javax.swing.JLabel();
        lblCpfVendedor = new javax.swing.JLabel();
        lblNomeDaPropriedadeVendedor = new javax.swing.JLabel();
        lblEnderecoVendedor = new javax.swing.JLabel();
        lblIncra = new javax.swing.JLabel();
        txtNomeVendedor = new javax.swing.JTextField();
        txtCpfVendedor = new javax.swing.JTextField();
        txtNomePropriedadeVendedor = new javax.swing.JTextField();
        txtEnderecoVendedor = new javax.swing.JTextField();
        txtIncra = new javax.swing.JTextField();
        btnCasado = new javax.swing.JRadioButton();
        btnSolteiro = new javax.swing.JRadioButton();
        btnViuvo = new javax.swing.JRadioButton();
        lblConjuge = new javax.swing.JLabel();
        lblCpfConjuge = new javax.swing.JLabel();
        txtCpfConjuge = new javax.swing.JTextField();
        lblIcms = new javax.swing.JLabel();
        btnVendaEstado = new javax.swing.JRadioButton();
        btnVendaForaEstado = new javax.swing.JRadioButton();
        lblEstado = new javax.swing.JLabel();
        lblValorIcms = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        txtValorIcms = new javax.swing.JTextField();
        lblComprador = new javax.swing.JLabel();
        lblNomeDaPropriedadeComprador = new javax.swing.JLabel();
        lblEnderecoComprador = new javax.swing.JLabel();
        txtNomeComprador = new javax.swing.JTextField();
        txtCpfComprador = new javax.swing.JTextField();
        txtNomePropriedadeComprador = new javax.swing.JTextField();
        txtEnderecoComprador = new javax.swing.JTextField();
        lblNomeComprador = new javax.swing.JLabel();
        lblCpfComprador = new javax.swing.JLabel();
        btnCancelarCadastro = new javax.swing.JButton();
        btnSalvarCadastro = new javax.swing.JButton();
        imgCadastro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Nota");
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        btnGrupoDeTiposPosse.add(btnProprietario);
        btnProprietario.setText("Proprietário");
        btnProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProprietarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnProprietario);
        btnProprietario.setBounds(30, 70, 100, 20);

        btnGrupoDeTiposPosse.add(btnArrendatario);
        btnArrendatario.setText("Arrendatário");
        btnArrendatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArrendatarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnArrendatario);
        btnArrendatario.setBounds(142, 70, 100, 21);

        btnGrupoDeTiposPosse.add(btnParceiro);
        btnParceiro.setText("Parceiro");
        getContentPane().add(btnParceiro);
        btnParceiro.setBounds(243, 70, 80, 21);

        lblPorcentagem.setText("Porcentagem:");
        getContentPane().add(lblPorcentagem);
        lblPorcentagem.setBounds(154, 100, 90, 16);
        getContentPane().add(txtPorcentagem);
        txtPorcentagem.setBounds(251, 97, 70, 22);

        lblVendedor.setText("Vendedor:");
        getContentPane().add(lblVendedor);
        lblVendedor.setBounds(22, 124, 80, 16);

        lblNomeVendedor.setText("Nome:");
        getContentPane().add(lblNomeVendedor);
        lblNomeVendedor.setBounds(32, 146, 50, 16);

        lblCpfVendedor.setText("CPF:");
        getContentPane().add(lblCpfVendedor);
        lblCpfVendedor.setBounds(31, 174, 37, 16);

        lblNomeDaPropriedadeVendedor.setText("Nome da Propriedade:");
        getContentPane().add(lblNomeDaPropriedadeVendedor);
        lblNomeDaPropriedadeVendedor.setBounds(31, 202, 170, 16);

        lblEnderecoVendedor.setText("Endereço:");
        getContentPane().add(lblEnderecoVendedor);
        lblEnderecoVendedor.setBounds(31, 230, 70, 16);

        lblIncra.setText("Incra:");
        getContentPane().add(lblIncra);
        lblIncra.setBounds(31, 258, 40, 16);
        getContentPane().add(txtNomeVendedor);
        txtNomeVendedor.setBounds(74, 146, 227, 22);
        getContentPane().add(txtCpfVendedor);
        txtCpfVendedor.setBounds(74, 174, 227, 22);
        getContentPane().add(txtNomePropriedadeVendedor);
        txtNomePropriedadeVendedor.setBounds(161, 202, 140, 22);
        getContentPane().add(txtEnderecoVendedor);
        txtEnderecoVendedor.setBounds(91, 230, 210, 22);
        getContentPane().add(txtIncra);
        txtIncra.setBounds(74, 258, 227, 22);

        btnGrupoEstadoCivil.add(btnCasado);
        btnCasado.setText("Casado");
        getContentPane().add(btnCasado);
        btnCasado.setBounds(31, 292, 70, 21);

        btnGrupoEstadoCivil.add(btnSolteiro);
        btnSolteiro.setText("Solteiro");
        getContentPane().add(btnSolteiro);
        btnSolteiro.setBounds(111, 292, 80, 21);

        btnGrupoEstadoCivil.add(btnViuvo);
        btnViuvo.setText("Viuvo");
        getContentPane().add(btnViuvo);
        btnViuvo.setBounds(192, 292, 60, 21);

        lblConjuge.setText("Dados do Cônjuge:");
        getContentPane().add(lblConjuge);
        lblConjuge.setBounds(22, 325, 120, 16);

        lblCpfConjuge.setText("CPF:");
        getContentPane().add(lblCpfConjuge);
        lblCpfConjuge.setBounds(33, 359, 40, 16);
        getContentPane().add(txtCpfConjuge);
        txtCpfConjuge.setBounds(81, 359, 220, 22);

        lblIcms.setText("Dados do ICMS:");
        getContentPane().add(lblIcms);
        lblIcms.setBounds(22, 387, 110, 16);

        btnGrupoTipoVenda.add(btnVendaEstado);
        btnVendaEstado.setText("Venda para o Estado");
        getContentPane().add(btnVendaEstado);
        btnVendaEstado.setBounds(35, 416, 150, 21);

        btnGrupoTipoVenda.add(btnVendaForaEstado);
        btnVendaForaEstado.setText("Venda para fora do Estado");
        getContentPane().add(btnVendaForaEstado);
        btnVendaForaEstado.setBounds(193, 416, 180, 21);

        lblEstado.setText("Estado:");
        getContentPane().add(lblEstado);
        lblEstado.setBounds(35, 455, 50, 16);

        lblValorIcms.setText("Valor do ICMS:");
        getContentPane().add(lblValorIcms);
        lblValorIcms.setBounds(35, 486, 100, 16);
        getContentPane().add(txtEstado);
        txtEstado.setBounds(79, 455, 220, 22);
        getContentPane().add(txtValorIcms);
        txtValorIcms.setBounds(119, 483, 180, 22);

        lblComprador.setText("Comprador:");
        getContentPane().add(lblComprador);
        lblComprador.setBounds(382, 124, 80, 16);

        lblNomeDaPropriedadeComprador.setText("Nome da Propriedade:");
        getContentPane().add(lblNomeDaPropriedadeComprador);
        lblNomeDaPropriedadeComprador.setBounds(409, 202, 130, 16);

        lblEnderecoComprador.setText("Endereço:");
        getContentPane().add(lblEnderecoComprador);
        lblEnderecoComprador.setBounds(409, 230, 70, 16);
        getContentPane().add(txtNomeComprador);
        txtNomeComprador.setBounds(452, 146, 227, 22);
        getContentPane().add(txtCpfComprador);
        txtCpfComprador.setBounds(452, 174, 227, 22);
        getContentPane().add(txtNomePropriedadeComprador);
        txtNomePropriedadeComprador.setBounds(539, 202, 140, 22);
        getContentPane().add(txtEnderecoComprador);
        txtEnderecoComprador.setBounds(479, 230, 200, 22);

        lblNomeComprador.setText("Nome:");
        getContentPane().add(lblNomeComprador);
        lblNomeComprador.setBounds(410, 146, 60, 16);

        lblCpfComprador.setText("CPF:");
        getContentPane().add(lblCpfComprador);
        lblCpfComprador.setBounds(409, 174, 37, 16);

        btnCancelarCadastro.setText("Cancelar");
        btnCancelarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelarCadastro);
        btnCancelarCadastro.setBounds(499, 531, 90, 23);

        btnSalvarCadastro.setText("Salvar");
        btnSalvarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvarCadastro);
        btnSalvarCadastro.setBounds(607, 531, 72, 23);

        imgCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadastro_1.png"))); // NOI18N
        imgCadastro.setText("jLabel1");
        imgCadastro.setMaximumSize(new java.awt.Dimension(800, 600));
        imgCadastro.setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().add(imgCadastro);
        imgCadastro.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArrendatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArrendatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnArrendatarioActionPerformed

    private void btnProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProprietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProprietarioActionPerformed

    private void btnCancelarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastroActionPerformed
        this.dispose();  // Fecha a tela de edição
        if (tabelaNotas != null) {
            tabelaNotas.setVisible(true); // Reabre a tela da tabela
        }
    }//GEN-LAST:event_btnCancelarCadastroActionPerformed

    private void btnSalvarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCadastroActionPerformed
        // Capturando os dados dos JTextFields
        String nomeComprador = txtNomeComprador.getText();
        String cpfComprador = txtCpfComprador.getText();
        String enderecoComprador = txtEnderecoComprador.getText();
        String nomePropriedadeComprador = txtNomePropriedadeComprador.getText();
        String nomeVendedor = txtNomeVendedor.getText();
        String cpfVendedor = txtCpfVendedor.getText();
        String enderecoVendedor = txtEnderecoVendedor.getText();
        String nomePropriedadeVendedor = txtNomePropriedadeVendedor.getText();
        String cpfConjuge = txtCpfConjuge.getText();
        String estado = txtEstado.getText();
        String incra = txtIncra.getText();

        // Capturando os valores das variáveis que são do tipo double
        String porcentagemStr = txtPorcentagem.getText();
        String valorIcmsStr = txtValorIcms.getText();

        // Validando se todos os campos obrigatórios foram preenchidos
        if (nomeComprador.isEmpty() || cpfComprador.isEmpty() || enderecoComprador.isEmpty() || nomePropriedadeComprador.isEmpty()
                || nomeVendedor.isEmpty() || cpfVendedor.isEmpty() || enderecoVendedor.isEmpty() || nomePropriedadeVendedor.isEmpty()
                || (lblCpfConjuge.isVisible() && cpfConjuge.isEmpty()) // Verifica se o campo de CPF do cônjuge está visível
                || (!btnSolteiro.isSelected() && !btnCasado.isSelected() && !btnViuvo.isSelected())
                || (!btnProprietario.isSelected() && !btnArrendatario.isSelected() && !btnParceiro.isSelected())
                || (!btnVendaEstado.isSelected() && !btnVendaForaEstado.isSelected())
                || (lblEstado.isVisible() && estado.isEmpty()) // Verifica se o campo de estado está visível
                || (btnVendaForaEstado.isSelected() && lblValorIcms.isVisible() && (valorIcmsStr == null || valorIcmsStr.isEmpty())) // Verifica se o campo de valor ICMS está visível apenas se a venda for fora do estado
                || (lblPorcentagem.isVisible() && porcentagemStr.isEmpty())) { // Verifica se o campo de porcentagem está visível

            // Exibe uma mensagem de erro se algum campo obrigatório não for preenchido
            JOptionPane.showMessageDialog(this, "É necessário completar todos os dados antes de salvar.", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Impede que o cadastro seja salvo se faltar algum dado
        }

        // Capturando o estado civil
        String estadoCivil = "";
        if (btnSolteiro.isSelected()) {
            estadoCivil = "Solteiro";
            cpfConjuge = null; // Define o CPF do cônjuge como null
        } else if (btnCasado.isSelected()) {
            estadoCivil = "Casado";
        } else if (btnViuvo.isSelected()) {
            estadoCivil = "Viúvo";
            cpfConjuge = null; // Define o CPF do cônjuge como null
        }

        // Capturando o tipo de posse
        String tipoPosse = "";
        if (btnProprietario.isSelected()) {
            tipoPosse = "Proprietário";
        } else if (btnArrendatario.isSelected()) {
            tipoPosse = "Arrendatário";
        } else if (btnParceiro.isSelected()) {
            tipoPosse = "Parceiro";
        }

        String estadoDestino = "";
        if (btnVendaEstado.isSelected()) {
            estadoDestino = "VendaEstado";
            estado = null; // Define o estado como nulo valorIcmsStr = null; // Define o valor do ICMS como nulo
        } else if (btnVendaForaEstado.isSelected()) {
            estadoDestino = "VendaForaEstado";
        }

        // Convertendo os valores de porcentagem e valorIcms para double
        double porcentagem = 0;
        double valorIcms = 0;

        try {
            // Verifica se a porcentagem está vazia antes de converter
            if (!porcentagemStr.isEmpty()) {
                porcentagem = Double.parseDouble(porcentagemStr) / 100; // Dividir por 100 para obter a fração correta
            }

            // Verifica se o valor do ICMS está vazio antes de converter
            if (btnVendaForaEstado.isSelected() && valorIcmsStr != null && !valorIcmsStr.isEmpty()) {
                valorIcms = Double.parseDouble(valorIcmsStr);
            } else {
                valorIcms = 0; // Define como 0 se a venda for para o estado
            }
        } catch (NumberFormatException e) {
            // Se não for possível converter, mostrar erro e retornar
            JOptionPane.showMessageDialog(this, "Porcentagem ou ICMS inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Atualizando a nota com os dados capturados
        nota.setNomeVendedor(nomeVendedor);
        nota.setCpfVendedor(cpfVendedor);
        nota.setNomePropriedadeVendedor(nomePropriedadeVendedor);
        nota.setEnderecoVendedor(enderecoVendedor);
        nota.setIncra(incra);
        nota.setCpfComprador(cpfComprador);
        nota.setNomeComprador(nomeComprador);
        nota.setNomePropriedadeComprador(nomePropriedadeComprador);
        nota.setEnderecoComprador(enderecoComprador);
        nota.setPorcentagem(porcentagem);
        nota.setValorIcms(valorIcms);
        nota.setEstado(estado);
        nota.setCpfConjuge(cpfConjuge);
        nota.setEstadoCivil(estadoCivil);
        nota.setTipoDePosse(tipoPosse);
        nota.setEstadoDestino(estadoDestino);

        // Atualizando a nota no banco de dados
        try {
            OperacoesNotas.editarNota(nota); // Atualiza a nota no banco de dados
            JOptionPane.showMessageDialog(this, "Edição realizada com sucesso!");

            // Atualiza a tabela na classe TabelaNotas
            if (tabelaNotas != null) {
                tabelaNotas.atualizarTabela(); // Chama o método para atualizar a tabela
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar os dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        // Após salvar, fecha a tela de edição
        this.dispose();
        if (tabelaNotas != null) {
            tabelaNotas.setVisible(true); // Reabre a tela da tabela
        }
    }//GEN-LAST:event_btnSalvarCadastroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

// Exemplo de nota para edição
        Notas notaParaEditar = new Notas("Proprietário", 0.5, "Vendedor Exemplo", "12345678901",
                "Propriedade Exemplo", "Endereço Exemplo", "123456789",
                "Solteiro", "", "VendaEstado", "Estado Exemplo",
                100.0, "Comprador Exemplo", "98765432100",
                "Propriedade Comprador", "Endereço Comprador");

        //Cria e exibe a tela de edição de notas
        java.awt.EventQueue.invokeLater(() -> {
            EditarNotas editarNota = new EditarNotas(notaParaEditar); // Passa a nota a ser editada
            editarNota.setVisible(true); // Exibe a tela de edição
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnArrendatario;
    private javax.swing.JButton btnCancelarCadastro;
    private javax.swing.JRadioButton btnCasado;
    private javax.swing.ButtonGroup btnGrupoDeTiposPosse;
    private javax.swing.ButtonGroup btnGrupoEstadoCivil;
    private javax.swing.ButtonGroup btnGrupoTipoVenda;
    private javax.swing.JRadioButton btnParceiro;
    private javax.swing.JRadioButton btnProprietario;
    private javax.swing.JButton btnSalvarCadastro;
    private javax.swing.JRadioButton btnSolteiro;
    private javax.swing.JRadioButton btnVendaEstado;
    private javax.swing.JRadioButton btnVendaForaEstado;
    private javax.swing.JRadioButton btnViuvo;
    private javax.swing.JLabel imgCadastro;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lblComprador;
    private javax.swing.JLabel lblConjuge;
    private javax.swing.JLabel lblCpfComprador;
    private javax.swing.JLabel lblCpfConjuge;
    private javax.swing.JLabel lblCpfVendedor;
    private javax.swing.JLabel lblEnderecoComprador;
    private javax.swing.JLabel lblEnderecoVendedor;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIcms;
    private javax.swing.JLabel lblIncra;
    private javax.swing.JLabel lblNomeComprador;
    private javax.swing.JLabel lblNomeDaPropriedadeComprador;
    private javax.swing.JLabel lblNomeDaPropriedadeVendedor;
    private javax.swing.JLabel lblNomeVendedor;
    private javax.swing.JLabel lblPorcentagem;
    private javax.swing.JLabel lblValorIcms;
    private javax.swing.JLabel lblVendedor;
    private javax.swing.JTextField txtCpfComprador;
    private javax.swing.JTextField txtCpfConjuge;
    private javax.swing.JTextField txtCpfVendedor;
    private javax.swing.JTextField txtEnderecoComprador;
    private javax.swing.JTextField txtEnderecoVendedor;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtIncra;
    private javax.swing.JTextField txtNomeComprador;
    private javax.swing.JTextField txtNomePropriedadeComprador;
    private javax.swing.JTextField txtNomePropriedadeVendedor;
    private javax.swing.JTextField txtNomeVendedor;
    private javax.swing.JTextField txtPorcentagem;
    private javax.swing.JTextField txtValorIcms;
    // End of variables declaration//GEN-END:variables
}
