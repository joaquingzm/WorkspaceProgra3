package tp5_ej2;
import java.util.List;

import tp5_ej1ListAdy.EdgeListAdy;
import tp5_ej1ListAdy.GraphListAdy;
import tp5_ej1ListAdy.VertexListAdy;

import java.util.LinkedList;

public class Recorridos<T> {
	
	public List<T> dfs(GraphListAdy<T> grafo){
		LinkedList<T> aux = new LinkedList<T>();
		boolean visitados[]= new boolean[grafo.getSize()];
		int i;
		for(i=0;i<grafo.getSize();i++) {
			if(!visitados[i]) {
				dfsP(grafo.getVertices(),visitados,aux);
		
			}
		}
	}
	
	private void dfsP(List<VertexListAdy<T>> listV,boolean[] visitados,List<T> listD) {
		for(VertexListAdy<T> auxV : listV) {
			listD.add(auxV.getData());
			if(!visitados[auxV.getPosition()]) {
				visitados[auxV.getPosition()]=true;
				dfsP(auxV.getVertexList(),visitados,)
			}
		}
	}
	
public List<T> Bfs(GraphListAdy<T> grafo){
		
	}
}
