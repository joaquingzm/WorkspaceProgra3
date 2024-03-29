package tp1_ej8;

import java.util.ArrayList;

public class DoubleEndedQueue<T> extends Queue_implementacion<T> {
	public void enqueueFirst(T t) {
		if(this.is_empty()) {
			data = new ArrayList<T>();
		}
		data.add(0,t);	
		}

}
