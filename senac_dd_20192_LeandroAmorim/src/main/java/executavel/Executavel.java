package executavel;

import model.dao.entityDAO.EmpregadoDAO;

import model.vo.Gerente;

public class Executavel {

	public static void main(String[] args) {

 	Gerente gerente = new Gerente();
 	gerente.setIdEmpregado(0);
 	gerente.setNome("lele Altera");
	gerente.setCpf("08877878947");
	gerente.setSexo("M");
	gerente.setIdade(40);
	gerente.setSalarioBruto(8000.00);
	gerente.calcularSalarioBase();
	gerente.calcularSalarioLiquido();
	gerente.calculoImpostoDeRenda();
	gerente.calculoContribuicao();
	gerente.setComissao(500.00);
	gerente.setTipo(2);
	
	
	EmpregadoDAO empregadoDAO = new EmpregadoDAO();
	//empregadoDAO.salvar(gerente);
	//empregadoDAO.excluir(1);
	empregadoDAO.alterar(gerente);
	
	}

	// banco de dados tem apenas uma tabela de empregado e diferencia pelo tipo 1/2/3
	
	// deve ser desenvolvido mais duas classes, gerencia e diretoria
	// diretoria possui * gerentes ;
	//gerentes possui * funcionarios;
	// no banco de dados deve ter outra tabela de setor;
	// uma terceira tabela trabalha pra armazernar
	
	
	
	
	
}