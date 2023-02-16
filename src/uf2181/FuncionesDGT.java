package uf2181;

/**
 * Librería de funciones necesarias para el proyecto MF0494
 * @author Barbara Ruiz
 *
 */
public class FuncionesDGT {
	
	/**
	 * Función que, dado un vector de enteros con los puntos de los conductores, devuelve la media de puntos de ese vector.
	 * @param puntos int puntos del carnet de conducir.
	 * @return double devuelve la media de los puntos del array.
	 * @throws ArrayIndexOutOfBoundsException Cuando el vector tiene una logitud igual a 0.
	 */
	public double mediaPuntos(int puntos[]) {
		double suma = 0;
		
		for (int i = 0; i < puntos.length; i++) {
			suma = suma +puntos[i];
		}
		if (puntos.length==0) throw new ArrayIndexOutOfBoundsException();
		return suma/puntos.length;
	}
	
	/**
	 * Función a la que le pasamos dos parámetros: tipo de conductor y aire. El logaritmo calcula, en base a un baremo, cuál es la tasa máxima permitida según el tipo de conductor y si la prueba ha sido por aire expirado(true) o por sangre(false).
	 * @param tipoConductor String Se debe de indicar si el conductor es General o es Novel(o profesional).
	 * @param aire boolean Se indica true cuando la prueba efectuada haya sido por aire expirado. Se indica false cuando la prueba efectuada haya sido por análisis de sangre.
	 * @return double Devuelve la tasa máxima permitida de alcohol por aire expirado o por sangre según su parámetro introducido.
	 */
	public double maximaTasaPermitida(String tipoConductor, boolean aire) {
		double tasa=0.25;
		if (tipoConductor.equalsIgnoreCase("General")) {
			if (aire) {
				tasa=0.25;
			} else {
				tasa=0.5;
			}
		} else {
			// profesionales y noveles
			if (aire) {
				tasa=0.15;
			} else {
				tasa=0.3;
			}
		}
		return tasa;
	}

	
}
