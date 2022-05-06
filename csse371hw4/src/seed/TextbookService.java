package seed;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class TextbookService {
	private DatabaseConnectionService dbService = null;

	public TextbookService(DatabaseConnectionService dbService) {
		this.dbService = dbService;
	}
	
	public void addTextbook(Textbook Textbook) {
	}
}
