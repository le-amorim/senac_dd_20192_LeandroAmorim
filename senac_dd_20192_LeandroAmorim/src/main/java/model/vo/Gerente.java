package model.vo;

public class Gerente extends Empregados {
	private int IdGerente;
	private double comissao;
	 private double salarioBase;
	 private double salarioLiquido;


	


	public Gerente(int idEmpregado, String nome, String cpf, String sexo, int idade, double salarioBruto,
			double comissao, int tipo, int idGerente, double comissao2, double salarioBase, double salarioLiquido) {
		super(idEmpregado, nome, cpf, sexo, idade, salarioBruto, comissao, tipo);
		IdGerente = idGerente;
		comissao = comissao2;
		this.salarioBase = salarioBase;
		this.salarioLiquido = salarioLiquido;
	}


	public Gerente() {
		super();
		// TODO Auto-generated constructor stub
	}

		
	public double getComissao() {
		return comissao;
	}



	public void setComissao(double comissao) {
		this.comissao = comissao;
	}


	public int getIdGerente() {
		return IdGerente;
	}



	public void setIdGerente(int idGerente) {
		IdGerente = idGerente;
	}

	

	public double getSalarioBase() {
		return salarioBase;
	}


	public double getSalarioLiquido() {
		return salarioLiquido;
	}


	@Override
	public double calcularSalarioLiquido() {
		salarioLiquido = this.getSalarioBase() * 0.90 + this.getComissao();	
		
		return salarioLiquido;
	}


	@Override
	public double calcularSalarioBase() {
		salarioBase = this.getSalarioBruto() - this.getContribuicao() - this.getImpostoRenda(); 
		
		return salarioBase;
	}


}
