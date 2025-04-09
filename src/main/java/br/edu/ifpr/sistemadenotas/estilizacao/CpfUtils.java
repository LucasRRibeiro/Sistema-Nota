/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.sistemadenotas.estilizacao;

/**
 *
 * @author Aluno
 */
public class CpfUtils {

    public static String formatarCpf(String cpf) {
        cpf = cpf.replaceAll("[^\\d]", ""); // Remove qualquer caractere não numérico

        // Aplica a máscara de CPF
        if (cpf.length() > 6) {
            cpf = cpf.substring(0, 6) + "." + cpf.substring(6);
        }
        if (cpf.length() > 3) {
            cpf = cpf.substring(0, 3) + "." + cpf.substring(3);
        }
        if (cpf.length() > 11) {
            cpf = cpf.substring(0, 11) + "-" + cpf.substring(11);
        }

        return cpf;
    }
}
