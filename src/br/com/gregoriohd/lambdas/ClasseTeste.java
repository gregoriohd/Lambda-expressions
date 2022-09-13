package br.com.gregoriohd.lambdas;

import br.com.gregoriohd.method.references.Figuras;

public class ClasseTeste {

	public static void main(String[] args) {
//		InterfaceExemplo1 ex1 = () -> System.out.println("exemplo 1");
//		ex1.exemplo1();
//
//		InterfaceExemplo2 ex2 = messagem -> System.out.println("Exemplo 2 " + messagem);
//		ex2.exemplo2("Com argumentos");
//		
//		InterfaceExemplo3 ex3 = () ->  "Exemplo 3 com retono";
//		System.out.println(ex3.exemplo3());
//		
//		InterfaceExemplo4 ex4 = mensagem ->  "Exemplo 4 " + mensagem;
//		System.out.println(ex4.exemplo4("Com argumento e com retorno"));
//		
//		InterfaceExemplo5 ex5 = (nome, idade) -> "Exemplo 5Nome " + nome + " idade: "+ idade ;
//		System.out.println(ex5.exemplo6("Gregorio", 34));
		
		Figuras figs = new Figuras();
		figs.criarFiguras();
		figs.executarImpressao();
	}

}
