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
			Vertex<T> origen = grafo.search(ciudad1);
			devolverCaminoP((AdjListVertex<T>)origen,ciudad2,(LinkedList<T>)lista,(LinkedList<T>)aux,visitados);
			
		}
		return lista;
	}
	private void devolverCaminoP(AdjListVertex<T> V,T ciudad2,LinkedList<T> lista,LinkedList<T> aux,boolean visitados[]){		
		visitados[V.getPosition()]=true;
		aux.add(V.getData());
		if(V.getData()==ciudad2) {
			clonarLista(lista,aux);
		}
		else {
			for(Edge<T> auxE : V.getEdges()) {
				if(!visitados[auxE.getTarget().getPosition()]) {
					devolverCaminoP((AdjListVertex<T>)auxE.getTarget(),ciudad2,lista,aux,visitados);
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
	
	
	
	
	public List<T> devolverCaminoExceptuando(T ciudad1,T ciudad2,LinkedList<T> ciudades){
		LinkedList<T> lista = new LinkedList<T>();
		if(grafo!=null&!grafo.isEmpty()) {
			LinkedList<T> aux = new LinkedList<T>();
			boolean visitados[]= new boolean[grafo.getSize()];
			Vertex<T> origen = grafo.search(ciudad1);
			devolverCaminoExceptuandoP((AdjListVertex<T>)origen,ciudad2,lista,aux,ciudades,visitados);
			
		}
		return lista;
	}
	private void devolverCaminoExceptuandoP(AdjListVertex<T> V,T ciudad2,LinkedList<T> lista,LinkedList<T> aux,LinkedList<T> ciudades,boolean visitados[]){		
		visitados[V.getPosition()]=true;
		aux.add(V.getData());
		if(V.getData()==ciudad2) {
			clonarLista(lista,aux);
		}
		else {
			for(Edge<T> auxE : V.getEdges()) {
				if(!visitados[auxE.getTarget().getPosition()]&&!ciudades.contains(auxE.getTarget().getData())) {
					devolverCaminoP((AdjListVertex<T>)auxE.getTarget(),ciudad2,lista,aux,visitados);
					aux.removeLast();
				}
				if(!lista.isEmpty())break;
			}
		}
	}
	
	
	
	public List<T> caminoMasCorto(T ciudad1,T ciudad2){
		LinkedList<T> lista = new LinkedList<T>();
		if(grafo!=null&!grafo.isEmpty()) {
			Integer distanciaLista = 9999;
			LinkedList<T> aux = new LinkedList<T>();
			boolean visitados[]= new boolean[grafo.getSize()];
			Vertex<T> origen = grafo.search(ciudad1);
			distanciaLista = caminoMasCortoP((AdjListVertex<T>)origen,ciudad2,lista,aux,visitados,distanciaLista,0);
			
		}
		return lista;
	}
	private int caminoMasCortoP(AdjListVertex<T> V,T ciudad2,LinkedList<T> lista,LinkedList<T> aux,boolean visitados[],Integer distanciaLista,int distanciaAux){		
		visitados[V.getPosition()]=true;
		aux.add(V.getData());
		/*
		 * Como contemplo pesos negativos, solamente al llegar a destino
		 * compruebo si el costo de mi recorrido candidato (Aux) fue
		 * menor al mejor recorrido hasta el momento (Lista)
		 */
		if(V.getData()==ciudad2&&distanciaLista>distanciaAux) {
			lista.clear();
			clonarLista(lista,aux);
			return distanciaAux;
		}
		else {
			for(Edge<T> auxE : V.getEdges()) {
				/*
				 * En el caso de grafos sin peso negativo se puede agregar a la condición
				 * que la suma del peso al target + distanciaAux sea menor a distanciaLista.
				 * En este caso como quería probar con pesos negativos largo el recorrido
				 * por todo el árbol porque nunca se sabe si el último peso es negativo y
				 * termina siendo mejor que los recorridos anteriores por más que al principio
				 * pareciera que no
				 */
				if(!visitados[auxE.getTarget().getPosition()]) {
					distanciaLista = caminoMasCortoP((AdjListVertex<T>)auxE.getTarget(),ciudad2,lista,aux,visitados,distanciaLista,distanciaAux+auxE.getWeight());
					aux.removeLast();
					/*
					 * Cuando vuelvo del vertice visitado desde v1 lo vuelvo a marcar como no visitado para el
					 * caso de que el siguiente vertice v3 esté conectado al anterior(v2) y
					 * el costo sea menor al que probé yendo directamente desde v1 a v2
					 */
					visitados[auxE.getTarget().getPosition()]=false;
				}
			}
		}
		return distanciaLista;
	}
	
	
	
	/*
	 * Asumo que el peso de las aristas
	 * es directamente proporcional al
	 * consumo de combustible
	 */
	public List<T> caminoSinCargarCombustible(T ciudad1,T ciudad2,int combustible){
		LinkedList<T> lista = new LinkedList<T>();
		if(grafo!=null&!grafo.isEmpty()) {
			LinkedList<T> aux = new LinkedList<T>();
			boolean visitados[]= new boolean[grafo.getSize()];
			Vertex<T> origen = grafo.search(ciudad1);
			caminoSinCargarCombustibleP((AdjListVertex<T>)origen,ciudad2,(LinkedList<T>)lista,(LinkedList<T>)aux,visitados,-1,combustible);
			
		}
		return lista;
	}
	private int caminoSinCargarCombustibleP(AdjListVertex<T> V,T ciudad2,LinkedList<T> lista,LinkedList<T> aux,boolean visitados[],int combustibleRestanteL,int combustibleRestanteA){		
		visitados[V.getPosition()]=true;
		aux.add(V.getData());
		if(V.getData()==ciudad2&&combustibleRestanteA>combustibleRestanteL) {
			lista.clear();
			clonarLista(lista,aux);
			return combustibleRestanteA;
		}
		else {
			for(Edge<T> auxE : V.getEdges()) {
				if(!visitados[auxE.getTarget().getPosition()]&&(combustibleRestanteA-auxE.getWeight()>=0)) {
					combustibleRestanteL = caminoSinCargarCombustibleP((AdjListVertex<T>)auxE.getTarget(),ciudad2,lista,aux,visitados,combustibleRestanteL,combustibleRestanteA-auxE.getWeight());
					aux.removeLast();
					visitados[auxE.getTarget().getPosition()]=false;
				}
			}
		}
		return combustibleRestanteL;
	}
	
	
	public List<T> caminoConMenorCargaDeCombustible(T ciudad1,T ciudad2,int capacidadTanque){
		LinkedList<T> lista = new LinkedList<T>();
		if(grafo!=null&!grafo.isEmpty()) {
			LinkedList<T> aux = new LinkedList<T>();
			boolean visitados[]= new boolean[grafo.getSize()];
			Vertex<T> origen = grafo.search(ciudad1);
			caminoConMenorCargaDeCombustibleP((AdjListVertex<T>)origen,ciudad2,(LinkedList<T>)lista,(LinkedList<T>)aux,visitados,999,0,capacidadTanque,capacidadTanque);
			
		}
		return lista;
	}
	private int caminoConMenorCargaDeCombustibleP(AdjListVertex<T> V,T ciudad2,LinkedList<T> lista,LinkedList<T> aux,boolean visitados[],int cantCargasL,int cantCargasA,int capacidadTanque,int combustibleRestante){		
		visitados[V.getPosition()]=true;
		aux.add(V.getData());
		if(V.getData()==ciudad2) {
			lista.clear();
			clonarLista(lista,aux);
			return cantCargasA;
		}
		else if(cantCargasA<cantCargasL){
			for(Edge<T> auxE : V.getEdges()) {
				if(!visitados[auxE.getTarget().getPosition()]&&auxE.getWeight()<capacidadTanque) {
					if((combustibleRestante-auxE.getWeight())<0) {
						cantCargasL = caminoConMenorCargaDeCombustibleP((AdjListVertex<T>)auxE.getTarget(),ciudad2,lista,aux,visitados,cantCargasL,cantCargasA+1,capacidadTanque,capacidadTanque-auxE.getWeight());
					}
					else {
						cantCargasL = caminoConMenorCargaDeCombustibleP((AdjListVertex<T>)auxE.getTarget(),ciudad2,lista,aux,visitados,cantCargasL,cantCargasA,capacidadTanque,combustibleRestante-auxE.getWeight());
					}
					aux.removeLast();
					visitados[auxE.getTarget().getPosition()]=false;
				}
			}
		}
		return cantCargasL;
	}
}
