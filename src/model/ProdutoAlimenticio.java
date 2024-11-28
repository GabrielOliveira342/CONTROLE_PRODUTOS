package model; // pacote model

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class ProdutoAlimenticio extends Produto { // classe Alimentício com extends em Produto
    // Atributos
    private Date dataValidade;
    private String infoNutri;

    // Construtor e parâmetros
    public ProdutoAlimenticio(String nome, double precoCusto, double precoVenda, Date dataValidade, String infoNutri) {
        super(nome, precoCusto, precoVenda); // classe super herança
        this.dataValidade = dataValidade;
        this.infoNutri = infoNutri;
    }

    // Getters e Setters
    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getInfoNutri() {
        return infoNutri;
    }

    public void setInfoNutri(String infoNutri) {
        this.infoNutri = infoNutri;
    }

    // Métodos para persistência no banco de dados
    @Override
    public void salvar() {
        String sql = "INSERT INTO produtos (nome, precoCusto, precoVenda, dataValidade, infoNutricional) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, this.getNome());
            stmt.setDouble(2, this.getPrecoCusto());
            stmt.setDouble(3, this.getPrecoVenda());
            stmt.setDate(4, new java.sql.Date(this.dataValidade.getTime()));
            stmt.setString(5, this.infoNutri);
            stmt.executeUpdate();
            System.out.println("Produto alimentício salvo com sucesso no banco de dados.");
        } catch (SQLException e) {
            System.err.println("Erro ao salvar produto alimentício: " + e.getMessage());
        }
    }

    @Override
    public void deletar() {
        System.out.println("Deletando Produto Alimentício do banco de dados...");
        // Implemente a lógica de exclusão aqui, se necessário.
    }

    @Override
    public void atualizar() {
        System.out.println("Atualizando Produto Alimentício no banco de dados...");
        // Implemente a lógica de atualização aqui, se necessário.
    }
}

