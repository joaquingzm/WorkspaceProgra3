package tp5_ej5;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.listaAdy.AdjListGraph;
import tp5.ejercicio1.listaAdy.AdjListVertex;

import java.util.List;
import java.util.Random;

public class testQuedateEnCasa {
	public static void main(String[]args) {
		AdjListGraph<Persona> grafo = new AdjListGraph<Persona>();
		int cantPersonas = 12;
		int maxJubilados = 8;
		int grado = 2;
		QuedateEnCasa qdec = new QuedateEnCasa();
		Persona empleadoP= new Persona(false,false,"E");
		AdjListVertex<Persona> empleadoV = (AdjListVertex<Persona>) grafo.createVertex(empleadoP);
		generarGrafoJubilados(grafo,empleadoV,cantPersonas);
		grafo.printGraph();
		System.out.println(qdec.algoritmoDistanciaMenor(grafo, (AdjListVertex<Persona>)empleadoV, grado, maxJubilados));
	}
	
	public static void generarGrafoJubilados(AdjListGraph<Persona> grafo,AdjListVertex<Persona> empleado,int cantPersonas) {
		//Le pegué a una semilla que crea una componente conexa que incluye a todos los vertices
		Random rand = new Random(1);
		
		Persona auxP;
		AdjListVertex<Persona> auxV;
		int eJ,jP,dim,elemento;
		boolean jubilacionPercibida,esJubilado;
		String nombre;
		
		
		for(int i=0;i<cantPersonas;i++) {
			eJ = rand.nextInt(5);
			jP = rand.nextInt(5);
			dim = rand.nextInt(4);
		
			if(eJ==0) {
				esJubilado=false;
			}
			else {
				esJubilado=true;
			}
			if(esJubilado) {
				nombre = ("J"+i);
			}
			else {
				nombre = ("P"+i);
			}
			if(esJubilado) {
				if(jP!=0) {
					jubilacionPercibida=false;
				}
				else {
					jubilacionPercibida=true;
				}
			}
			else {
				jubilacionPercibida=false;
			}
			auxP = new Persona(esJubilado,jubilacionPercibida,nombre);
			auxV = (AdjListVertex<Persona>)grafo.createVertex(auxP);
			
			for(int j=0;j<dim;j++) {
				elemento = rand.nextInt(grafo.getSize());
				if(grafo.getVertices().get(elemento)!=auxV&&!algunaAristaApuntaA((AdjListVertex<Persona>)grafo.getVertices().get(elemento),auxV.getEdges())) {
					grafo.connectND(auxV, grafo.getVertices().get(elemento));
				}
			}
		}
	}
	
	public static boolean algunaAristaApuntaA(AdjListVertex<Persona> vertex,List<Edge<Persona>> listaE ) {
		for(Edge<Persona> e : listaE) {
			if(e.getTarget()==vertex)return true;
		}
		return false;
	}
}
