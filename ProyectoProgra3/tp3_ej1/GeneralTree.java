package tp3_ej1;
import java.util.LinkedList;
public class GeneralTree<T> {
	private LinkedList<GeneralTree<T>> children;
	private T data;
	
	public GeneralTree() {}
	public GeneralTree(T data) {
		this.setChildren(null);
		this.data=data;
	}
	public GeneralTree(T data,LinkedList<GeneralTree<T>> children) {
		this.setChildren(children);
		this.setData(data);
	}
	public LinkedList<GeneralTree<T>> getChildren() {
		return children;
	}
	public void setChildren(LinkedList<GeneralTree<T>> children) {
		this.children = children;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public void addChild(GeneralTree<T> child) {
		this.children.add(child);
	}
	public void removeChild(GeneralTree<T> child) {
		int i=0;
		while(i<this.getChildren().size()&&this.getChildren().get(i)!=child) {
			i++;
		}
		if(this.getChildren().get(i)!=child) {
			this.getChildren().remove(i);
		}
	}
	public boolean hasChildren() {
		return this.getChildren()!=null&&!this.getChildren().isEmpty();
	}
	public boolean isEmpty() {
		return this.getData()==null&&this.getChildren()==null;
	}
	public boolean isLeaf() {
		return this.getChildren()==null;
	}
	public int altura() {
		if(!this.isLeaf()) {
			int max=0;
			int alt;
			for(GeneralTree<T> h : this.getChildren()) {
				alt = h.altura();
				if(alt>max)max=alt;
			}
			return max+1;
		}
		else return 0;
	}
	
	public int nivel(T dato) {
		if(this!=null) {
			if(this.getData()==dato)return 0;
			if(this.hasChildren()) {
				int aux;
				for(GeneralTree<T> nodo : this.getChildren()) {
					aux=nodo.nivel(dato);
					if(aux>=0)return aux+1;
				}
			}
		}
		return -1;
	}
	
	public int ancho() {
		if(this!=null) {
			if(this.hasChildren()) {
				int aux;
				int max_ancho = this.getChildren().size();
				for(GeneralTree<T> nodo : this.getChildren()) {
					aux=nodo.ancho();
					if(aux>max_ancho)max_ancho=aux;
				}
				return max_ancho;
			}
		}
		return (this.isEmpty()?0:1);
	}
	
	public GeneralTree<T> encontrarNodo(T data){
		if(this!=null&&!this.isEmpty()) {
			if(this.getData()==data)return this;
			if(this.hasChildren()) {
				GeneralTree<T> aux;
				for(GeneralTree<T> nodo : this.getChildren()) {
					aux = nodo.encontrarNodo(data);
					if(aux!=null)return aux;
				}
			}
		}
		return null;
	}
	
	public boolean esAncestro(T a, T b) {
		if(a!=null&&b!=null) {
			GeneralTree<T> aux = this.encontrarNodo(a);
			if(aux!=null) {
				aux = aux.encontrarNodo(b);
				return aux!=null;
			}
		}
		return false;
	}	
	
	
	
	
	
	
	
}
