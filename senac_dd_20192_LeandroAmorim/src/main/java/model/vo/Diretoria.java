package model.vo;

import java.util.ArrayList;

public class Diretoria extends Lotacao {
	private int IdDiretoria;
	private Diretor diretor;
	private ArrayList<Gerente> gerencia;	
	
	public Diretoria(int idlotacao, String nome, String sigla, int idDiretoria, Diretor diretor,
			ArrayList<Gerente> gerencia) {
		super(idlotacao, nome, sigla);
		IdDiretoria = idDiretoria;
		this.diretor = diretor;
		this.gerencia = gerencia;
	}
	
	
	public Diretoria() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getIdDiretoria() {
		return IdDiretoria;
	}
	public void setIdDiretoria(int idDiretoria) {
		IdDiretoria = idDiretoria;
	}
	public Diretor getDiretor() {
		return diretor;
	}
	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}
	public ArrayList<Gerente> getGerencia() {
		return gerencia;
	}
	public void setGerencia(ArrayList<Gerente> gerencia) {
		this.gerencia = gerencia;
	}


}
