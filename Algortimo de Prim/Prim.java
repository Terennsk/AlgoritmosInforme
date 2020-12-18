package Algoritmo;

public class Prim {

	public static void main(String args[]) {
		long TInicio, TFin, tiempo; // Variables para determinar el tiempo de ejecución
		TInicio = System.currentTimeMillis();
		int graph[][] = new int[][] { { 0, (int) 61.53, (int) 125.89, 0, 0, 0, 0 },
				{ (int) 61.53, 0, 0, (int) 122.48, 0, 0, 0 }, { (int) 125.89, 0, 0, (int) 61.65, (int) 53, 0, 0 },
				{ 0, (int) 122.48, (int) 61.65, 0, 0, (int) 11.24, 0 }, { 0, 0, (int) 53, 0, 0, 0, (int) 117.21 },
				{ 0, 0, 0, (int) 11.24, 0, 0, (int) 19.33 }, { 0, 0, 0, 0, (int) 117.21, (int) 19.33, 0 } };

		int visited[] = new int[7];
		int min = 999;
		int u = 0;
		int v = 0;
		int total = 0;

		for (int i = 0; i < 7; i++) {
			visited[i] = 0;
			for (int j = 0; j < 7; j++) {
				if (graph[i][j] == 0) {
					graph[i][j] = 999;
				}
			}
		}
		visited[0] = 1;
		for (int counter = 0; counter < 6; counter++) {
			min = 999;
			for (int i = 0; i < 7; i++) {
				if (visited[i] == 1) {
					for (int j = 0; j < 7; j++) {
						if (visited[j] == 0) {
							if (min > graph[i][j]) {
								min = graph[i][j];
								u = i;
								v = j;
							}
						}
					}
				}
			}
			visited[v] = 1;
			total = total + min;
			System.out.println("Camino : " + u + "--->" + v + ":" + min);
		}
		System.out.println("Total del camino recorrido " + total);
		TFin = System.currentTimeMillis(); // Tomamos la hora en que finalizó el algoritmo y la almacenamos en la
											// variable T
		tiempo = TFin - TInicio; // Calculamos los milisegundos de diferencia
		System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
	}
}