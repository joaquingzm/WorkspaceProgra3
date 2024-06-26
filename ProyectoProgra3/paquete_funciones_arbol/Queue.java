package paquete_funciones_arbol;
import java.util.*;
public class Queue<T> extends Sequence {
	
	protected ArrayList<T> data = new ArrayList<T>();

	
	
	public Queue() {}
	
	public void enqueue(T t) {
		if(this.is_empty()) {
			data = new ArrayList<T>();
		}
		data.add(t);
	}
	
	public T dequeue() {
		return data.remove(0);
	}
	
	public T head() {
		return data.get(0);
	}
	
	@Override
	public int size() {
		return data.size() ;
	}
	
	@Override
	public boolean is_empty() {
		return (data.size()==0);
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
