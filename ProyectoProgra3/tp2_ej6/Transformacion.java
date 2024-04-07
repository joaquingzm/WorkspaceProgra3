package tp2_ej6;
import tp2_ej1.BinaryTree;
public class Transformacion {
	private BinaryTree<Integer> ab=null;
	
	public void setArbol(BinaryTree<Integer> ab) {
		this.ab=ab;
	}
	
	public BinaryTree<Integer> getArbol(){
		return this.ab;
	}
	
	public BinaryTree<Integer> suma(){
		BinaryTree<Integer> aux = new BinaryTree<Integer>();
		sumaP(this.getArbol(),aux);
		return aux;
	}
	private int sumaP(BinaryTree<Integer> ab,BinaryTree<Integer> copia){
		if(ab!=null) {
			BinaryTree<Integer> aux_ab= new BinaryTree<Integer>();
			copia.addLeftChild(aux_ab); //Creo un arbol de la misma forma a medida que recorro el otro
			int a = sumaP(ab.getLeftChild(),copia.getLeftChild());//Guardo la suma de mi hijo izq junto con todo su hijos
			aux_ab= new BinaryTree<Integer>();
			copia.addRightChild(aux_ab);
			int b = sumaP(ab.getRightChild(),copia.getRightChild());//Guardo la suma de mi hijo der junto con todo su hijos
			copia.setData(a+b);//Seteo el valor de la suma de mis hijos en mi arbol copia
			return ab.getData()+a+b;//Retorno la suma del nodo más sus hijos al padre
		}
		return 0;
	}
}
