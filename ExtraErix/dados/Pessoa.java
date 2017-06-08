package dados;

import java.io.Serializable;


public class Pessoa implements Serializable{

		public final static int PESSOA = 1;
		public final static int PESSOA_FISICA = 2;
		public final static int PESSOA_JURIDICA = 3;
		public final static int PESSOA_FISICA_FUNCIONARIO = 4;
		public final static int PESSOA_FISICA_FUNCIONARIO_GERENTE = 5;
		
		protected String nome;
		protected String telefone;
		
		public Pessoa(String nome, String telefone) {
			this.nome = nome;
			this.telefone = telefone;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		
		public int getTipo() {
			return PESSOA;
		}
		
		public String toString() {
			return
				"NOME : " + nome + "\n" +
				"TELEFONE : " + telefone + "\n" ;	
		}
		
}
