package br.com.devmedia.articles.devops.model.api;

import br.com.devmedia.articles.devops.model.Resistor;
import br.com.devmedia.articles.devops.model.exceptions.CorDeBaseInvalida;
import br.com.devmedia.articles.devops.model.exceptions.CorDePrecisaoInvalida;
import br.com.devmedia.articles.devops.model.exceptions.NumeroDeFaixasIncorreto;

public interface CalculadoraDeResistencia {
	
	/**
	 * Constrói representações de resistores baseado nas faixas fornecidas.
	 * 
	 * @param faixas Faixas gravadas no corpo do resistor físico
	 * @return Especificações nominais do resistor em questão
	 * 
	 * @throws CorDeBaseInvalida quando a cor fornecida para o cálculo do valor de base for inválido
	 * @throws CorDePrecisaoInvalida quando a cor fornecida para o cálculo da precisão for inválido
	 * @throws NumeroDeFaixasIncorreto quando houver mais ou menos de quatro faixas fornecidas
	 */
	Resistor montarResistor (String ... faixas) 
			throws NumeroDeFaixasIncorreto, CorDePrecisaoInvalida, CorDeBaseInvalida;
}
