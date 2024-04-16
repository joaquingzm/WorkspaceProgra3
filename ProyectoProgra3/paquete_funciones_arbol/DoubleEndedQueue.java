package paquete_funciones_arbol;

import java.util.ArrayList;

public class DoubleEndedQueue<T> extends Queue<T> {
	public void enqueueFirst(T t) {
		if(this.is_empty()) {
			data = new ArrayList<T>();
		}
		data.add(0,t);	
		}

}
