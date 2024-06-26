package tp3_ej7;
import tp3_ej1.GeneralTree;
import java.util.List;
import java.util.LinkedList;
public class Caminos {
	private GeneralTree<Integer> ag=null;
	
	public Caminos() {
	}
	public Caminos(GeneralTree<Integer> ag) {
		this.ag=ag;
	}
	
	public List<Integer> caminoAHojaMasLejana(){
		if(ag!=null&&!ag.isEmpty()) {
			LinkedList<Integer> max = new LinkedList<Integer>();
			LinkedList<Integer> aux = new LinkedList<Integer>();
			caminoAHojaMasLejanaP(this.ag,max,aux);
			return max;
		}
		return null;
	}
	private void caminoAHojaMasLejanaP(GeneralTree<Integer> ag,LinkedList<Integer> max,LinkedList<Integer> aux){
		aux.add(ag.getData());
		if(!ag.isLeaf()) {
			for(GeneralTree<Integer> nodo : ag.getChildren()) {
				caminoAHojaMasLejanaP(nodo,max,aux);
			}			
		}
		else if(max.size()<aux.size()) {
			max.clear();
			clonarLista(max,aux);
		}
		aux.removeLast();
	}
	
	private void clonarLista(LinkedList<Integer> l1,LinkedList<Integer> l2){
		for(int i=0;i<l2.size();i++) {
			l1.add(l2.get(i));
		}
	}
}
