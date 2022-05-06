package seed;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoredProceduresCreateService {

		private String dbName = "Textbooks"; 

		private DatabaseConnectionService dbService = null;

		public StoredProceduresCreateService(DatabaseConnectionService dbService) {
			this.dbService = dbService;
		}
		
		public void createSProcs() {
			createAddTextbook();
		}
		
		private void createAddTextbook() {
			String query = "";
			try {
				PreparedStatement stmt = this.dbService.getConnection().prepareStatement(query);
				stmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Created add textbook stored procedure");
		}
		
}
