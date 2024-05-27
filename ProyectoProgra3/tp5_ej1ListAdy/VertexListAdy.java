package tp5_ej1ListAdy;

import java.util.LinkedList;
import java.util.List;

public class VertexListAdy<T> implements VertexIntListAdy<T> {
	private T data;
	private int position;
	private List<VertexListAdy<T>> adyVertexList;
	
	public void addVertex(VertexListAdy<T> vertex) {
		if(this.adyVertexList==null) {
			this.adyVertexList = new LinkedList<VertexListAdy<T>>();
		}
		this.adyVertexList.add(vertex);
	}
	
	public void removeVertex(VertexListAdy<T> vertex) {
		if(this.adyVertexList!=null) {
			this.adyVertexList.remove(vertex);
		}
	}
	
	public List<VertexListAdy<T>> getVertexList() {
		return this.adyVertexList;
	}
	
	public void setVertexList(List<VertexListAdy<T>> adyVertexList) {
		this.adyVertexList=adyVertexList;
	}
	@Override
	public T getData() {
		return this.data;
	}

	@Override
	public void setData(T data) {
		this.data=data;
	}

	@Override
	public int getPosition() {
		return this.position;
	}

	@Override
	public void setPosition(int position) {
		this.position=position;
	}

}
