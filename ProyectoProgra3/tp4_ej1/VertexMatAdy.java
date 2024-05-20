package tp4_ej1;

public class VertexMatAdy<T> implements VertexInt<T> {
	private T data;
	
	@Override
	public T getData() {
		return data;
	}

	@Override
	public void setData(T data) {
		this.data=data;
	}

	@Override
	public int getPosition() {
		return 0;
	}

}
