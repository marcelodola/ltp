package dados;

import java.util.*;

import utilitarios.LtpUtil;

public class Cliente {
	
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private GregorianCalendar dataInclusao;
	private GregorianCalendar dataUltInclusao;
	public Cliente(String cpf, String nome, String telefone, String email) {
		
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataInclusao = dataInclusao;
		this.dataUltInclusao = dataUltInclusao;
		
		
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public GregorianCalendar getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(GregorianCalendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public GregorianCalendar getDataUltInclusao() {
		return dataUltInclusao;
	}
	public void setDataUltInclusao(GregorianCalendar dataUltInclusao) {
		this.dataUltInclusao = dataUltInclusao;
	}
	@Override
	public String toString() {
		return "Cliente " + "\n" +
				"CPF..: " + cpf + "\n" + 
				"Nome..: " + nome + "\n" + 
				"Telefone..: " + telefone + "\n" + 
				"Email..: " + email + "\n" + 
				"Data de Inclusao..: " + LtpUtil.formatarData(dataInclusao, "EEEE dd/MM/yyyy HH:mm") +  "\n" +
				"Data da Ultima Inclusao..: " + LtpUtil.formatarData(dataUltInclusao, "EEEE dd/MM/yyyy HH:mm") ;
	}
	

}
