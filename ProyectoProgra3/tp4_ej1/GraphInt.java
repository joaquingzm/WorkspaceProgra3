package tp4_ej1;
import java.util.List;
public interface GraphInt<T> {
	public VertexMatAdy<T> createVertex(T data);
	public void removeVertex(VertexMatAdy<T> vertex);
	public VertexMatAdy<T> search(T data);
	public void connect(VertexMatAdy<T> origin,VertexMatAdy<T> destination);
	public void connect(VertexMatAdy<T> origin,VertexMatAdy<T> destination,int weight);
	public void disconnect(VertexMatAdy<T> origin,VertexMatAdy<T> destination);
	public boolean existsEdge(VertexMatAdy<T> origin,VertexMatAdy<T> destination);
	public int weight (VertexMatAdy<T> origin,VertexMatAdy<T> destination);
	public boolean isEmpty();
	public List<VertexMatAdy<T>> getVertices();
	public List<EdgeMatAdy<T>> getEdges(VertexMatAdy<T> v);
	public VertexMatAdy<T> getVertex(int position);
	public int getSize();
}
