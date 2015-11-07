package br.com.devmedia.articles.devops.model;

import br.com.devmedia.articles.devops.model.exceptions.NumeroDeFaixasIncorreto;

public interface CalculadoraDeResistencia {
	
	/**
	 * Constrói representações de resistores baseado nas faixas fornecidas.
	 * 
	 * @param faixas Faixas gravadas no corpo do resistor físico
	 * @return Especificações nominais do resistor em questão
	 */
	Resistor montarResistor (String ... faixas) throws NumeroDeFaixasIncorreto;
}
