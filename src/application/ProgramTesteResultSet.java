package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class ProgramTesteResultSet {

	public static void main(String[] args) {



		Connection conn = null; 
		Statement st = null;
		ResultSet rs = null;

		try {

			conn = DB.getConnection();


			// Instanciando objeto do tipo Statement
			st = conn.createStatement();


			// Executando query
			rs = st.executeQuery("select * from department");



			// percorrendo ResultSet para imprimir resultado da query

			System.out.println("Resultado da pesquisa:\n");
			while(rs.next()) {

				System.out.println(rs.getInt("Id") + " - " + rs.getString("Name"));

			}	


		}catch (SQLException e) {

			e.printStackTrace();			
		}finally {

			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();			
		}
	}

}
