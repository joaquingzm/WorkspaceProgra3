package tp2_ej3;
import tp2_ej1.BinaryTree;
import tp1_ej8.Queue;
public class ContadorArbol {
	private BinaryTree<Integer> ab = null;
	
	public ContadorArbol() {}
	public ContadorArbol(BinaryTree<Integer> ab) {
		this.setArbol(ab);
	}
	
	public void setArbol(BinaryTree<Integer> ab) {
		this.ab=ab;
	}
	public BinaryTree<Integer> getArbol() {
		return ab;
	}
	public Queue<Integer> numerosParesInOrden() {
		Queue<Integer> q = new Queue<Integer>();
		this.numerosParesInOrdenRecursivo(ab, q);
		return (q!=null) ? q : null;
	}
	private void numerosParesInOrdenRecursivo(BinaryTree<Integer> ab,Queue<Integer> q) {
		if(ab!=null) {
			this.numerosParesInOrdenRecursivo(ab.getLeftChild(),q);
			if(ab.getData()%2==0)q.enqueue(ab.getData());
			this.numerosParesInOrdenRecursivo(ab.getRightChild(), q);
		}
	}
	public Queue<Integer> numerosParesPostOrden() {
		Queue<Integer> q = new Queue<Integer>();
		this.numerosParesPostOrdenRecursivo(ab, q);
		return (q!=null) ? q : null;
	}
	private void numerosParesPostOrdenRecursivo(BinaryTree<Integer> ab,Queue<Integer> q) {
		if(ab!=null) {
			this.numerosParesPostOrdenRecursivo(ab.getLeftChild(),q);
			this.numerosParesPostOrdenRecursivo(ab.getRightChild(), q);
			if(ab.getData()%2==0)q.enqueue(ab.getData());	
		}
	}
}
