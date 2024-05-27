package tp5_ej1MatAdy;

import tp5_ej1ListAdy.VertexIntListAdy;

public class VertexMatAdy<T> implements VertexIntListAdy<T> {
	private T data;
	private int position;
	
	@Override
	public T getData() {
		return data;
	}

	@Override
	public void setData(T data) {
		this.data=data;
	}
	
	@Override
	public void setPosition(int position) {
		this.position=position;
	}

	@Override
	public int getPosition() {
		return position;
	}

}
