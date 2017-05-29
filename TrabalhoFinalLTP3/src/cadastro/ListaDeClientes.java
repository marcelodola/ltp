/**
 * Classe para implementaç�o do Cadastro
 */
package cadastro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import dados.Cliente;
import dados.ItemVenda;
import dados.Produto;
import dados.Venda;
import erros.SisVendasException;

public class ListaDeClientes {	

	public static HashMap<String, Cliente> cadClientes = new HashMap<String, Cliente>(); //CPF

	public static void incluirCliente(Cliente clientes) {
		cadClientes.put(clientes.getCpf(), clientes);
	}
	
	public static void excluirCliente(Cliente clientes) {
		cadClientes.remove(clientes.getCpf());
	} 
	
	public static Cliente clientePeloCPF(String cpf) throws SisVendasException {
		if (cadClientes.containsKey(cpf)) {
			return cadClientes.get(cpf);
		} else {
			throw new SisVendasException("N�o existe cliente para o cpf");
		}
	}
	
	public static ArrayList<Cliente> clientesAlfabeticamente(String nome) throws SisVendasException {
		if (cadClientes.containsValue(nome)) {
			return (ArrayList<Cliente>) cadClientes.values();
		} else {
			throw new SisVendasException("N�o existe nenhum cliente para o nome");
		}
	}

}
