package tp5_ej3;

import tp5.ejercicio1.listaAdy.AdjListVertex;
import tp5_ej1ListAdy.GraphListAdy;
import tp5.ejercicio1.listaAdy.AdjListGraph;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListEdge;

import java.util.LinkedList;
import java.util.List;

import tp1_ej8.DoubleEndedQueue;


public class Mapa<T> {
	private AdjListGraph<T> grafo;
	
	public void setGrafo(AdjListGraph<T> grafo) {
		this.grafo=grafo;
	}
	
	
	public List<T> devolverCamino(T ciudad1,T ciudad2){
		LinkedList<T> lista = new LinkedList<T>();
		if(grafo!=null&!grafo.isEmpty()) {
			LinkedList<T> aux = new LinkedList<T>();
			boolean visitados[]= new boolean[grafo.getSize()];
			int i;
			grafo.search(ciudad1)
			/*
			 * Terminar, tener en cuenta que primero tengo que encontrar el vertice origen para iniciar
			 * la busqueda del camino
			 * */
			devolverCaminoP((AdjListVertex<T>)grafo.getVertices(),ciudad1,ciudad2,(LinkedList<T>)lista,(LinkedList<T>)aux,visitados);
			
		}
		return lista;
	}
	private void devolverCaminoP(AdjListVertex<T> V,T ciudad1,T ciudad2,LinkedList<T> lista,LinkedList<T> aux,boolean visitados[]){
		visitados[V.getPosition()]=true;
		aux.add(V.getData());
		if(V.getData()==ciudad1||V.getData()==ciudad2)
		for(Edge<T> auxE : V.getEdges()) {
			if(!visitados[auxE.getTarget().getPosition()]) {
				devolverCaminoP((AdjListVertex<T>)auxE.getTarget(),ciudad1,ciudad2,lista,aux,visitados);
				aux.removeLast();
			}
		}
	}
}
