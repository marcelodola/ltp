package dados;

import java.util.*;
import dados.ItemVenda;
import dados.Cliente;
import dados.Produto;

public class Venda implements Comparable<Venda> {

	private int numVenda;
	private Cliente cliente;
	private GregorianCalendar dataVenda;
	private static ArrayList<ItemVenda> vendaItens = new ArrayList<>();

	private static int seq;

	public Venda(Cliente cliente, GregorianCalendar dataVenda) {

		numVenda = ++seq;
		this.cliente = cliente;
		this.dataVenda = dataVenda;
	}

	public int getNumVenda() {
		return numVenda;
	}

	public void setNumVenda(int numVenda) {
		this.numVenda = numVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public GregorianCalendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(GregorianCalendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	public static ArrayList<ItemVenda> getVendaItens() {
		return vendaItens;
	}

	public static void setVendaItens(ArrayList<ItemVenda> vendaItens) {
		Venda.vendaItens.addAll(vendaItens);
	}

	public static int getSeq() {
		return seq;
	}

	public static void setSeq(int seq) {
		Venda.seq = seq;
	}

	@Override
	public String toString() {
		return "Vendas " + "\n" + "Numero da Venda..:" + numVenda + "\n" + "Cliente.:" + cliente + "\n"
				+ "Data da Venda..: " + dataVenda + "\n";
	}

	@Override
	public int compareTo(Venda vend) {
		return dataVenda.compareTo(vend.dataVenda);
	}

}
