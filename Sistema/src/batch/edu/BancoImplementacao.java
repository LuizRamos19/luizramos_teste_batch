package batch.edu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoImplementacao {
	private Connection con;

	public BancoImplementacao() {
		con = Singleton.getInstance().getConnection();
	}
	
	public void adicionar() {
		try {
			System.out.println("Inserindo dados na tabela. Favor aguarde...");
			String sql = "INSERT INTO tb_customer_account(id_customer, cpf_cnpj, nm_customer, is_active, vl_total) "
					+ "VALUES (1208, '399.823.388-23', 'Luiz Gustavo', 0, 1500),"
					+ "(1400, '432.564.768-87', 'Evair Rodrigues', 1, 206),"
					+ "(1700, '354.643.464-22', 'Nilson Munoz', 1, 559),"
					+ "(2000, '265.488.871-88', 'Rodrigo Tanebal', 1, 308),"
					+ "(2020, '594.874.544-84', 'Leonardo Gaspar', 0, 561),"
					+ "(1690, '854.520.027-23', 'Guilherme Queiroz', 0, 720),"
					+ "(700, '543.676.232-56', 'Nilton Brito', 0, 1200),"
					+ "(1500, '855.514.541-94', 'Kevin Soares', 1, 800),"
					+ "(903, '562.489.120-29', 'Luana Silva', 1, 870),"
					+ "(1499, '857.695.878-20', 'Barbara Moraes', 0, 280),"
					+ "(1849, '143.654.278-43', 'Ludmilla Santos', 1, 520),"
					+ "(2699, '352.842.931-52', 'Raphael Esteves', 0, 130),"
					+ "(3054, '854.921.302-34', 'Bruno Santos', 1, 1300),"
					+ "(3062, '975.306.895-62', 'Roger Guimarães', 0, 1258),"
					+ "(1594, '825.621.921-43', 'Vinicius Moura', 0, 540),"
					+ "(1207, '025.642.894-32', 'Alberto Duarte', 1, 542),"
					+ "(4039, '008.842.777-43', 'Luciana Mendonça', 0, 897),"
					+ "(3048, '954.856.275-55', 'Cassio da Silva', 1, 456),"
					+ "(2050, '61.797.924/0003-17', 'HP', 1, 122)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			System.out.println("Dados inseridos com sucesso\n");
		} catch (SQLException e) {
			System.out.println("Não foi possível inserir os dados na tabela");
		}
	}

	public double mediaIntervalo() {
		double media = 0;
		System.out.println("Calculando média final. Favor aguarde...");
		try {
			String sql = "SELECT AVG(vl_total) FROM tb_customer_account WHERE vl_total > 560 AND id_customer BETWEEN 1500 AND 2700";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				media = rs.getInt(1);
			}
			System.out.println("Cálculo finalizado com sucesso\n");
		} catch (SQLException e) {
			System.out.println("Não foi possível consultar os dados da tabela");
		}
		return media;
	}
		
	public String pesquisarClientes() {
		String clientes = "";
		try {
			System.out.println("Consultando os clientes utilizados para o cálculo da média...");
			String sql = "SELECT nm_customer, vl_total FROM tb_customer_account WHERE vl_total > 560 AND id_customer BETWEEN 1500 AND 2700 ORDER BY vl_total DESC";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				clientes = clientes+"Nome: "+rs.getString(1)+"\nSaldo: "+rs.getDouble(2)+"\n\n";
			}
		} catch (SQLException e) {
			System.out.println("Não foi possível consultar os dados da tabela");
		}
		return clientes;
	}
	
	public void deletarDados() {
		try {
			System.out.println("Excluindo os registro do banco de dados\n");
			String sql = "DELETE FROM tb_customer_account";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Não foi possível deletar os dados do banco de dados");
		}
	}
}