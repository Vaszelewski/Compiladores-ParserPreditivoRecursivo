import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public abstract class Parser {
	
	/**
	 * Tabela de Simbolos
	 */
	TS ts;
	
	/**
	 * Analisador Lexico
	 */
	Lexico lexer;
	
	/**
	 * Token corrente que está sendo analisado
	 */
	Token t;
	
	public Parser(String arquivo) throws UnsupportedEncodingException, FileNotFoundException {
		ts = new TS();
		lexer = new Lexico(arquivo);
	}
	
	/**
	 * O metodo deve ser implementado pelo parser concreto
	 * @throws IOException
	 */
	public abstract void parse() throws IOException;
	
	/**
	 * Obtem o próximo token
	 */
	public void buscaToken() throws IOException {
		t = lexer.buscaToken();
	}
	
	public boolean erro(String erro) {
		System.out.println(erro + ": " + t.linha + ", " + t.coluna);
		return false;
	}
}
