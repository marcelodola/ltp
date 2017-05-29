package cadastro;

import java.util.ArrayList;
import java.util.HashMap;

import dados.Produto;
import erros.SisVendasException;

public class ListaDeProdutos {

	public static HashMap<Integer, Produto> cadProdutos = new HashMap<Integer, Produto>(); //Cod

	/**
	 * @param Produto
	 */
	public static void incluirProduto(Produto pro) {
		cadProdutos.put(pro.getCodigo(), pro);
	}
	
	
	/**
	 * @param Produto
	 */
	public static void excluirProduto(Produto pro) {
		cadProdutos.remove(pro.getCodigo());
	} 
	
	/**
	 * @param cod
	 * @return Produto do codigo
	 * @throws SisVendasException
	 */
	public static Produto produtoPeloCod(Integer cod) throws SisVendasException {
		if (cadProdutos.containsKey(cod)) {
			return cadProdutos.get(cod);
		} else {
			throw new SisVendasException("N�o existe produto para o c�digo");
		}
	}
	
	/**
	 * @param nome
	 * @return Produtos com o nome
	 * @throws SisVendasException
	 */
	public static ArrayList<Produto> produtosAlfabeticamente(String nome) throws SisVendasException {
		ArrayList<Produto> prod = new ArrayList<Produto>();
		for (Produto produto : cadProdutos.values()) {
			if (produto.getNome().contains(nome))
				prod.add(produto);
		}
		
		if(prod.isEmpty())
			throw new SisVendasException("N�o existe nenhum produto para o nome");
		else
			return prod;
	}
}
