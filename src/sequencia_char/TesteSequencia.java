package sequencia_char;

import java.util.Scanner;

/**Teste de l�gica: Dada uma palavra, escreva um algoritmo que retorne a sequ�ncia de caracteres que mais 
 * aparecem em sequ�ncia. Ex.: "Pressaaao", deve retornar "aaa". 
 * 
 * @author Felipe Wisniewski
 * @version 1.0
 */

public class TesteSequencia {

	private static Scanner scanner;

	public static void main(String[] args) {
		String palavra;
		
		System.out.println("Entre com a palavra: ");
		scanner = new Scanner(System.in);
		palavra = scanner.nextLine(); 
		
		Palavra p = new Palavra(palavra);
		
		System.out.println(sequenciaCaracteres(p));		

	}
	
	public static String sequenciaCaracteres(Palavra pa) {
	/**M�todo que retorna a sequ�ncia de caracteres que mais aparecem.
	 * @author Felipe Wisniewski
	 * @param pa - Objeto do tipo Palavra
	 * @return sequencia - String de caracteres. 
	 */
		
		String aux, sequencia = "";
		
		for(int i = 0; i < pa.tamanhoPalavra(); i++) {
			
			aux = Character.toString(pa.letraPalavra(i));
			
			while(pa.letraPalavra(i) == pa.letraPalavra(i+1)) {				
				aux += pa.letraPalavra(i+1);
				i++;				
			}
			
			if(aux.length() > sequencia.length()) {
				sequencia = aux;
			}			
		}		
		
		return sequencia;
	}

}
