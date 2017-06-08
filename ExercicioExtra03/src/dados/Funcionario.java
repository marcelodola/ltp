package dados;

public abstract class Funcionario {

	public static final int MENSALISTA = 1;
	public static final int HORISTA = 2;
	
	protected String cpf;
	protected String nome;
	
	public Funcionario(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
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
	/**
	 * Calcular o salario mensal
	 * @param mes
	 * @param ano
	 * @return salario calculado
	 */
	public abstract double salarioMensal(int mes, int ano);
	
	/**
	 * Retorna o tipo de funcionário
	 * @return 1 para mensalista e 2 para horista
	 */
	public abstract int getTipo();
	
}
