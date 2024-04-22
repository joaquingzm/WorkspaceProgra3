package tp3_ej7;
import tp3_ej1.GeneralTree;
import java.util.List;
import java.util.LinkedList;
public class Caminos {
	GeneralTree<Integer> ag=null;
	
	public Caminos() {
	}
	public Caminos(GeneralTree<Integer> ag) {
		this.ag=ag;
	}
	
	public List<Integer> caminoAHojaMasLejana(){
		LinkedList<Integer> max = new LinkedList<Integer>();
		LinkedList<Integer> aux = new LinkedList<Integer>();
		caminoAHojasMasLejanaP(this.ag,max,aux);
	/*Terminar, en concepto el pasaje de parametros serias asi como lo puse y tengo que crear un metodo clone para cambiarle valores a max cuando llego a leaf*/
	}
	public void caminoAHojaMasLejanaP(GeneralTree<Integer> ag,LinkedList<Integer> max,LinkedList<Integer> aux){
		if(!ag.isLeaf()) {
			LinkedList<Integer> aux;
			LinkedList<Integer> max = new LinkedList<Integer>();
			max.add(ag.getData());
			int alt;
			for(GeneralTree<Integer> nodo : ag.getChildren()) {
				aux = (LinkedList<Integer>) caminoAHojaMasLejanaP(nodo);
				if(aux.size()>max.size()) {
					max=aux;
				}
			}
			return max+1;
		}
		else return 0;
	}
}
