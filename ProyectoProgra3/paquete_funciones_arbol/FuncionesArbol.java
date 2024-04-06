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
import java.util.Scanner;
import tp2_ej1.BinaryTree;
public class FuncionesArbol{
	
	
	public void cargarArbolString(BinaryTree<String> ab,Scanner in) {
		if(ab!=null) {
			DoubleEndedQueue<BinaryTree<String>> nodos_ant = new DoubleEndedQueue<BinaryTree<String>>();
			DoubleEndedQueue<BinaryTree<String>> nodos_padre = new DoubleEndedQueue<BinaryTree<String>>();
			DoubleEndedQueue<String> ops_ant = new DoubleEndedQueue<String>();
			String aux_op="";
			BinaryTree<String> aux_ab = null;
			BinaryTree<String> nodo_act=ab;
			System.out.print("Operaciones: Cargar, Salir: ");
			aux_op = in.next();
			aux_op= aux_op.toLowerCase();
			if(aux_op.equals("cargar")) {
				cargarS(nodo_act,in);
			}
			while(!aux_op.equals("salir")) {
				System.out.print("Operaciones: Cargar, Salir, Volver, Imprimir, Hd, Hi, P: ");
				aux_op = in.next();
				aux_op=aux_op.toLowerCase();
				switch (aux_op){
				
				case "cargar":
					cargarS(nodo_act,in);
					ops_ant.enqueueFirst(aux_op);
					break;
					
				case "hi":	
				case "hd":					
					nodos_padre.enqueueFirst(nodo_act);
					nodos_ant.enqueueFirst(nodo_act);
					if(aux_op.equals("hi")) {
						if(!nodo_act.hasLeftChild()) {
							cargarSH(nodo_act,in,true);
							ops_ant.enqueueFirst("hi_cargar");
						}
						else ops_ant.enqueueFirst("hi_mover");
						nodo_act = nodo_act.getLeftChild();
					}
					else {
						if(!nodo_act.hasRightChild()) {
							cargarSH(nodo_act,in,false);
							ops_ant.enqueueFirst("hd_cargar");
						}
						else ops_ant.enqueueFirst("hd_mover");
						nodo_act = nodo_act.getRightChild();
					}
					break;
					
				case "p":
					if(!nodos_padre.is_empty()) {
						aux_ab=nodo_act;
						nodo_act=nodos_padre.dequeue();
						ops_ant.enqueueFirst("p_mover");
						nodos_ant.enqueueFirst(aux_ab);
					}
					break;
					
				case "volver":
					if(!nodos_ant.is_empty()) {
						if(nodos_ant.head()==nodo_act.getLeftChild()||nodos_ant.head()==nodo_act.getRightChild())nodos_padre.enqueue(nodo_act);
						nodo_act=nodos_ant.dequeue();
						switch(ops_ant.dequeue()) {
						case "hi_cargar":nodo_act.removeLeftChild();break;
						case "hd_cargar":nodo_act.removeRightChild();break;
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
	private void cargarS(BinaryTree<String> nodo_act,Scanner in) {
		System.out.print("Cargar Dato: ");
		String aux_data = in.next();
		nodo_act.setData(aux_data);
	}
	private void cargarSH(BinaryTree<String> nodo_act,Scanner in,boolean hi) {
		BinaryTree<String> aux_ab = new BinaryTree<String>();
		cargarS(aux_ab,in);
		if(hi)nodo_act.addLeftChild(aux_ab);
		else nodo_act.addRightChild(aux_ab);
	}
	
	public void cargarArbolInteger(BinaryTree<Integer> ab,Scanner in) {
		if(ab!=null) {
			DoubleEndedQueue<BinaryTree<Integer>> nodos_ant = new DoubleEndedQueue<BinaryTree<Integer>>();
			DoubleEndedQueue<BinaryTree<Integer>> nodos_padre = new DoubleEndedQueue<BinaryTree<Integer>>();
			DoubleEndedQueue<String> ops_ant = new DoubleEndedQueue<String>();
			String aux_op="";
			BinaryTree<Integer> aux_ab = null;
			BinaryTree<Integer> nodo_act=ab;
			System.out.print("Operaciones: Cargar, Salir: ");
			aux_op = in.next();
			aux_op= aux_op.toLowerCase();
			if(aux_op.equals("cargar")) {
				cargarI(nodo_act,in);
			}
			while(!aux_op.equals("salir")) {
				System.out.print("Operaciones: Cargar, Salir, Volver, Imprimir, Hd, Hi, P: ");
				aux_op = in.next();
				aux_op=aux_op.toLowerCase();
				switch (aux_op){
				
				case "cargar":
					cargarI(nodo_act,in);
					ops_ant.enqueueFirst(aux_op);
					break;
					
				case "hi":	
				case "hd":					
					nodos_padre.enqueueFirst(nodo_act);
					nodos_ant.enqueueFirst(nodo_act);
					if(aux_op.equals("hi")) {
						if(!nodo_act.hasLeftChild()) {
							cargarIH(nodo_act,in,true);
							ops_ant.enqueueFirst("hi_cargar");
						}
						else ops_ant.enqueueFirst("hi_mover");
						nodo_act = nodo_act.getLeftChild();
					}
					else {
						if(!nodo_act.hasRightChild()) {
							cargarIH(nodo_act,in,false);
							ops_ant.enqueueFirst("hd_cargar");
						}
						else ops_ant.enqueueFirst("hd_mover");
						nodo_act = nodo_act.getRightChild();
					}
					break;
					
				case "p":
					if(!nodos_padre.is_empty()) {
						aux_ab=nodo_act;
						nodo_act=nodos_padre.dequeue();
						ops_ant.enqueueFirst("p_mover");
						nodos_ant.enqueueFirst(aux_ab);
					}
					break;
					
				case "volver":
					if(!nodos_ant.is_empty()) {
						if(nodos_ant.head()==nodo_act.getLeftChild()||nodos_ant.head()==nodo_act.getRightChild())nodos_padre.enqueue(nodo_act);
						nodo_act=nodos_ant.dequeue();
						switch(ops_ant.dequeue()) {
						case "hi_cargar":nodo_act.removeLeftChild();break;
						case "hd_cargar":nodo_act.removeRightChild();break;
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
	private void cargarI(BinaryTree<Integer> nodo_act,Scanner in) {
		System.out.print("Cargar Dato: ");
		Integer aux_data = in.nextInt();
		nodo_act.setData(aux_data);
	}
	private void cargarIH(BinaryTree<Integer> nodo_act,Scanner in,boolean hi) {
		BinaryTree<Integer> aux_ab = new BinaryTree<Integer>();
		cargarI(aux_ab,in);
		if(hi)nodo_act.addLeftChild(aux_ab);
		else nodo_act.addRightChild(aux_ab);
	}	
	
	public void cargarArbolCharacter(BinaryTree<Character> ab,Scanner in) {
		if(ab!=null) {
			DoubleEndedQueue<BinaryTree<Character>> nodos_ant = new DoubleEndedQueue<BinaryTree<Character>>();
			DoubleEndedQueue<BinaryTree<Character>> nodos_padre = new DoubleEndedQueue<BinaryTree<Character>>();
			DoubleEndedQueue<String> ops_ant = new DoubleEndedQueue<String>();
			String aux_op="";
			BinaryTree<Character> aux_ab = null;
			BinaryTree<Character> nodo_act=ab;
			System.out.print("Operaciones: Cargar, Salir: ");
			aux_op = in.next();
			aux_op= aux_op.toLowerCase();
			if(aux_op.equals("cargar")) {
				cargarC(nodo_act,in);
			}
			while(!aux_op.equals("salir")) {
				System.out.print("Operaciones: Cargar, Salir, Volver, Imprimir, Hd, Hi, P: ");
				aux_op = in.next();
				aux_op=aux_op.toLowerCase();
				switch (aux_op){
				
				case "cargar":
					cargarC(nodo_act,in);
					ops_ant.enqueueFirst(aux_op);
					break;
					
				case "hi":	
				case "hd":					
					nodos_padre.enqueueFirst(nodo_act);
					nodos_ant.enqueueFirst(nodo_act);
					if(aux_op.equals("hi")) {
						if(!nodo_act.hasLeftChild()) {
							cargarCH(nodo_act,in,true);
							ops_ant.enqueueFirst("hi_cargar");
						}
						else ops_ant.enqueueFirst("hi_mover");
						nodo_act = nodo_act.getLeftChild();
					}
					else {
						if(!nodo_act.hasRightChild()) {
							cargarCH(nodo_act,in,false);
							ops_ant.enqueueFirst("hd_cargar");
						}
						else ops_ant.enqueueFirst("hd_mover");
						nodo_act = nodo_act.getRightChild();
					}
					break;
					
				case "p":
					if(!nodos_padre.is_empty()) {
						aux_ab=nodo_act;
						nodo_act=nodos_padre.dequeue();
						ops_ant.enqueueFirst("p_mover");
						nodos_ant.enqueueFirst(aux_ab);
					}
					break;
					
				case "volver":
					if(!nodos_ant.is_empty()) {
						if(nodos_ant.head()==nodo_act.getLeftChild()||nodos_ant.head()==nodo_act.getRightChild())nodos_padre.enqueue(nodo_act);
						nodo_act=nodos_ant.dequeue();
						switch(ops_ant.dequeue()) {
						case "hi_cargar":nodo_act.removeLeftChild();break;
						case "hd_cargar":nodo_act.removeRightChild();break;
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
	private void cargarC(BinaryTree<Character> nodo_act,Scanner in) {
		System.out.print("Cargar Dato: ");
		String aux = in.next();
		Character aux_data = aux.charAt(0);
		nodo_act.setData(aux_data);
	}
	private void cargarCH(BinaryTree<Character> nodo_act,Scanner in,boolean hi) {
		BinaryTree<Character> aux_ab = new BinaryTree<Character>();
		cargarC(aux_ab,in);
		if(hi)nodo_act.addLeftChild(aux_ab);
		else nodo_act.addRightChild(aux_ab);
	}
	
	private void imprimirArbolP(BinaryTree<?> ab,int i,BinaryTree<?> act) {
		if(ab!=null) {
			this.imprimirArbolP(ab.getRightChild(),i+1,act);
			int a=0;
			if(ab==act) {
				System.out.print("-  ");
				a++;
			}
			for(;a<i+1;a++) {
				System.out.print("   ");
			}
			System.out.println(ab.getData());
			this.imprimirArbolP(ab.getLeftChild(),i+1,act);
		}
	}
	
	public  void imprimirArbol(BinaryTree<?> ab,int i) {
		if(ab!=null) {
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

