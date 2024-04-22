package tp3_ej4;
import tp3_ej1.GeneralTree;
import java.util.Scanner;
import paquete_funciones_arbol.FuncionesArbolG;
public class PruebaAnalizadorArbol {

	public static void main(String[] args) {
		AnalizadorArbol a = new AnalizadorArbol();
		FuncionesArbolG func = new FuncionesArbolG();
		Scanner in = new Scanner(System.in);
		GeneralTree<Integer> ag = new GeneralTree<Integer>();
		func.cargarArbolInteger(ag, in);
		System.out.println(a.devolverMaximoPromedio(ag));
	}

}
