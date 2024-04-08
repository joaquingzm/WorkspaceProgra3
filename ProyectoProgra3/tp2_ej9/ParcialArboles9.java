package tp2_ej9;
import tp2_ej1.BinaryTree;
public class ParcialArboles9 {
	public BinaryTree<Valores> sumAndDif(BinaryTree<Integer> arbol){
		if(arbol!=null&&!arbol.isEmpty()) {
			BinaryTree<Valores> nuevo = new BinaryTree<Valores>();
			sumAndDifP(nuevo,arbol,0,0);
			return nuevo;
		}
		else return null;
	}
	private void sumAndDifP(BinaryTree<Valores> copia,BinaryTree<Integer> ab,int s,int d){
		if(ab.hasLeftChild()) {
			/*Como en estructura ambos arboles van a ser iguales
			solamente agrego hijos al arbol copia si el arbol original los tiene*/
			BinaryTree<Valores> aux_nod = new BinaryTree<Valores>();
			copia.addLeftChild(aux_nod);
			sumAndDifP(aux_nod,ab.getLeftChild(),ab.getData()+s,ab.getData());
		}
		if(ab.hasRightChild()) {
			//Ídem
			BinaryTree<Valores> aux_nod = new BinaryTree<Valores>();
			copia.addRightChild(aux_nod);
			sumAndDifP(aux_nod,ab.getRightChild(),ab.getData()+s,ab.getData());
		}
		Valores aux_val = new Valores(s+ab.getData(),ab.getData()-d);
		copia.setData(aux_val);
		
	}
}
