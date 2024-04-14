package paquete_funciones_arbol;
import tp3_ej1.GeneralTree;
import java.util.Scanner;;
public class PruebaAG {

	public static void main(String[] args) {
		GeneralTree<String> agS = new GeneralTree<String>();
		FuncionesArbolG func = new FuncionesArbolG();
		Scanner in = new Scanner(System.in);
		func.cargarArbolString(agS, in);
		func.imprimirArbol(agS, 0);
	}

}
