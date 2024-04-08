package tp2_ej8;
import tp2_ej1.BinaryTree;
public class ParcialArboles8 {
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if(arbol1!=null) {
			if(arbol2!=null) {
				if(esPrefijo(arbol1.getLeftChild(),arbol2.getLeftChild())&&esPrefijo(arbol1.getRightChild(),arbol2.getRightChild())) {
					return (arbol1.getData()==arbol2.getData()?true:false);
			
				}
				else return false;
			}
			else return false;
		}
		else return true;
	}
}
