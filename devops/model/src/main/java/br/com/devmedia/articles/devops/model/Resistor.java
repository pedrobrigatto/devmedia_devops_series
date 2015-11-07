package br.com.devmedia.articles.devops.model;

public class Resistor {
	
	private Double valorBase;
	private Double variacao;
	
	public Resistor() {}
	
	public Resistor(Double valorBase, Double variacao) {
		this.valorBase = valorBase;
		this.variacao = variacao;
	}

	public Double getValorBase() {
		return valorBase;
	}

	public void setValorBase(Double valorNominal) {
		this.valorBase = valorNominal;
	}

	public Double getVariacao() {
		return variacao;
	}

	public void setVariacao(Double variacao) {
		this.variacao = variacao;
	}
	
	public Double lerMenorValor() {
		return valorBase * (1 - variacao);
	}
	
	public Double lerMaiorValor() {
		return valorBase * (1 + variacao);
	}

	@Override
	public String toString() {
		return "Resistor [valorBase=" + valorBase + " Ohms, variacao=" + variacao + "%]";
	}
}
