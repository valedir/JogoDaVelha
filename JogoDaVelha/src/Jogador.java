import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jogador {

	private String jogador;
	private char simbolo;
	private List<List<?>> vencedor;

	public Jogador(String jogador, char simbolo) {
		super();
		this.jogador = jogador;
		this.simbolo = simbolo;
		vencedor = new ArrayList<List<?>>();
		adiciona();
	}

	public String getJogador() {
		return jogador;
	}

	public void setJogador(String jogador) {
		this.jogador = jogador;
	}

	public char getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}

	public String vitoria(List<Integer> pos) {
		for (List<?> l : vencedor) {
			if (pos.containsAll(l)) {
				return jogador + " ganohu..!!";
			}
		}
		for (List<?> l : vencedor) {
			if (!pos.containsAll(l) && pos.size() == 5) {
				return "Empate";
			}
		}
		return "";
	}

	public void adiciona() {
		List<Integer> linha1 = Arrays.asList(1, 2, 3);
		List<Integer> linha2 = Arrays.asList(4, 5, 6);
		List<Integer> linha3 = Arrays.asList(7, 8, 9);
		List<Integer> coluna1 = Arrays.asList(1, 4, 7);
		List<Integer> coluna2 = Arrays.asList(2, 5, 8);
		List<Integer> coluna3 = Arrays.asList(3, 6, 9);
		List<Integer> crus1 = Arrays.asList(1, 5, 9);
		List<Integer> crus2 = Arrays.asList(7, 5, 3);
		vencedor.add(linha1);
		vencedor.add(linha2);
		vencedor.add(linha3);
		vencedor.add(coluna1);
		vencedor.add(coluna2);
		vencedor.add(coluna3);
		vencedor.add(crus1);
		vencedor.add(crus2);
	}

}
