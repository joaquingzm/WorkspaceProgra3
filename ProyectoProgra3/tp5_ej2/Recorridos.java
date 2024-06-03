package tp5_ej2;
import java.util.List;

import tp5.ejercicio1.listaAdy.AdjListVertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Vertex;
import tp1_ej8.DoubleEndedQueue;


import java.util.LinkedList;

public class Recorridos<T> {
	
	public List<T> dfs(AdjListGraph<T> grafo){
		if(grafo!=null&&!grafo.isEmpty()) {
			LinkedList<T> aux = new LinkedList<T>();
			boolean visitados[]= new boolean[grafo.getSize()];
			int i;
			for(i=0;i<grafo.getSize();i++) {
				if(!visitados[i]) {
					dfsP((AdjListVertex<T>) grafo.getVertices().get(i),visitados,aux);
				}
			}
			return aux;
		}
		return null;
	}
	
	private void dfsP(AdjListVertex<T> V,boolean[] visitados,List<T> listD) {
		visitados[V.getPosition()]=true;
		listD.add(V.getData());
		for(Edge<T> auxE : V.getEdges()) {
			if(!visitados[auxE.getTarget().getPosition()]) {
				dfsP((AdjListVertex<T>)auxE.getTarget(),visitados,listD);
			}
		}
	}
	
	public List<T> Bfs(AdjListGraph<T> grafo){
		if(grafo!=null&&!grafo.isEmpty()) {
			DoubleEndedQueue<Vertex<T>> cola = new DoubleEndedQueue<Vertex<T>>();
			List<Vertex<T>> listaV = grafo.getVertices();
			List<Edge<T>> listaE;
			boolean visitados[]= new boolean[grafo.getSize()];
			List<T> listaR = new LinkedList<T>();
		
			Vertex<T> act;
			for(int j=0;j<listaV.size();j++) {
				if(!visitados[listaV.get(j).getPosition()]) {
					cola.enqueue(listaV.get(j));
					while(!cola.is_empty()) {
						act = cola.dequeue();
						listaR.add(act.getData());
						listaE = grafo.getEdges(act);
						for(Edge<T> e : listaE) {
							if(!visitados[e.getTarget().getPosition()]) {
								cola.enqueue(e.getTarget());
								visitados[e.getTarget().getPosition()]=true;
							}
						}
					}
				}
			}
			return listaR;
		}
		return null;
	}
	
}
