package model.vo;

public class FuncionarioOperacional extends Empregados {
	
	private int Id;
	private String nome;
	private Gerente gerente;
	private double  salarioLiquido;
	private double salarioBase;
	
	public FuncionarioOperacional() {
		super();

	}


	public FuncionarioOperacional(String nome, String cpf, String sexo, int idade, double salarioBruto,
			double impostoRenda, double contribuicao, int id, String nome2, Gerente gerente, double salarioLiquido,
			double salarioBase) {
		super(nome, cpf, sexo, idade, salarioBruto, impostoRenda, contribuicao);
		Id = id;
		nome = nome2;
		this.gerente = gerente;
		this.salarioLiquido = salarioLiquido;
		this.salarioBase = salarioBase;
	}





	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}



	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
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


	public double CalcularSalarioLiquido() {
		salarioLiquido = salarioBase * 0.85;
		
		return salarioLiquido;
	}

	
}
