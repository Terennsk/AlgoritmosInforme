package Algoritmo;

public class TestEjercicio {

	public static void main(String[] args) {
		long matrizA[][] = { { 0, (long) 61.55, (long) 125.29, 999999999, 999999999, 999999999, 999999999 },
				{ 999999999, 0, 999999999, (long) 122.48, 999999999, 999999999, 999999999 },
				{ 999999999, 999999999, 0, (long) 61.65, 53, 999999999, 999999999 },
				{ 999999999, 999999999, 999999999, 0, 999999999, (long) 41.24, 999999999 },
				{ 999999999, 999999999, 999999999, 999999999, 0, 999999999, (long) 117.91 },
				{ 999999999, 999999999, 999999999, 999999999, 999999999, 0, (long) 19.33 },
				{ 999999999, 999999999, 999999999, 999999999, 999999999, 999999999, 0 } };
		long TInicio, TFin, tiempo; // Variables para determinar el tiempo de ejecución
		TInicio = System.currentTimeMillis();
		Ejercicio ruta = new Ejercicio();
		System.out.println(ruta.algortimoFloyd(matrizA));
		TFin = System.currentTimeMillis(); // Tomamos la hora en que finalizó el algoritmo y la almacenamos en la
											// variable T
		tiempo = TFin - TInicio; // Calculamos los milisegundos de diferencia
		System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); // Mostramos en pantalla el tiempo de
																				// ejecución en milisegundos

	}
}
