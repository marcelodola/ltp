package dados;

import java.io.Serializable;

import utilitarios.LtpUtil;

@SuppressWarnings("serial")
public class PessoaJuridica extends Pessoa implements Serializable{

	protected String cnpj;
	protected String razaoSocial;
	
	public PessoaJuridica(String nome, String telefone, String cnpj,
			String razaoSocial) {
		super(nome, telefone);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public int getTipo(){
		return PESSOA_JURIDICA;
	}
	
	public String toString() {
		return
				super.toString() +
				"CNPJ : " + LtpUtil.formatarCNPJ(cnpj) + "\n" +
				"RAZÃO SOCIAL : " + razaoSocial + "\n";
	}
	
}
