package tp5_ej3;

import tp5.ejercicio1.listaAdy.*;

import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Vertex;

public class testCaminos {
    public static void main(String[] args) {
        probarCaminos1y2();
        System.out.println("\n\n");
        probarCaminos3();
        System.out.println("\n\n");
        probarCaminos4();
        System.out.println("\n\n");
        probarCaminos5();
    }

    public static void printGraph(AdjListGraph<Integer> graph) {
        List<Vertex<Integer>> vertices = graph.getVertices();
        for (Vertex<Integer> vertex : vertices) {
            System.out.print("Vertex " + vertex.getData() + ": ");
            List<Edge<Integer>> edges = graph.getEdges(vertex);
            for (Edge<Integer> edge : edges) {
                System.out.print(" -> (" + edge.getTarget().getData() + ", weight: " + edge.getWeight() + ")");
            }
            System.out.println();
        }
    }
    
    public static void probarCaminos1y2() {
    	 AdjListGraph<Integer> graph = new AdjListGraph<Integer>();
         Mapa<Integer> mapa = new Mapa<Integer>();
         LinkedList<Integer> ciudades = new LinkedList<Integer>();

         Vertex<Integer> v1 = graph.createVertex(1);
         Vertex<Integer> v2 = graph.createVertex(2);
         Vertex<Integer> v3 = graph.createVertex(3);
         Vertex<Integer> v4 = graph.createVertex(4);
         Vertex<Integer> v5 = graph.createVertex(5);
         Vertex<Integer> v6 = graph.createVertex(6);
         
         graph.connectND(v1, v2); 
         graph.connectND(v1, v3); 
         graph.connectND(v3, v5); 
         graph.connectND(v2, v4);
         graph.connectND(v4, v5);
         graph.connectND(v3,v6);
         graph.connectND(v5, v6);

         printGraph(graph);
         
         mapa.setGrafo(graph);
         System.out.println("\nPrimer camino encontrado desde "+v1.getData()+" hasta "+v6.getData()+"\n");
         System.out.println(mapa.devolverCamino(v1.getData(), v6.getData()));

         ciudades.add(2);
         System.out.println("\nPrimer camino encontrado desde "+v1.getData()+" hasta "+v6.getData()+" exceptuando "+ciudades+"\n");
         System.out.println(mapa.devolverCaminoExceptuando(v1.getData(), v6.getData(), ciudades));
    }
    
    public static void probarCaminos3() {
    	AdjListGraph<Integer> graph = new AdjListGraph<Integer>();
        Mapa<Integer> mapa = new Mapa<Integer>();
        

        Vertex<Integer> v1 = graph.createVertex(1);
        Vertex<Integer> v2 = graph.createVertex(2);
        Vertex<Integer> v3 = graph.createVertex(3);
        Vertex<Integer> v4 = graph.createVertex(4);
        Vertex<Integer> v5 = graph.createVertex(5);
        Vertex<Integer> v6 = graph.createVertex(6);
        
        graph.connectND(v1, v2,5); 
        graph.connectND(v1, v3,8); 
        graph.connectND(v3, v5,1); 
        graph.connectND(v2, v4,1);
        graph.connectND(v4, v5,2);
        graph.connectND(v3,v6,-12);
        graph.connectND(v5, v6,-4);

        printGraph(graph);
        
        mapa.setGrafo(graph);
        
        System.out.println("\nCamino más corto encontrado desde "+v1.getData()+" hasta "+v6.getData()+" contando con pesos negativos\n");
        System.out.println(mapa.caminoMasCorto(v1.getData(), v6.getData()));
    }
    
    public static void probarCaminos4() {
    	AdjListGraph<Integer> graph = new AdjListGraph<Integer>();
        Mapa<Integer> mapa = new Mapa<Integer>();
        int combustible = 10;

        Vertex<Integer> v1 = graph.createVertex(1);
        Vertex<Integer> v2 = graph.createVertex(2);
        Vertex<Integer> v3 = graph.createVertex(3);
        Vertex<Integer> v4 = graph.createVertex(4);
        Vertex<Integer> v5 = graph.createVertex(5);
        Vertex<Integer> v6 = graph.createVertex(6);
        
        graph.connectND(v1, v2,5); 
        graph.connectND(v1, v3,8); 
        graph.connectND(v3, v5,1); 
        graph.connectND(v2, v4,1);
        graph.connectND(v4, v5,2);
        graph.connectND(v3,v6,4);
        graph.connectND(v5, v6,2);

        printGraph(graph);
        
        mapa.setGrafo(graph);
        
        System.out.println("\nCamino sin cargar combustible y con el mayor combustible restante encontrado desde "+v1.getData()+" hasta "+v6.getData()+"\n");
        System.out.println(mapa.caminoSinCargarCombustible(v1.getData(), v6.getData(),combustible));
    }
    
    public static void probarCaminos5() {
    	AdjListGraph<Integer> graph = new AdjListGraph<Integer>();
        Mapa<Integer> mapa = new Mapa<Integer>();
        int capacidadTanque = 10;
        

        Vertex<Integer> v1 = graph.createVertex(1);
        Vertex<Integer> v2 = graph.createVertex(2);
        Vertex<Integer> v3 = graph.createVertex(3);
        Vertex<Integer> v4 = graph.createVertex(4);
        Vertex<Integer> v5 = graph.createVertex(5);
        Vertex<Integer> v6 = graph.createVertex(6);
        
        
        graph.connectND(v1, v2,5); 
        graph.connectND(v1, v3,8); 
        graph.connectND(v3, v5,4); 
        graph.connectND(v2, v4,4);
        graph.connectND(v4, v5,9);
        graph.connectND(v3,v6,8);
        graph.connectND(v5, v6,7);

        printGraph(graph);
        
        mapa.setGrafo(graph);
        
        System.out.println("\nCamino con la menor cantidad de cargas de combustible encontrado desde "+v1.getData()+" hasta "+v6.getData()+"\n");
        System.out.println(mapa.caminoConMenorCargaDeCombustible(v1.getData(), v6.getData(),capacidadTanque));
    }
}

