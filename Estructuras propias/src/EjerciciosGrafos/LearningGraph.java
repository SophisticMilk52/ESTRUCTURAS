package EjerciciosGrafos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class LearningGraph {
	private static nodo nod;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea = br.readLine();
		String[] NMK = linea.split(" ");
		int n = Integer.parseInt(NMK[0]);
		int m = Integer.parseInt(NMK[1]);
		int k = Integer.parseInt(NMK[2]);
		TreeMap map = new TreeMap();
		String[] valoresString = linea.split(" ");
		int[] valoresInt = new int[n];
		for (int i = 0; i < valoresString.length; i++) {
			valoresInt[i] = Integer.parseInt(valoresString[i]);
		}
		int cont = 1;
		while (m > 0) {
			nodo nod2 = new nodo(cont, valoresInt[m]);
			cont++;
			String[] arr = br.readLine().split(" ");
			int[] arr2 = new int[2];
			arr2[0] = Integer.parseInt(arr[0]);
			arr2[1] = Integer.parseInt(arr[1]);
			ArrayList<Integer> val = new ArrayList();
			if (map.isEmpty()) {
				val.add(arr2[1]);
				map.put(arr2[0], val);
			} else {
				if (map.get(arr[0]) != null) {
					((ArrayList<Integer>) map.get(arr[0])).add(arr2[1]);
				} else {
					val.add(arr2[1]);
					map.put(arr2[0], val);
				}
			}
			m--;
		}

	}

	public static class nodo implements Comparator {
		public int valor;
		public int peso;

		public nodo(int val, int conx) {
			val = valor;
			conx = peso;
		}

		@Override
		public int compare(Object o1, Object o2) {
			nodo nodo1 = (nodo) o1;
			nodo nodo2 = (nodo) o2;
			if (nodo1.peso > nodo2.peso) {
				return 1;
			} else {
				return 0;
			}
		}
	}

}