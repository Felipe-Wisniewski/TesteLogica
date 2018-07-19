package sequencia_char;
/** 
 * @author Felipe Wisniewski
 */
public class Palavra {

	private String palavra;

	public Palavra(String palavra) {
		this.palavra = palavra;
	}

	public String getPalavra() { return palavra; }

	public void setPalavra(String palavra) { this.palavra = palavra; }
	
	public int tamanhoPalavra() { return this.palavra.length();	}
	
	public char letraPalavra(int i) {
	/**M�todo que retorna o car�cter que se encontra no �ndice desejado.
	 * @param i - inteiro referente ao index.
	 * @return c - char da posi��o requerida.  
	 */
		
		if(i == tamanhoPalavra()) {
			if(this.palavra.charAt(i) == '*') {
				return '#';
			}else {
				return '*';		
			}
		}
		
		char c = this.palavra.charAt(i);
		return c;
	}
	
}
