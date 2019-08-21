package model.vo;

public abstract class Empregados {
	private int IdEmpregado;
	private String nome;
	private String cpf;
	private String sexo;
	private int idade;
	private double salarioBruto;
	private double impostoRenda;
	private double contribuicao;
	private double salarioBase;
	private double salarioLiquido;
	private double comissao;
	private int tipo;
	 
	 
	
	


	public Empregados(int idEmpregado, String nome, String cpf, String sexo, int idade, double salarioBruto,
			double comissao, int tipo) {
		super();
		IdEmpregado = idEmpregado;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.idade = idade;
		this.salarioBruto = salarioBruto;
		this.comissao = comissao;
		this.tipo = tipo;
	}

	public Empregados() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public double getImpostoRenda() {
		return impostoRenda;
	}

	public double getContribuicao() {
		return contribuicao;
	}

	
	
	public double getSalarioBase() {
		return salarioBase;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	
	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	

	public int getIdEmpregado() {
		return IdEmpregado;
	}

	public void setIdEmpregado(int idEmpregado) {
		IdEmpregado = idEmpregado;
	}
	
	

	public double getComissao() {
		return comissao;
	}

	
	
	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public double calculoImpostoDeRenda() {
		if (salarioBruto < 1800) {
			impostoRenda = 0;
		} else if (salarioBruto > 1800 || salarioBruto <= 3000) {
			impostoRenda = salarioBruto * 10 / 100;
		} else {
			impostoRenda = salarioBruto * 15 / 100;
		}

		return impostoRenda;
	}

	public double calculoContribuicao() {
		if (idade < 45) {
			contribuicao = salarioBruto * 12 / 100;
		} else if (idade >= 45) {
			contribuicao = salarioBruto * 8 / 100;
		}

		return contribuicao;
	}
	
	public abstract double calcularSalarioBase(); 
	public abstract double calcularSalarioLiquido();
	
}
