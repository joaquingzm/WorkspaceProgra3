package tp1_ej9;
import java.util.Scanner;
import tp1_ej8.DoubleEndedQueue;
public class Ej9 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Strings: ");
		String str=in.next();
		DoubleEndedQueue<Character> queue = new DoubleEndedQueue<Character>();
		char[] array=str.toCharArray(); //Convierto str a char array
		int i=0;
		char aux;
		Boolean b=true;
		while(b&&i<array.length) {
			while(i+1<array.length&&!es_car_esp(array[i])) {
				i++; //Descarto caracteres que no seas especiales
			}
			if(i<array.length&&es_car_esp(array[i])) {
				//Chequeo indice dentro de dimensiones
				aux=array[i];
				if(abre(aux)) {
					queue.enqueueFirst(aux);
				}
				else b=char_cierra_primer_char(aux,queue);			
			}
			i++;
		}
		System.out.println(b);
		in.close();
	}


	public static boolean es_car_esp(char a) {
		return a=='('||a==')'||a=='['||a==']'||a=='{'||a=='}';
	}
	
	public static boolean abre(char a) {
		return a=='('||a=='['||a=='{';
	}
	
	public static boolean char_cierra_primer_char(char aux,DoubleEndedQueue<Character> queue) {
		if(aux!=')') {
			if(aux!=']') {
				if(aux!='}') {
					return false;
				}
				else {
					if(queue.dequeue()!='{') {
						return false;
					}
				}
			}
			else {
				if(queue.dequeue()!='[') {
					return false;
				}
			}
		}
		else {
			if((queue.is_empty())||queue.dequeue()!='(') {
				return false;
			}
		}
		return true;
	}
}
	


