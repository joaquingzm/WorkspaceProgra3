package paquete_funciones_arbol;
import tp2_ej1.BinaryTree;
import java.util.Scanner;
public class Prueba {

	public static void main(String[] args) {
		FuncionesArbol func = new FuncionesArbol();
		Scanner in = new Scanner(System.in);
		
		BinaryTree<String> ab = new BinaryTree<String>(); 
		func.cargarArbolString(ab,in);
		ab.niveles();
		System.out.println(ab.getData() instanceof String);
		
		BinaryTree<Character> ab_i = new BinaryTree<Character>();
		func.cargarArbolCharacter(ab_i, in);
		ab_i.niveles();
		System.out.println(ab_i.getData() instanceof Character);
		
		BinaryTree<Integer> a = new BinaryTree<Integer>();
		func.cargarArbolInteger(a, in);
		a.niveles();
		System.out.println(a.getData() instanceof Integer);
	}

}
