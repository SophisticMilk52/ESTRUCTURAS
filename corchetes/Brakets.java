package corchetes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Brakets {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea = br.readLine();
		while (linea != null) {
			Stack <String>pila = new Stack();

			for (int i = 0; i < linea.length(); i++) {
				if (linea.charAt(i) == '(' || linea.charAt(i) == '[' || linea.charAt(i) == '{' ) {
					pila.add(linea.charAt(i)+"");
				}
				if (pila.isEmpty() == false) {
					if (pila.peek().equals("{")) {
						if (linea.charAt(i) == '}') {
							pila.pop();
						}

					} else if (pila.peek().equals("[")) {
						if (linea.charAt(i) == ']') {
							pila.pop();
					
						}

					}
				} else if (pila.peek().equals("(")) {
					if (linea.charAt(i) == ')') {
						pila.pop();
					}
				}
				if (pila.isEmpty() == true && i == linea.length() - 1) {
					System.out.println(true);
				} else if (pila.isEmpty() == false && i == linea.length() - 1) {
					System.out.println(false);
				}

			}
			linea = br.readLine();
		}
	}

}
