package tp2_ej1;
import tp1_ej8.Queue;
public class BinaryTree<T> {
	
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;
	
	public BinaryTree(){
	
	}
	public BinaryTree(T t){
		this.setData(t);
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	public void addLeftChild(BinaryTree<T> leftChild) {
		this.leftChild = leftChild;
	}
	public BinaryTree<T> getRightChild() {
		return rightChild;
	}
	public void addRightChild(BinaryTree<T> rightChild) {
		this.rightChild = rightChild;
	}
	public void removeLeftChild() {
		this.leftChild=null;
	}
	public void removeRightChild() {
		this.rightChild=null;
	}
	public boolean isEmpty() {
		return this.data==null;
	}
	public boolean isLeaf() {
		return this.leftChild==null&&this.rightChild==null;
	}
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}
	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		String str="- ";
		this.toStringRecursivo(this, str);
		return str;
	}
	private void toStringRecursivo(BinaryTree<T> b,String str) {
		if(b!=null) {
			str=str+b.getData()+" - ";
			this.toStringRecursivo(b.getLeftChild(), str);
			this.toStringRecursivo(b.getRightChild(), str);
		}
	}
	public int contarHojas() {
		Integer i=0;
		this.contarHojasRecursivo(this,i);
		return i;
	}
	private void contarHojasRecursivo(BinaryTree<T> b,Integer i) {
		if(b.getLeftChild()==null&&b.getRightChild()==null) {
			i++;
		}
		else {
			if(b.getLeftChild()!=null) this.contarHojasRecursivo(b.getLeftChild(), i);
			if(b.getRightChild()!=null) this.contarHojasRecursivo(b.getRightChild(), i);
		}
	}
	public BinaryTree<T> espejoA(){
		BinaryTree<T> aux=null;
		this.espejoRecursivo(this,aux);
		return aux;
	}
	private void espejoRecursivo(BinaryTree<T> b,BinaryTree<T> r) {
		if(b!=null) {	
			r = new BinaryTree<T>();
			r.setData(b.getData());
			this.espejoRecursivo(b.getLeftChild(),r.getRightChild());
			this.espejoRecursivo(b.getRightChild(),r.getLeftChild());
		}
	}
	//Mejor forma, no creo arboles al pedo
	public BinaryTree<T> espejoB(){
		BinaryTree<T> aux = new BinaryTree<T>(this.getData());
		if (this.hasLeftChild()) aux.addRightChild(this.getLeftChild().espejoB());
		if (this.hasRightChild()) aux.addLeftChild(this.getRightChild().espejoB());
		return aux;
	}
	public void entreProfundidades(int min,int max) {
		BinaryTree<T> b = null;
		Queue<BinaryTree<T>> q = new Queue<BinaryTree<T>>();
		int i=0;
		q.enqueue(this);
		q.enqueue(null);
		while(!q.is_empty()) {
			b=q.dequeue(); 
			//Desencolo elemento
			if(b!=null) {  
				if(min<=i&&i<=max)System.out.print(b.getData()+" - ");
				/*Si el contador de profundidad está
				entre las cotas, entonces imprimo*/
				if(b.hasLeftChild()) {
					q.enqueue(b.getLeftChild());
				}
				if(b.hasRightChild()) {
					q.enqueue(b.getRightChild());
				/*Encolo elementos detras del null que separa nivel*/
				}
			}
			else if(!q.is_empty()) {
			/*Cuando b==null significa que o terminé mi cola o que
			cambié de profundiad, por lo tanto incremento contador de profundidad*/
				i++;
				q.enqueue(null);
				/*Al haber ido ya encolando el resto de elementos del siguiente nivel
				encolo un null para separarlos de su respectivo siguiente nivel*/
				System.out.println();
			}
		}
	}
	public void entreAlturas(int min,int max) {
		BinaryTree<T> b = null;
		Queue<BinaryTree<T>> q = new Queue<BinaryTree<T>>();
		Queue<BinaryTree<T>> aux = new Queue<BinaryTree<T>>();
		int i=0;
		q.enqueue(this);
		q.enqueue(null);
		while(!q.is_empty()) {
			aux.enqueue(q.head());
			/*Copio cola auxiliar, gracias a la cola auxiliar los niveles ya están separados
			por nulls*/
			b=q.dequeue();
			/*Cola auxiliar para saber dónde poner el null para separar por niveles*/
			if(b!=null) {
				if(b.hasLeftChild()) {
					q.enqueue(b.getLeftChild());
				}
				if(b.hasRightChild()) {
					q.enqueue(b.getRightChild());
				}
			}
			else if(!q.is_empty()) {
				i++;//Cuento cantidad de niveles
				q.enqueue(null);
			}
		}
		int j=i;
		b=aux.dequeue(); //Descarto ultimo null de la cola
		while(j<=i&&!aux.is_empty()) {
			b=aux.dequeue();
			if(b!=null&&min<=j&&j<=max) {
				System.out.print(b.getData()+" - ");
			}
			else if(b==null){
				j--;//Desciendo de nivel
				System.out.println();
			}
		}
		
	}
	public void niveles() {
		BinaryTree<T> b = null;
		Queue<BinaryTree<T>> q = new Queue<BinaryTree<T>>();
		q.enqueue(this);//Encolo primer elemento profundidad 0
		q.enqueue(null);//Separo profundiad 0 con un null
		while(!q.is_empty()) {
			b=q.dequeue();
			if(b!=null) {
				System.out.print(b.getData()+" - ");
				/*Cuando el elemento se encuentra en un mismo nivel de 
				profundidad lo imprimo*/
				if(b.hasLeftChild()) {
					q.enqueue(b.getLeftChild());
				}
				if(b.hasRightChild()) {
					q.enqueue(b.getRightChild());
				}
			}
			else if(!q.is_empty()) {
				/*Cuando llega a null y no está vacía implica un cambio de
				nivel de profundidad*/
				q.enqueue(null);
				/*Ya estuve acumulando el siguiente nivel de 
				profundidad, lo separo con un null*/
				System.out.println();
			}
		}
		
	}
}
