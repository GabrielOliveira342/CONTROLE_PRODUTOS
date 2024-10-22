package model;

public class ProdutoVestiario extends Produto {

	private String tamanho;
	private String cor;
	private String material;
	
	public ProdutoVestiario (String nome, double precoCusto, double precoVenda, String tamanho, String cor, String material) {
		super(nome, precoCusto, precoVenda);
		this.tamanho = tamanho;
		this.cor = cor;
		this.material = material;
	}
	
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

	@Override
	public void salvar() {
		System.out.println("Salvando Produto de Vestuário no banco de dados...");
	}
	@Override
	public void deletar() {
		System.out.println("Deletando Produto de Vestuário do banco de dados...");
	}
	@Override
	public void atualizar() {
		System.out.println("Atualizando Produto de Vestuário no banco de dados...");
	}
	
}
