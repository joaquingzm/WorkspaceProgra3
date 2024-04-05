package paquete_funciones_arbol;
import tp2_ej1.BinaryTree;
/* Cosas a tener en cuenta:
 * - Probar enfoque recursivo para crear el String para imprimir el arbol o directamente
 ir imprimendo el arbol, creo que deberia ser post orden asi conozco la cantidad de niveles
 y por lo tanto la cantidad de blancos que tengo que agregar para que la impresión sea simétrica
 * - Las operaciones deberían poder ser en mayusuculas o mminisculas gracias al toLowerCase()
 * - Hacer módulo que imprima el arbol
 * - Cambiar color del nodo para saber donde estoy

 * Reglas:
 * - salir = deja el arbol así como está, si no se cargó nada queda en null
 * - cargar = se elige el nodo actual para cargar datos
 * - hd/hi = se mueve al hijo derecho/hijo izquierdo del nodo (si no existe pregunta si se
 quiere crear un nodo para cargar)
 * - p = vuelve al padre
 * - cancelar = idealmente volvería al estado anterior(sólo guarda el estado inmediato anterior)
 * - 
 */
import java.util.Scanner;
import tp1_ej8.Queue;
public class FuncionesArbol{
	Scanner in = new Scanner(System.in);
	public BinaryTree<String> cargarArbol() {
		BinaryTree<String> ab=null;
		boolean b = false;
		while (b==false){
			System.out.print("Ingrese tipo de dato de los nodos: ");
			String tipo = in.next();
			switch(tipo) {
			case "String": ab = null;b=true;
			case "Integer": ab = null;b=true;
			case "Character": ab = null;b=true;
			default: System.out.println("Porfavor ingresar un tipo válido.");
			}
		}
		cargarArbolP(ab);
		in.close();
		return ab;
	}
	private void cargarArbolP(BinaryTree<String> nodo_act) {
		String aux_op="";
		String aux_op_ant="";
		String aux_data="";
		BinaryTree<String> aux_ab = null;
		BinaryTree<String> nodo_ant=null;
		if(aux_data=="cargar") {
			aux_data = in.next();
			nodo_act = new BinaryTree<String>(aux_data);
		}
		while(aux_op!="salir") {
			System.out.println("Operaciones: Cargar, Salir, Hd, Hi, Cancelar\n- ");
			aux_op_ant=aux_op;
			aux_op = in.next();
			aux_op.toLowerCase();
			switch (aux_op){
			
			case "cargar":
				System.out.println("Cargar Dato:\n- ");
				aux_data = in.next();
				nodo_act.setData(aux_data);
				
			case "hd":
				if(!nodo_act.hasRightChild()) {
					System.out.println("Hijo derecho no existe, queres crear uno y cargarlo?(Si, No)\n- ");
					aux_op = in.next();
					aux_op.toLowerCase();
					if(aux_op=="si") {
						aux_ab = new BinaryTree<String>();
						nodo_act.addRightChild(aux_ab);
						nodo_ant = nodo_act;
						nodo_act = nodo_act.getRightChild();
					}
				}
				
			case "hi":
				if(!nodo_act.hasLeftChild()) {
					System.out.println("Hijo izquierdo no existe, queres crear uno y cargarlo?(Si o No)\n- ");
					aux_op = in.next();
					aux_op.toLowerCase();
					if(aux_op=="si") {
						aux_ab = new BinaryTree<String>();
						nodo_act.addLeftChild(aux_ab);
						nodo_ant = nodo_act;
						nodo_act = nodo_act.getLeftChild();
					}
				}
			
			case "p":
				nodo_act=nodo_ant;
				
			case "cancelar":
				nodo_act=nodo_ant;
				switch(aux_op_ant) {
				case "hi":nodo_act.removeLeftChild();
				case "hd":nodo_act.removeRightChild();
				}
			case "salir":
				break;
			default:
				System.out.println("Operación no válida\n");
			}
			System.out.println("");
		}
	}

	private void imprimirArbolNodoAct(BinaryTree<String> ab,BinaryTree<String> nodo_act) {
		BinaryTree<String> b = null;
		Queue<BinaryTree<String>> q = new Queue<BinaryTree<String>>();
		String aux_a_imprimir=" a ";
		q.enqueue(ab);//Encolo primer elemento profundidad 0
		q.enqueue(null);//Separo profundiad 0 con un null
		while(!q.is_empty()) {
			b=q.dequeue();
			if(b!=null) {
				if(b==nodo_act)aux_a_imprimir=aux_a_imprimir;
				else aux_a_imprimir=aux_a_imprimir + b.getData();
				/*Cuando el elemento se encuentra en un mismo nivel de 
				profundidad lo imprimo*/
				if(b.hasLeftChild()) {
					q.enqueue(b.getLeftChild());
				}
				if(b.hasRightChild()) {
					q.enqueue(b.getRightChild());
				}
			}
			else if(!q.is_empty()) {
				/*Cuando llega a null y no está vacía implica un cambio de
				nivel de profundidad*/
				q.enqueue(null);
				/*Ya estuve acumulando el siguiente nivel de 
				profundidad, lo separo con un null*/
				System.out.println();
			}
		}
	}
}

