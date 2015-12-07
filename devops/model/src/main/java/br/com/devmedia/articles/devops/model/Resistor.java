package br.com.devmedia.articles.devops.model;

/**
 * Representação lógica de um resistor (componente eletroeletrônico). 
 * 
 * @author pedrobrigatto
 */
public class Resistor {
	
	private static final String MENSAGEM = 
			"Resistor [Valor: %.2f Ohms, Variação percentual: %.2f, Mín: %.2f, Max:%.2f]";
	
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
		return String.format(MENSAGEM, valorBase, 
				variacao, this.lerMenorValor(), this.lerMaiorValor());
	}
}
