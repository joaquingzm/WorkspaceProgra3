package tp1_ej7;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import tp1_ej3.Estudiante;
public class Ej7 {
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		//inicio a)
		int dim=5;
		
		ArrayList<Integer> arreglo = cargar_imprimir_ArrayList(dim);;
		//fin a)
		//inicio d
		crear_lista_3_estud();
		//fin d
		//inicio f
		System.out.println(es_capicua(arreglo));
		//fin f
		//inicio g
		System.out.print(" Numero n:");
		
		int n = in.nextInt();
		LinkedList<Integer> l = new LinkedList<Integer>();
		sucesion_recursivo(l,n);
		System.out.println(l.toString());
		//fin g
		//incio h
		invertir_arraylist1(arreglo,arreglo.size());
		System.out.println(arreglo.toString());
		//fin h
		//inicio j
		ArrayList<Integer> lista1 = new ArrayList<Integer>();
		ArrayList<Integer> lista2 = new ArrayList<Integer>();
		cargar_listas(lista1,lista2);
		ArrayList<Integer> listar = combinar_ordenado(lista1,lista2);
		System.out.println(listar.toString());
		//fin j
		in.close();
	}
	//inicio a)
	public static ArrayList<Integer> cargar_imprimir_ArrayList(int dim) {
		
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i=0;i<dim;i++) {
			System.out.print((i+1)+" - ");
			l.add(in.nextInt());
		}
		System.out.println(l.toString());
		return l;
	}
	//fin a)
	//inicio d)
	public static void crear_lista_3_estud() {
		List<Estudiante> list_E = new LinkedList<Estudiante>();
		for(int i=0;i<3;i++) {
			Estudiante e = new Estudiante("i","i","i","i","i"); 
			list_E.add(e);
		}
		List<Estudiante> list_E_copia = new LinkedList<Estudiante>();
		//Copio los valores de los elementos de la lista, no los punteros
		for(int i=0;i<list_E.size();i++) {
			Estudiante e_copia = new Estudiante(
					list_E.get(i).getNombre(),
					list_E.get(i).getApellido(),
					list_E.get(i).getComision(),
					list_E.get(i).getEmail(),
					list_E.get(i).getDireccion()
					);
			list_E_copia.add(e_copia);
		}
		List<Estudiante> list_E_copia2=new LinkedList<Estudiante>();
		List<Estudiante> list_E_copia3=new LinkedList<Estudiante>(list_E_copia2);
		list_E_copia2.addAll(list_E_copia);
		System.out.println("Lista original:"+list_E.toString());
		System.out.println("Lista copia: "+list_E_copia.toString());
		list_E_copia.remove(0);
		System.out.println("Lista copia con elemento 0 removed: "+list_E_copia.toString());
		System.out.println("Lista copia2 copió lista copia con .addAll antes de remover elem 0: "+list_E_copia2.toString());
		System.out.println("Lista copia3 copió lista copia con constructor antes de remover elem 0: "+list_E_copia3.toString());
		
	}
	//fin d)
	//inicio f)
	public static boolean es_capicua(ArrayList<Integer> lista) {
		List<Integer> listaOriginal = new LinkedList<Integer>(lista);
		List<Integer> listaRevertida = new LinkedList<Integer>();
		int i=0;
		Boolean b=true;
		return es_capicua_recursivo(listaOriginal,listaRevertida,i,b);
	}
	
	public static boolean es_capicua_recursivo(List<Integer> list1,List<Integer> list2,int i,Boolean b) {
		if(list1.size()>i) {
			list2.add(0,list1.get(i).intValue());
			/*me aseguro de no instanciar si no es necesario,
			entiendo que si la 1era condicion no se cumple entonces no
			se evalua la 2da y por lo tanto no se llama a la funcion*/
			if (b&&(!es_capicua_recursivo(list1,list2,i+1,b))) {b=false;}
			else { if (!b&&(es_capicua_recursivo(list1,list2,i+1,b))) {b=true;}};
		}
		else {i--;}
		if(b&&list1.get(i).intValue()==list2.get(i).intValue())return true;
		else return false;
	}
	//fin f
	//inicio g
	public static void sucesion_recursivo(LinkedList<Integer> l,int n) {
		if(n!=1) {
			if(n%2==0) {
				l.add(n/2);
				sucesion_recursivo(l,n/2);
			}
			else {
				l.add(3*n+1);
				sucesion_recursivo(l,3*n+1);
			}
		}
	}
	//fin g
	//inicio h
	public static void invertir_arraylist1(ArrayList<Integer> Lista,int i) {
		if(i!=0) {
			Lista.add(Lista.remove(--i));
			invertir_arraylist1(Lista,i);
		}
	}
	
	//fin h
	//inicio j
	public static void cargar_listas(ArrayList<Integer> lista1,ArrayList<Integer> lista2) {
		
		int dim1 = 5,dim2 = 6;
		System.out.println("    -Lista1-");
		for(int i=0;i<dim1;i++) {
			lista1.add(i*2);
			System.out.print((i+1)+" - "+lista1.get(i)+"\n");
		}
		System.out.println("    -Lista2-");
		for(int i=0;i<dim2;i++) {
			lista2.add(i*2+1);
			System.out.print((i+1)+" - "+lista2.get(i)+"\n");
		}
		
	}
	public static ArrayList<Integer> combinar_ordenado(ArrayList<Integer> lista1,ArrayList<Integer> lista2) {
		int  i=0,dim=(lista1.size()+lista2.size());
		int j=0,dimj=lista1.size();
		int k=0,dimk=(lista2.size());
		ArrayList<Integer> listar= new ArrayList<Integer>();
		while(i<dim){
			if(j<dimj&&lista1.get(j).intValue()<lista2.get(k).intValue()) {
				listar.add(lista1.get(j).intValue());
				j++;
			}
			else if(k<dimk) {
				listar.add(lista2.get(k).intValue());
				k++;
			}
			i++;
		}
		return listar;
	}
	//fin j
}
