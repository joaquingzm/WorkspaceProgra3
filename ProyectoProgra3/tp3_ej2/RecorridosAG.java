package tp3_ej2;
import java.util.List;
import java.util.LinkedList;
import tp3_ej1.GeneralTree;
public class RecorridosAG {
	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> ag,Integer n){
		List<Integer> aux_list = new LinkedList<Integer>();
		this.numerosImparesMayoresQuePreOrdenP(ag, n, aux_list);
		return aux_list;
	}
	private void numerosImparesMayoresQuePreOrdenP(GeneralTree<Integer> ag,Integer n,List<Integer> aux_list){
		if(ag!=null) {
			int i=0,dim=ag.getChildren().size();
			while(i<dim)
			if(ag.getData()>n)aux_list.add(ag.getData());
			numerosImparesMayoresQuePreOrdenP(ag.getChildren().get(i),n,aux_list);
			i++;
		}
	}
}
