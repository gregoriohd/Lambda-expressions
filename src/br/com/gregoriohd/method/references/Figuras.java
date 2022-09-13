package br.com.gregoriohd.method.references;

import java.util.ArrayList;
import java.util.List;

interface Figura2D {
	void desenha(Double largura, Double altura);
}

class Retangulo {
	public void desenhaRetangulo(Double largura, Double altura) {
		System.out.println("Denho retangulo - Largura: " + largura + " Altura: " + altura);
	}
}

interface Imagem2D {
	Quadrado desenha(Double base, Double altura);
}

class Quadrado {
	public Quadrado(Double base, Double altura) {
		System.out.println("Denho quadrado - Base: " + base + " Altura: " + altura);
	}
}

class Produtos {
	private String nome;
	private Double preco;

	public Produtos(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void imprimir() {
		System.out.println("Produtos " + getNome() + " - " + getPreco());
	}

}

class Impressora {
	public static void imprimir(Produtos p) {
		System.out.println(p.getNome() + " - " + p.getPreco());
	}
}

public class Figuras {

	public void criarFiguras() {
		// lambda expression
		Figura2D fig1 = (largura, altura) -> System.out.println("Figura - Largura: " + largura + " Altura: " + altura);
		fig1.desenha(8.0, 1.8);

		// method references por objeto especifico
		Retangulo retangulo = new Retangulo();
		Figura2D fig2 = retangulo::desenhaRetangulo;
		fig2.desenha(5.0, 2.5);

		Imagem2D img = Quadrado::new;
		img.desenha(5.0, 5.0);

	}

	public void executarImpressao() {
		List<Produtos> lista = new ArrayList<Produtos>();

		lista.add(new Produtos("TV 42", 2000.00));
		lista.add(new Produtos("Geladeira 470L", 4000.00));
		lista.add(new Produtos("Fogão 4 Bocas", 900.00));
		lista.add(new Produtos("VideoGame", 500.00));
		lista.add(new Produtos("Microondas", 200.00));

		// lambda expression
		lista.forEach((p) -> System.out.println("Imprimir valores : " + p.getNome() + " " + p.getPreco()));
		// method references chamando metodo estatico
		lista.forEach(Impressora::imprimir);
		// method references instancia de clase de um metodo especifico
		lista.forEach(Produtos::imprimir);

	}
}
