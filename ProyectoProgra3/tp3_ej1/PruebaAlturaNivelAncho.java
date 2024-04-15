package tp3_ej1;
import paquete_funciones_arbol.FuncionesArbolG;
import java.util.Scanner;
public class PruebaAlturaNivelAncho {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		FuncionesArbolG func = new FuncionesArbolG();
		GeneralTree<Integer> ag = new GeneralTree<Integer>();
		func.cargarArbolInteger(ag, in);
		System.out.println(ag.altura());
	}

}
