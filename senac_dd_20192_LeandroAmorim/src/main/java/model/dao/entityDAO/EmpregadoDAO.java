package model.dao.entityDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.dao.Banco;
import model.dao.BaseDAO;
import model.vo.Diretor;
import model.vo.Empregados;
import model.vo.FuncionarioOperacional;
import model.vo.Gerente;

public class EmpregadoDAO implements BaseDAO<Empregados> {

	public Empregados salvar(Empregados empregado) {
		Connection conexao = Banco.getConnection();
		String sql = "INSERT INTO EMPREGADO (NOME, CPF, SEXO, IDADE, SALARIOBRUTO,SALARIOBASE ,SALARIOLIQUIDO, IMPOSTORENDA, CONTRIBUICAO,COMISSAO, TIPO ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, empregado.getNome());
			prepStmt.setString(2, empregado.getCpf());
			prepStmt.setString(3, empregado.getSexo());
			prepStmt.setInt(4, empregado.getIdade());
			prepStmt.setDouble(5, empregado.getSalarioBruto());
			prepStmt.setDouble(6, empregado.getSalarioBase());
			prepStmt.setDouble(7, empregado.getSalarioLiquido());
			prepStmt.setDouble(8, empregado.getImpostoRenda());
			prepStmt.setDouble(9, empregado.getContribuicao());
			prepStmt.setDouble(10, empregado.getComissao());
			prepStmt.setDouble(11, empregado.getTipo());

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				empregado.setIdEmpregado(idGerado);
			}

			prepStmt.execute();

		} catch (SQLException e) {
			System.out.println("Erro ao salvar Empregado");
			System.out.println("Erro: " + e);

		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);

		}

		return empregado;

	}

	public boolean excluir(int IdEmpregado) {
		Connection conexao = Banco.getConnection();
		String sql = "DELETE FROM EMPREGADO WHERE IDEMPREGADO=" + IdEmpregado;
		Statement stmt = Banco.getStatement(conexao);
		int resultado = 0;

		try {
			resultado = stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("Erro ao deletar Empregado");
			System.out.println("Erro: " + e);
			System.out.println(sql);
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return resultado > 0;
	}

	public boolean alterar(Empregados empregado) {
		Connection conexao = Banco.getConnection();
		String sql = "UPDATE EMPREGADO SET (NOME=?, CPF=?, SEXO=?, IDADE=?,SALARIOBRUTO=?, SALARIOBASE=?, SALARIOLIQUIDO=?, IMPOSTORENDA=?, CONTRIBUICAO=?, COMISSAO=?, TIPO=?) WHERE IDEMPREGADO=?";
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		int quantidadeDeLinhasAfetadas = 0;
		
		try {
			prepStmt.setString(1, empregado.getNome());
			prepStmt.setString(2, empregado.getCpf());
			prepStmt.setString(3, empregado.getSexo());
			prepStmt.setInt(4, empregado.getIdade());
			prepStmt.setDouble(5, empregado.getSalarioBruto());
			prepStmt.setDouble(6, empregado.getSalarioBase());
			prepStmt.setDouble(7, empregado.getSalarioLiquido());
			prepStmt.setDouble(8, empregado.getImpostoRenda());
			prepStmt.setDouble(9, empregado.getContribuicao());
			prepStmt.setDouble(10, empregado.getComissao());
			prepStmt.setDouble(11, empregado.getTipo());
			prepStmt.setInt(12, empregado.getIdEmpregado());

			quantidadeDeLinhasAfetadas = prepStmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erro ao alterar Empregado");
			System.out.println("Erro: " + e);
			System.out.println(sql);
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return quantidadeDeLinhasAfetadas > 0;
	}

	public Empregados consultarPorId(int IdEmpregado) {
		Connection conexao = Banco.getConnection();
		Statement stmt = Banco.getStatement(conexao);
		ResultSet resultado = null;
		String sql = "SELECT * EMPREGADO WHERE IDEMPREGADO =" + IdEmpregado;
		Empregados diretorConsultado = new Diretor();
		Empregados gerenteConsultado = new Gerente();
		Empregados operacionalConsultado = new FuncionarioOperacional();

		try {
			resultado = stmt.executeQuery(sql);
			} catch (SQLException e) {
			System.out.println("Erro ao consultar por ID do Empregado");
			System.out.println("Erro: " + e);
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conexao);

		}
		
		return null ;
	}

	public ArrayList<Empregados> consultarTodos() {
		Connection conexao = Banco.getConnection();
		Statement stmt = Banco.getStatement(conexao);
		ResultSet rs = null;
		String sql = "Select * from EMPREGADO";
		ArrayList<Empregados> empregados = new ArrayList<Empregados>();
		
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
			
				
				
				
				
				
		}
			
		} catch (Exception e) {
			System.out.println("Erro ao consultar  Empregados");
			System.out.println("Erro: " + e);
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeResultSet(rs);
			Banco.closeConnection(conexao);

		}
		
		
		return empregados;
	}

}
