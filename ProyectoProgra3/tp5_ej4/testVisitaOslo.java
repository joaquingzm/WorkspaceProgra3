package tp5_ej4;

import java.util.LinkedList;

import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;

public class testVisitaOslo {
	public static void main(String[] args) {
   	 	AdjListGraph<String> graph = new AdjListGraph<String>();
        VisitaOslo<String> VisitaOslo = new VisitaOslo<String>();
        LinkedList<String> ciudades = new LinkedList<String>();

        Vertex<String> Ayuntamiento = graph.createVertex("Ayuntamiento");
        Vertex<String> ParqueBotanico = graph.createVertex("ParqueBotanico");
        Vertex<String> AkkerBrigge = graph.createVertex("AkkerBrigge");
        Vertex<String> PalacioReal = graph.createVertex("PalacioReal");
        Vertex<String> ElTigre = graph.createVertex("ElTigre");
        Vertex<String> MuseoMunch = graph.createVertex("MuseoMunch");
        Vertex<String> LaOpera = graph.createVertex("LaOpera");
        Vertex<String> FortalezaAkershus = graph.createVertex("FortalezaAkershus");
        Vertex<String> GaleriaNacional = graph.createVertex("GaleriaNacional");
        Vertex<String> ParqueVigeland = graph.createVertex("ParqueVigeland");
        Vertex<String> FolkMuseum = graph.createVertex("FolkMuseum");
        Vertex<String> MuseoFram = graph.createVertex("MuseoFram");
        Vertex<String> MuseoVikingo = graph.createVertex("MuseoVikingo");
        Vertex<String> MuseoDelBarcoPolar = graph.createVertex("MuseoDelBarcoPolar");

        
        graph.connectND(Ayuntamiento,AkkerBrigge,20); 
        graph.connectND(Ayuntamiento,ParqueBotanico,10); 
        graph.connectND(Ayuntamiento,ElTigre,15); 
        graph.connectND(Ayuntamiento,PalacioReal,5);
        
        graph.connectND(ParqueBotanico, MuseoMunch,1);
        graph.connectND(ParqueBotanico, GaleriaNacional,15);
        
        
        graph.connectND(ElTigre,MuseoMunch,15);
        graph.connectND(ElTigre,LaOpera,5);
        
        graph.connectND(LaOpera, FortalezaAkershus,10);
        
        graph.connectND(GaleriaNacional, ParqueVigeland,10);
        
        graph.connectND(FolkMuseum,ParqueVigeland,20);
        graph.connectND(FolkMuseum,PalacioReal,5);
        graph.connectND(FolkMuseum,AkkerBrigge,30);
        graph.connectND(FolkMuseum,MuseoFram,5);
        
        graph.connectND(AkkerBrigge,MuseoVikingo,30);
        
        graph.connectND(MuseoVikingo,MuseoDelBarcoPolar,5);

        graph.connectND(MuseoFram,MuseoDelBarcoPolar,5);

        
        
        graph.printGraph();
        

        ciudades.add(AkkerBrigge.getData());
        ciudades.add(PalacioReal.getData());
        System.out.println("\nPrimer camino encontrado desde "+Ayuntamiento.getData()+" hasta "+MuseoVikingo.getData()+" exceptuando "+ciudades+"\n");
        System.out.println(VisitaOslo.paseoEnBici(graph,Ayuntamiento.getData(), MuseoVikingo.getData(), ciudades,120));
   }
}
