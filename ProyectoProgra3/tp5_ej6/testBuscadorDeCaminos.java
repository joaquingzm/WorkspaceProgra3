package tp5_ej6;

import tp5.ejercicio1.listaAdy.AdjListGraph;
import tp5.ejercicio1.listaAdy.AdjListVertex;

public class testBuscadorDeCaminos {

	public static void main(String[] args) {
		AdjListGraph<String> bosque = new AdjListGraph<String>();
		BuscadorDeCaminos<String> buscadorDeCaminos = new BuscadorDeCaminos<String>(bosque,5);
		crearBosque(bosque);
		bosque.printGraph();
		System.out.println(buscadorDeCaminos.recorridoMasSeguro("Casa Caperucita", "Casa Abuelita"));

	}

	public static void crearBosque(AdjListGraph<String> bosque) {
		
		AdjListVertex<String> casaCaperucita = (AdjListVertex<String>) bosque.createVertex("Casa Caperucita");
		AdjListVertex<String> claro1 = (AdjListVertex<String>) bosque.createVertex("Claro1");
		AdjListVertex<String> claro2 = (AdjListVertex<String>) bosque.createVertex("Claro2");
		AdjListVertex<String> claro3 = (AdjListVertex<String>) bosque.createVertex("Claro3");
		AdjListVertex<String> claro4 = (AdjListVertex<String>) bosque.createVertex("Claro4");
		AdjListVertex<String> claro5 = (AdjListVertex<String>) bosque.createVertex("Claro5");
		AdjListVertex<String> casaAbuelita = (AdjListVertex<String>) bosque.createVertex("Casa Abuelita");
		
		bosque.connectND(casaCaperucita, claro1, 3);
		bosque.connectND(casaCaperucita, claro2, 4);
		bosque.connectND(casaCaperucita, claro3, 4);
		
		bosque.connectND(claro5, claro1, 3);
		bosque.connectND(claro5, claro3, 15);
		bosque.connectND(claro5, claro2, 11);
		bosque.connectND(claro5, casaAbuelita, 4);
		
		bosque.connectND(claro2, claro4, 10);
		bosque.connectND(claro2, claro1, 4);
		
		bosque.connectND(claro4,casaAbuelita, 10);
		
		
		
	}
}
