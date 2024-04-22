package tp3_ej6;
import tp3_ej1.GeneralTree;
import java.util.Scanner;
import paquete_funciones_arbol.FuncionesArbolG;
public class PruebaRedDeAguaPotable {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		GeneralTree<String> ag = new GeneralTree<String>();
		FuncionesArbolG func = new FuncionesArbolG();
		func.cargarArbolString(ag, in);
		RedDeAguaPotable rdap = new RedDeAguaPotable(ag);
		System.out.println(rdap.minimoCaudal(1000));
	}

}
