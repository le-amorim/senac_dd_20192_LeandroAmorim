package model.vo;

public class Diretor extends Empregados {
	private int IdDiretor;
	private double comissao;

	
	
	
	public Diretor(String nome, String cpf, String sexo, int idade, double salarioBruto, int tipo, int idDiretor,
			double comissao) {
		super(idDiretor, nome, cpf, sexo, idade, salarioBruto, tipo, idDiretor);
		IdDiretor = idDiretor;
		this.comissao = comissao;
	}


	public Diretor() {
		super();
	}

	
	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}


	public int getIdDiretor() {
		return IdDiretor;
	}


	public void setIdDiretor(int idDiretor) {
		IdDiretor = idDiretor;
	}


	@Override
	public double calcularSalarioLiquido() {
	double salario;
	salario = this.getSalarioBase() * 3 + this.getComissao();
		
		return salario;
	}


	@Override
	public double calcularSalarioBase() {
		double salarioBase;
		salarioBase = this.getSalarioBruto() - this.getContribuicao() - this.getImpostoRenda(); 
		
		return salarioBase;
		
	}

	
	
 }
