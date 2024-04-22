package tp3_ej4;

import java.util.LinkedList;

import tp3_ej1.GeneralTree;

public class AnalizadorArbol {
	//Es por nivel, no por hijos, por lo tanto no puedo utilizar recursividad para sumar todos los hijosy sacar su promedio
	/*Podría funcionar en caso de que el problema pidiera un promedio por hijos y no por niveles
	public int devolverMaximoPromedio(GeneralTree<Integer> ag) {
		if(ag!=null) {
			if(ag.hasChildren()) {
				int max_prom_hijos=0;
				int suma_local=0;
				int aux=0;
				for(GeneralTree<Integer> nodo : ag.getChildren()) {
					aux=devolverMaximoPromedio(nodo);
					if(aux>max_prom_hijos)max_prom_hijos=aux;
					suma_local+=nodo.getData();
				}
				suma_local/=ag.getChildren().size();
				return (suma_local>max_prom_hijos?suma_local:max_prom_hijos);
			}
		}
		return 0;
	}
	*/
	
	public int devolverMaximoPromedio(GeneralTree<Integer> ag) {
		if(ag!=null) {
			int max_prom=0;
			//Variable donde guardo el promedio máximo para después retornarlo
			int aux_suma=0;
			//Variable dónde guardo suma de los datos de cada nodo de un nivel
			int cant_nodos=0;
			//Variable dónde guardo cantidad de nodos para poder sacar el promedio después
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
			System.out.print(nodo_act.getData());
			System.out.println();
			//Si cumple condicion, lo encolo
			lista_actual=nodo_act.getChildren();
			//Asigno lista actual sobre la que me voy a mover
			if(nodo_act.hasChildren()) {
				lista_de_listas.add(nodo_act.getChildren());
				lista_de_listas.add(null);
				max_prom=nodo_act.getData();
			}
			while(!lista_de_listas.isEmpty()) {
					indice_act=0;
					//Seteo el indice actual en 0 para cada loop
				    lista_actual=lista_de_listas.remove(0);
				    //Actualizo lista actual
				    if(lista_actual!=null) {
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
							aux_suma+=nodo_act.getData();
							cant_nodos++;
						}
				    }
				    else if(!lista_de_listas.isEmpty()) {
				    	lista_de_listas.add(null);
				    	aux_suma/=cant_nodos;
				    	if((aux_suma)>max_prom)max_prom=aux_suma;
				    	aux_suma=0;
				    	cant_nodos=0;
				    }
			}
			aux_suma/=cant_nodos;
	    	if((aux_suma)>max_prom)max_prom=aux_suma;
			return max_prom;
		}
		return 0;
	}
}
