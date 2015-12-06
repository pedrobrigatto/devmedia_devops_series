package br.com.devmedia.articles.devops.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.com.devmedia.articles.devops.model.MapaDeCores;
import br.com.devmedia.articles.devops.model.Resistor;
import br.com.devmedia.articles.devops.model.api.CalculadoraDeResistencia;
import br.com.devmedia.articles.devops.model.exceptions.CorDeBaseInvalida;
import br.com.devmedia.articles.devops.model.exceptions.CorDePrecisaoInvalida;
import br.com.devmedia.articles.devops.model.exceptions.NumeroDeFaixasIncorreto;

/**
 * Interface principal para cálculo de valores nominais de resistores.		
 */
public class CalculadoraResistores extends JFrame {

	private static final long serialVersionUID = -445111854643404575L;
	
	private CalculadoraDeResistencia calculadora;
	private JButton calcular;
	
	// Elementos do painel
	private GridBagLayout layoutPrincipal;
	
	private JComboBox<String> opcoesFaixa1;
	private JComboBox<String> opcoesFaixa2;
	private JComboBox<String> opcoesFaixa3;
	private JComboBox<String> opcoesFaixa4;
	
	public CalculadoraResistores build() {
		montarPainel();
		configurarTratamentoDeEventos();
		return this;
	}
	
	private void montarPainel() {
		
		carregarComboBoxes();
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		
		layoutPrincipal = new GridBagLayout();
		this.setLayout(layoutPrincipal);
		
		add(new JLabel("Primeira faixa do resistor:"), constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.weighty = 2;
		
		add(opcoesFaixa1, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.weighty = 1;
		
		add(new JLabel("Segunda  faixa do resistor:"), constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.weighty = 2;
		
		add(opcoesFaixa2, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.weighty = 1;
		
		add(new JLabel("Terceira faixa do resistor:"), constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.weighty = 2;
		
		add(opcoesFaixa3, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.weighty = 1;
		
		add(new JLabel("Quarta-faixa do resistor:"), constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.weighty = 2;
		
		add(opcoesFaixa4, constraints);
		
		calcular = new JButton("CALCULAR");
		
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.weighty = 3;
		
		add(calcular, constraints);
		
		this.setSize(400, 200);
		this.setVisible(true);
	}
	
	private void carregarComboBoxes() {
		opcoesFaixa1 = new JComboBox<String>(new String [] {
				MapaDeCores.PRETO, MapaDeCores.MARROM, MapaDeCores.VERMELHO, 
				MapaDeCores.AMARELO, MapaDeCores.LARANJA, MapaDeCores.VERDE,
				MapaDeCores.AZUL, MapaDeCores.VIOLETA, MapaDeCores.CINZA, MapaDeCores.BRANCO});
		
		opcoesFaixa2 = new JComboBox<String>(new String [] {
				MapaDeCores.PRETO, MapaDeCores.MARROM, MapaDeCores.VERMELHO, 
				MapaDeCores.AMARELO, MapaDeCores.LARANJA, MapaDeCores.VERDE,
				MapaDeCores.AZUL, MapaDeCores.VIOLETA, MapaDeCores.CINZA, MapaDeCores.BRANCO});
		
		opcoesFaixa3 = new JComboBox<String>(new String [] {
				MapaDeCores.PRETO, MapaDeCores.MARROM, MapaDeCores.VERMELHO, 
				MapaDeCores.AMARELO, MapaDeCores.LARANJA, MapaDeCores.VERDE,
				MapaDeCores.AZUL, MapaDeCores.VIOLETA, MapaDeCores.CINZA, MapaDeCores.BRANCO});
		
		opcoesFaixa4 = new JComboBox<String>(new String [] { MapaDeCores.DOURADO, MapaDeCores.PRATEADO});
	}
	
	private void configurarTratamentoDeEventos() {
		calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Resistor resistor = calculadora.montarResistor(
							(String) opcoesFaixa1.getSelectedItem(), 
							(String) opcoesFaixa2.getSelectedItem(), 
							(String) opcoesFaixa3.getSelectedItem(),
							(String) opcoesFaixa4.getSelectedItem());
					JOptionPane.showMessageDialog(CalculadoraResistores.this, resistor.toString());
				} catch (NumeroDeFaixasIncorreto nfie) {
					nfie.printStackTrace();
				} catch (CorDePrecisaoInvalida cpie) {
					cpie.printStackTrace();
				} catch (CorDeBaseInvalida cbie) {
					cbie.printStackTrace();
				}
			}
		});
	}

	public void setCalculadora(CalculadoraDeResistencia calculadora) {
		this.calculadora = calculadora;
	}
}
