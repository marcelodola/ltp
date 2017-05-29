package dados;

import java.util.*;
import dados.Cliente;
import dados.Produto;
import dados.Venda;

public class ItemVenda {
	
	private Produto produto;
	private double precoUnitario;
	private double quantVenda;
	private double valorVenda;
	
	public ItemVenda(Produto produto, double precoUnitario, double quantVenda, double valorVenda) {
		
		this.produto = produto;
		this.precoUnitario = precoUnitario;
		this.quantVenda = quantVenda;
		this.valorVenda = valorVenda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public double getQuantVenda() {
		return quantVenda;
	}

	public void setQuantVenda(double quantVenda) {
		this.quantVenda = quantVenda;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	@Override
	public String toString() {
		return "Item Venda " + "\n" +
				"Produto..: " + produto + "\n" + 
				"Preco Unitario..: " + precoUnitario + "\n" + 
				"Quantidade Venda..: " + quantVenda + "\n" +
				"Valor Venda..: " + valorVenda;
	}
	
	
	
	
	
}
