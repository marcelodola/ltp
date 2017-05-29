package usuario;

import utilitarios.Console;
import utilitarios.LtpUtil;

import java.util.*;

import dados.Venda;
import dados.Cliente;
import dados.Produto;
import dados.ItemVenda;
import cadastro.ListaDeClientes;
import cadastro.ListaDeProdutos;
import cadastro.ListaDeVendas;
import erros.SisVendasException;


public class Usuario {

	public static void main(String[] args) throws SisVendasException{
		menu();
		System.out.println("\n" + "Final do aplicativo");
		System.exit(0);
	}

	public static void menu() throws SisVendasException{
		int opcao = 0;
		do {
			System.out.println("=== CLIENTE ===");
			System.out.println("1 - Incluir novo cliente");
			System.out.println("2 - Alterar cliente via CPF.");
			System.out.println("3 - Excluir cliente via CPF.");
			System.out.println("4 - Consultar cliente via CPF.");
			System.out.println("5 - Consultar clientes em ordem alfab?tica pelo nome.");
			System.out.println("=== PRODUTOS ===");
			System.out.println("6 - Incluir novo produto.");
			System.out.println("7 - Alterar produto via codigo");
			System.out.println("8 - Excluir produto via codigo");
			System.out.println("9 - Consultar produtos em ordem alfab?tica pelo nome.");
			System.out.println("=== VENDAS ===");
			System.out.println("10 - Incluir nova venda.");
			System.out.println("11 - Excluir uma venda. ");
			System.out.println("12 - Consultar as vendas pelo per?odo em ordem de cliente e data da venda descrescente.");
			System.out.println("13 - Consultar a est?stica de vendas por cliente em ordem alfab?tica em um per?odo de vendas.");
			opcao = Console.readInt("Informe a opcao: ");
			switch (opcao) {
			case 1:
				novoCliente();
				break;
			case 2:
				alterarCliente(Console.readLine("Informe o Cpf.: ").trim().replace(".", "").replace("-", ""));
				break;
			case 3:
				//excluirCliente();
				break;
			case 4:
				//consultarClienteCPF();
				break;
			case 5:
				//consultarClienteOrdemAlfabetica();
				break;
			case 6:
				//incluirProduto();
				break;
			case 7:
				//alterarProduto();
				break;
			case 8:
				//excluirProduto();
				break;
			case 9:
				//consultarProdutoOrdemAlfabetica();
				break;
			case 10:
				//incluirVenda();
				break;
			case 11:
				//excluirVenda();
				break;
			case 12:
				//consultarVendaPeriodo();
				break;
			case 13:
				//consultarEstatistica();
				break;
			case 0:

				break;

			default:
				System.out.println("Opcao invalida.");
				break;
			}

		} while (opcao != 0);

	}
	
	private static void novoCliente() throws SisVendasException {
		try {
			String cpf, nome, telefone, email;
			do {
				cpf = Console.readLine("Informe o CPF: ").trim().replace(".", "").replace("-", "");
			} while (!LtpUtil.validarCPF(cpf));
			do {
				nome = Console.readLine("Infome o Nome: ").trim();
			} while(LtpUtil.contarPalavras(nome) < 2);
			do {
				telefone = Console.readLine("Infome o Telefone: ").trim();
			} while (telefone.length() < 7);
			do {
				email = Console.readLine("Infome o E-mail: ").trim();
			} while (!LtpUtil.validarEmail(email));
			
			if (ListaDeClientes.cadClientes.containsKey(cpf))
				throw new SisVendasException("Cliente j? cadastrado !");
			else
				ListaDeClientes.incluirCliente ( new Cliente(cpf, nome, telefone, email));
		} catch (SisVendasException  e) {
			System.err.println(e.getMessage().toString());
		}
	}



