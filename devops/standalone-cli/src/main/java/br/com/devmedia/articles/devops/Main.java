package br.com.devmedia.articles.devops;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.devmedia.articles.devops.view.CalculadoraResistores;

public class Main {
	
	private static ApplicationContext appContext;

	public static void main (String [] args) {
		appContext = new ClassPathXmlApplicationContext("devops_standalonecli-context.xml");
		((CalculadoraResistores) appContext.getBean(CalculadoraResistores.class)).build();
	}
}
