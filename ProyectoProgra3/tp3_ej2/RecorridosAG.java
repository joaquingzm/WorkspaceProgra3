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
			if(ag.getData()%2!=0&&ag.getData()>n)aux_list.add(ag.getData());
			if(ag.hasChildren()) {
				int i=0,dimf=ag.getChildren().size();
				while(i<dimf) {
					numerosImparesMayoresQuePreOrdenP(ag.getChildren().get(i),n,aux_list);
					i++;
				}
			}
		}
	}
	
	
	//CONSULTAR: Terminar In Orden y Post Orden(issue en git)
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> ag,Integer n){
		List<Integer> aux_list = new LinkedList<Integer>();
		this.numerosImparesMayoresQueInOrdenP(ag, n, aux_list);
		return aux_list;
	}
	private void numerosImparesMayoresQueInOrdenP(GeneralTree<Integer> ag,Integer n,List<Integer> aux_list){
		if(ag!=null) {
			if(ag.hasChildren()) {
				int i=0,dimf=ag.getChildren().size();
				while(i<dimf) {
					numerosImparesMayoresQuePreOrdenP(ag.getChildren().get(i),n,aux_list);
					i++;
				}
			}
			if(ag.getData()%2!=0&&ag.getData()>n)aux_list.add(ag.getData());
		}
	}
	
	
	
	//CONSULTAR: si quisiera separar por niveles cómo hago para añadir un null a la lista?
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> ag,Integer n) {
		LinkedList<Integer> lista_nums = new LinkedList<Integer>();
		
		int indice_act=0;
		//Indice del nodo actual en la lista de hijos
		int dim_lista;
		//Dimension de la lista de hijos
		LinkedList<LinkedList<GeneralTree<Integer>>> lista_de_listas = new LinkedList<LinkedList<GeneralTree<Integer>>>();
		//Lista donde guardo los hijos del siguiente nivel sobre el que me estoy moviendo
		LinkedList<GeneralTree<Integer>> lista_actual=null;
		//Lista de hijos actual sobre la que me muevo
		GeneralTree<Integer> nodo_act=ag;
		//Nodo actual
		if(nodo_act.getData()%2!=0&&ag.getData()>n)lista_nums.add(ag.getData());
		//Si cumple condicion, lo encolo
		lista_actual=nodo_act.getChildren();
		//Asigno lista actual sobre la que me voy a mover
		if(nodo_act.hasChildren()) {
			lista_de_listas.add(nodo_act.getChildren());
		}
		while(!lista_de_listas.isEmpty()) {
				indice_act=0;
				//Seteo el indice actual en 0 para cada loop
				
			    lista_actual=lista_de_listas.remove(0);
			    //Actualizo lista actual
				dim_lista=lista_actual.size();
				//Dimension de lista actual
				while(indice_act<dim_lista) {
					//Condicion de corte de control: llegar al final de la lista
					nodo_act=lista_actual.get(indice_act);
					//Nodo actual pasa a ser el primer(cuando recien entro al loop) o siguiente hijo de la lista
					if(nodo_act.hasChildren())lista_de_listas.add(nodo_act.getChildren());
					//Si mi nodo actual tiene lista de hijos la añado a la lista de listas de hijos (siguiente nivel)
					indice_act++;
					//Aumento indice actual sobre la lista para la siguiente vuelta
					if(nodo_act.getData()%2!=0&&nodo_act.getData()>n)lista_nums.add(nodo_act.getData());
					//Si nodo actual cumple condicion lo añado a la lista a retornar
				}
				
		}
		return lista_nums;
	}
	
}
