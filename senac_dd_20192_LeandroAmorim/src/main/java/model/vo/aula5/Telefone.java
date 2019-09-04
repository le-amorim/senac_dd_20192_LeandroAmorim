package model.vo.aula5;

public class Telefone {
	private int id;
	private Cliente cliente;
	private String codigoPais;
	private String ddd;
	private String numero;
	private String tipoLinha;
	private boolean ativo;

	public Telefone() {
		
	}
	
	public Telefone(Cliente cliente, String codigoPais, String ddd, String numero, String tipoLinha,
			boolean ativo) {
		super();
		this.cliente = cliente;
		this.codigoPais = codigoPais;
		this.ddd = ddd;
		this.numero = numero;
		this.tipoLinha = tipoLinha;
		this.ativo = ativo;
	}
	
	public Telefone(int id, int idCliente, String codigoPais, String ddd, String numero, String tipoLinha,
			boolean ativo) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.codigoPais = codigoPais;
		this.ddd = ddd;
		this.numero = numero;
		this.tipoLinha = tipoLinha;
		this.ativo = ativo;
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipoLinha() {
		return tipoLinha;
	}

	public void setTipoLinha(String tipoLinha) {
		this.tipoLinha = tipoLinha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", cliente=" + cliente + ", codigoPais=" + codigoPais + ", ddd=" + ddd
				+ ", numero=" + numero + ", tipoLinha=" + tipoLinha + ", ativo=" + ativo + "]";
	}
}