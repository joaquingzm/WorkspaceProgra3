package tp5_ej1ListAdy;
import java.util.List;
public interface GraphIntListAdy<T> {
	public VertexListAdy<T> createVertex(T data);
	public void removeVertex(VertexListAdy<T> vertex);
	public VertexListAdy<T> search(T data);
	public void connect(VertexListAdy<T> origin,VertexListAdy<T> destination);
	public void connect(VertexListAdy<T> origin,VertexListAdy<T> destination,int weight);
	public void disconnect(VertexListAdy<T> origin,VertexListAdy<T> destination);
	public boolean existsEdge(VertexListAdy<T> origin,VertexListAdy<T> destination);
	public int weight (VertexListAdy<T> origin,VertexListAdy<T> destination);
	public boolean isEmpty();
	public List<VertexListAdy<T>> getVertices();
	public List<EdgeListAdy<T>> getEdges(VertexListAdy<T> v);
	public VertexListAdy<T> getVertex(int position);
	public int getSize();
}
