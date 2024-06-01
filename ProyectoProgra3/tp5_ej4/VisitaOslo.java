package tp5_ej4;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;
import tp5.ejercicio1.listaAdy.AdjListVertex;

public class VisitaOslo<T> {
	
	
	
	public List<T> paseoEnBici(AdjListGraph<T> grafo,T ciudad1,T ciudad2,LinkedList<T> ciudades,int maxTiempo){
		LinkedList<T> lista = new LinkedList<T>();
		if(grafo!=null&!grafo.isEmpty()) {
			LinkedList<T> aux = new LinkedList<T>();
			boolean visitados[]= new boolean[grafo.getSize()];
			Vertex<T> origen = grafo.search(ciudad1);
			paseoEnBiciP((AdjListVertex<T>)origen,ciudad2,lista,aux,ciudades,visitados,maxTiempo);
			
		}
		return lista;
	}
	private void paseoEnBiciP(AdjListVertex<T> V,T ciudad2,LinkedList<T> lista,LinkedList<T> aux,LinkedList<T> ciudades,boolean visitados[],int tiempoRestante){		
		visitados[V.getPosition()]=true;
		aux.add(V.getData());
		if(V.getData().equals(ciudad2)) {
			clonarLista(lista,aux);
		}
		else {
			for(Edge<T> auxE : V.getEdges()) {
				if(!visitados[auxE.getTarget().getPosition()]&&!estaEnLista(auxE.getTarget().getData(),ciudades)&&(tiempoRestante-auxE.getWeight()>=0)) {
					paseoEnBiciP((AdjListVertex<T>)auxE.getTarget(),ciudad2,lista,aux,ciudades,visitados,tiempoRestante-auxE.getWeight());
					aux.removeLast();
				}
				if(!lista.isEmpty())break;
			}
		}
	}
	
	private void clonarLista(LinkedList<T> lista1,LinkedList<T> lista2) {
		for(T aux : lista2) {
			lista1.add(aux);
		}
	}
	
	private boolean estaEnLista(T s,List<T> l) {
		for(T e : l) {
			if(e.equals(s))return true;
		}
		return false;
	}
}
