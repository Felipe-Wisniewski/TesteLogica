package soma_maxima;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**Teste de l�gica: Dado um conjunto de n�meros, descobrir o subconjunto em que a soma dos elementos s�o de 
 * m�xima soma.
 * Exemplo: dado o conjunto de elementos [2, -4, 6, 8, -10, 100, -6, 5]
 * O subconjunto de soma m�xima �: [2, -4, **6, 8, -10, 100**, -6, 5]
 * 
 * @author Felipe Wisniewki
 * @version 1.1
 */

public class TesteSoma {

	private static Scanner scanner;
	
	public static void main(String[] args) {
		
		Integer n = 0;
		ArrayList<Integer> sequencia = new ArrayList<>();
		
		System.out.println("Digite um n�mero inteiro e aperte enter ou '9999' para parar: ");
		
		//Preenche o conjunto de inteiros
		do{
			scanner = new Scanner(System.in);
			
			try {
				n = scanner.nextInt();
				
				if(n != 9999)
					sequencia.add(n);
	
			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("Digite apenas n�meros Inteiros!!");
			}			
			
			if(n == 9999  && sequencia.isEmpty()) {
				System.out.println("N�o pode sair com o conjunto vazio!!");
				n = 0;
			}
			
		}while(n != 9999);
				
		System.out.println(subconjuntoSomaMaxima(sequencia));

	}

	private static ArrayList<String> subconjuntoSomaMaxima(ArrayList<Integer> s) {
	/**M�todo que recebe o conjunto de n�meros e retorna o subconjunto identificado por '**'
	 * @author Felipe Wisniewski
	 * @param s - ArrayList<Integer> (Conjunto de inteiros)
	 * @return sub - ArrayList<String> (Resultado com a identifica��o do subconjunto)
	 */
		
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
