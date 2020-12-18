package Competicion;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

class Vertice implements Comparable<Vertice> {
	public final String nombre;
	public Edge[] lista;
	public double minDistancia = Double.POSITIVE_INFINITY;
	public Vertice previous;

	public Vertice(String argName) {
		nombre = argName;
	}

	public String toString() {
		return nombre;
	}

	public int compareTo(Vertice otro) {
		return Double.compare(minDistancia, otro.minDistancia);
	}

}

class Edge {
	public final Vertice target;
	public final double peso;

	public Edge(Vertice argTarget, double argPeso) {
		target = argTarget;
		peso = argPeso;
	}
}

public class Dijkstra {
	public static void main(String[] args) {
		
		Vertice v0 = new Vertice("A");
		Vertice v1 = new Vertice("B");
		Vertice v2 = new Vertice("C");
		Vertice v3 = new Vertice("D");
		Vertice v4 = new Vertice("E");
		Vertice v5 = new Vertice("F");
		Vertice v6 = new Vertice("New F");
		v0.lista = new Edge[] { new Edge(v2, 61.55), new Edge(v3, 125.99) };
		v1.lista = new Edge[] { new Edge(v3, 122.48) };
		v2.lista = new Edge[] { new Edge(v4, 53),new Edge(v3, 61.65) };
		v3.lista = new Edge[] { new Edge(v5, 11.24)};
		v4.lista = new Edge[] { new Edge(v6, 117.21) };
		v5.lista = new Edge[] { new Edge(v6, 19.33)};
		v6.lista = new Edge[] { };
		Vertice[] vertices = { v0, v1, v2, v3, v4, v5, v6 };

		computePaths(v0);
		for (Vertice v : vertices) {
			System.out.println("Distancia " + v + ": " + v.minDistancia);
			List<Vertice> path = getShortestPathTo(v);
			System.out.println("Camino: " + path);
		}
		

	}

	public static void computePaths(Vertice fuente) {
		fuente.minDistancia = 0.;
		PriorityQueue<Vertice> ColaVerices = new PriorityQueue<Vertice>();
		ColaVerices.add(fuente);

		while (!ColaVerices.isEmpty()) {
			Vertice u = ColaVerices.poll();

			// Visit each edge exiting u
			for (Edge e : u.lista) {
				Vertice v = e.target;
				double peso = e.peso;
				double distancia = u.minDistancia + peso;
				if (distancia < v.minDistancia) {
					ColaVerices.remove(v);

					v.minDistancia = distancia;
					v.previous = u;
					ColaVerices.add(v);

				}

			}
		}
	}

	public static List<Vertice> getShortestPathTo(Vertice target) {
		List<Vertice> path = new ArrayList<Vertice>();
		for (Vertice verti = target; verti != null; verti = verti.previous)
			path.add(verti);

		Collections.reverse(path);
		return path;
	}
}