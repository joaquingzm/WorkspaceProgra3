package tp3_ej9;
import tp3_ej1.GeneralTree;
public class Parcial9 {
	
	public boolean esDeSeleccion(GeneralTree<Integer> ag) {
		if(ag!=null&&!ag.isEmpty()&&!ag.isLeaf()) {
			int min=9999;
			for(GeneralTree<Integer> nodo : ag.getChildren()) {
				if(!esDeSeleccion(nodo))return false;
				if(nodo.getData()<min)min=nodo.getData();
			}
			return ag.getData()==min;
		}
		if(ag.isLeaf())return true;
		return false;
	}
}
