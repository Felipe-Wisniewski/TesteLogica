package soma_maxima;

import java.util.ArrayList;
import java.util.Scanner;

public class TesteSoma {

	private static Scanner scanner;
	
	public static void main(String[] args) {
		
		Integer n;
		ArrayList<Integer> sequencia = new ArrayList<>();
		
		System.out.println("Digite um número inteiro e aperte enter ou 00 para sair: ");
		
		do{
			scanner = new Scanner(System.in);
			n = scanner.nextInt();
			
			if(n != 00)
				sequencia.add(n);
			
		}while(n != 00);
		
		System.out.println(subconjuntoSomaMaxima(sequencia));

	}

	private static ArrayList<String> subconjuntoSomaMaxima(ArrayList<Integer> s) {
		
		ArrayList<String> sub = new ArrayList<>();
		int maxTotal, maxAtual, idx, idxI, idxF;
		maxAtual = 0;
		maxTotal = -1;
		idx = 0;
		idxI = 0;
		idxF = 0;	
		
		for(int i = 0; i < s.size(); i++) {
			maxAtual = maxAtual + s.get(i);
			
			if(s.get(i) > maxAtual) {
				maxAtual = s.get(i);
				idx = i;			
			}				
						
			if(maxAtual > maxTotal) {
				maxTotal = maxAtual;
				idxI = idx;
				idxF = i;
			}
			sub.add(s.get(i).toString());
		}		
		
		sub.set(idxI, "**" + s.get(idxI).toString());
		sub.set(idxF, s.get(idxF).toString() + "**");
		
		return sub;
	}

}
