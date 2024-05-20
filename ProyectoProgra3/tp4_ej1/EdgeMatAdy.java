package tp4_ej1;

/*
 * No es necesario utilizarlo para esta implementacion*/
public class EdgeMatAdy<T> implements EdgeInt<T> {
	private VertexMatAdy<T> vertex;
	private int weight;
	
	@Override
	public VertexMatAdy<T> getTarget() {
		return vertex;
	}

	@Override
	public int getWeight() {
		return weight;
	}

}
