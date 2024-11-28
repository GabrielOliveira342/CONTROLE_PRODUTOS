package model; // pacote model

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoVestiario extends Produto { // classe Vestuário extends Produto
    // Atributos encapsulados
    private String tamanho;
    private String cor;
    private String material;

    // Construtor e parâmetros
    public ProdutoVestiario(String nome, double precoCusto, double precoVenda, String tamanho, String cor, String material) {
        super(nome, precoCusto, precoVenda);
        this.tamanho = tamanho;
        this.cor = cor;
        this.material = material;
    }

    // Getters e Setters
    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    // Métodos para persistência no banco de dados
    @Override
    public void salvar() {
        String sql = "INSERT INTO produtos (nome, precoCusto, precoVenda, tamanho, cor, material) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, this.getNome());
            stmt.setDouble(2, this.getPrecoCusto());
            stmt.setDouble(3, this.getPrecoVenda());
            stmt.setString(4, this.tamanho);
            stmt.setString(5, this.cor);
            stmt.setString(6, this.material);
            stmt.executeUpdate();
            System.out.println("Produto de Vestuário salvo com sucesso no banco de dados.");
        } catch (SQLException e) {
            System.err.println("Erro ao salvar produto de vestuário: " + e.getMessage());
        }
    }

    @Override
    public void deletar() {
        System.out.println("Deletando Produto de Vestuário do banco de dados...");
        // Implemente a lógica de exclusão aqui, se necessário.
    }

    @Override
    public void atualizar() {
        System.out.println("Atualizando Produto de Vestuário no banco de dados...");
        // Implemente a lógica de atualização aqui, se necessário.
    }
}

