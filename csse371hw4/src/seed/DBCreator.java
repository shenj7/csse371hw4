package seed;

public class DBCreator {
	public static void createDB() {
		String serverUsername = "user371";
		String serverPassword = "user371";

		DatabaseConnectionService dbService = new DatabaseConnectionService("127.0.0.1",
				"Textbooks");
		dbService.connect(serverUsername, serverPassword);
		DBCreateService dbcs = new DBCreateService(dbService);
		dbcs.createDatabase();
		StoredProceduresCreateService spcs = new StoredProceduresCreateService(dbService);
		spcs.createSProcs();
		TextbookService ts = new TextbookService(dbService);
		String importFile = "textbooks3C.csv";
//		String importFile = "StudentsWithStanding.csv";
		ImportDataParser importer = new ImportDataParser(importFile);
		

		dbService.closeConnection();
	}
}
