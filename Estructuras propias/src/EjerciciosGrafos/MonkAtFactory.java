package EjerciciosGrafos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonkAtFactory {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int n = Integer.parseInt(line);

		String linea= br.readLine();
		String[] arr= linea.split(" ");
		int []num= new int[n];
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			num[i]=Integer.parseInt(arr[i]);
		}
		for (int i = 0; i < num.length; i++) {
			result+=num[i];
		}
		result=result/2;
	
		if(result+1==n) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}

}
