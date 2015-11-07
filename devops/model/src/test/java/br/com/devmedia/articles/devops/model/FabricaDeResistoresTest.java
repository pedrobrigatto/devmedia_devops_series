package br.com.devmedia.articles.devops.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.devmedia.articles.devops.model.exceptions.NumeroDeFaixasIncorreto;

public class FabricaDeResistoresTest {

	@Test
	public void testMontagemResistorCom4Faixas() throws NumeroDeFaixasIncorreto {
		FabricaDeResistores fabrica = new FabricaDeResistores();
		
		Resistor resistor = fabrica.montarResistor(
				MapaDeCores.MARROM, MapaDeCores.PRETO, 
				MapaDeCores.PRETO, MapaDeCores.PRATEADO);
		Assert.assertTrue(resistor.getValorBase() == 10.0);
		Assert.assertTrue(resistor.lerMaiorValor() == 11.0);
		Assert.assertTrue(resistor.lerMenorValor() == 9.0);
	}
	
	@Test(expected = NumeroDeFaixasIncorreto.class)
	public void testMontagemResistorComFaixasSobrando() throws NumeroDeFaixasIncorreto {
		FabricaDeResistores fabrica = new FabricaDeResistores();
		fabrica.montarResistor(MapaDeCores.MARROM, MapaDeCores.PRETO, MapaDeCores.PRETO);
	}
	
	@Test(expected = NumeroDeFaixasIncorreto.class)
	public void testMontagemResistorComFaixasFaltando() throws NumeroDeFaixasIncorreto {
		FabricaDeResistores fabrica = new FabricaDeResistores();
		fabrica.montarResistor(MapaDeCores.MARROM, MapaDeCores.PRETO, 
				MapaDeCores.PRETO, MapaDeCores.PRATEADO, MapaDeCores.MARROM,MapaDeCores.PRETO);
	}
}
