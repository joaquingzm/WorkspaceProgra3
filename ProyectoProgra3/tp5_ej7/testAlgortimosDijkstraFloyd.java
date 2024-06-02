package tp5_ej7;

import tp5.ejercicio1.listaAdy.AdjListGraph;
import tp5.ejercicio1.listaAdy.AdjListVertex;

/*
 * DUDA: No se supone que Dijsktra funciona para grafos sin ciclos?
 * Entiendo que en este caso funcione porque en los 2 ciclos que hay
 * el vertice desde donde se larga el algoritmo es parte y por lo tanto 
 * está marcado como visitado, pero si el ciclo de produciera entre otros
 * vertices sí daría error, no? */

public class testAlgortimosDijkstraFloyd {

	public static void main(String[] args) {
		AdjListGraph<Integer> grafo = new AdjListGraph<Integer>();
		crearGrafoDijkstra(grafo);
		AlgoritmosDijkstraFloyd<Integer> algoritmos = new AlgoritmosDijkstraFloyd<Integer>();
		int arr[] = algoritmos.dijkstra(grafo, 1);
		System.out.print("Posiciones:\n  ");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" , ");
		}
		System.out.println("\n\n");
		System.out.println(algoritmos.caminoMasCortoD(grafo, 1, 3));
	}
	
	public static void crearGrafoDijkstra(AdjListGraph<Integer> grafo) {
		
		AdjListVertex<Integer> v1 = (AdjListVertex<Integer>) grafo.createVertex(1);
		AdjListVertex<Integer> v2 = (AdjListVertex<Integer>) grafo.createVertex(2);
		AdjListVertex<Integer> v3 = (AdjListVertex<Integer>) grafo.createVertex(3);
		AdjListVertex<Integer> v4 = (AdjListVertex<Integer>) grafo.createVertex(4);
		AdjListVertex<Integer> v5 = (AdjListVertex<Integer>) grafo.createVertex(5);
		AdjListVertex<Integer> v6 = (AdjListVertex<Integer>) grafo.createVertex(6);
		
		grafo.connect(v1, v6,5);
		grafo.connect(v1, v5,10);
		grafo.connect(v1, v3,40);
		
		grafo.connect(v6, v5,10);
		grafo.connect(v6, v2,20);
		
		
		grafo.connect(v5, v4,20);
		
		//En el pdf v3 apunta tmb a v5, pero eso vuelve al grafo ciclico, así que no lo hago
		grafo.connect(v3, v5,5);
		grafo.connect(v3, v2,10);
		
		//En el pdf v2 apunta tmb a v4, pero eso vuelve al grafo ciclico, así que no lo hago
		grafo.connect(v2, v4,5);
		
		grafo.connect(v4, v3,5);
	}

}
