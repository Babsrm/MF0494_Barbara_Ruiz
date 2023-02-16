package uf2178;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Barbara Ruiz
 *
 */
public class Ppal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Escribe aqu� las sentencias del apartado 3
		Scanner teclado = new Scanner(System.in);
		double tasa = 0;
		int puntos [] = new int [6];
		int sanciones[] = new int [6];
		
		
		System.out.println("Este programa calculará la sanción que le pertenece a un conductor según su tasa de alcoholemia.");
		System.out.println("Introduzca la tasa de alcoholemia: ");
		tasa = teclado.nextDouble();
		
		while (tasa<0) {
			System.out.println("El valor introducido no es válido.");
			System.out.println("Introduzca un valor positivo.");
			tasa = teclado.nextDouble();	
		} 		
		Funciones.calculaSancion(tasa);
		
		System.out.println("A continuación, es necesario que introduzca dos vectores de 6 elementos.");
		System.out.println("Introduzca los valores del vector puntos:");
		Funciones.pedir_vector(puntos);
		System.out.println("Introduzca los valores del vector sanciones:");
		Funciones.pedir_vector(sanciones);
		
		System.out.println("Los vectores introducidos son:"
				+ "\nvector puntos: ");
		Funciones.mostrar_vector(puntos);
		System.out.println("\nvector sanciones: ");
		Funciones.mostrar_vector(sanciones);
		
		System.out.println("Se va a proceder a aplicar la resta de puntos. El resultado es: ");
		Funciones.mostrar_vector(Funciones.restaPuntos(puntos, sanciones));
	}

}
