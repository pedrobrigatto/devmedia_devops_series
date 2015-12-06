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
	 * @throws CorDeBaseInvalida
	 * @throws CorDePrecisaoInvalida
	 * @throws NumeroDeFaixasIncorreto
	 */
	Resistor montarResistor (String ... faixas) 
			throws NumeroDeFaixasIncorreto, CorDePrecisaoInvalida, CorDeBaseInvalida;
}
