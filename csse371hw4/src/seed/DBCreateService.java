package seed;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBCreateService {
	private String dbName = "Textbooks"; // use find and replace

	private DatabaseConnectionService dbService = null;

	public DBCreateService(DatabaseConnectionService dbService) {
		this.dbService = dbService;
	}

	public void createDatabase() {
		String query = "USE [Textbooks]\r\n"
				+ "CREATE TABLE [Textbook]\r\n"
				+ "(\r\n"
				+ "[Title] NVARCHAR(100),\r\n"
				+ "[CopyrightYear] int,\r\n"
				+ "[ISBN] CHAR(15) PRIMARY KEY,\r\n"
				+ "[Description] NVARCHAR(MAX)\r\n"
				+ ")\r\n"
				+ "CREATE TABLE [Publisher]\r\n"
				+ "(\r\n"
				+ "[Name] NVARCHAR(50) PRIMARY KEY,\r\n"
				+ ")\r\n"
				+ "CREATE TABLE [Contributor]\r\n"
				+ "(\r\n"
				+ "[Name] NVARCHAR(50),\r\n"
				+ "[Institution] NVARCHAR(50),\r\n"
				+ "PRIMARY KEY ([Name], [Institution]),\r\n"
				+ ")\r\n"
				+ "CREATE TABLE [License]\r\n"
				+ "(\r\n"
				+ "[Name] NVARCHAR(50) PRIMARY KEY,\r\n"
				+ ")\r\n"
				+ "CREATE TABLE [ContributesTo]\r\n"
				+ "(\r\n"
				+ "[Name] NVARCHAR(50),\r\n"
				+ "[Institution] NVARCHAR(50),\r\n"
				+ "[ISBN] CHAR(15),\r\n"
				+ "PRIMARY KEY ([Name], [Institution], [ISBN]),\r\n"
				+ "FOREIGN KEY ([Name], [Institution]) REFERENCES [Contributor]([Name], [Institution]),\r\n"
				+ "FOREIGN KEY ([ISBN]) REFERENCES [Textbook]([ISBN]),\r\n"
				+ ")\r\n"
				+ "CREATE TABLE [Publishes]\r\n"
				+ "(\r\n"
				+ "[Publisher] NVARCHAR(50),\r\n"
				+ "[ISBN] CHAR(15),\r\n"
				+ "PRIMARY KEY ([Publisher], [ISBN]),\r\n"
				+ "FOREIGN KEY ([Publisher]) REFERENCES [Publisher]([NAME]),\r\n"
				+ "FOREIGN KEY ([ISBN]) REFERENCES [Textbook]([ISBN]),\r\n"
				+ ")\r\n"
				+ "CREATE TABLE [LicensedBy]\r\n"
				+ "(\r\n"
				+ "[License] NVARCHAR(50),\r\n"
				+ "[Textbook] CHAR(15),\r\n"
				+ "PRIMARY KEY ([License], [Textbook]),\r\n"
				+ "FOREIGN KEY ([License]) REFERENCES [License]([Name]),\r\n"
				+ "FOREIGN KEY ([Textbook]) REFERENCES [Textbook]([ISBN]),\r\n"
				+ ") ";
		try {
			PreparedStatement stmt = this.dbService.getConnection().prepareStatement(query);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Created database");
	}
	
}
