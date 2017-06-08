package dados;

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

public class Funcionario extends PessoaFisica implements Serializable {
	protected GregorianCalendar admissao;
	protected double salario;
	
	public Funcionario(String nome, String telefone, String cpf, String identidade, String sexo,
			GregorianCalendar admissao, double salario) {
		super(nome, telefone, cpf, identidade, sexo);
		this.admissao = admissao;
		this.salario = salario;
	}

	public GregorianCalendar getAdmissao() {
		return admissao;
	}

	public void setAdmissao(GregorianCalendar admissao) {
		this.admissao = admissao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public int getTipo() {
		return PESSOA_FISICA_FUNCIONARIO;
	}
	
	public String toString(){
		return
			super.toString() + "\n" +
			"ADMISSÃO: " + LtpUtil.formatarData(admissao, "dd/MM/yyyy") + "\n" +
			"SALÁRIO: " + salario + "\n";
	}
	
}
