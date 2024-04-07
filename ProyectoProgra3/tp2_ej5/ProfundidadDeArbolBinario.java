package tp2_ej5;
import tp2_ej1.BinaryTree;
public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> ab=null;
	
	
	public BinaryTree<Integer> getArbolBinario(){
		return ab;
	}
	public void setArbolBinario(BinaryTree<Integer> ab) {
		this.ab=ab;
	}
	
	public int sumaElementosProfundidad(int p) {
		return this.sumaElementosProfundidadP(p, this.getArbolBinario());
	}
	
	private int sumaElementosProfundidadP(int p,BinaryTree<Integer> ab) {
		if(ab!=null) {
			return sumaElementosProfundidadP(p-1,ab.getLeftChild())+
				   sumaElementosProfundidadP(p-1,ab.getRightChild())+
				   (p<=0? ab.getData():0);
		}
		return 0;
	}
}
