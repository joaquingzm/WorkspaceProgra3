package tp3_ej6;
import tp3_ej1.GeneralTree;
public class RedDeAguaPotable {
	GeneralTree<String> ag = null;
	
	public RedDeAguaPotable() {
	}
	public RedDeAguaPotable(GeneralTree<String> ag) {
		this.ag=ag;
	}
	
	public double minimoCaudal(double caudal) {
		if(this.ag!=null) {
			return minimoCaudalP(caudal,ag);
		}
		return -1;
	}
	
	private double minimoCaudalP(double caudal, GeneralTree<String> ag) {
		if(ag.hasChildren()) {
			int dim = ag.getChildren().size();
			double aux=0;
			double min=caudal;
			for(GeneralTree<String> nodo : ag.getChildren()) {
				aux=minimoCaudalP(caudal/dim,nodo);
				if(aux<min)min=aux;
			}
			return min;
		}
		return caudal;
	}
}
