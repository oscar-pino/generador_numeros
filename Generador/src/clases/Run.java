
package clases;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {

		Generador generador = new Generador();
		Scanner in = new Scanner(System.in);
		int contador=0;
		int limite=0;
		String captura=null;

		do {
			contador = 1;
			
			do {
			System.out.print("\ningrese universo de números para sortear: ");
			captura = in.next();					
			
			if(generador.isNumero(captura)==Integer.MIN_VALUE)
				numeroEquivocado("letras");
			else if(generador.isNumero(captura)<0 & generador.isNumero(captura)!=Integer.MIN_VALUE)
				numeroEquivocado("menores");
			
			}while(generador.isNumero(captura)==Integer.MIN_VALUE | generador.isNumero(captura)<0 & generador.isNumero(captura)!=Integer.MIN_VALUE);
			
			generador.setlongitudRuleta(generador.isNumero(captura));
			
				
			do {
			System.out.print("\ningrese cantidad de números a generar: ");
			captura = in.next();
			
			if(generador.isNumero(captura)==Integer.MIN_VALUE)
				numeroEquivocado("letras");
			else if(generador.isNumero(captura)<0 & generador.isNumero(captura)!=Integer.MIN_VALUE)
				numeroEquivocado("menores");
			
			}while(generador.isNumero(captura)==Integer.MIN_VALUE | generador.isNumero(captura)<0 & generador.isNumero(captura)!=Integer.MIN_VALUE);
			
			generador.setLongitudSorteo(generador.isNumero(captura));
			
			do {
			System.out.print("\ningrese veces aleatorias: ");
			captura = in.next();
			
			if(generador.isNumero(captura)==Integer.MIN_VALUE)
				numeroEquivocado("letras");
			else if(generador.isNumero(captura)<0 & generador.isNumero(captura)!=Integer.MIN_VALUE)
				numeroEquivocado("menores");
			
			}while(generador.isNumero(captura)==Integer.MIN_VALUE | generador.isNumero(captura)<0 & generador.isNumero(captura)!=Integer.MIN_VALUE);
			
			limite = generador.isNumero(captura);
			
			do {
				System.out.print("\n(Sorteo N°: " + contador + ") Agua -> ");
				generador.generoAleatorios();
				System.out.println();
				contador++;

			} while (contador < limite);

			System.out.print("\nSorteo N° " + contador);
			System.out.print(" valido -> ");
			generador.generoAleatorios();

			System.out.println();
			System.out.print("\nordenados -> ");
			for (Integer v : generador.ordenaLista(generador.getSorteo())) {
				System.out.print("[" + v + "] ");
			}

			System.out.println();
			System.out.print("\nquieres probar nuevamente? (s/n): ");
			captura = in.next();

		} while (captura.toLowerCase().equals("s"));

		System.out.println();
		System.out.println("Gracias por elegir a Oscar Pino 2021");
	}
	
	public static void numeroEquivocado(String mensaje) {			
		
		if(mensaje.equalsIgnoreCase("letras")) {
			System.out.println("\n------------------------------------------");
			System.out.println("Debes ingresar solamente valores numericos");
			System.out.println("------------------------------------------");
		}else if(mensaje.equalsIgnoreCase("menores")){
			System.out.println("\n------------------------------------");
			System.out.println("Debes ingresar un valor mayor a cero");
			System.out.println("------------------------------------");
		}
		
	}

}
