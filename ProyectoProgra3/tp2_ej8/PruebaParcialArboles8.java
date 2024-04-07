package tp2_ej8;
import tp2_ej1.BinaryTree;
import paquete_funciones_arbol.FuncionesArbol;
import java.util.Scanner;
public class PruebaParcialArboles8 {
	public static void main(String args[]) {
		ParcialArboles8 pa = new ParcialArboles8();
		Scanner in = new Scanner(System.in);
		FuncionesArbol func = new FuncionesArbol();
		BinaryTree<Integer> ab1 = new BinaryTree<Integer>();
		BinaryTree<Integer> ab2 = new BinaryTree<Integer>();
		System.out.println("Cargar arbol 1:");
		func.cargarArbolInteger(ab1, in);
		System.out.println("Cargar arbol 2:");
		func.cargarArbolInteger(ab2, in);
		System.out.println(pa.esPrefijo(ab1, ab2));
	}

}
