package EjerciciosGrafos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MonkInTheRealState {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea = br.readLine();
		int test = Integer.parseInt(linea);
		for (int i = 0; i < test; i++) {
			int e = Integer.parseInt(br.readLine());
			ArrayList<Integer> arreglo = new ArrayList();
			for (int j = 0; j < e; j++) {
				String[] ar = br.readLine().split(" ");
				int[] arr = new int[2];
				arr[0] = Integer.parseInt(ar[0]);
				arr[1] = Integer.parseInt(ar[1]);
				boolean cons = false;
				boolean cons2 = false;
				if (arreglo.isEmpty()) {
					if(arr[0]==arr[1]) {
						arreglo.add(arr[0]);
					}else {
					arreglo.add(arr[0]);
					arreglo.add(arr[1]);
				} }else {
				for (int k = 0; k < arreglo.size(); k++) {
				
						if (arreglo.get(k) == arr[0] && cons == false) {
							cons = true;
						} else if (k == arreglo.size() - 1 && cons == false && arreglo.get(k) != arr[0]) {
							arreglo.add(arr[0]);
						}
						if (arreglo.get(k) == arr[1] && cons2 == false) {
							cons2 = true;
						} else if (k == arreglo.size() - 1 && cons2 == false && arreglo.get(k) != arr[1]) {
							arreglo.add(arr[1]);
						}
					}
				}
				
			}
            System.out.println(arreglo.size());
		}
	}

}
