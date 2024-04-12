package paquete_funciones_arbol;
/*
 * Operaciones:
 * - cargar = se elige el nodo actual para cargar datos
 * - salir = deja el arbol así como está, si no se cargó nada queda en null
 * - volver = vuelve al estado anterior borrando hijos si se fueron hechos (hace tope con la raiz, si se quiere poner el estado
 anterior hay que volver a cargar)
 * - imprimir = imprime estado del arból y marca el nodo con '-'
 * - hd/hi = se mueve al hijo derecho/hijo izquierdo del nodo (si no existe pregunta si se
 quiere crear un nodo para cargar)
 * - p = vuelve al padre
 */
import tp1_ej8.DoubleEndedQueue;
import tp2_ej1.BinaryTree;

import java.util.Scanner;
import tp3_ej1.GeneralTree;
import tp2_ej9.Valores;
import java.util.LinkedList;
public class FuncionesArbolG{
	
	
	public void cargarArbolString(GeneralTree<String> ab,Scanner in) {
		if(ab!=null) {
			LinkedList<GeneralTree<String>> lista_act=null;
			int indice_act;
			//Creo lista actual sobrela que me estoy moviendo y posicion de mi nodo actual
			DoubleEndedQueue<String> ops_ant = new DoubleEndedQueue<String>();
			DoubleEndedQueue<GeneralTree<String>> nodos_ant = new DoubleEndedQueue<GeneralTree<String>>();
			//Tanto nodos_ant como ops_ant sirven para la operacion volver
			DoubleEndedQueue<GeneralTree<String>> nodos_padre = new DoubleEndedQueue<GeneralTree<String>>();
			GeneralTree<String> aux_ag = null;
			/*Nodos_padre sirve para la operacion p, no es lo mismo mantener una lista de nodos anteriores en los que
			se estuvo a mantener una lista fija de padres hasta llegar al padre de mi nodo actual
			  Por otro lado aux_ab sirve para guardar momentaneamente el valor de mi nodo actual cuando utilizo
			la operacion p, asiganar a nodo_act su padre y aux_ab(nodo actual anterior)encolarlo en nodos_ant*/
			DoubleEndedQueue<String> cargas_ant = new DoubleEndedQueue<String>();
			//Cola que el estado anterior de un nodo, sirve para la op volver
			String aux_op="";
			GeneralTree<String> nodo_act=ab;
			System.out.print("Operaciones: Cargar, Salir: ");
			aux_op = in.next();
			aux_op= aux_op.toLowerCase();
			if(aux_op.equals("cargar")) {
				cargarS(nodo_act,in);
			}
			while(!aux_op.equals("salir")) {
				System.out.print("Operaciones(Nodo act:"+nodo_act.getData()+"): Cargar, Salir, Volver, Imprimir, H, Hsig, P: ");
				aux_op = in.next();
				aux_op=aux_op.toLowerCase();
				switch (aux_op){
				
				case "cargar":
					cargas_ant.enqueueFirst(nodo_act.getData());
					//Guardo estado anterior del nodo
					cargarS(nodo_act,in);
					ops_ant.enqueueFirst(aux_op);
					//Encolo op
					break;
						
				case "h":					
					nodos_padre.enqueueFirst(nodo_act);
					nodos_ant.enqueueFirst(nodo_act);
					/*Cuando paso a un hijo, exista ya o se vaya a crear, guardo como padre
					el nodo en el que estaba y paso a uno de su hijo izq, además también lo guardo
					en nodos_ant en caso de que quiera utilizar la op volver al estado anterior*/
					
					if(!nodo_act.hasChildren()) {
						//Si no tiene hijo izq
						cargarSH(nodo_act,in);
						ops_ant.enqueueFirst("h_cargar");
						//Guardo que se creo un hijo, para que el volver sepa si tiene que borrarlo
					}
					else ops_ant.enqueueFirst("h_sig");
					//Guardo que solamente elegí moverme al hijo, el volver no borra nada en ese caso
					nodo_act = nodo_act.getChildren().get(0);
					//Guardo lista sobre la que me voy a mover
					lista_act = nodo_act.getChildren();
					indice_act=0;
					break;
				
				case "hsig":
					ops_ant.enqueueFirst("h_sig");
					//Guardo que solamente elegí moverme al hijo, el volver no borra nada en ese caso
					nodos_ant.enqueueFirst(nodo_act);
					//Guardo nodo anterior en el que estaba
					indice_act++;
					//Incremento mi posicion en la lista de hijos
					nodo_act = lista_act.get(indice_act);
					//Cambio mi nodo actual al siguiente
					break;
				case "p":
					if(!nodos_padre.is_empty()) {
						aux_ag=nodo_act;
						nodo_act=nodos_padre.dequeue();
						//Paso al padre de nodo_act
						ops_ant.enqueueFirst("p_mover");
						//Guardo que me moví al padre para la op volver
						nodos_ant.enqueueFirst(aux_ag);
						//Guardo mi el nodo en el que estaba antes de subir a su padre
					}
					break;
					
				case "volver":
					if(!ops_ant.is_empty()){
						String op_ant=(ops_ant.dequeue());
						if(!nodos_ant.is_empty()&&!op_ant.equals("cargar")) {
							if(nodo_act.getChildren().contains(nodos_ant.head()))nodos_padre.enqueueFirst(nodo_act);
							/*Si en la cabeza de la cola de nodos anteriores hay alguno de los hijos de mi nodo actual entonces significa
							que antes estuve en unos de mis nodos hijo y realicé una operación p en la cual nodo actual pasó a ser el primer
							elemento de la cola nodos_padre, o sea, subí a mi padre, por lo tanto si lo quiero revertir tengo que reencolar al
							principio de la cola al que había sido padre(nodo_act) */
							//Guardo nodo anterior para borrar en caso de que fuera un nodo recien cargado
							aux_ag=nodo_act;
							nodo_act=nodos_ant.dequeue();
							//Vuelvo a nodo anterior, sea padre o hijo
							if(op_ant.equals("h_cargar")) {
								nodo_act.removeChild(aux_ag);
							}
						}
						/*Unicos casos de operaciones que cambian algo más al volver
						son cuando un hijo fue creado y cargado o un nodo fue reescrito, entonces se borran*/
						if(op_ant.equals("cargar")) {
						nodo_act.setData(cargas_ant.dequeue());
						}
					}
				case "salir":
					break;
				case "imprimir":
					imprimirArbolP(ab,0,nodo_act);
					break;
				default:
					System.out.print("Operación no válida");
				}
			
			}
		}
	}
	private void cargarS(GeneralTree<String> nodo_act,Scanner in) {
		System.out.print("Cargar Dato: ");
		String aux_data = in.next();
		nodo_act.setData(aux_data);
	}
	private void cargarSH(GeneralTree<String> nodo_act,Scanner in) {
		GeneralTree<String> aux_ab = new GeneralTree<String>();
		cargarS(aux_ab,in);
		nodo_act.addChild(aux_ab);
	}
	private void imprimirArbolP(GeneralTree<?> ag,int i,GeneralTree<?> act) {
		/*Primero llega al hijo más derecho y lo imprime con una cantidad de espacios que fue aumentando
		mientrass bajaba en profundiad, así va imprimiendose en manera triangular horizontal el árbol. Además 
		cuando el nodo es coincidente con el nodo_act agrega un '-' para indicar posición*/
		
		//Terminar 
		if(ag!=null&&!ag.isEmpty()&&ag.getChildren()!=null) {
			int j=1,dim=ag.getChildren().size()-1;
			while(j<dim) {
				this.imprimirArbolP(ag.getChildren().get(dim-j),i+1,act);
				j++;
			}
			int a=0;
			if(ag==act) {
				System.out.print("-  ");
				a++;
			}
			for(;a<i+1;a++) {
				System.out.print("   ");
			}
			System.out.println(ag.getData());
			this.imprimirArbolP(ab.getLeftChild(),i+1,act);
		}
	}
	
	public  void imprimirArbol(BinaryTree<?> ab,int i) {
		/*Primero llega al hijo más derecho y lo imprime con una cantidad de espacios que fue aumentando
		mientrass bajaba en profundiad, así va imprimiendose en manera triangular horizontal el árbol*/
		if(ab!=null&&!ab.isEmpty()) {
			this.imprimirArbol(ab.getRightChild(),i+1);
			int a=0;
			for(;a<i+1;a++) {
				System.out.print("   ");
			}
			System.out.println(ab.getData());
			this.imprimirArbol(ab.getLeftChild(),i+1);
		}
	}
}