	private static void alterarCliente(String cpf) throws SisVendasException {
		try {
			Cliente cli = ListaDeClientes.clientePeloCPF(cpf);
			System.out.println(cli.toString());
			String nome, telefone, email;
			do {
				nome = Console.readLine("Infome o novo nome: ");
			} while(LtpUtil.contarPalavras(nome) < 2);
			do {
				telefone = Console.readLine("Infome o novo telefone: ");
			} while (telefone.length() < 7);
			do {
				email = Console.readLine("Infome o novo e-mail: ");
			} while (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$;"));
			
			if(LtpUtil.validarCPF(cpf) && ListaDeClientes.cadClientes.containsKey(cpf) && !ListaDeClientes.clientePeloCPF(cpf).equals(null)) {
				cli.setDataUltInclusao( new GregorianCalendar());
				cli.setEmail(email);
				cli.setNome(nome);
				cli.setTelefone(telefone);
				//cad.excluirCliente(cli);
				ListaDeClientes.incluirCliente(cli);
				
			}
		} catch (SisVendasException  e) {
			System.err.println(e.getMessage().toString());
		}
	}

	private static void excluirCliente(String cpf) throws SisVendasException {
		try {
			System.out.println(ListaDeClientes.clientePeloCPF(cpf).toString());
			if((Console.readLine("Efetuar a exclus?o? (s/n)").equalsIgnoreCase("S")) ? true : false)
				ListaDeClientes.excluirCliente(ListaDeClientes.clientePeloCPF(cpf));
		} catch (SisVendasException  e) {
			System.err.println(e.getMessage().toString());
		}
	}	
	
	//Consultar Cliente CPF
	
	//Consultar Ordem Alfabetica pelo nome

	private static void novoProduto() {
		try {
			String nome;
			double preco;
			do {
				nome = Console.readLine("Informe o Nome: ");
			} while (nome.equals(null));
			do {
				preco = Console.readDouble("Informe o pre?o: ".replace(",", "."));
			} while (preco < 0);
			
			cadastro.ListaDeProdutos.incluirProduto( new Produto (nome, preco, null));
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
		}
	}
	
	private static void alterarProduto(Integer cod) throws SisVendasException {
		try {
			Produto pro = ListaDeProdutos.produtoPeloCod(cod);
			System.out.println(pro);
			String nome;
			double preco;
			do {
				nome = Console.readLine("Informe o novo nome: ");
			} while (nome.trim().isEmpty());
			do {
				preco = Console.readDouble("Informe o novo pre?o: ");
			} while (preco < 0);
			
			if ((Console.readLine("Efetuar a altera??o? (s/n)").equalsIgnoreCase("S")) ? true : false) {	
				pro.setNome(nome);
				pro.setDataUltAlteracao( new GregorianCalendar());
				pro.setPrecoUnitario(preco);
				//ListaDeProdutos.excluirProduto(pro);
				ListaDeProdutos.incluirProduto(pro);
			}
		} catch (SisVendasException  e) {
			System.err.println(e.getMessage().toString());
		}
	}
	 
	private static void excluirProduto(Integer cod) throws SisVendasException {
		try {
			System.out.println(ListaDeProdutos.produtoPeloCod(cod).toString());
			if((Console.readLine("Efetuar a exclus?o ? (s/n)").equalsIgnoreCase("S")) ? true : false)
				ListaDeProdutos.excluirProduto(ListaDeProdutos.produtoPeloCod(cod));
		} catch (SisVendasException  e) {
			System.err.println(e.getMessage().toString());
		}
	}

	private static void ProdutosAlfabeticamente(String produto) throws SisVendasException {
		try {
			ArrayList<Produto> prod = ListaDeProdutos.produtosAlfabeticamente(produto);
			for (Produto p : prod) {
				System.out.println(p.toString());
			}
		} catch (SisVendasException  e) {
			System.err.println(e.getMessage().toString());
		}
	}

	private static void IncluirVendaCliente(String cpf) throws SisVendasException {
		try {
			int cod, qnt;
			do {
				cod = Console.readInt("Informe o c?digo do produto: ");
				Produto prod = ListaDeProdutos.produtoPeloCod(cod);
				do {
					qnt = Console.readInt("Informe a quantidade para compra: ");
				} while (qnt < 0);
				ListaDeVendas.IncluirItemVenda( new ItemVenda(prod, prod.getPrecoUnitario(), qnt, prod.getPrecoUnitario()*qnt));
			} while (Console.readLine("Mais algum produto ? (S/N)").equalsIgnoreCase("S") ? true : false);
			ListaDeVendas.incluirVenda( new Venda(ListaDeClientes.clientePeloCPF(cpf), new GregorianCalendar()));
		} catch (SisVendasException  e) {
			System.err.println(e.getMessage().toString());
		}
	}

	private static void ExcluirVenda(int cod) throws SisVendasException {
		try {
			System.out.println(ListaDeVendas.vendaPeloCod(cod).toString());
			if(Console.readLine("Confirmar exclus?o ? (S/N)").equalsIgnoreCase("S") ? true : false)
				ListaDeVendas.excluirVenda(ListaDeVendas.vendaPeloCod(cod));
		} catch (SisVendasException e) {
			System.err.println(e.getMessage().toString());
		}	
	}
	 
	private static void ConsultaVenda(String cpf) throws SisVendasException {
		try {
			System.out.println(ListaDeVendas.vendasDoClienteOrderDataDesc(ListaDeClientes.clientePeloCPF(cpf)).toString());
		} catch (SisVendasException e) {
			System.err.println(e.getMessage().toString());
		}
	}
	
	private static void Estatisticas(String dataInicial, String dataFinal) throws SisVendasException {
		try {
			while(!LtpUtil.validarData(dataInicial)) {
				dataInicial = Console.readLine("Informe a data INICIAL novamente: ");
			}
			while(!LtpUtil.validarData(dataFinal)) {
				dataFinal = Console.readLine("Informe a data FINAL novamente: ");
			}
			ListaDeVendas.estatistica(dataInicial, dataFinal);
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
		}
		
	}

}
