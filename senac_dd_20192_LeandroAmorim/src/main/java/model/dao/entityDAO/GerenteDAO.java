package model.dao.entityDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.dao.Banco;
import model.dao.BaseDAO;
import model.vo.Gerente;

public class GerenteDAO implements BaseDAO<Gerente> {

	public Gerente salvar(Gerente gerente) {
		Connection conexao = Banco.getConnection();
		String sql = "INSERT INTO GERENTE NOME, CPF, SEXO, IDADE, SALARIOBRUTO, SALARIOLIQUIDO, IMPOSTORENDA, CONTRIBUICAO, COMISSAO  VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, gerente.getNome());
			prepStmt.setString(2, gerente.getCpf());
			prepStmt.setString(3, gerente.getSexo());
			prepStmt.setInt(4, gerente.getIdade());
			prepStmt.setDouble(5, gerente.getSalarioBruto());
			prepStmt.setDouble(6, gerente.getSalarioLiquido());
			prepStmt.setDouble(7, gerente.getImpostoRenda());
			prepStmt.setDouble(8, gerente.getContribuicao());
			prepStmt.setDouble(9, gerente.getComissao());
			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				gerente.setIdGerente(idGerado);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao salvar gerente");
			System.out.println("Erro: " + e);

		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return gerente;
	}

	public boolean excluir(int id) {
		Connection conexao = Banco.getConnection();
		Statement stmt = Banco.getStatement(conexao);
		String sql = "DELETE * FROM GERENTE WHERE ID=  " + id;
		int resultado = 0;
		try {
			resultado = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("Erro ao salvar gerente");
			System.out.println("Erro: " + e);

		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);

		}

		return resultado > 0;
	}

	public boolean alterar(Gerente gerente) {
		Connection conexao = Banco.getConnection();
		String sql = "UPDATE GERENTE SET NOME=?, CPF=?, SEXO=?, IDADE=?, SALARIOBRUTO=?, SALARIOLIQUIDO=?, IMPOSTORENDA=?, CONTRIBUICAO=?, COMISSAO=?  ";
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		int QuantidadeDeLinhasAfetadas = 0;

		try {

			prepStmt.setString(1, gerente.getNome());
			prepStmt.setString(2, gerente.getCpf());
			prepStmt.setString(3, gerente.getSexo());
			prepStmt.setInt(4, gerente.getIdade());
			prepStmt.setDouble(5, gerente.getSalarioBruto());
			prepStmt.setDouble(6, gerente.getSalarioLiquido());
			prepStmt.setDouble(7, gerente.getImpostoRenda());
			prepStmt.setDouble(8, gerente.getContribuicao());
			prepStmt.setDouble(9, gerente.getComissao());
			prepStmt.setInt(9, gerente.getIdGerente());
			QuantidadeDeLinhasAfetadas = prepStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao alterar gerente");
			System.out.println("Erro: " + e);
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);

		}

		return QuantidadeDeLinhasAfetadas > 0;
	}

	public Gerente consultarPorId(int id) {
		Connection conexao = Banco.getConnection();
		Statement stmt = Banco.getStatement(conexao);
		ResultSet resultado = null;
		String sql = "SELECT * FROM GERENTE WHERE ID=" + id;
		Gerente gerenteConsultado = new Gerente();
		
		try {
			resultado = stmt.executeQuery(sql);
			while (resultado.next()){
				gerenteConsultado.setNome(resultado.getString("nome"));
				gerenteConsultado.setCpf(resultado.getString("cpf"));
				gerenteConsultado.setSexo(resultado.getString("sexo"));
				gerenteConsultado.setIdade(resultado.getInt("idade"));
				gerenteConsultado.setSalarioBruto(resultado.getDouble("salarioBruto"));
				gerenteConsultado.setSalarioLiquido(resultado.getDouble("salarioLiquido"));
				gerenteConsultado.setImpostoRenda(resultado.getDouble("ImpostoRenda"));
				gerenteConsultado.setContribuicao(resultado.getDouble("Contribuicao"));
				gerenteConsultado.setComissao(resultado.getDouble("comissao"));
				gerenteConsultado.setIdGerente(resultado.getInt("Idgerente"));
			
			}
					
		} catch (SQLException e) {
			System.out.println("Erro ao salvar gerente");
			System.out.println("Erro: " + e);
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conexao);
		}
		return gerenteConsultado;
	}

	public ArrayList<Gerente> consultarTodos() {
		Connection conexao = Banco.getConnection();
		Statement stmt = Banco.getStatement(conexao);
		ResultSet resultado = null;
		String sql = "Select * from FUNCIONARIO_OP";
		ArrayList<Gerente> gerentes = new ArrayList<Gerente>();
		Gerente gerenteTodos = new Gerente();
	try {
		resultado = stmt.executeQuery(sql);
		while (resultado.next()){
		gerenteTodos.setNome(resultado.getString("nome"));
		gerenteTodos.setCpf(resultado.getString("cpf"));
		gerenteTodos.setSexo(resultado.getString("sexo"));
		gerenteTodos.setIdade(resultado.getInt("idade"));
		gerenteTodos.setSalarioBruto(resultado.getDouble("salarioBruto"));
		gerenteTodos.setSalarioLiquido(resultado.getDouble("salarioLiquido"));
		gerenteTodos.setImpostoRenda(resultado.getDouble("ImpostoRenda"));
		gerenteTodos.setContribuicao(resultado.getDouble("Contribuicao"));
		gerenteTodos.setComissao(resultado.getDouble("comissao"));
		gerenteTodos.setIdGerente(resultado.getInt("Idgerente"));
		gerentes.add(gerenteTodos);	
		}
	} catch (SQLException e) {
		System.out.println("Erro ao salvar gerente");
		System.out.println("Erro: " + e);
	}finally {
		Banco.closeResultSet(resultado);
		Banco.closeStatement(stmt);
		Banco.closeConnection(conexao);
		
	}
		
		return gerentes;
	}

}
