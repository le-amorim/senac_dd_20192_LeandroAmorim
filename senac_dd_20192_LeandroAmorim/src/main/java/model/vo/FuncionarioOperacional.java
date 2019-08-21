package model.vo;

public class FuncionarioOperacional extends Empregados {
	
	private int IdOperacional;
	public FuncionarioOperacional() {
		super();

	}
	

	public FuncionarioOperacional(int idEmpregado, String nome, String cpf, String sexo, int idade, double salarioBruto,
			int tipo, int idOperacional) {
		super(idEmpregado, nome, cpf, sexo, idade, salarioBruto, tipo, idOperacional);
		IdOperacional = idOperacional;
	}


	public int getIdOperacional() {
		return IdOperacional;
	}

	public void setIdOperacional(int idOperacional) {
		IdOperacional = idOperacional;
	}


	@Override
	public double calcularSalarioLiquido() {
		double salarioLiquido;
		salarioLiquido = this.getSalarioBase() * 0.85;
		
		
		
		return salarioLiquido;
	}


	@Override
	public double calcularSalarioBase() {
		double salarioBase;
		salarioBase = this.getSalarioBruto() - this.getContribuicao() - this.getImpostoRenda(); 
		
		return salarioBase;
	}

}
