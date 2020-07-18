package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class ProgramTesteResultSet {

	public static void main(String[] args) {

		
		
		Connection conn = null;

		// Usado para manipulação dos dados na Base
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"update seller "
					+ "set BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "DepartmentId = ?"					
					);
			
			st.setDouble(1, 200.00);
			st.setInt(2, 4);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println(rowsAffected + " rows Affected!");
			
			

		}catch (SQLException e) {
			e.printStackTrace();		
		}finally {
			
			DB.closeStatement(st);
			DB.closeStatement(st);
		}

	}

}
