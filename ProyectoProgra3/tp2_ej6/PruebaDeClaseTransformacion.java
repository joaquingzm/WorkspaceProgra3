package tp2_ej6;
import paquete_funciones_arbol.FuncionesArbol;
import java.util.Scanner;
import tp2_ej1.BinaryTree;
public class PruebaDeClaseTransformacion {
	public static void main(String args[]) {
		Transformacion t = new Transformacion();
		Scanner in = new Scanner(System.in);
		BinaryTree<Integer> ab = new BinaryTree<Integer>();
		FuncionesArbol func = new FuncionesArbol();
		func.cargarArbolInteger(ab, in);
		t.setArbol(ab);
		BinaryTree<Integer> aux = t.suma();
		func.imprimirArbol(aux, 0);
	}
}
