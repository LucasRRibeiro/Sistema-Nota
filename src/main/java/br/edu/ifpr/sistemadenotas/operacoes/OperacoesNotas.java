/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.sistemadenotas.operacoes;

import br.edu.ifpr.sistemadenotas.conexao.Conexao;
import br.edu.ifpr.sistemadenotas.modelo.AuxiliarAdministrativo;
import br.edu.ifpr.sistemadenotas.modelo.Notas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class OperacoesNotas {

    // Método para inserir auxiliar administrativo
    public static void inserirAuxiliarAdministrativo(AuxiliarAdministrativo auxiliar) {
        String sql = "INSERT INTO tb_usuario (cpf, senha) VALUES (?, ?)";
        try {
            PreparedStatement sqlPreparada = Conexao.getConexao().prepareStatement(sql);
            sqlPreparada.setString(1, auxiliar.getCpf());
            sqlPreparada.setString(2, auxiliar.getSenha());
            sqlPreparada.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void inserirNota(Notas notas) {
        String sql = "INSERT INTO tb_notas (tipo_de_posse, porcentagem, nome_vendedor, cpf_vendedor, nome_propriedade_vendedor, "
                + "endereco_vendedor, incra, estado_civil, cpf_conjuge, estado_destino, estado, valor_icms, nome_comprador, "
                + "cpf_comprador, nome_propriedade_comprador, endereco_comprador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement sqlPreparada = Conexao.getConexao().prepareStatement(sql);
            // Setando os valores dos campos da nota
            sqlPreparada.setString(1, notas.getTipoDePosse());
            sqlPreparada.setDouble(2, notas.getPorcentagem());
            sqlPreparada.setString(3, notas.getNomeVendedor());
            sqlPreparada.setString(4, notas.getCpfVendedor());
            sqlPreparada.setString(5, notas.getNomePropriedadeVendedor());
            sqlPreparada.setString(6, notas.getEnderecoVendedor());
            sqlPreparada.setString(7, notas.getIncra());
            sqlPreparada.setString(8, notas.getEstadoCivil());
            sqlPreparada.setString(9, notas.getCpfConjuge());
            sqlPreparada.setString(10, notas.getEstadoDestino());
            sqlPreparada.setString(11, notas.getEstado());
            sqlPreparada.setDouble(12, notas.getValorIcms());
            sqlPreparada.setString(13, notas.getNomeComprador());
            sqlPreparada.setString(14, notas.getCpfComprador());
            sqlPreparada.setString(15, notas.getNomePropriedadeComprador());
            sqlPreparada.setString(16, notas.getEnderecoComprador());
            sqlPreparada.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Notas> buscarNotas() {
        List<Notas> listaNotas = new ArrayList<>();
        String sql = "SELECT id_notas, tipo_de_posse, porcentagem, nome_vendedor, cpf_vendedor, "
                + "nome_propriedade_vendedor, endereco_vendedor, incra, estado_civil, cpf_conjuge, "
                + "estado_destino, estado, valor_icms, nome_comprador, cpf_comprador, "
                + "nome_propriedade_comprador, endereco_comprador FROM tb_notas"; // Removendo 'codigo'

        try {
            Statement stmt = Conexao.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Notas nota = new Notas(
                        rs.getInt("id_notas"), // Usando id_notas como código
                        rs.getString("tipo_de_posse"),
                        rs.getDouble("porcentagem"),
                        rs.getString("nome_vendedor"),
                        rs.getString("cpf_vendedor"),
                        rs.getString("nome_propriedade_vendedor"),
                        rs.getString("endereco_vendedor"),
                        rs.getString("incra"),
                        rs.getString("estado_civil"),
                        rs.getString("cpf_conjuge"),
                        rs.getString("estado_destino"),
                        rs.getString("estado"),
                        rs.getDouble("valor_icms"),
                        rs.getString("nome_comprador"),
                        rs.getString("cpf_comprador"),
                        rs.getString("nome_propriedade_comprador"),
                        rs.getString("endereco_comprador")
                );
                listaNotas.add(nota);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaNotas;
    }

    // Método para excluir uma nota usando o CPF
    public static void excluirNota(int idNotas) {
        String sql = "DELETE FROM tb_notas WHERE id_notas = ?";
        try {
            PreparedStatement sqlPreparada = Conexao.getConexao().prepareStatement(sql);
            sqlPreparada.setInt(1, idNotas); // Usando o id_notas como identificador
            int rowsAffected = sqlPreparada.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Nota excluída com sucesso.");
            } else {
                System.out.println("Nenhuma nota encontrada com o ID fornecido.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editarNota(Notas nota) {
        String sql = "UPDATE tb_notas SET tipo_de_posse = ?, porcentagem = ?, nome_vendedor = ?, cpf_vendedor = ?, "
                + "nome_propriedade_vendedor = ?, endereco_vendedor = ?, incra = ?, estado_civil = ?, "
                + "cpf_conjuge = ?, estado_destino = ?, estado = ?, valor_icms = ?, nome_comprador = ?, "
                + "cpf_comprador = ?, nome_propriedade_comprador = ?, endereco_comprador = ? "
                + "WHERE id_notas = ?"; // Usando id_notas como identificador

        try (PreparedStatement sqlPreparada = Conexao.getConexao().prepareStatement(sql)) {
            // Setando os valores dos campos da nota
            sqlPreparada.setString(1, nota.getTipoDePosse());
            sqlPreparada.setDouble(2, nota.getPorcentagem());
            sqlPreparada.setString(3, nota.getNomeVendedor());
            sqlPreparada.setString(4, nota.getCpfVendedor());
            sqlPreparada.setString(5, nota.getNomePropriedadeVendedor());
            sqlPreparada.setString(6, nota.getEnderecoVendedor());
            sqlPreparada.setString(7, nota.getIncra());
            sqlPreparada.setString(8, nota.getEstadoCivil());
            sqlPreparada.setString(9, nota.getCpfConjuge());
            sqlPreparada.setString(10, nota.getEstadoDestino());
            sqlPreparada.setString(11, nota.getEstado());
            sqlPreparada.setDouble(12, nota.getValorIcms());
            sqlPreparada.setString(13, nota.getNomeComprador());
            sqlPreparada.setString(14, nota.getCpfComprador());
            sqlPreparada.setString(15, nota.getNomePropriedadeComprador());
            sqlPreparada.setString(16, nota.getEnderecoComprador());
            sqlPreparada.setInt(17, nota.getIdNotas()); // Usando id_notas para identificar a nota

            // Executa a atualização
            int rowsAffected = sqlPreparada.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Nota atualizada com sucesso.");
            } else {
                System.out.println("Nenhuma nota encontrada com o ID fornecido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para validar usuário permanece o mesmo
    public static boolean validarUsuario(AuxiliarAdministrativo auxiliar) {
        String sql = "SELECT * FROM tb_usuario WHERE cpf = ? AND senha = ?";
        try {
            PreparedStatement sqlPreparada = Conexao.getConexao().prepareStatement(sql);
            sqlPreparada.setString(1, auxiliar.getCpf());
            sqlPreparada.setString(2, auxiliar.getSenha());

            ResultSet rs = sqlPreparada.executeQuery();
            return rs.next(); // Se houver um resultado, o usuário é válido
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Retorna false em caso de erro
        }
    }
}
