package br.com.gregoriohd.method.references;

import java.util.ArrayList;
import java.util.List;

interface Figura2D {
	void desenha(Double largura, Double altura);
}

class Retangulo {
	public void desenhaRetangulo(Double largura, Double altura) {
		System.out.println("Desenho retangulo - Largura: " + largura + " Altura: " + altura);
	}
}

class Retangulo2 {
	public static void desenhaRetangulo2(Double largura, Double altura) {
		System.out.println("Desenho retangulo - Largura: " + largura + " Altura: " + altura);
	}
}

class Retangulo3 {
	public void desenhaRetangulo3(Double largura, Double altura) {
		System.out.println("Desenho retangulo - Largura: " + largura + " Altura: " + altura);
	}
}
interface Imagem2D {
	Quadrado desenha(Double base, Double altura);
}

class Quadrado {
	public Quadrado(Double base, Double altura) {
		System.out.println("Desenho quadrado - Base: " + base + " Altura: " + altura);
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
		// method references por construtor
		Imagem2D img = Quadrado::new;
		img.desenha(5.0, 5.0);

		// exemplificar caracteristicas do uso comum(calsse anonima) para lambda e para
		// mthod references
		Figura2D fig3 = new Figura2D() {

			@Override
			public void desenha(Double largura, Double altura) {
				System.out.println("Anonimas " + largura + " " + altura);

			}
		};
		fig3.desenha(10.2, 5.0);
		
		Figura2D fig4 = (largura, altura) -> System.out.println("Lambda " + altura + " " + largura);
		fig4.desenha(2.0, 5.8);
		
		Figura2D fig5 = Retangulo2::desenhaRetangulo2;
		fig5.desenha(2.9, 9.9);
		
		Retangulo3 rt = new Retangulo3();
		Figura2D fig6 = rt::desenhaRetangulo3;
		fig6.desenha(9.9, 1.11);

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
