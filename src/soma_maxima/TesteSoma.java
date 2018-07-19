package soma_maxima;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**Teste de lógica: Dado um conjunto de números, descobrir o subconjunto em que a soma dos elementos são de 
 * máxima soma.
 * Exemplo: dado o conjunto de elementos [2, -4, 6, 8, -10, 100, -6, 5]
 * O subconjunto de soma máxima é: [2, -4, **6, 8, -10, 100**, -6, 5]
 * 
 * @author Felipe Wisniewki
 * @version 1.1
 */

public class TesteSoma {

	private static Scanner scanner;
	
	public static void main(String[] args) {
		
		Integer n = 0;
		ArrayList<Integer> sequencia = new ArrayList<>();
		
		System.out.println("Digite um número inteiro e aperte enter ou '9999' para parar: ");
		
		//Preenche o conjunto de inteiros
		do{
			scanner = new Scanner(System.in);
			
			try {
				n = scanner.nextInt();
				
				if(n != 9999)
					sequencia.add(n);
	
			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("Digite apenas números Inteiros!!");
			}			
			
			if(n == 9999  && sequencia.isEmpty()) {
				System.out.println("Não pode sair com o conjunto vazio!!");
				n = 0;
			}
			
		}while(n != 9999);
				
		System.out.println(subconjuntoSomaMaxima(sequencia));

	}

	private static ArrayList<String> subconjuntoSomaMaxima(ArrayList<Integer> s) {
	/**Método que recebe o conjunto de números e retorna o subconjunto identificado por '**'
	 * @author Felipe Wisniewski
	 * @param s - ArrayList<Integer> (Conjunto de inteiros)
	 * @return sub - ArrayList<String> (Resultado com a identificação do subconjunto)
	 */
		
		ArrayList<String> sub = new ArrayList<>();
		int maxTotal, maxAtual, indX, indI, indF;
		maxAtual = 0;
		maxTotal = -1;
		indX = 0;
		indI = 0;
		indF = 0;	
		
		for(int i = 0; i < s.size(); i++) {
			maxAtual = maxAtual + s.get(i);
			
			//Se o resultado da soma for menor que a posição atual, atualiza o índice do subconjunto
			if(s.get(i) > maxAtual) {
				maxAtual = s.get(i);
				indX = i;			
			}				
			
			//Atualiza a soma total e seus índices no array
			if(maxAtual > maxTotal) {
				maxTotal = maxAtual;
				indI = indX;
				indF = i;
			}
			sub.add(s.get(i).toString());
		}		
		
		//Edita a posição inicial e final do subconjunto dentro do array
		sub.set(indI, "**" + s.get(indI).toString());
		sub.set(indF, s.get(indF).toString() + "**");
		
		return sub;
	}

}
