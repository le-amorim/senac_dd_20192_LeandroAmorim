package model.dao.entityDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.dao.Banco;
import model.dao.BaseDAO;
import model.vo.FuncionarioOperacional;

public class FuncionarioOperacionalDAO implements BaseDAO<FuncionarioOperacional> {

	public FuncionarioOperacional salvar(FuncionarioOperacional funcionarioOP) {
		Connection conexao = Banco.getConnection();
		String sql = "INSERT INTO FUNCIONARIO_OP (nome, cpf, sexo, idade, SALARIOBRUTO, salarioLiquido, IMPOSTORENDA, CONTRIBUICAO,IDGERENTE ) VALUES ?,?,?,?,?,?,?,?,?";
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, funcionarioOP.getNome());
			prepStmt.setString(2, funcionarioOP.getCpf());
			prepStmt.setString(3, funcionarioOP.getSexo());
			prepStmt.setInt(4, funcionarioOP.getIdade());
			prepStmt.setDouble(5, funcionarioOP.getSalarioBruto());
			prepStmt.setDouble(6, funcionarioOP.getSalarioLiquido());
			prepStmt.setDouble(7, funcionarioOP.getImpostoRenda());
			prepStmt.setDouble(8, funcionarioOP.getContribuicao());
			prepStmt.setInt(9, funcionarioOP.getIdgerente());

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				funcionarioOP.setId(idGerado);
			}

			prepStmt.execute();

		} catch (SQLException e) {
			System.out.println("Erro ao salvar funcionarioOP");
			System.out.println("Erro: " + e);

		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);

		}

		return funcionarioOP;
	}

	public boolean excluir(int id) {
		Connection conexao = Banco.getConnection();
		Statement stmt = Banco.getStatement(conexao);
		int resultado = 0;
		String sql = "DELETE FROM FUNCIONARIO_OP WHERE ID= " + id;
		try {
			resultado = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("Erro ao deletar funcionarioOP");
			System.out.println("Erro: " + e);

		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conexao);

		}

		return resultado != 0;
	}

	public boolean alterar(FuncionarioOperacional funcionarioOP) {
		Connection conexao = Banco.getConnection();
		String sql = "UPDATE FUNCIONARIO_OP SET NOME=?, cpf=?, sexo=?, idade=?,salarioBruto=?, SALARIOLIQUIDO=?, IMPOSTORENDA=?, CONTRIBUICAO=?, IDGERENTE=? WHERE ID=?";
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		int quantidadeDeLinhasAfetadas = 0;

		try {
			prepStmt.setString(1, funcionarioOP.getNome());
			prepStmt.setString(2, funcionarioOP.getCpf());
			prepStmt.setString(3, funcionarioOP.getSexo());
			prepStmt.setInt(4, funcionarioOP.getIdade());
			prepStmt.setDouble(5, funcionarioOP.getSalarioBruto());
			prepStmt.setDouble(6, funcionarioOP.getSalarioLiquido());
			prepStmt.setDouble(7, funcionarioOP.getImpostoRenda());
			prepStmt.setDouble(8, funcionarioOP.getContribuicao());
			prepStmt.setInt(9, funcionarioOP.getIdgerente());
			prepStmt.setInt(10, funcionarioOP.getId());
			quantidadeDeLinhasAfetadas = prepStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao Atualizar funcionarioOP");
			System.out.println("Erro: " + e);

		} finally {
			Banco.closeStatement(prepStmt);
			Banco.closeConnection(conexao);

		}

		return quantidadeDeLinhasAfetadas > 0;
	}

	public FuncionarioOperacional consultarPorId(int id) {
		Connection conexao = Banco.getConnection();
		Statement stmt = Banco.getStatement(conexao);
		ResultSet resultado = null;
		FuncionarioOperacional FuncionarioOpConsultado = new FuncionarioOperacional();
		String sql = "SELECT * FUNCIONARIO_OP WHERE ID =" + id;

		try {
			resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				FuncionarioOpConsultado.setNome(resultado.getString("nome"));
				FuncionarioOpConsultado.setCpf(resultado.getString("cpf"));
				FuncionarioOpConsultado.setSexo(resultado.getString("sexo"));
				FuncionarioOpConsultado.setIdade(resultado.getInt("idade"));
				FuncionarioOpConsultado.setSalarioBruto(resultado.getDouble("salarioBruto"));
				FuncionarioOpConsultado.setSalarioLiquido(resultado.getDouble("salarioLiquido"));
				FuncionarioOpConsultado.setImpostoRenda(resultado.getDouble("IMPOSTORENDA"));
				FuncionarioOpConsultado.setContribuicao(resultado.getDouble("Contribuicao"));
				FuncionarioOpConsultado.setIdgerente(resultado.getInt("Idgerente"));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao Consultar um funcionarioOP");
			System.out.println("Erro: " + e);
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conexao);
		}

		return FuncionarioOpConsultado;
	}

	public ArrayList<FuncionarioOperacional> consultarTodos() {
		Connection conexao = Banco.getConnection();
		Statement stmt = Banco.getStatement(conexao);
		ResultSet rs = null;
		String sql = "Select * from FUNCIONARIO_OP";
		ArrayList<FuncionarioOperacional> FuncionariosOP = new ArrayList<FuncionarioOperacional>();
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				FuncionarioOperacional funcionarioConsulta = new FuncionarioOperacional();
				funcionarioConsulta.setNome(rs.getString("nome"));
				funcionarioConsulta.setCpf(rs.getString("cpf"));
				funcionarioConsulta.setSexo(rs.getString("sexo"));
				funcionarioConsulta.setIdade(rs.getInt("idade"));
				funcionarioConsulta.setSalarioBruto(rs.getDouble("salarioBruto"));
				funcionarioConsulta.setSalarioLiquido(rs.getDouble("salarioLiquido"));
				funcionarioConsulta.setImpostoRenda(rs.getDouble("IMPOSTORENDA"));
				funcionarioConsulta.setContribuicao(rs.getDouble("Contribuicao"));
				funcionarioConsulta.setIdgerente(rs.getInt("Idgerente"));
				FuncionariosOP.add(funcionarioConsulta);
			}

		} catch (Exception e) {
			System.out.println("Erro ao Consultar todos funcionarioOP");
			System.out.println("Erro: " + e);

		} finally {
			Banco.closeStatement(stmt);
			Banco.closeResultSet(rs);
			Banco.closeConnection(conexao);

		}

		return FuncionariosOP;
	}

}
