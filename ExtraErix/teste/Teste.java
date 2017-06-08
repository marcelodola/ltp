package teste;

import java.io.File;
import java.util.ArrayList;

import cadastro.CadastroPessoas;
import dados.Pessoa;
import dados.PessoaFisica;
import erros.PessoaException;
import utilitarios.Console;
import utilitarios.LtpUtil;

public class Teste {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// LER ARQUIVO
		File objFile = new File("Cadastro de Pessoas.obj");
		if (objFile.exists()) {
		  try {
				CadastroPessoas.listaPessoas = LtpUtil.lerArquivoObjetosArray("Cadastro de Pessoas.obj");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(1); // finalizar com falha
			}	
		}
		
		menu();
		
		// GRAVAR ARQUIVO
		
		try {
			LtpUtil.gravarArquivoObjetosArray("Cadastro de Pessoas.obj", CadastroPessoas.listaPessoas);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(2); // finalizar com falha
		}
		
		System.out.println("\n" + "Final dos testes.");
		System.exit(0);

	}

	private static void menu() {
		int opcao=0;
		do {
			System.out.println("\n" + "Menu");
			System.out.println("1-Cadastrar Cliente");
			System.out.println("2-Pesquisar Cliente pelo CPF");
			System.out.println("3-Pesquisar Cliente pelo Nome");
			System.out.println("4-Cadastrar Fornecedor");
			System.out.println("5-Pesquisar Fornecedor pelo CNPJ");
			System.out.println("0-Sair");
			opcao = Console.readInt("Op��o: ");
			switch (opcao) {
				case 1:
					incluirCliente();
					break;
				case 2: 
					pesqClienteCpf();
					break;
				case 3:
					pesqClienteNome();
					break;
				case 0 : break;	
				default:
					System.out.println("Op��o inv�lida.");
					break;
			}
		} while (opcao!=0);
		
	}

	private static void pesqClienteNome() {
		System.out.println("\nPesquisa do Cliente pelo Nome\n");
		
		String nome = Console.readLine("NOME: ");
		
		try {
			ArrayList<Pessoa> lista = CadastroPessoas.pesqPessoaNome(nome);
			System.out.println("\nLista de Clientes\n");
			for (Pessoa obj : lista) {
				if (obj.getTipo()==Pessoa.PESSOA_FISICA) {
					System.out.println(obj.toString());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	private static void pesqClienteCpf() {
		System.out.println("\nPesquisa do Cliente pelo CPF\n");
		
		String cpf = Console.readLine("CPF: ");
		
		try {
			PessoaFisica obj = CadastroPessoas.pesqPessoaCpf(cpf);
			System.out.println("\nDados do Cliente\n");
			System.out.println(obj.toString());
		} catch (PessoaException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void incluirCliente() {
		System.out.println("\nCadastrar cliente\n");
		
		String nome;
		String telefone;
		String cpf;
		String identidade;
		String sexo;
		
		nome = Console.readLine("NOME: ");
		telefone = Console.readLine("TELEFONE: ");
		
		while (true) {
			cpf = Console.readLine("CPF: ");
			if (!LtpUtil.validarCPF(cpf)) {
				System.out.println("CPF inv�lido.");
				continue;
			}
			
			try {
				PessoaFisica obj = CadastroPessoas.pesqPessoaCpf(cpf);
				System.out.println(obj.toString()); 
				System.out.println("J� existe cliente para o CPF.");
			} catch (Exception e) {
				break;
			}
		}
		
		identidade = Console.readLine("IDENTIDADE: ");
		sexo = Console.readLine("SEXO: ");
		
		CadastroPessoas.incluirPessoa(new PessoaFisica(nome, telefone, cpf, identidade, sexo));
		
		System.out.println("\n" + "Cliente cadastrado.");
		
		
	}

}
