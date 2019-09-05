package controller.aula05;

import java.util.ArrayList;
import model.bo.aula05.TelefoneBO;
import model.vo.aula5.Telefone;

public class TelefoneController {

	public static final String TIPO_TELEFONE_MOVEL = "Movel";
	public static final String TIPO_TELEFONE_FIXO = "Fixo";
	public static final String SELECIONE_UM_TIPO = "<selecione um tipo>";

	private TelefoneBO bo = new TelefoneBO();

	public ArrayList<Telefone> consultarTodos() {

		return bo.consultarTodos();
	}

	public ArrayList<Telefone> consultarTelefonesDoCliente(int idCliente) {
		return bo.consultarTelefonesDoCliente(idCliente);
	}

	String mensagem = " ";

	public String validarCamposTelefone(String codigoDigitado, String dddDigitado, String numeroDigitado,
			String tipoSelecionado) {
		if (codigoDigitado.isEmpty() || codigoDigitado.trim().length() > 2) {
			mensagem += " código do Páis digitado é  inválido";
		}

		if (dddDigitado.isEmpty() || dddDigitado.trim().length() > 2) {
			mensagem += "DDD digitado é  inválido";
		}

		if (numeroDigitado.isEmpty() || numeroDigitado.trim().length() < 7 || numeroDigitado.trim().length() > 13) {
			mensagem += " número digitado é  inválido";
		}
	
		if (tipoSelecionado.isEmpty() || tipoSelecionado == TelefoneController.SELECIONE_UM_TIPO) {
			mensagem += "selecione um tipo de telefone!";
		}
		
		return mensagem;
	}

	public String salvarTelefone(Telefone novoTelefone) {
		return bo.salvar(novoTelefone);
	}



}
