package tp3_ej7;
import paquete_funciones_arbol.FuncionesArbolG;
import java.util.Scanner;
import tp3_ej1.GeneralTree;
public class PruebaCaminos {

	public static void main(String[] args) {
		GeneralTree<Integer> ag = new GeneralTree<Integer>();
		Scanner in = new Scanner(System.in);
		FuncionesArbolG func = new FuncionesArbolG();
		func.cargarArbolInteger(ag, in);
		Caminos camino = new Caminos(ag);
		System.out.println(camino.caminoAHojaMasLejana());

	}

}
