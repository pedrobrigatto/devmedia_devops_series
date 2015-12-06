package br.com.devmedia.articles.devops.model.exceptions;

/**
 * Indica que a cor fornecida para o cálculo da precisão de um resistor não 
 * é válida. Esta faixa, especificamente, pode assumir uma dentre duas cores 
 * apenas, que são: 
 * 
 * <ul>
 *   <li>Prateado</li>
 *   <li>Dourado</li>
 * </ul>
 * 
 * @author pedrobrigatto
 */
public class CorDePrecisaoInvalida extends Exception {

	private static final long serialVersionUID = -8352413111475047973L;
	
	public CorDePrecisaoInvalida (String message) {
		super(message);
	}
}
