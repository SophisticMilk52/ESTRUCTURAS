package EjerciciosGrafos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ListaAdyacencia {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea = br.readLine();
		String[] arr = linea.split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		HashMap map = new HashMap();
		while (m > 0) {
			String lin = br.readLine();
			String[] val = lin.split(" ");
			int a = Integer.parseInt(val[0]);
			int b = Integer.parseInt(val[1]);
	
			map.put(a, b);
			m--;

		}
		String lin=br.readLine();
		int q= Integer.parseInt(lin);
		while (q>0) {
			String lineas = br.readLine();
			String[] val = lineas.split(" ");
			int a = Integer.parseInt(val[0]);
			int b = Integer.parseInt(val[1]);
if(map.get(a).equals(b)) {
	System.out.println("YES");
	}else {
		System.out.println("NO");
	}
			q--;
		}
	}
}
