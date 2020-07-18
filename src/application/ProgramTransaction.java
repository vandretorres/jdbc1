package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class ProgramTransaction {


	public static void main(String[] args) {

		
		
		Connection conn = null;

		// Usado para manipulação dos dados na Base
		Statement st = null;

		try {
			
			conn = DB.getConnection();
			
			// Desabilitando auto commit
			conn.setAutoCommit(false);

			
				st = conn.createStatement();
				
				int rows1 = st.executeUpdate("Update seller set BaseSalary = 2090 where DepartmentId = 1");
				
				System.out.println("Rows 1 : " + rows1);
				
				
			/*	
			 * LANÇANDO EXCESSÇÃO PARA TESTAR ROLLBACK
			 * 
				int x = 1;
				if ( x < 2) {
					
					throw new SQLException("Fake Error");
					
				}
				*/		
							
				int rows2 = st.executeUpdate("Update seller set BaseSalary = 3090 where DepartmentId = 2");			
				System.out.println("Rows 2 : " + rows2);
				
			// commit da transação
			conn.commit();
			
			

		}	
		catch (SQLException e) {
			    
			try {
					conn.rollback();
					throw new DbException("Rollback executed! Error Caused by: " + e.getMessage());
			
			} catch (SQLException e1) {					
			
				throw new DbException("Error trying to rollback! Caused by: " + e.getMessage());
					
				}				
		}
		finally {
			
			DB.closeStatement(st);
			DB.closeStatement(st);
		
		}

	}

}
