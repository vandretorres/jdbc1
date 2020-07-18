package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import db.DB;
import db.DbIntegrityException;

public class ProgramDeleteData {


	public static void main(String[] args) {

		
		
		Connection conn = null;

		// Usado para manipulação dos dados na Base
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"DELETE FROM  department"
					+ " where "
					+ " Id = ?"
					);			
			
			st.setInt(1, 2);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println(rowsAffected + " rows Affected!");
			
			

		}catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());		
	}	
		finally {
			
			DB.closeStatement(st);
			DB.closeStatement(st);
		}

	}

}
