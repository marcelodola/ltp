package cadastro;

import java.util.*;
import java.io.File;
import dados.Funcionario;
import dados.HorasTrab;
import cadastro.ListaDeFaltas;
import cadastro.ListaDeFuncionarios;
import cadastro.ListaDeHorasTrabalhadas;
import erros.PagtoException;
import utilitarios.Console;
import utilitarios.LtpUtil;

public class ListaDeFuncionarios {
	
	public static HashMap<String, Funcionario> listaDeFuncionarios = new HashMap<>();

	public static Funcionario pesqFuncionarioCpf(String cpf) throws PagtoException{
		
		if (listaDeFuncionarios.containsKey(cpf)) {
			return listaDeFuncionarios.get(cpf);
		} else {
			throw new PagtoException("NÃO EXISTE CONTA PARA O CPF.");
		}
		
	}
	
	public static void incluirFuncionario(Funcionario fun) {
		
		listaDeFuncionarios.put(fun.getCpf(), fun);		
	}
}

//----
/*
 * 
 * package listacontas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import dados.Conta;
import erros.ContaException;

public class ListaContas {

	public static HashMap<String, Conta> lstContas = new HashMap<>();

	/**
	 * Buscar a conta pelo cpf
	 * @param cpf
	 * @return Conta
	 * @throws ContaException - "NÃO EXISTE CONTA PARA O CPF."
	 
	
	public static Conta pesqContaCpf(String cpf) throws ContaException{
		
		if (lstContas.containsKey(cpf)) {
			return lstContas.get(cpf);
		} else {
			throw new ContaException("NÃO EXISTE CONTA PARA O CPF.");
		}
		
	}
	
	public static void incluirConta(Conta obj) {
		
		lstContas.put(obj.getCpf(), obj);
		
	}
	
	public static void excluirConta(Conta obj) throws ContaException{
		
		if (obj.getListaLanc().isEmpty()) {
			lstContas.remove(obj.getCpf());
		} else {
			throw new ContaException("NÃO PODE EXCLUIR CONTA COM LANÇAMENTO.");
		}
		
	}
	
	public static ArrayList<Conta> pesqContaNome(String nome) throws ContaException{
		
		ArrayList<Conta> resposta = new ArrayList<>();
		
		for (Conta obj : lstContas.values()) {
			if (obj.getNome().toUpperCase().contains(nome.toUpperCase())) {
				resposta.add(obj);
			}
		}
		
		if (resposta.isEmpty()) {
			throw new ContaException("NAÕ EXISTE CONTA PARA O NOME.");
		} else {
			
			Collections.sort(resposta, new Comparator<Conta>() {

				@Override
				public int compare(Conta obj1, Conta obj2) {
					return obj1.getNome().compareTo(obj2.getNome());
				}
				
			});
			
			return resposta;
		}
	}
}

*/
