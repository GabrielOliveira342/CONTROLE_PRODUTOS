package model;

public abstract class Produto {
	
	private String nome;
	private double precoCusto;
	private double precoVenda;
	
	
	public Produto (String nome, double precoCusto, double precoVenda) {
		this.nome = nome;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	
	public double getPrecoVenda() {
		return precoVenda;
	}
	
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	public double calcularLucro() {
		return precoVenda - precoCusto;
	}

	public abstract void salvar();
	public abstract void deletar();
	public abstract void atualizar();
}
