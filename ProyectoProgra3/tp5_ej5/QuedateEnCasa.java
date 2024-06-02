package tp5_ej5;

import java.util.LinkedList;
import java.util.List;

import tp1_ej8.DoubleEndedQueue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.listaAdy.AdjListEdge;
import tp5.ejercicio1.listaAdy.AdjListGraph;
import tp5.ejercicio1.listaAdy.AdjListVertex;

public class QuedateEnCasa {
	
	public List<Persona> algoritmoDistanciaMenor(AdjListGraph<Persona> grafo,AdjListVertex<Persona> empleado,int grado,int maxLenLista){
		if(grafo!=null&&!grafo.isEmpty()) {
			DoubleEndedQueue<Edge<Persona>> cola = new DoubleEndedQueue<Edge<Persona>>();
			List<Edge<Persona>> listaE = empleado.getEdges();
			boolean visitados[]= new boolean[grafo.getSize()];
			List<Persona> listaR = new LinkedList<Persona>();
			Edge<Persona> act = new AdjListEdge<Persona>(empleado,1);
			
			
			cola.enqueue(act);
			cola.enqueue(null);
			
			while(!cola.is_empty()&&grado>=0) {
				act = cola.dequeue();
				if(act!=null) {
					if(act.getTarget().getData().esJubilado()&&!act.getTarget().getData().jubilacionPercibida()) {
						listaR.add(act.getTarget().getData());
					}
					if(listaR.size()>=maxLenLista)break;
					listaE = ((AdjListVertex<Persona>) act.getTarget()).getEdges();
					for(Edge<Persona> e : listaE) {
						if(!visitados[e.getTarget().getPosition()]) {
							cola.enqueue(e);
							visitados[e.getTarget().getPosition()]=true;
						}
					}
				}
				else {
					if(!cola.is_empty()) {
						cola.enqueue(null);
						grado--;
					}
				}
			}
			
			
			return listaR;
		}
		return null;
	}
}
