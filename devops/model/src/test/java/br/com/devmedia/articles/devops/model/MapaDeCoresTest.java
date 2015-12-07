package br.com.devmedia.articles.devops.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.devmedia.articles.devops.model.exceptions.CorDeBaseInvalida;
import br.com.devmedia.articles.devops.model.exceptions.CorDePrecisaoInvalida;

/**
 * Avalia o comportamento da classe responsável por gerenciar o mapa de cores utilizado para 
 * cálculos nominais de resistência elétrica.
 * 
 * @author pedrobrigatto
 */
public class MapaDeCoresTest {
	
	@Test(expected=CorDePrecisaoInvalida.class)
	public void testLeituraDePrecisaoDesconhecida() throws CorDePrecisaoInvalida {
		MapaDeCores.lerPrecisao("abc");
	}
	
	@Test
	public void testLeituraDePrecisaoValida() throws CorDePrecisaoInvalida {
		assertTrue((Double) MapaDeCores.lerPrecisao(MapaDeCores.DOURADO) == 0.05);
	}
	
	@Test(expected=CorDeBaseInvalida.class)
	public void testLeituraDeBaseInvalida() throws CorDeBaseInvalida {
		MapaDeCores.lerValorBase("abc");
	}
	
	@Test
	public void testLeituraDeBaseValida() throws CorDeBaseInvalida {
		assertTrue((Double) MapaDeCores.lerValorBase(MapaDeCores.PRETO) == 0);
	}
}
