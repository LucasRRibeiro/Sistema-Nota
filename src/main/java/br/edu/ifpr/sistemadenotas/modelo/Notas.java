package br.edu.ifpr.sistemadenotas.modelo;

/**
 * Classe que representa uma nota com seus dados.
 */
public class Notas {

    private int idNotas;
    private String tipoDePosse;
    private double porcentagem;
    private String nomeVendedor;
    private String cpfVendedor;
    private String nomePropriedadeVendedor;
    private String enderecoVendedor;
    private String incra;
    private String estadoCivil;
    private String cpfConjuge;
    private String estadoDestino;
    private String estado;
    private Double valorIcms;
    private String nomeComprador;
    private String cpfComprador;
    private String nomePropriedadeComprador;
    private String enderecoComprador;

    // Construtor padrão
    public Notas() {
    }

        // Construtor que aceita o ID
    public Notas(int idNotas, String tipoDePosse, double porcentagem, String nomeVendedor, String cpfVendedor, 
                 String nomePropriedadeVendedor, String enderecoVendedor, String incra, 
                 String estadoCivil, String cpfConjuge, String estadoDestino, String estado, 
                 double valorIcms, String nomeComprador, String cpfComprador, 
                 String nomePropriedadeComprador, String enderecoComprador) {
        this.idNotas = idNotas; // Inicializa o ID
        this.tipoDePosse = tipoDePosse;
        this.porcentagem = porcentagem;
        this.nomeVendedor = nomeVendedor;
        this.cpfVendedor = cpfVendedor;
        this.nomePropriedadeVendedor = nomePropriedadeVendedor;
        this.enderecoVendedor = enderecoVendedor;
        this.incra = incra;
        this.estadoCivil = estadoCivil;
        this.cpfConjuge = cpfConjuge;
        this.estadoDestino = estadoDestino;
        this.estado = estado;
        this.valorIcms = valorIcms;
        this.nomeComprador = nomeComprador;
        this.cpfComprador = cpfComprador;
        this.nomePropriedadeComprador = nomePropriedadeComprador;
        this.enderecoComprador = enderecoComprador;
    }
    
    // Construtor atualizado
    public Notas(String tipoDePosse, double porcentagem, String nomeVendedor, String cpfVendedor,
            String nomePropriedadeVendedor, String enderecoVendedor, String incra, String estadoCivil,
            String cpfConjuge, String estadoDestino, String estado, double valorIcms, String nomeComprador,
            String cpfComprador, String nomePropriedadeComprador, String enderecoComprador) {
        this.tipoDePosse = tipoDePosse;
        this.porcentagem = porcentagem;
        this.nomeVendedor = nomeVendedor;
        this.cpfVendedor = cpfVendedor;
        this.nomePropriedadeVendedor = nomePropriedadeVendedor;
        this.enderecoVendedor = enderecoVendedor;
        this.incra = incra;
        this.estadoCivil = estadoCivil;
        this.cpfConjuge = cpfConjuge;
        this.estadoDestino = estadoDestino;
        this.estado = estado;
        this.valorIcms = valorIcms;
        this.nomeComprador = nomeComprador;
        this.cpfComprador = cpfComprador;
        this.nomePropriedadeComprador = nomePropriedadeComprador;
        this.enderecoComprador = enderecoComprador;
    }

    // Getters e Setters
    public int getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(int idNotas) {
        this.idNotas = idNotas;
    }

    public String getTipoDePosse() {
        return tipoDePosse;
    }

    public void setTipoDePosse(String tipoDePosse) {
        this.tipoDePosse = tipoDePosse;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public String getCpfVendedor() {
        return cpfVendedor;
    }

    public void setCpfVendedor(String cpfVendedor) {
        this.cpfVendedor = cpfVendedor;
    }

    public String getNomePropriedadeVendedor() {
        return nomePropriedadeVendedor;
    }

    public void setNomePropriedadeVendedor(String nomePropriedadeVendedor) {
        this.nomePropriedadeVendedor = nomePropriedadeVendedor;
    }

    public String getEnderecoVendedor() {
        return enderecoVendedor;
    }

    public void setEnderecoVendedor(String enderecoVendedor) {
        this.enderecoVendedor = enderecoVendedor;
    }

    public String getIncra() {
        return incra;
    }

    public void setIncra(String incra) {
        this.incra = incra;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCpfConjuge() {
        return cpfConjuge;
    }

    public void setCpfConjuge(String cpfConjuge) {
        this.cpfConjuge = cpfConjuge;
    }

    public String getEstadoDestino() {
        return estadoDestino;
    }

    public void setEstadoDestino(String estadoDestino) {
        this.estadoDestino = estadoDestino;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getValorIcms() {
        return valorIcms;
    }

    public void setValorIcms(Double valorIcms) {
        this.valorIcms = valorIcms;
    }

    public String getNomeComprador() {
        return nomeComprador;
    }

    public void setNomeComprador(String nomeComprador) {
        this.nomeComprador = nomeComprador;
    }

    public String getCpfComprador() {
        return cpfComprador;
    }

    public void setCpfComprador(String cpfComprador) {
        this.cpfComprador = cpfComprador;
    }

    public String getNomePropriedadeComprador() {
        return nomePropriedadeComprador;
    }

    public void setNomePropriedadeComprador(String nomePropriedadeComprador) {
        this.nomePropriedadeComprador = nomePropriedadeComprador;
    }

    public String getEnderecoComprador() {
        return enderecoComprador;
    }

    public void setEnderecoComprador(String enderecoComprador) {
        this.enderecoComprador = enderecoComprador;

    }
}
