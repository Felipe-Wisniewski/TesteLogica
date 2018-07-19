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
		int maxTotal, maxAtual, n;
		maxAtual = 0;
		maxTotal = -1;
		n=0;
		
		for(int i = 0; i < s.size(); i++) {
			maxAtual = maxAtual + s.get(i);
			
			//Se a soma for negativa, zera o valor
			if(maxAtual < 0) {
				maxAtual = 0;
				sub.clear();
				n=0;
			}				
			
			
			if(maxAtual > maxTotal) {
				maxTotal = maxAtual;
				
				if(n == 0) {
					sub.add("**" + s.get(i).toString());
					n++;
				}else if(n == 1) {
					sub.add(s.get(i).toString() + "**");
					n++;
				}else {
					sub.set(sub.size() - 1, s.get(i - 1).toString());
					sub.add(s.get(i).toString() + "**");
				}
				
			}else {
				sub.add(s.get(i).toString());
			}
			
		}		
			
		return sub;
	}

}
