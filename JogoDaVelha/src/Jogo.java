import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jogo {

	private Tabuleiro tabuleiro;
	private Jogador[] jogador;
	private char simbolo;
	private Scanner scan;
	private Random rand;
	private List<Integer> posicaoX;
	private List<Integer> posicaoO;
	private String resultado;
	private char[][] tab = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
			{ '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };

	public Jogo() {
		posicaoX = new ArrayList<Integer>();
		posicaoO = new ArrayList<Integer>();
		tabuleiro = new Tabuleiro();
		jogador = new Jogador[2];
		jogador[0] = new Jogador("HUMANO", 'X');
		jogador[1] = new Jogador("COMPUTADOR", 'O');
		inicio();
	}

	public void testaVencedor(Jogador j, List<Integer> l) {
		resultado = j.vitoria(l);
		if (!resultado.equals("")) {
			desenhaTabuleiro(tab);
			System.out.println(resultado);
			System.exit(0);
		}
	}

	public void desenhaTabuleiro(char[][] tab) {
		tabuleiro.desenhaTabuleiro(tab);
	}

	public void insereX(char[][] tab) {
		scan = new Scanner(System.in);
		System.out.print("Insere uma posicao no tabuleiro(1-9): ");
		String str = scan.next();
		int p = validaNumero(str);
		while (posicaoX.contains(p) || posicaoO.contains(p)) {
			System.out.println("Posicao invalida...");
			scan = new Scanner(System.in);
			System.out.print("Insere uma posicao no tabuleiro(1-9): ");
			str = scan.next();
			p = validaNumero(str);
		}
		posicaoX.add(p);
		jogada(tab, p, jogador[0]);
		testaVencedor(jogador[0], posicaoX);
	}

	public void insereO(char[][] tab) {
		rand = new Random();
		int p = rand.nextInt(9) + 1;
		while (posicaoO.contains(p) || posicaoX.contains(p)) {
			p = rand.nextInt(9) + 1;
		}
		posicaoO.add(p);
		jogada(tab, p, jogador[1]);
		testaVencedor(jogador[1], posicaoO);
	}
	
	public int validaNumero(String str) {
		while (!str.matches("[1-9]")) {
			System.out.println("Posicao invalida...");
			scan = new Scanner(System.in);
			System.out.print("Insere uma posicao no tabuleiro(1-9): ");
			str = scan.next();
		}
		int p = Integer.parseInt(str);
		return p;
	}

	public void inicio() {
		while (true) {
			desenhaTabuleiro(tab);
			insereX(tab);
			insereO(tab);
		}
	}

	public void jogada(char[][] tab, int pos, Jogador jogador) {
		simbolo = jogador.getSimbolo();

		switch (pos) {
		case 1:
			tab[0][0] = simbolo;
			break;
		case 2:
			tab[0][2] = simbolo;
			break;
		case 3:
			tab[0][4] = simbolo;
			break;
		case 4:
			tab[2][0] = simbolo;
			break;
		case 5:
			tab[2][2] = simbolo;
			break;
		case 6:
			tab[2][4] = simbolo;
			break;
		case 7:
			tab[4][0] = simbolo;
			break;
		case 8:
			tab[4][2] = simbolo;
			break;
		case 9:
			tab[4][4] = simbolo;
			break;

		default:
			break;
		}
	}
	
	

	public static void main(String[] args) {
		new Jogo();
	}

}
