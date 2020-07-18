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

		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");				
		Connection conn = null;

		// Usado para manipulação dos dados na Base
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();
			
			// cria Statement para insrção de  dados
			st = conn.prepareStatement(
					"INSERT into seller "
							+ "(Name, Email,BirthDate, BaseSalary,DepartmentId)"
							+ "values "
							+ "(?,?,?,?,?)",
							Statement.RETURN_GENERATED_KEYS
					);


			// substitui palceholders ( ? ) com valores que serão inseridos na base
			st.setString(1,"Mike Ross");
			st.setString(2,"ross@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("13/07/1985").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5,4);
			
			
			// Executa statement
			int rowAffected = st.executeUpdate();

			if ( rowAffected > 0) {
				
				ResultSet rs = st.getGeneratedKeys();
				
				while(rs.next()) {
					
					int id = rs.getInt(1);
					
					System.out.println("Id gerado pela inserção: " + id);
					
				}
				
			}else {
				
				System.out.println("No rows affected");
				
			}

		}catch (SQLException e) {

			e.printStackTrace();
		}catch (ParseException e) {
            e.printStackTrace();
		}finally {
			
			DB.closeStatement(st);
			DB.closeStatement(st);
		}

	}

}
