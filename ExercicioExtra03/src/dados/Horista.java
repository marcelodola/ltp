package dados;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import erros.PagtoException;

public class Horista extends Funcionario {

	private double valorHora;
	
	private ArrayList<HorasTrab> listaHoras = new ArrayList<>();
	
	
	public Horista(String cpf, String nome, double valorHora) {
		super(cpf, nome);
		this.valorHora = valorHora;
	}

	@Override
	public double salarioMensal(int mes, int ano) {
		double totHorasMesAno = 0;
		for (HorasTrab obj : listaHoras){
			if (obj.getDataTrab().get(GregorianCalendar.YEAR)==ano && 
				obj.getDataTrab().get(GregorianCalendar.MONTH)==mes-1){
				totHorasMesAno += obj.getHorasTrab();
			}
		}
		return totHorasMesAno * valorHora;
	}

	@Override
	public int getTipo() {
		// TODO Auto-generated method stub
		return HORISTA;
	}
	
	public void incluirHoraTrab(HorasTrab obj){
		listaHoras.add(obj);
	}
	
	public void excluirHorasTrab(HorasTrab obj){
		listaHoras.remove(obj);
	}
	
	public HorasTrab pesqHorasData(GregorianCalendar data) throws PagtoException{
		for (HorasTrab obj : listaHoras){
			if (obj.getDataTrab().equals(data)){
				return obj;
			}
		}
		throw new PagtoException("NÃO EXISTE REGISTRO DE HORAS TRABALHADAS PARA A DATA INFORMADA.");
	}

	public String toString(){
		return 
				"NOME: " + nome + "\n" +
				"...";
	}
}
