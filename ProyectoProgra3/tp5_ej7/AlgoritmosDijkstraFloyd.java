package tp5_ej7;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;
import tp5.ejercicio1.listaAdy.AdjListVertex;

public class AlgoritmosDijkstraFloyd<T> {
	
	public List<T> caminoMasCortoD(AdjListGraph<T> grafo,T origen,T destino){
		LinkedList<T> listaR = new LinkedList<T>();
		if(grafo!=null&&!grafo.isEmpty()) {
			int arr[] = dijkstra(grafo,origen);
			List<Vertex<T>> listaV = (List<Vertex<T>>) grafo.getVertices();
			listaR.addFirst(destino);
			int auxPos = arr[grafo.search(destino).getPosition()];
			while(listaV.get(auxPos)!=grafo.search(origen)) {
				listaR.addFirst(listaV.get(auxPos).getData());
				auxPos = arr[auxPos];
			}
			listaR.addFirst(origen);
		}
		return listaR;
	}
	
	public int[] dijkstra(AdjListGraph<T> grafo,T origen){
		if(grafo!=null&&!grafo.isEmpty()) {
			AdjListVertex<T> origenV = (AdjListVertex<T>) grafo.search(origen);
			AdjListVertex<T> auxV;
			boolean visitados[] = new boolean[grafo.getSize()];
			int costos[] = new int[grafo.getSize()];
			for(int i=0;i<grafo.getSize();i++) {
				costos[i]=9999;
			}
			//Posiciones del vertice desde donde se viene
			int[] puntosDePartida = new int[grafo.getSize()];
			
			costos[origenV.getPosition()]=0;
			puntosDePartida[origenV.getPosition()]=0;
			
			while(faltanVisitar(visitados)) {
				auxV = (AdjListVertex<T>) grafo.getVertices().get(posDelMenorCostoNoVisitado(costos,visitados));
				visitados[auxV.getPosition()]=true;
				for(Edge<T> e : auxV.getEdges()) {
					if(!visitados[e.getTarget().getPosition()]) {
						if(costos[auxV.getPosition()]+e.getWeight()<costos[e.getTarget().getPosition()]) {
							costos[e.getTarget().getPosition()]=costos[auxV.getPosition()]+e.getWeight();
							puntosDePartida[e.getTarget().getPosition()]=auxV.getPosition();
						}
					}
				}
			}
			return puntosDePartida;
		}
		
		return null;
	}
	
	public boolean faltanVisitar(boolean visitados[]) {
		for(int i=0;i<visitados.length;i++) {
			if(!visitados[i])return true;
		}
		return false;
	}
	
	public int posDelMenorCostoNoVisitado(int costos[],boolean visitados[]) {
		int minCosto=9999;
		int minPos=0;
		for(int i=0;i<costos.length;i++) {
			if(!visitados[i]&&costos[i]<minCosto) {
				minCosto=costos[i];
				minPos=i;
			}
		}
		return minPos;
	}
	
	
}
