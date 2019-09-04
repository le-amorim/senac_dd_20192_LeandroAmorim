package controller.aula05;

import java.util.ArrayList;
import model.dao.aula05.TelefoneDAO;
import model.bo.aula05.TelefoneBO;
import model.vo.aula5.Telefone;

public class TelefoneController {

	public static final String TIPO_TELEFONE_MOVEL = "Movel";
	public static final String TIPO_TELEFONE_FIXO = "Fixo";
	public static final String SELECIONE_UM_TIPO = "<selecione um tipo>";

	private TelefoneBO bo = new TelefoneBO();
	private	TelefoneDAO dao = new TelefoneDAO();
	

	public ArrayList<Telefone> consultarTodos() {

		return bo.consultarTodos();
	}

	public ArrayList<Telefone> consultarTelefonesDoCliente(int idCliente) {
		return bo.consultarTelefonesDoCliente(idCliente);
	}

	String mensagem = " ";

	public String validarCamposTelefone(String codigoDigitado, String DDDDigitado, String numeroDigitado,
			String tipoSelecionado) {
		if (codigoDigitado.isEmpty() || codigoDigitado.trim().length() > 3) {
			mensagem += " verifique o campo digitado";
		}

		if (DDDDigitado.isEmpty() || DDDDigitado.trim().length() > 3) {
			mensagem += " verifique o campo digitado";
		}

		if (numeroDigitado.isEmpty() || numeroDigitado.trim().length() < 8 || numeroDigitado.trim().length() > 12) {
			mensagem += " verifique o campo digitado";
		}
		return mensagem;
	}

	public Telefone salvarTelefone(Telefone novoTelefone) {
	 dao.salvar(novoTelefone);
		
		return novoTelefone;
	}

	
	
}