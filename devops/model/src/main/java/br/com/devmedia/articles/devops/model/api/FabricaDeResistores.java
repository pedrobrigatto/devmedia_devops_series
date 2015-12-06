package br.com.devmedia.articles.devops.model.api;

import br.com.devmedia.articles.devops.model.MapaDeCores;
import br.com.devmedia.articles.devops.model.Resistor;
import br.com.devmedia.articles.devops.model.exceptions.CorDeBaseInvalida;
import br.com.devmedia.articles.devops.model.exceptions.CorDePrecisaoInvalida;
import br.com.devmedia.articles.devops.model.exceptions.NumeroDeFaixasIncorreto;

public class FabricaDeResistores implements CalculadoraDeResistencia {
	
	/**
	 * Este método assume que as três primeiras faixas passadas compõem o valor nominal do 
	 * resistor, enquanto a quarta faixa compõe o intervalo que este resistor varia. 
	 * 
	 * @param valores Faixas coloridas no corpo do resistor
	 * @return A resistência em si, composta por valor nominal e faixa de variação
	 */
	public Resistor montarResistor (String ... valores) 
			throws NumeroDeFaixasIncorreto, CorDePrecisaoInvalida, CorDeBaseInvalida {
		
		if (valores == null || valores.length != 4) {
			throw new NumeroDeFaixasIncorreto(
					"O número de faixas fornecidas não corresponde às 4 faixas esperadas");
		}
		
		StringBuilder builder = new StringBuilder();
		String token = String.valueOf(MapaDeCores.lerValorBase(valores[0]));
		
		builder.append(token.substring(0, token.indexOf(".")));
		
		token = String.valueOf(MapaDeCores.lerValorBase(valores[1]));
		builder.append(token.substring(0, token.indexOf(".")));
		
		Double base = Double.parseDouble(builder.toString());
		Double powerOfTen = (Double) MapaDeCores.lerValorBase(valores[2]);
		
		Double precisao = (Double) MapaDeCores.lerPrecisao(valores[3]);
		
		return new Resistor(new Double(base * Math.pow(10,  powerOfTen)), precisao);
	}
}
