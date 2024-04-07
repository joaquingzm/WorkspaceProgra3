package tp2_ej9;
import java.util.Scanner;
import tp2_ej1.BinaryTree;
import paquete_funciones_arbol.FuncionesArbol;
public class PruebaParcial9 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		FuncionesArbol func= new FuncionesArbol();
		BinaryTree<Integer> ab = new BinaryTree<Integer>(); 
		ParcialArboles9 pa9 = new ParcialArboles9();
		System.out.println("Cargar arbol de enteros:");
		func.cargarArbolInteger(ab, in);
		BinaryTree<Valores> ab_val = pa9.sumAndDif(ab);
		System.out.println("Arbol de valores:");
		func.imprimirArbolV(ab_val,0);
	}
	
	
}
