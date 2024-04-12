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
	
}
