package tp2_ej1;

public class Ej1 {
	public static void main(String[] args) {
		BinaryTree<Integer> b = new BinaryTree<Integer>();
		int nums=3;
		cargarArbol(b,nums);
		b.niveles();
		System.out.println();
		b.entreProfundidades(1,2);
		System.out.println();
		b.entreNiveles(0,1);
	}
	
	public static void cargarArbol(BinaryTree<Integer> b,int i) {
		BinaryTree<Integer> aux = new BinaryTree<Integer>(i);
		cargarArbolRecursivo(b,aux,i);
	}
	public static void cargarArbolRecursivo(BinaryTree<Integer> b,BinaryTree<Integer> aux,int i) {
		b.setData(i);
		if(i>0) {
			i--;
			aux=new BinaryTree<Integer>();
			b.addLeftChild(aux);
			cargarArbolRecursivo(b.getLeftChild(),aux,i);
			aux=new BinaryTree<Integer>();
			b.addRightChild(aux);
			cargarArbolRecursivo(b.getRightChild(),aux,i);
		}
	}
		

}