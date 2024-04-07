package tp2_ej7;
import java.util.Scanner;
import tp2_ej1.BinaryTree;
import paquete_funciones_arbol.FuncionesArbol;
public class PruebaParcialArboles7 {
	public static void main(String args[]) {
		ParcialArboles7 pa = new ParcialArboles7();
		FuncionesArbol func = new FuncionesArbol();
		BinaryTree<Integer> ab = new BinaryTree<Integer>();
		Scanner in = new Scanner(System.in);
		func.cargarArbolInteger(ab, in);
		pa.setArbol(ab);
		System.out.println(pa.isLeftTree(2));
	}

}
