package tp3_ej2;
import java.util.LinkedList;
import tp3_ej1.GeneralTree;
import java.util.Scanner;
import paquete_funciones_arbol.FuncionesArbolG;
public class PruebaRecorridosAG {

	public static void main(String[] args) {
		RecorridosAG rec_ag = new RecorridosAG();
		FuncionesArbolG func_ag = new FuncionesArbolG();
		GeneralTree<Integer> ag = new GeneralTree<Integer>();
		Scanner in = new Scanner(System.in);
		func_ag.cargarArbolInteger(ag, in);
		LinkedList<Integer> l = (LinkedList<Integer>) rec_ag.numerosImparesMayoresQuePreOrden(ag, 4);
		System.out.println(l.toString());
		l = (LinkedList<Integer>) rec_ag.numerosImparesMayoresQueInOrden(ag, 4);
		System.out.println(l.toString());
		l = (LinkedList<Integer>) rec_ag.numerosImparesMayoresQuePorNiveles(ag, 4);
		System.out.println(l.toString());
	}

}
