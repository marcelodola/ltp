package dados;

import java.io.Serializable;

import utilitarios.LtpUtil;

@SuppressWarnings("serial")
public class PessoaFisica extends Pessoa implements Serializable {

	protected String cpf;
	protected String identidade;
	protected String sexo;
	
	public PessoaFisica(String nome, String telefone, String cpf,
			String identidade, String sexo) {
		super(nome, telefone);
		this.cpf = cpf;
		this.identidade = identidade;
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public int getTipo() {
		return PESSOA_FISICA;
	}
	
	public String toString() {
		return
			super.toString() +
			"CPF : " + LtpUtil.formatarCPF(cpf) + "\n" +
			"IDENTIDADE : " + identidade + "\n" +
			"SEXO : " + sexo + "\n";
	}
	
}
