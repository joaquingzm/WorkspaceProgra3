package tp5_ej6;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;
import tp5.ejercicio1.listaAdy.AdjListVertex;

public class BuscadorDeCaminos<T> {
	private AdjListGraph<T> bosque;
	private int cantidadFrutales;
	
	public BuscadorDeCaminos(AdjListGraph<T> bosque,int cantidadFrutales) {
		this.bosque=bosque;
		this.cantidadFrutales=cantidadFrutales;
	}
	
	public List<T> recorridoMasSeguro(T origen,T destino){
		LinkedList<T> lista = new LinkedList<T>();
		if(bosque!=null&!bosque.isEmpty()) {
			LinkedList<T> aux = new LinkedList<T>();
			boolean visitados[]= new boolean[bosque.getSize()];
			Vertex<T> origenV = bosque.search(origen);
			recorridoMasSeguro((AdjListVertex<T>)origenV,destino,(LinkedList<T>)lista,(LinkedList<T>)aux,visitados);
			
		}
		return lista;
	}
	private void recorridoMasSeguro(AdjListVertex<T> V,T ciudad2,LinkedList<T> lista,LinkedList<T> aux,boolean visitados[]){		
		visitados[V.getPosition()]=true;
		aux.add(V.getData());
		if(V.getData().equals(ciudad2)) {
			clonarLista(lista,aux);
		}
		else {
			for(Edge<T> auxE : V.getEdges()) {
				if(!visitados[auxE.getTarget().getPosition()]&&auxE.getWeight()<this.cantidadFrutales) {
					recorridoMasSeguro((AdjListVertex<T>)auxE.getTarget(),ciudad2,lista,aux,visitados);
					aux.removeLast();
					visitados[auxE.getTarget().getPosition()]=false;
				}
			}
		}
	}
	
	private void clonarLista(LinkedList<T> lista1,LinkedList<T> lista2) {
		for(T aux : lista2) {
			lista1.add(aux);
		}
	}
}
