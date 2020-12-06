import java.io.IOException;

public class PPR extends Parser {
	
	public PPR(String arquivo) throws IOException {
		super(arquivo);
	}

	@Override
	public void parse() throws IOException {
		analisaPrograma();
	}
	
	
	public boolean analisaPrograma() throws IOException{
		buscaToken();
		if(t.tipo==Tipo.SPROGRAMA) {
			System.out.println(t.tipo+" ");
			buscaToken();
			if(t.tipo == Tipo.SIDENTIFICADOR) {
				System.out.println(t.tipo + ": "+ t.lexema +' ');
				//Adicionar identificador à tabela de simbolos
				ts.ts.put(t.lexema, t);
				buscaToken();
				if(t.tipo==Tipo.SPONTO_E_VIRGULA) {
					System.out.println(t.tipo + " ");
					if(analisaBloco()) {
						buscaToken();
						if(t.tipo==Tipo.SPONTO) {
							System.out.println(t.tipo + " ");
							return true;
						}
					}else 
						return erro("Bloco principal nao encontrado: ");
				}else {
					return erro("Ponto e virgula nao encontrado: ");
				}
			}else {
				return erro("Identificador nao encontrado: ");
			}
		}else {
			return erro("Não foi encontrado o programa principal: ");
		}
		return true;
	}

	public boolean analisaBloco() throws IOException {
		buscaToken();
		return analisaEtapaDeclaracaoDeVariaveis();
	}
	
	
	public boolean analisaEtapaDeclaracaoDeVariaveis() throws IOException {
		if(t.tipo == Tipo.SVAR) {
			buscaToken();
			if(t.tipo == Tipo.SIDENTIFICADOR) {
				System.out.println(t.tipo + ": "+ t.lexema +' ');
				while(t.tipo == Tipo.SIDENTIFICADOR) {
					if(t.tipo == Tipo.SPONTO_E_VIRGULA) {
						System.out.println(t.tipo + " ");
						buscaToken();
					}else {
						return erro("Ponto e virgula não encontrado");
					}
				}
			}else {
				return erro("Identificador nao encontrado");
			}
			
		}
		return true;
	}
	
	

}
