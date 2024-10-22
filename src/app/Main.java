package app;

import model.ProdutoAlimenticio;
import model.ProdutoVestiario;
import java.util.Date;
import java.util.Calendar;

public class Main {
	
	public static void main(String[] args) {
	
		
		Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.OCTOBER, 5); // 5 de outubro de 2024
        Date dataValidade = calendar.getTime();
		
        ProdutoAlimenticio produtoAlimenticio = new ProdutoAlimenticio("Biscoito", 1.50, 2.50, 
        		dataValidade, "150 kcal por pacote");
		
		System.out.println("Produto Alimenticio: " + produtoAlimenticio.getNome());
		System.out.println("Lucro: R$ " + produtoAlimenticio.calcularLucro());	
		produtoAlimenticio.salvar();
	    produtoAlimenticio.atualizar();
	    produtoAlimenticio.deletar();
	
	    ProdutoVestiario produtoVestiario = new ProdutoVestiario("Camiseta", 10.00, 20.00, "M","Azul","Algodão");
	    
	    System.out.println("\nProduto de Vestuário: " + produtoVestiario.getNome());
        System.out.println("Lucro: R$ " + produtoVestiario.calcularLucro());
        produtoVestiario.salvar();
        produtoVestiario.atualizar();
        produtoVestiario.deletar();
	}
}
