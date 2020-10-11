package Modelo;

public class Juego {
	private int solucion;
	private int intentos;
	
	public Juego() {
		solucion = (int)( (Math.random() * 100) +1);
		intentos = 1;
	}
	
	public String[] jugar(int intento) {
		String []resultado = new String[2];
		if(solucion == intento) {
			resultado[0] = "";
			resultado[1] = "Lo has intentado " + intentos + " veces";
			intentos = 1;
			solucion = (int)( (Math.random() * 100) +1);
		}else {
			intentos++;
			if(intento < solucion) {
				resultado[0] = "La solucion es mayor que " + intento;
			}else {
				resultado[0] = "La solucion es menor que " + intento;
			}
		}
		return resultado;
	}
	
	
	public void hacerTrampa() {
		System.out.println("solucion: " + solucion);
	}
}
