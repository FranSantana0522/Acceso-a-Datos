package prueba;

public class Boletin2Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 1;
		int contP = 0;
		for (int i = 0; i < num; i++) {
			if (esPrimo(i)) {
				System.out.println("Primo: " + i);
				if (contP < 21) {
					num = num + 1;
					contP++;
				} else {
					num = 0;
				}
			} else {
				if (contP < 20) {
					num = num + 1;
				} else {
					num = 0;
				}
			}
		}
	}

	public static boolean esPrimo(int i) {
		int contador = 2;
		boolean primo = true;
		while ((primo) && (contador != i)) {
			if (i % contador == 0)
				primo = false;
			contador++;
		}
		return primo;
	}

}
