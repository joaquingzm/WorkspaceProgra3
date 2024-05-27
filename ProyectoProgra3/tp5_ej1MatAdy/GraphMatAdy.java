package tp5_ej1MatAdy;

import java.util.List;

/*
 * Decidí no implementar la clase Edge porque con la matriz de enteros
 * puedo conocer el peso de un Edge que hay entre vertice y vertice, y
 * asociando a cada posicion de la lista una fila en la matriz puedo conocer
 * la posicion del vertice en la lista del que estoy averiguando si hay camino
 * a otro vertice de otra posicion en la lista y cual es su peso
 * 
 * Cada que un nuevo elemento es agregado o removido creo una nueva
 * matriz, no es lo más eficiente en temas de tiempo de ejecución
 * pero sí en simplicidad y cantidad de código*/

public class GraphMatAdy<T> implements GraphIntMatAdy<T> {
	private List<VertexMatAdy<T>> vertexList;
	private int matAdy[][];
	private int matDim;
	
	@Override
	public VertexMatAdy<T> createVertex(T data) {
		VertexMatAdy<T> aux = new VertexMatAdy<T>();
		vertexList.add(aux);
		this.matAdy=createMat(vertexList,matAdy);
		return aux;
	}

	@Override
	public void removeVertex(VertexMatAdy<T> vertex) {
		vertexList.remove(vertex);
		this.matAdy=createMat(vertexList,matAdy);
	}

	@Override
	public VertexMatAdy<T> search(T data) {
		for(VertexMatAdy<T> aux : vertexList) {
			if(aux.getData()==data)return aux;
		}
		return null;
	}

	@Override
	public void connect(VertexMatAdy<T> origin, VertexMatAdy<T> destination) {
		matAdy[origin.getPosition()][destination.getPosition()]=1;
	}

	@Override
	public void connect(VertexMatAdy<T> origin, VertexMatAdy<T> destination, int weight) {
		matAdy[origin.getPosition()][destination.getPosition()]=weight;
	}

	@Override
	public void disconnect(VertexMatAdy<T> origin, VertexMatAdy<T> destination) {
		matAdy[origin.getPosition()][destination.getPosition()]=0;
	}

	@Override
	public boolean existsEdge(VertexMatAdy<T> origin, VertexMatAdy<T> destination) {
		return (matAdy[origin.getPosition()][destination.getPosition()]==0?false:true);
	}

	@Override
	public int weight(VertexMatAdy<T> origin, VertexMatAdy<T> destination) {
		return matAdy[origin.getPosition()][destination.getPosition()];
	}

	@Override
	public boolean isEmpty() {
		return (vertexList==null?true:false);
	}

	@Override
	public List<VertexMatAdy<T>> getVertices() {
		return vertexList;
	}

	/*
	 * Como no implementé la clase Edges, no retorno nada*/
	@Override
	public List<EdgeMatAdy<T>> getEdges(VertexMatAdy<T> v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VertexMatAdy<T> getVertex(int position) {
		for(VertexMatAdy<T> aux : vertexList) {
			if(aux.getPosition()==position)return aux;
		}
		return null;
	}

	@Override
	public int getSize() {
		return matDim;
	}
	
	private int[][] createMat(List<VertexMatAdy<T>> list,int[][] oldMat){
		int newMat[][] = new int[list.size()][list.size()];
		int i ,j;
		VertexMatAdy<T> auxV;
		for(i=0;i<list.size()-1;i++) {
			auxV=list.get(i);
			for(j=0;j<oldMat.length;j++) {
				newMat[i][j]=oldMat[auxV.getPosition()][j];
				auxV.setPosition(i);
			}
			i++;
		}
		return newMat;
	}

}
