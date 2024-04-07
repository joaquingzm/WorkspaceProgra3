package tp2_ej9;

public class Valores {
	private int sum;
	private int dif;
	
	public Valores() {
		
	}
	public Valores(int sum,int dif) {
		this.sum=sum;
		this.dif=dif;
	}
	
	public void setSum(int sum) {
		this.sum=sum;
	}
	public void setDif(int dif) {
		this.dif=dif;
	}
	public int getSum() {
		return sum;
	}
	public int getDif() {
		return dif;
	}
	public String toString() {
		String aux = ("S:"+this.getSum()+" D:"+this.getDif());
		return aux;
	}
}
