package executavel;

import java.util.ArrayList;
import java.util.Scanner;

import model.vo.Diretor;
import model.vo.FuncionarioOperacional;
import model.vo.Gerente;

public class Executavel {

	public static void main(String[] args) {

		
		cadastrarDiretor();
		cadastrarGerente();
		cadastrarFuncionario();

	}
	
	private static void cadastrarGerente() {
		Scanner entrada = new Scanner(System.in);
		Gerente gerente = new Gerente();
		System.out.println("digite o nome do gerente:");
		gerente.setNome(entrada.nextLine());
		System.out.println("digite cpf de" + gerente.getNome());
		gerente.setCpf(entrada.nextLine());
		System.out.println("Digite sexo de" + gerente.getNome());
		gerente.setSexo(entrada.nextLine());
		System.out.println("digite a idade "+ gerente.getNome());
		gerente.setIdade(entrada.nextInt());
		System.out.println("Digite salario Bruto de " + gerente.getNome());
		gerente.setSalarioBruto(Double.parseDouble(entrada.nextLine()));
		System.out.println("o valor do imposto é:");
		gerente.setImpostoRenda(gerente.calculoImpostoDeRenda());
		System.out.println("O valor da Contribuição é:");
		gerente.setContribuicao(gerente.calculoContribuicao());
	}

	private static void cadastrarDiretor() {
		Scanner entrada = new Scanner(System.in);
		Diretor diretor = new Diretor();
		System.out.println("digite o nome do diretor: ");
		diretor.setNome(entrada.nextLine());
		System.out.println("digite cpf de " + diretor.getNome());
		diretor.setCpf(entrada.nextLine());
		System.out.println("Digite sexo de " + diretor.getNome());
		diretor.setSexo(entrada.nextLine());
		System.out.println("digite a idade "+ diretor.getNome());
		diretor.setIdade(entrada.nextInt());
		System.out.println("Digite salario Bruto de " + diretor.getNome());
		diretor.setSalarioBruto(Double.parseDouble(entrada.nextLine()));
		System.out.println("o valor do imposto é:");
		diretor.setImpostoRenda(diretor.calculoImpostoDeRenda());
		System.out.println("O valor da Contribuição é:");
		diretor.setContribuicao(diretor.calculoContribuicao());
		System.out.println("seu salario base é: ");
		diretor.setSalarioBase(diretor.CalcularSalarioBase());
		System.out.println("seu liquido é: ");
		diretor.setSalarioLiquido(diretor.CalcularSalarioLiquido());
		ArrayList <Gerente> gerentes = null;
		gerentes.add(gerente);
		diretor.setGerentes(gerentes);
	}

	private static void cadastrarFuncionario() {

	}
}