package EjerciciosGrafos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MatrizAdyacencia {
	public static void main(String[] args) throws IOException {
		// BufferedReader

		// BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea = br.readLine();
		String[] name = linea.split(" ");
		int Nodes = Integer.parseInt(name[0]);
		int m = Integer.parseInt(name[1]);
		int edges = m;
		String line = " ";
	
		ArrayList<int[]> arr = new ArrayList();
		while (m > 0) {
			int[] arreglo = new int[2];
			line = br.readLine();
			String[] mi = line.split(" ");
			int a = Integer.parseInt(mi[0]);
			int b = Integer.parseInt(mi[1]);
			arreglo[0] = a;
			arreglo[1] = b;
			arr.add(arreglo);
			m--;
		}
		String qu = br.readLine();
		int q = Integer.parseInt(qu);
	
		ArrayList<int[]> arr1 = new ArrayList();
		while (q > 0) {
			int[] arreglo1 = new int[2];
			line = br.readLine();
			String[] mi = line.split(" ");
			int a = Integer.parseInt(mi[0]);
			int b = Integer.parseInt(mi[1]);
		//	System.out.println(a+" "+b);
			arreglo1[0] = a;
			arreglo1[1] = b;
			arr1.add(arreglo1);
			q--;
		}
		boolean[][] matriz = new boolean[Nodes][Nodes];
		for (int i = 0; i < arr.size(); i++) {
			
				System.out.println(arr.get(i)[0] + " " + arr.get(i)[1]);
				matriz[arr.get(i)[0] - 1][arr.get(i)[1] - 1] = true;
			

		}

		for (int i = 0; i < arr1.size(); i++) {
			if (matriz[arr1.get(i)[0] - 1][arr1.get(i)[1] - 1] == true) {

				System.out.println("YES");

			} else if (matriz[arr1.get(i)[0] - 1][arr1.get(i)[1] - 1] == false) {

				System.out.println("NO");

			}

		}

	}

}
