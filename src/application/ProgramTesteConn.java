package application;

import java.sql.Connection;
import java.util.Properties;

import db.DB;

public class ProgramTesteConn {

	public static void main(String[] args) {


		Connection conn = DB.getConnection();
		
		
	
		if(conn != null) {
			
			System.out.println("Banco de dados connectado ");
		}
		
		DB.closeConnection();
		

	}

}
