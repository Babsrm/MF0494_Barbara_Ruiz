package uf2178;

import java.util.Scanner;

public class Funciones {
	
	/** 
	 * M�todo de la clase que pide un vector por teclado
	 * @param v int[] el vector a introducir por teclado
	 */
	public static void  pedir_vector(int v[]) {
		Scanner entrada = new Scanner(System.in);
		
		for (int i = 0; i < v.length; i++) {
			System.out.printf("Introduce el elemento %d: ", i);
			v[i] = entrada.nextInt();
		}
	}
	
	/**
	 * M�todo para mostrar por pantalla el vector pasado como par�metro
	 * @param v int [] el vector a mostrar en pantalla
	 */
	public static void  mostrar_vector(int v[]) {
		for (int i = 0; i < v.length; i++) {
			System.out.printf("%d ", v[i]);
		}
		System.out.println();
	}
	
	// Escribe las sentencias de los apartados 1 y 2
	
	public static void calculaSancion (double tasaAlcoholemia) {
		String sancion = "";
		
		if (tasaAlcoholemia<0) {
			System.err.println("El valor introducido ha de ser positivo. Vuelva a intentarlo.");
			System.exit(-1);
		}
				
		if (tasaAlcoholemia<0.25) {
			sancion = "sin sanción";
		} else if (tasaAlcoholemia < 0.5) {
			sancion = "500€ y pérdida de 4 puntos";
		} else if (tasaAlcoholemia<0.6) {
			sancion = "1000€ y pérdida de 6 puntos";
		} else {
			sancion = "retirada del carnet y de 3 a 6 meses de cárcel";
		}
		
		System.out.println("El conductor con tasa de alcoholemia "
				+ String.format("%.2f",tasaAlcoholemia) +" tiene la sanción: "
				+ sancion +".");
	}
	
	public static int [] restaPuntos (int puntos[], int sanciones[]) {
		if (puntos.length != sanciones.length) {
			System.err.println("Los índices de los arrays son diferentes. Vuelva a intentarlo de nuevo. El programa se cerrará. ");
			return null;}
		int arrayResta[] = new int [puntos.length];
		for (int i = 0; i < arrayResta.length; i++) {
			arrayResta[i] = puntos[i] - sanciones[i];
			
			if (arrayResta[i]<0) {
				arrayResta[i] = 0;
			}
			}
		return arrayResta;
}}
