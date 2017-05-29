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

public class ListaDeVendas {
	
	public static HashMap<Integer, Venda> regVendas = new HashMap<Integer, Venda>(); //Cod
	public static HashMap<Integer, Produto> produtos = new HashMap<Integer, Produto>(); //Cod
	public static ArrayList<ItemVenda> itensVenda = new ArrayList<ItemVenda>();


	public static void incluirVenda(Venda ven) {
		regVendas.put(ven.getNumVenda(), ven);
	}

	public static void excluirVenda(Venda ven) {
		regVendas.remove(ven.getNumVenda());
	}

	public static Venda vendaPeloCod(Integer cod) throws SisVendasException {
		if (regVendas.containsKey(cod)) {
			return regVendas.get(cod);
		} else {
			throw new SisVendasException("N�o existe venda para o c�digo");
		}
	}

	public static ArrayList<Venda> vendasDoClienteOrderDataDesc(Cliente cli) throws SisVendasException {
		ArrayList<Venda> retorno = new ArrayList<Venda>();
		for (Venda item : retorno) {
			if (item.getCliente().getCpf().equals(cli.getCpf()))
				retorno.add(item);
		}

		Collections.sort(retorno);

		if (retorno.equals(null))
			return retorno;
		else
			throw new SisVendasException("N�o existe nenhuma venda para o cliente");
	}

	public static ArrayList<Venda> vendasPorPeriodoOrderNomeDataDesc(GregorianCalendar inicio, GregorianCalendar termino) {
		ArrayList<Venda> retorno = new ArrayList<Venda>();
		for (Venda item : retorno) {
			if (item.getDataVenda().after(inicio) && item.getDataVenda().before(termino))
				retorno.add(item);
		}

		Collections.sort(retorno);

		return retorno;
	}

	public static String vendasPorClienteOrderClienteAsc(GregorianCalendar inicio, GregorianCalendar termino) {

		String nome = null;
		int cont = 0;
		double total = 0;
		ArrayList<Venda> retorno = new ArrayList<>();
		for (Venda item : retorno) {
			if (item.getDataVenda().after(inicio) && item.getDataVenda().before(termino)) {
				nome = item.getCliente().getNome();
				cont++;
				total += produtos.get(item.getVendaItens()).getPrecoUnitario();
			}
		}

		return String.format("Cliente: %1$s - Quantidade que comprou: %2$s - Total das compras: %3$s", nome, cont,
				total);
	}

	public static void IncluirItemVenda(ItemVenda item) {
		itensVenda.add(item);
	}

	@SuppressWarnings("null")
	public static ArrayList<String> estatistica(String dataInicial, String dataFinal) {
		String produto = null;
		ArrayList<String> retorno = null;
		double totalVendaProduto = 0;
		double totalValorProduto = 0.0, totalGeral = 0.0;

		for (Venda v : regVendas.values()) {
			for (ItemVenda ven : itensVenda) {
				if (v.getDataVenda().before(dataFinal) && v.getDataVenda().after(dataInicial)) {
					produto = ven.getProduto().getNome();
					totalVendaProduto = ven.getQuantVenda();
					totalValorProduto = ven.getValorVenda();
					totalGeral = ven.getValorVenda();

					retorno.add(String.format(
							"Estat�stica das Vendas: Nome do produto = %1$s - Total das Quantidades das Vendas do Produto no Per�odo = %2$s - Total do Valor das Vendas do Produto no Per�odo = %3$s",
							produto, totalVendaProduto, totalValorProduto));
				}
			}
		}

		retorno.add("Total Geral = " + totalGeral);

		Collections.sort(retorno);

		return retorno;
	}

}
