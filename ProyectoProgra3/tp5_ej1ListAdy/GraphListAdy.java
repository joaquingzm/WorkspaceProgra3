package tp5_ej1ListAdy;

import java.util.List;

import tp5_ej1MatAdy.EdgeMatAdy;
import tp5_ej1MatAdy.GraphIntMatAdy;
import tp5_ej1MatAdy.VertexMatAdy;

public class GraphListAdy<T> implements GraphIntListAdy<T> {
	private List<VertexListAdy<T>> vertexList;

	@Override
	public VertexListAdy<T> createVertex(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeVertex(VertexListAdy<T> vertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VertexListAdy<T> search(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connect(VertexListAdy<T> origin, VertexListAdy<T> destination) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connect(VertexListAdy<T> origin, VertexListAdy<T> destination, int weight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnect(VertexListAdy<T> origin, VertexListAdy<T> destination) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsEdge(VertexListAdy<T> origin, VertexListAdy<T> destination) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int weight(VertexListAdy<T> origin, VertexListAdy<T> destination) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<VertexListAdy<T>> getVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EdgeListAdy<T>> getEdges(VertexListAdy<T> v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VertexListAdy<T> getVertex(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
