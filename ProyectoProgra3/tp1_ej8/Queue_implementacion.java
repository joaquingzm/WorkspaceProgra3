package tp1_ej8;
import java.util.*;
public class Queue_implementacion<T> extends Sequence {
	
	private List<T> data;

	
	public Queue_implementacion() {}
	
	@Override
	public int size() {
		return data.size() ;
	}
	@Override
	public boolean is_empty() {
		return (data.size()>0);
	}
	
	public void enqueue(T t) {
		if(this.is_empty()) {
			data = new ArrayList<T>();
		}
		data.add(t);
	}
	public T dequeue(T t) {
		return data.remove(0);
	}
	public T head(T t) {
		return data.get(0);
	}
	@Override
	public String toString() {
		String aux="";
		for(int i=0;i<this.size();i++) {
			aux = aux+data.get(i).toString();
		}
		return aux;
	}
	

}
