package tp4_ej1;

import java.util.List;
/*
 * Decidí no implementar la clase Edge porque con la matriz de enteros
 * puedo conocer el peso de un Edge que hay entre vertice y vertice, y
 * asociando a cada posicion de la lista una fila en la matriz puedo conocer
 * la posicion del vertice en la lista del que estoy averiguando si hay camino
 * a otro vertice de otra posicion en la lista y cual es su peso*/
public class GraphMatAdy<T> implements GraphInt<T> {
	private List<VertexMatAdy<T>> vertexList;
	private int matAdy[][];
	private int matDim;
	@Override
	public VertexMatAdy<T> createVertex(T data) {
		
		return null;
	}

	@Override
	public void removeVertex(VertexMatAdy<T> vertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VertexMatAdy<T> search(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connect(VertexMatAdy<T> origin, VertexMatAdy<T> destination) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connect(VertexMatAdy<T> origin, VertexMatAdy<T> destination, int weight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnect(VertexMatAdy<T> origin, VertexMatAdy<T> destination) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsEdge(VertexMatAdy<T> origin, VertexMatAdy<T> destination) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int weight(VertexMatAdy<T> origin, VertexMatAdy<T> destination) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<VertexMatAdy<T>> getVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EdgeMatAdy<T>> getEdges(VertexMatAdy<T> v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VertexMatAdy<T> getVertex(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

}
