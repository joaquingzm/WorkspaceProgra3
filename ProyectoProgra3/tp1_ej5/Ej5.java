package tp1_ej5;

public class Ej5 {

	public static void main(String[] args) {
		int[] arregloInt = {1,2,3,4,5,};		
		int[] result;
		result=a(arregloInt);
		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println(result[2]);
		System.out.println();
		MaxMinProm mmp = new MaxMinProm();
		b(arregloInt,mmp);
		System.out.println(mmp.getMax());
		System.out.println(mmp.getMin());
		System.out.println(mmp.getProm());
		System.out.println();	
	}

	public static int[] a(int arr[]) {
		int max=-99999,min=9999,prom=0;
		int[] aux = new int[3];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max)max=arr[i];
			if(arr[i]<min)min=arr[i];
			prom+=arr[i];
		}
		prom/=arr.length;
		aux[0]=max;
		aux[1]=min;
		aux[2]=prom;
		return aux;
	}
	
	public static void b(int arr[],MaxMinProm p) {
		int max=-99999,min=9999,prom=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max)max=arr[i];
			if(arr[i]<min)min=arr[i];
			prom+=arr[i];
		}
		prom/=arr.length;
		p.setMax(max);
		p.setMin(min);
		p.setProm(prom);
	}
	
	
}
