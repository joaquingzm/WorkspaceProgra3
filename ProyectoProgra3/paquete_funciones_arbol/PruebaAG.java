package paquete_funciones_arbol;
import tp3_ej1.GeneralTree;
import java.util.Scanner;;
public class PruebaAG {

	public static void main(String[] args) {
		GeneralTree<Integer> agS = new GeneralTree<Integer>();
		FuncionesArbolG func = new FuncionesArbolG();
		Scanner in = new Scanner(System.in);
		func.cargarArbolInteger(agS, in);
		func.imprimirArbolGPorNiveles(agS);
	}

}
