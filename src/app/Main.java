package app;

import model.ProdutoAlimenticio;
import model.ProdutoVestiario;
import model.ConexaoBD;

import java.util.Date;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Connection conexao = ConexaoBD.conectar();
        if (conexao != null) {
            try {
                // Estanciando Calendar e data de validade
                Calendar calendar = Calendar.getInstance();
                calendar.set(2024, Calendar.OCTOBER, 5);
                Date dataValidade = calendar.getTime();

                // Estanciando a classe ProdutoAlimenticio
                ProdutoAlimenticio produtoAlimenticio = new ProdutoAlimenticio(
                        "Biscoito", 1.50, 2.50, dataValidade, "150 kcal por pacote");

                // Exibindo informações
                System.out.println("Produto Alimentício: " + produtoAlimenticio.getNome());
                System.out.println("Lucro: R$ " + produtoAlimenticio.calcularLucro());
                produtoAlimenticio.salvar();
                produtoAlimenticio.atualizar();
                produtoAlimenticio.deletar();

                // Estanciando a classe ProdutoVestuario
                ProdutoVestiario produtoVestuario = new ProdutoVestiario(
                        "Camiseta", 10.00, 20.00, "M", "Azul", "Algodão");

                // Exibindo informações
                System.out.println("\nProduto de Vestuário: " + produtoVestuario.getNome());
                System.out.println("Lucro: R$ " + produtoVestuario.calcularLucro());
                produtoVestuario.salvar();
                produtoVestuario.atualizar();
                produtoVestuario.deletar();

            } finally {
                try {
                    if (conexao != null) conexao.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        } else {
            System.err.println("Erro: conexão com o banco de dados não foi estabelecida.");
        }
    }
}