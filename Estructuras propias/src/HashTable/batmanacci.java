package HashTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class batmanacci {
	private ArrayList <String> batman;
	
	public batmanacci() {
		super();
		batman= new ArrayList();
	}

	public static void main(String[] args) throws IOException {
		
		//LECTURA DE ARCHIVO TXT
		File file = new File ("Hola Mundo.txt");//Carga el archivo
		
		try {
			FileReader reader = new FileReader(file); //Se prepara para la lectura del archivo
			BufferedReader br = new BufferedReader(reader); //Se carga en el buffer para su manipulación
			String line = "";
			
			while((line = br.readLine()) != null){ //Se leen las lineas hasta el final del documento
				System.out.println(line);
			}
			
			br.close(); //Se cierra el buffer
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
		
		}
		
		
		
		
		//LECTURA POR CONSOLA LO CSIGO CON UN WHILE
		
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		String parametros=buf.readLine();
		int n=Integer.parseInt(parametros.split(" ")[0]);
		long k=Long.parseLong(parametros.split(" ")[1]);
		
		if(n==1) {
			System.out.println("N");
		}else if(n==2) {
			System.out.println("A");
		}else {
			String n2="N";
			String n1="A";
			String actual="";
			for (int i = 3; i <=n; i++) {
				actual=n2+n1;
				n2=n1;
				n1=actual;
				
			}
			System.out.println(actual.charAt((int) (k-1)));
		}
	
		
	}

	
//	public static String fibo(long k, long n) {
//		MiPrimerHash map = new MiPrimerHash((int) (n / 2));
//		String cst = fibo1(n, k, map) + "";
//		return cst;
//	}
//
//	private static StringBuilder fibo1(long n, long k, MiPrimerHash map) {
//		StringBuilder resp = new StringBuilder();
//		String val = "";
//		if (n == 1) {
//			resp.append("N");
//			return resp;
//		} else if (n == 2) {
//			resp.append("A");
//			return resp;
//		}
//
//		else {
//			StringBuilder n1= new StringBuilder();
//			StringBuilder n2= new StringBuilder();
//			if (map.containsKey(n - 2)) {
//				String cts = map.get(n - 2) + "";
//
//				n1.append(cts);
//			} else {
//				n1.append(fibo1(n - 2, k, map));
//				map.put(n - 2, n1);
//			}
//			if (map.containsKey(n - 1)) {
//				String cts = map.get(n - 1) + "";
//				n2.append( cts);
//			} else {
//				n2.append( fibo1(n - 1, k, map));
//				map.put(n - 1, n2);
//			}
//
//			resp.append(n1);
//			resp.append(n2);
//		}
//
//		return resp;
//	}
}
