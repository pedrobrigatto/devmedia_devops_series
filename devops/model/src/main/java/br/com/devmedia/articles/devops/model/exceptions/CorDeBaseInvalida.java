package br.com.devmedia.articles.devops.model.exceptions;

/**
 * Indica que a cor fornecida para o cálculo do valor de base ou da potência de 10 de 
 * um resistor  não é válida. As cores que são permitidas dentro do contexto de cálculo 
 * de resistências são: 
 * 
 * <ul>
 *   <li>Preto</li>
 *   <li>Marrom</li>
 *   <li>Vermelho</li>
 *   <li>Laranja</li>
 *   <li>Amarelo</li>
 *   <li>Verde</li>
 *   <li>Azul</li>
 *   <li>Violeta</li>
 *   <li>Cinza</li>
 *   <li>Branco</li>
 * </ul>
 * 
 * @author pedrobrigatto
 */
public class CorDeBaseInvalida extends Exception {

	private static final long serialVersionUID = 994054615504447401L;
	
	public CorDeBaseInvalida (String message) {
		super(message);
	}
}
