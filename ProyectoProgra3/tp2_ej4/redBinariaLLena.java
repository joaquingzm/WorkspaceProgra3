package tp2_ej4;
import paquete_funciones_arbol.FuncionesArbol;
import tp2_ej1.BinaryTree;
import java.util.Scanner;
public class redBinariaLLena {
	public static void main(String args[]) {
		FuncionesArbol func = new FuncionesArbol();
		BinaryTree<Integer> ab = new BinaryTree<Integer>();
		Scanner in = new Scanner(System.in);
		func.cargarArbolInteger(ab, in);
		System.out.println(retardoReenvio(ab));
		in.close();
	}
	public static int retardoReenvio(BinaryTree<Integer> ab) {
		if(ab!=null&&!ab.isEmpty()) {
			/*Utilizo recorrido postOrden para llegar a las hojas y a partir
			de ahí subo enviando el dato del nodo más el su hijo con mayor valor
			*/
			int izq = retardoReenvio(ab.getLeftChild());
			int der = retardoReenvio(ab.getRightChild());
			return (izq>der?(ab.getData()+izq):(ab.getData()+der));
		}
		return 0;
	}
}

