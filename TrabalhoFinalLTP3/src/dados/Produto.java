package dados;

import java.util.*;

import utilitarios.LtpUtil;

public class Produto {
	
	private int codigo;
	private String nome;
	private double precoUnitario;
	private GregorianCalendar dataUltAlteracao;
	
	private static int seq;

	public Produto(String nome, double precoUnitario, GregorianCalendar dataUltAlteracao) {
		codigo = ++seq;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.dataUltAlteracao = dataUltAlteracao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public GregorianCalendar getDataUltAlteracao() {
		return dataUltAlteracao;
	}

	public void setDataUltAlteracao(GregorianCalendar dataUltAlteracao) {
		this.dataUltAlteracao = dataUltAlteracao;
	}

	public static int getSeq() {
		return seq;
	}

	public static void setSeq(int seq) {
		Produto.seq = seq;
	}

	@Override
	public String toString() {
		return "Produtos" + "\n" + 
				"Codigo..: " + codigo + "\n" + 
				"Nome..: " + nome +  "\n" + 
				"Preco Unitario..: " + precoUnitario + "\n" +
				"Data da Ultima Alteracao..: " + LtpUtil.formatarData(dataUltAlteracao, "EEEE dd/MM/yyyy HH:mm");
	}
	
	
	
	
	

}
