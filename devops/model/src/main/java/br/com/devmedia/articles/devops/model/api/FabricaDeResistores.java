package br.com.devmedia.articles.devops.model;

import br.com.devmedia.articles.devops.model.exceptions.NumeroDeFaixasIncorreto;

public class FabricaDeResistores implements CalculadoraDeResistencia {
	
	/**
	 * Este método assume que as três primeiras faixas passadas compõem o valor nominal do 
	 * resistor, enquanto a quarta faixa compõe o intervalo que este resistor varia. 
	 * 
	 * @param valores Faixas coloridas no corpo do resistor
	 * @return A resistência em si, composta por valor nominal e faixa de variação
	 */
	public Resistor montarResistor (String ... valores) throws NumeroDeFaixasIncorreto {
		
		if (valores == null || valores.length != 4) {
			throw new NumeroDeFaixasIncorreto(
					"O número de faixas fornecidas não corresponde às 4 faixas esperadas");
		}
		
		StringBuilder builder = new StringBuilder();
		String token = String.valueOf(MapaDeCores.get(valores[0]));
		
		builder.append(token.substring(0, token.indexOf(".")));
		
		token = String.valueOf(MapaDeCores.get(valores[1]));
		builder.append(token.substring(0, token.indexOf(".")));
		
		Double base = Double.parseDouble(builder.toString());
		Double powerOfTen = (Double) MapaDeCores.get(valores[2]);
		
		Double precisao = (Double) MapaDeCores.get(valores[3]);
		
		return new Resistor(new Double(base * Math.pow(10,  powerOfTen)), precisao);
	}
}
