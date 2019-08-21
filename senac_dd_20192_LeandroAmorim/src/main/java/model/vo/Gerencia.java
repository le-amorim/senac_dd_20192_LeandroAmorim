package model.vo;

import java.util.ArrayList;

public class Gerencia extends Lotacao {

	private int idGerencia;
	private Gerente gerente;
	private ArrayList<FuncionarioOperacional> Operacionais;
	
	
	
	public Gerencia(int idlotacao, String nome, String sigla, int idGerencia, Gerente gerente,
			ArrayList<FuncionarioOperacional> operacionais) {
		super(idlotacao, nome, sigla);
		this.idGerencia = idGerencia;
		this.gerente = gerente;
		Operacionais = operacionais;
	}

	public Gerencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdGerencia() {
		return idGerencia;
	}

	public void setIdGerencia(int idGerencia) {
		this.idGerencia = idGerencia;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public ArrayList<FuncionarioOperacional> getOperacionais() {
		return Operacionais;
	}

	public void setOperacionais(ArrayList<FuncionarioOperacional> operacionais) {
		Operacionais = operacionais;
	}

	
	
}
