package tp3_ej1;
import java.util.Scanner;
import paquete_funciones_arbol.FuncionesArbolG;
public class PruebaAncestro {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		FuncionesArbolG func = new FuncionesArbolG();
		GeneralTree<Integer> ag = new GeneralTree<Integer>();
		func.cargarArbolInteger(ag, in);
		System.out.println(ag.esAncestro(4,5));
		System.out.println(ag.esAncestro(5,4));
		System.out.println(ag.esAncestro(null,5));
		System.out.println(ag.esAncestro(4,null));
		System.out.println(ag.esAncestro(null,null));
	}

}
