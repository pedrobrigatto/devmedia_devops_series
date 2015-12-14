package br.com.devmedia.articles.devops.model.exceptions;

/**
 * Representação de uma situação em que o número de faixas informado para o cálculo da resistência é
 * diferente do esperado (4). Esta diferença pode ser tanto para mais quanto para menos, sendo 
 * representada da mesma forma por meio de um objeto desta classe. 
 * 
 * @author pedrobrigatto
 */
public class NumeroDeFaixasIncorreto extends Exception {

	private static final long serialVersionUID = -6338615808293109410L;
	
	public NumeroDeFaixasIncorreto(String mensagem) {
		super(mensagem);
	}
}
