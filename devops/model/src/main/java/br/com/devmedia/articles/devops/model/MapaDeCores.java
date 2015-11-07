package br.com.devmedia.articles.devops.model;

import java.util.HashMap;
import java.util.Map;

public final class MapaDeCores {
	
	public static final String PRETO = "PRETO";
	public static final String MARROM = "MARROM";
	public static final String VERMELHO = "VERMELHO";
	public static final String LARANJA = "LARANJA";
	public static final String AMARELO = "AMARELO";
	public static final String VERDE = "VERDE";
	public static final String AZUL = "AZUL";
	public static final String VIOLETA = "VIOLETA";
	public static final String CINZA = "CINZA";
	public static final String BRANCO = "BRANCO";
	public static final String DOURADO = "DOURADO";
	public static final String PRATEADO = "PRATEADO";
	
	private static Map<String, Double> codigosDeValor;
	private static Map<String, Double> codigosDeImprecisao;
	
	static {
		inicializarMapaDeCores();
	}
	
	private MapaDeCores () {}
	
	private static void inicializarMapaDeCores() {
		codigosDeValor = new HashMap<String, Double>();
		codigosDeValor.put(PRETO, 0.0);
		codigosDeValor.put(MARROM, 1.0);
		codigosDeValor.put(VERMELHO, 2.0);
		codigosDeValor.put(LARANJA, 3.0);
		codigosDeValor.put(AMARELO, 4.0);
		codigosDeValor.put(VERDE, 5.0);
		codigosDeValor.put(AZUL, 6.0);
		codigosDeValor.put(VIOLETA, 7.0);
		codigosDeValor.put(CINZA, 8.0);
		codigosDeValor.put(BRANCO, 9.0);
		
		codigosDeImprecisao = new HashMap<String, Double>();
		codigosDeImprecisao.put(DOURADO, 0.05);
		codigosDeImprecisao.put(PRATEADO, 0.1);
	}
	
	public static Number get(String chave) {
		
		Number valor = codigosDeValor.get(chave);
		
		if (valor == null) {
			valor = codigosDeImprecisao.get(chave);
		}
		
		if (valor == null) {
			valor = 0;
		}
		
		return valor;
	}
}
