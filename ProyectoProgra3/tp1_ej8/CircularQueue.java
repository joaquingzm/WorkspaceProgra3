package tp1_ej8;

public class CircularQueue<T> extends Queue<T> {
	T shift() {
		this.enqueue(data.get(0));
		return data.remove(0);
	}
}
