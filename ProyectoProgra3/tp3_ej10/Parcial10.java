package tp3_ej10;
import tp3_ej1.GeneralTree;
import paquete_funciones_arbol.FuncionesArbolG;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
public class Parcial10 {

	public static void main(String[] args) {
		GeneralTree<Integer> ag = new GeneralTree<Integer>();
		Scanner in = new Scanner(System.in);
		FuncionesArbolG func = new FuncionesArbolG();
		func.cargarArbolInteger(ag, in);
		System.out.println(resolver(ag));
	}

	
	
	public static List<Integer> resolver(GeneralTree<Integer> ag){
		if(ag!=null&&!ag.isEmpty()) {
			LinkedList<Integer> max = new LinkedList<Integer>();
			LinkedList<Integer> aux = new LinkedList<Integer>();
			resolverP(ag,aux,max,0,0,0);
			return max;
		}
		return null;
	}	
	/*Se podría crear un clase con una variable de instancia entera que guarde maxI, así no tengo que hacer asignaciones en cada iteración*/
	public static int resolverP(GeneralTree<Integer> ag,LinkedList<Integer> aux,LinkedList<Integer> max,int auxI,int maxI,int n){
		if(ag.getData()!=0)aux.add(1);
		auxI=auxI+ag.getData()*n;
		if(!ag.isLeaf()) {
			n++;
			for(GeneralTree<Integer> nodo : ag.getChildren()) {
				maxI=resolverP(nodo,aux,max,auxI,maxI,n);
			}
		}
		else if(auxI>maxI) {
			max.clear();
			clonarLista(max,aux);
			maxI=auxI;
		}
		if(ag.getData()!=0)aux.removeLast();
		return maxI;
	}
	
	
	
	public static void clonarLista(LinkedList<Integer> l1,LinkedList<Integer> l2){
		for(int i=0;i<l2.size();i++) {
			l1.add(l2.get(i));
		}
	}
}
