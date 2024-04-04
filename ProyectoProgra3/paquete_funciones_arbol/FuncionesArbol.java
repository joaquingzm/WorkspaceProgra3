package paquete_funciones_arbol;
import tp2_ej1.BinaryTree;
import java.util.Scanner;
public class FuncionesArbol{
	public BinaryTree<?> cargarArbol() {
		BinaryTree<?> ab;
		Scanner in = new Scanner(System.in);
		System.out.print("Ingrese tipo de dato de los nodos: ");
		String tipo = in.next();
		switch(tipo) {
		case "String": ab = cargarArbolString();
		case "Integer": ab = cargarArbolInteger();
		case "Character": ab = cargarArbolCharacter();
		default
		}
	}
	private BinaryTree<String> cargarArbolString() {
		
	}
}

