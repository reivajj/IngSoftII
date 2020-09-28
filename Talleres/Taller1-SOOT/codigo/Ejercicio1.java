public class Ejercicio1 {

	public int exercise1(String[] args) {
		int a = 8; int c = 3;
		if(args.length > 2) {
			a = 5;
		}
		c = 1;
		while(!(c > a)) {
			c = c + 2;
		}
		a = c - a;
		return a;
	}

}