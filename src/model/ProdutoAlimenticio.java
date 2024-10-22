package model;

import java.util.Date;

public class ProdutoAlimenticio extends Produto {
	private Date dataValidade;
	private String infoNutri;

	public ProdutoAlimenticio (String nome, double precoCusto, double precoVenda, Date dataValidade, String infoNutri) {
		super (nome, precoCusto, precoVenda);
		this.dataValidade = dataValidade;
		this.infoNutri = infoNutri;
	}

	public Date getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	public String getInfoNutri() {
		return infoNutri;
	}
	
	@Override
	public void salvar() {
		System.out.println("Salvando Produto Alimentício no banco de dados...");
	}
	@Override
	public void deletar() {
		System.out.println("Deletando Produto Alimentício do banco de dados...");
	}
	@Override
	public void atualizar() {
		System.out.println("Atualizando Produto Alimentício no banco de dados...");
	}
}
