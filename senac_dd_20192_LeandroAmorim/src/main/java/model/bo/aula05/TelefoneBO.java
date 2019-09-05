package model.bo.aula05;

import java.util.ArrayList;

import model.dao.aula05.TelefoneDAO;
import model.vo.aula5.Cliente;
import model.vo.aula5.Telefone;

public class TelefoneBO {

	private TelefoneDAO dao = new TelefoneDAO();
	
	public ArrayList<Telefone> consultarTodos() {
		return dao.consultarTodos();
	}

	public ArrayList<Telefone> consultarTelefonesDoCliente(int idCliente) {
		return dao.consultarTodosPorIdCliente(idCliente);
	}

	public String salvar(Telefone novoTelefone) {
		String mensagem = "";
		
		if(dao.temTelefoneCadastrado(novoTelefone)) {
			mensagem += "este telefone está cadastrado.";
		}else {
			novoTelefone = dao.salvar(novoTelefone);
		
			
		}
				
		return mensagem;
	}
}