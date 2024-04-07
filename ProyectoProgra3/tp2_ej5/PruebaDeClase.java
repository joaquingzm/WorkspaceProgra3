package tp2_ej5;
import paquete_funciones_arbol.FuncionesArbol;
import java.util.Scanner;
import tp2_ej1.BinaryTree;
public class PruebaDeClase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario();
		FuncionesArbol func = new FuncionesArbol();
		BinaryTree<Integer> ab = new BinaryTree<Integer>();
		func.cargarArbolInteger(ab, in);
		prof.setArbolBinario(ab);
		System.out.println(prof.sumaElementosProfundidad(2));
		in.close();
	}

}
