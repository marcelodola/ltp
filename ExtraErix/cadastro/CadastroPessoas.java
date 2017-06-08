package cadastro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import dados.Pessoa;
import dados.PessoaFisica;
import dados.PessoaJuridica;
import erros.PessoaException;

public class CadastroPessoas {

	public static ArrayList<Pessoa> listaPessoas = new ArrayList<>();
	
	/**
	 * Pesquisa pessoa fisica pelo cpf
	 * @param cpf
	 * @return pessoa fisica
	 * @throws PessoaException - "Não existe pessoa fisica para o cpf."
	 */
	public static PessoaFisica pesqPessoaCpf (String cpf) throws PessoaException {
		
		for (Pessoa obj : listaPessoas) {
		   if (obj.getTipo()==Pessoa.PESSOA_FISICA) {
			   if ( ((PessoaFisica)obj).getCpf().equals(cpf) ) {
				   return (PessoaFisica)obj;
			   }
		   }
		}
		
		throw new PessoaException("Não existe pessoa fisica para o cpf.");
	
	}
	
	/**
	 * Pesquisar pessoa pelo nome
	 * @param nome
	 * @return lista de pessoas em ordem de nome
	 * @throws PessoaException "Não existe pessoa para o nome"
	 */
	public static ArrayList<Pessoa> pesqPessoaNome(String nome) throws PessoaException {
		
		ArrayList<Pessoa> aux = new ArrayList<>();
		
		for (Pessoa obj : listaPessoas) {
			if (obj.getNome().contains(nome) ) {
				aux.add(obj);
			}
		}
		
		if (aux.isEmpty()) {
			throw new PessoaException("Não existe pessoa para o nome.");
		}
		
		if (aux.size() > 1) {
			
			// classificar a lista de pessoas selecionadas pelo nome
			Collections.sort(aux, new Comparator<Pessoa>() {

				@Override
				public int compare(Pessoa o1, Pessoa o2) {
					// TODO Auto-generated method stub
					return o1.getNome().compareTo(o2.getNome());
				}
				
			});
			
			return aux;
			
		} else {
			return aux;
		}
		
	}
	
	/**
	 * Pesquisa pessoa jurídica pelo CNPJ
	 * @param cnpj
	 * @return pessoa juridica
	 * @throws PessoaException "Não existe pessoa juridica para o CNPJ"
	 */
	public static PessoaJuridica pesqPessoaCnpj (String cnpj) throws Exception {
		
		for (Pessoa obj : listaPessoas) {
			if (obj.getTipo()==Pessoa.PESSOA_JURIDICA) {
				if ( ((PessoaJuridica)obj).getCnpj().equals(cnpj) ) {
					return (PessoaJuridica)obj;
				}
			}
		}
		
		throw new PessoaException("Não existe pessoa juridica para o CNPJ");
	}
	
	/**
	 * Incluir pessoa
	 * @param obj
	 */
	public static void incluirPessoa(Pessoa obj) {
		listaPessoas.add(obj);
	}
	
}
