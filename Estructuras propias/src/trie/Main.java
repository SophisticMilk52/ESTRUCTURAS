package trie;

public class Main {
	public Main() {
		Trie root = new Trie();
		root.add("sol");
		root.add("casa");
		root.add("carro");
		root.add("calcio");
		//this.mostrarArbol(root);
	this.leertrie(root);
	}

	private void mostrarArbol(Trie root) {
		if (root != null) {
			for (int i = 0; i < root.size(); i++) {
				if (root.letters[i] != null) {
					System.out.println("" + (char) (i + 'a'));
					this.mostrarArbol(root.letters[i]);

				}
			}
		}
	}

	private void leertrie(Trie root) {
		if (root != null) {
			
			for (int i = 0; i < root.size(); i++) {
				if (root.letters[i] != null) {
					this.mostrarArbol(root.letters[i]);
					System.out.println("" + ((char) (i  +'a')));
				}
			}
		}

	}

	public static void main(String[] args) {
		Main m = new Main();
	}
}
