package tp3_ej11;
import java.util.LinkedList;
import java.util.Scanner;
import paquete_funciones_arbol.FuncionesArbolG;
import tp3_ej1.GeneralTree;
public class Parcial11 {
	public static void main(String[]args) {
		GeneralTree<Integer> ag = new GeneralTree<Integer>();
		Scanner in = new Scanner(System.in);
		FuncionesArbolG func = new FuncionesArbolG();
		func.cargarArbolInteger(ag, in);
		System.out.println(resolver(ag));
	}
	

	
	public static boolean resolver(GeneralTree<Integer> ag) {
		if(ag!=null) {
			int cant_nodos_ant=1;
			int cant_nodos_act=0;
			int indice_act=0;
			int dim_lista;
			LinkedList<LinkedList<GeneralTree<Integer>>> lista_de_listas = new LinkedList<LinkedList<GeneralTree<Integer>>>();
			LinkedList<GeneralTree<Integer>> lista_actual=null;
			GeneralTree<Integer> nodo_act=ag;
			lista_actual=nodo_act.getChildren();
			if(nodo_act.hasChildren()) {
				lista_de_listas.add(nodo_act.getChildren());
				lista_de_listas.add(null);
			}
			while(!lista_de_listas.isEmpty()) {
					indice_act=0;
					lista_actual=lista_de_listas.remove(0);
				    if(lista_actual!=null) {
						dim_lista=lista_actual.size();
						cant_nodos_act+=dim_lista;
						if(cant_nodos_act>(cant_nodos_ant+1))return false;
						while(indice_act<dim_lista) {
							nodo_act=lista_actual.get(indice_act);
							if(nodo_act.hasChildren())lista_de_listas.add(nodo_act.getChildren());
							indice_act++;
						}
				    }
				    else {
				    	if(cant_nodos_act!=(cant_nodos_ant+1))return false;
				    	if(!lista_de_listas.isEmpty()) {
				    		lista_de_listas.add(null);
				    		cant_nodos_ant=cant_nodos_act;
				    		cant_nodos_act=0;
				    	}
					}
			}
			return true;
		}
	return false;
	}
}
	