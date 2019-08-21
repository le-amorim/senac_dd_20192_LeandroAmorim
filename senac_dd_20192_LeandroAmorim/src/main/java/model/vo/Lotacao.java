package model.vo;

public abstract class Lotacao {
	private int Idlotacao;
	private String Nome;
	private String sigla;
	
	public Lotacao(int idlotacao, String nome, String sigla) {
		super();
		Idlotacao = idlotacao;
		Nome = nome;
		this.sigla = sigla;
	}

	public Lotacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdlotacao() {
		return Idlotacao;
	}

	public void setIdlotacao(int idlotacao) {
		Idlotacao = idlotacao;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	
	
}
