package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
							+ "(?,?,?,?,?)"				
					);


			// substitui palceholders ( ? ) com valores que serão inseridos na base
			st.setString(1,"Carl Purple");
			st.setString(2,"cpurple@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("14/12/1981").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5,4);

			
			// Executa statement
			int rowAffected = st.executeUpdate();

			System.out.println("Done! " + rowAffected + " rows Affected");

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
