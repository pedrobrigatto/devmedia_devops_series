package br.com.devmedia.articles.devops.model.exceptions;

public class NumeroDeFaixasIncorreto extends Exception {

	private static final long serialVersionUID = -6338615808293109410L;
	
	public NumeroDeFaixasIncorreto(String mensagem) {
		super(mensagem);
	}
}
