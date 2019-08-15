package model.vo;

import java.util.ArrayList;

public class Diretor extends Empregados {
	private int IdDiretor;
	private String nome;
	private ArrayList<Gerente> gerentes;
	private double  salarioLiquido;	
	private double salarioBase;
	private double comissao;
	public Diretor() {
		super();
	}

	



	public Diretor(String nome, String cpf, String sexo, int idade, double salarioBruto, double impostoRenda,
			double contribuicao, int idDiretor, String nome2, ArrayList<Gerente> gerentes, double salarioLiquido,
			double salarioBase, double comissao) {
		super(nome, cpf, sexo, idade, salarioBruto, impostoRenda, contribuicao);
		IdDiretor = idDiretor;
		nome = nome2;
		this.gerentes = gerentes;
		this.salarioLiquido = salarioLiquido;
		this.salarioBase = salarioBase;
		this.comissao = comissao;
	}





	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Gerente> getGerentes() {
		return gerentes;
	}

	public void setGerentes(ArrayList<Gerente> gerentes) {
		this.gerentes = gerentes;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public int getIdDiretor() {
		return IdDiretor;
	}

	public void setIdDiretor(int idDiretor) {
		IdDiretor = idDiretor;
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
		salarioLiquido = 3 * salarioBase + comissao;
		
		return salarioLiquido;
	}
	
	public double CalcularSalarioBase() {
		salarioBase = this.getSalarioBruto() - this.calculoContribuicao() - this.calculoImpostoDeRenda();
		
		return salarioBase;
	}
	
 }
