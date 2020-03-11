
public class Tabuleiro {

	public Tabuleiro() {

	}

	public void desenhaTabuleiro(char[][] tab) {
		for (char[] row : tab) {
			for (char column : row) {
				System.out.print(column);
			}
			System.out.println();
		}
	}

}
