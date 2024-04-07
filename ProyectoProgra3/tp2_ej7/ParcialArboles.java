package tp2_ej7;
import tp2_ej1.BinaryTree;
public class ParcialArboles {
	private BinaryTree<Integer> ab=null;
	
	public void setArbol(BinaryTree<Integer> ab) {
		this.ab=ab;
	}
	public BinaryTree<Integer> getArbol(){
		return this.ab;
	}
	
	public boolean isLeftTree(int num){
		
		BinaryTree<Integer> nodo=buscarNodo(ab,num);
		//Busco nodo cuyo número coincida con num
		if(nodo!=null) {
			/*Si existe nodo que coincida con num entonces
			seteo cantidad de hijos únicos de hijo izq e hijo der
			en -1, si el nodo tiene hijo izq o hijo der entonces llamo
			a los métodos que devuelven cuántos hijos únicos tiene el nodo por
			lado y comparo en el return */
			int r=-1;
			int l=-1;
			if(nodo.hasLeftChild()) {
				l = recursivo(nodo.getLeftChild());
			}
			if(nodo.hasRightChild()) {
				r = recursivo(nodo.getRightChild());
			}
			return l>r;
		}
		else return false;
	}
	
	/*Duda: El caso base es que el nodo sea nulo, está bien o sería mejor chequear primero
	si el nodo tiene hijo izq e hijo der respectivamente? No sé que consume más recursos, si
	crear en memoria dinamica el método "recursivo" nuevamente y que ahí se fije si el hijo
	izq o der es nulo para entonces devolver 0 o realizar ese condicional antes de llamar al método
	utilizando ab.has(Left/Right)Child().*/
	private int recursivo(BinaryTree<Integer> ab) {
		if(ab!=null){
		    return recursivo(ab.getLeftChild())+
		    	   recursivo(ab.getRightChild())+
		    	   ((ab.hasLeftChild()&&!ab.hasRightChild()||!ab.hasLeftChild()&&ab.hasRightChild())?1:0);
		}
		return 0;
	}
	//Es buena práctica cortar un programa con returns?
	private BinaryTree<Integer> buscarNodo(BinaryTree<Integer> ab,int num){
		if(ab!=null) {
			if(ab.getData()==num) {
				return ab;
			}
			else {
				BinaryTree<Integer> auxL = buscarNodo(ab.getLeftChild(),num);
				if(auxL!=null)return auxL;
				BinaryTree<Integer> auxR = buscarNodo(ab.getRightChild(),num);
				if(auxR!=null)return auxR;
			}
		}
		return null;
	}

}
