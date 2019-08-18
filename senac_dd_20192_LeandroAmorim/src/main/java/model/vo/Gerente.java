package model.vo;

import java.util.ArrayList;

public class Gerente extends Empregados {
	private int IdGerente;
	private String nome;
	private ArrayList<FuncionarioOperacional> funcionarios;
	private double  salarioLiquido;
	private double salarioBase;
	private double comissao;
	
	public Gerente(String nome, String cpf, String sexo, int idade, double salarioBruto, double impostoRenda,
			double contribuicao, int idGerente, String nome2, ArrayList<FuncionarioOperacional> funcionarios,
			double salarioLiquido, double salarioBase, double comissao) {
		super(nome, cpf, sexo, idade, salarioBruto, impostoRenda, contribuicao);
		IdGerente = idGerente;
		nome = nome2;
		this.funcionarios = funcionarios;
		this.salarioLiquido = salarioLiquido;
		this.salarioBase = salarioBase;
		this.comissao = comissao;
	}



	public Gerente() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<FuncionarioOperacional> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<FuncionarioOperacional> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public int getIdGerente() {
		return IdGerente;
	}

	public void setIdGerente(int idGerente) {
		IdGerente = idGerente;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}
	
	
	
	public double getSalarioBase() {
		return salarioBase;
	}



	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getComissao() {
		return comissao;
	}



	public void setComissao(double comissao) {
		this.comissao = comissao;
	}


	public double CalcularSalarioLiquido() {
		salarioLiquido = salarioBase * 0.90 + comissao;
		
		return salarioLiquido;
	}

}
