package br.com.devmedia.articles.devops.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.devmedia.articles.devops.model.api.FabricaDeResistores;
import br.com.devmedia.articles.devops.model.exceptions.CorDeBaseInvalida;
import br.com.devmedia.articles.devops.model.exceptions.CorDePrecisaoInvalida;
import br.com.devmedia.articles.devops.model.exceptions.NumeroDeFaixasIncorreto;

public class FabricaDeResistoresTest {

	@Test
	public void testMontagemResistorCom4Faixas() 
			throws NumeroDeFaixasIncorreto, CorDePrecisaoInvalida, CorDeBaseInvalida {
		FabricaDeResistores fabrica = new FabricaDeResistores();

		Resistor resistor = fabrica.montarResistor(
				MapaDeCores.MARROM, MapaDeCores.PRETO, 
				MapaDeCores.PRETO, MapaDeCores.PRATEADO);
		Assert.assertTrue(resistor.getValorBase() == 10.0);
		Assert.assertTrue(resistor.lerMaiorValor() == 11.0);
		Assert.assertTrue(resistor.lerMenorValor() == 9.0);
	}

	@Test(expected = NumeroDeFaixasIncorreto.class)
	public void testMontagemResistorComFaixasSobrando() 
			throws NumeroDeFaixasIncorreto, CorDePrecisaoInvalida, CorDeBaseInvalida {
		FabricaDeResistores fabrica = new FabricaDeResistores();
		fabrica.montarResistor(MapaDeCores.MARROM, MapaDeCores.PRETO, MapaDeCores.PRETO);
	}

	@Test(expected = NumeroDeFaixasIncorreto.class)
	public void testMontagemResistorComFaixasFaltando() 
			throws NumeroDeFaixasIncorreto, CorDePrecisaoInvalida, CorDeBaseInvalida {
		FabricaDeResistores fabrica = new FabricaDeResistores();
		fabrica.montarResistor(MapaDeCores.MARROM, MapaDeCores.PRETO, 
				MapaDeCores.PRETO, MapaDeCores.PRATEADO, MapaDeCores.MARROM,MapaDeCores.PRETO);
	}

	@Test(expected = CorDeBaseInvalida.class)
	public void testCalculoComCorDeBaseInvalida() 
			throws NumeroDeFaixasIncorreto, CorDePrecisaoInvalida, CorDeBaseInvalida {
		FabricaDeResistores fabrica = new FabricaDeResistores();
		fabrica.montarResistor(
				MapaDeCores.PRATEADO, MapaDeCores.PRETO, 
				MapaDeCores.PRETO, MapaDeCores.PRATEADO);
	}

	@Test(expected = CorDePrecisaoInvalida.class)
	public void testCalculoComCorDePrecisaoInvalida() 
			throws NumeroDeFaixasIncorreto, CorDePrecisaoInvalida, CorDeBaseInvalida {
		FabricaDeResistores fabrica = new FabricaDeResistores();
		fabrica.montarResistor(
				MapaDeCores.MARROM, MapaDeCores.PRETO, 
				MapaDeCores.PRETO, MapaDeCores.PRETO);
	}
}
