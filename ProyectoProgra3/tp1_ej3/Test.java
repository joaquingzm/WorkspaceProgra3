package tp1_ej3;

public class Test {

	public static void main(String[] args) {
	
		Estudiante[] arregloEst = new Estudiante[2];
		Profesor[] arregloProf = new Profesor[3];
		
		for(int i=0;i<arregloEst.length;i++) {
			arregloEst[i] = new Estudiante();
			arregloEst[i].setNombre(""+i);
			arregloEst[i].setApellido(""+i);
			arregloEst[i].setEmail(""+i);
			arregloEst[i].setComision(""+i);
			arregloEst[i].setDireccion(""+i);
		}
		
		for(int i=0;i<arregloProf.length;i++) {
			arregloProf[i] = new Profesor();
			arregloProf[i].setNombre(""+i);
			arregloProf[i].setApellido(""+i);
			arregloProf[i].setEmail(""+i);
			arregloProf[i].setCatedra(""+i);
			arregloProf[i].setFacultad(""+i);
		}
		
		
		for(int i=0;i<arregloEst.length;i++) {
			System.out.print(arregloEst[i].tusDatos());
			System.out.print("\n");
		}
		
		for(int i=0;i<arregloProf.length;i++) {
			System.out.print(arregloProf[i].tusDatos());
			System.out.print("\n");
		}
		
		System.out.println("hola");
	
	}

}
