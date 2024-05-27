package tp5_ej1MatAdy;

/*
 * No es necesario utilizarlo para esta implementacion
 * */
public class EdgeMatAdy<T> implements EdgeIntMatAdy<T> {
	private VertexMatAdy<T> vertex;
	private int weight;
	
	/*Da error porque de todas las implementaciones de grafos
	 *que se pueden hacer elegí la de lista de adyacencias 
	 *y tuve que poner esa en la interface de Edge */
	@Override
	public VertexMatAdy<T> getTarget() {
		return vertex;
	}

	@Override
	public int getWeight() {
		return weight;
	}

}
