package tp3_ej9;
import tp3_ej1.GeneralTree;
import paquete_funciones_arbol.FuncionesArbolG;
import java.util.Scanner;
public class PruebaParcial9 {

	public static void main(String[] args) {
		GeneralTree<Integer> ag = new GeneralTree<Integer>();
		Scanner in = new Scanner(System.in);
		FuncionesArbolG func = new FuncionesArbolG();
		func.cargarArbolInteger(ag, in);
		Parcial9 p = new Parcial9();
		System.out.println(p.esDeSeleccion(ag));
	}
	
	

}
