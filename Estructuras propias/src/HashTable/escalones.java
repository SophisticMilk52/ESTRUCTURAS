package HashTable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class escalones {
	public static void main(String[] args) throws IOException {

		System.out.println(escalonariterativo(300));
		// System.out.println(escalonarfactorial(3));
		//System.out.println(fibo(1034));
	}

	public static BigInteger escalonariterativo(int escalone) {
		ArrayList<BigInteger> escalones = new ArrayList();
		BigInteger val1 = new BigInteger("1");
		BigInteger val2 = new BigInteger("2");
		BigInteger val3 = new BigInteger("3");
		escalones.add(val1);
		escalones.add(val2);
		escalones.add(val3);

		for (int i = 3; i < escalone; i++) {
			escalones.add(escalones.get(i - 1).add(escalones.get(i - 2)));
		}

		String c = escalones.get(escalone - 1) + "";
		BigInteger hola = new BigInteger(c);

		return hola;
	}

	public static long escalonarfactorial(int escalone) {

		if (escalone == 0 || escalone == 1) {
			return 1;
		} else {

			return escalonarfactorial(escalone - 1) + escalonarfactorial(escalone - 2);

		}
	}

	public static BigInteger fibo(int n) {
		MiPrimerHash map = new MiPrimerHash(n/2);
		String cst = fibo1(n, map) + "";
		BigInteger hola1 = new BigInteger(cst);
		return hola1;
	}

	private static BigInteger fibo1(int n, MiPrimerHash map) {
		if (n == 0 || n == 1) {
			BigInteger hola1 = new BigInteger("1");
			return hola1;
		} else {
			BigInteger n1;
			BigInteger n2;
			if (map.containsKey(n - 1)) {
				String cts = map.get(n - 1) + "";
				BigInteger hola1 = new BigInteger(cts);
				n1 = hola1;
			} else {
				n1 = fibo1(n - 1, map);
				map.put(n - 1, n1);
			}
			if (map.containsKey(n - 2)) {
				String cts = map.get(n - 2) + "";
				BigInteger hola1 = new BigInteger(cts);
				n2 = hola1;
			} else {
				n2 = fibo1(n - 2, map);
				map.put(n - 2, n2);
			}
			return n1.add(n2);
		}
	}

}
