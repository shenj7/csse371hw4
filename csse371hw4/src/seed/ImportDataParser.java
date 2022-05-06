package seed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportDataParser {
	String filename;

    public ImportDataParser(String filename) {
    	this.filename = filename;
        try {
            Scanner scanner = new Scanner(new File(filename));
            System.out.println("opening file " + filename);
            System.out.println("first line: " + scanner.nextLine()); // skip header line
            while (scanner.hasNextLine()){
                addTextbook(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addTextbook(String s) {
        //https://stackoverflow.com/questions/15979688/how-to-handle-commas-in-the-data-of-a-csv-in-java
        String[] textbookinfo = s.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);
        //0: Title
        String title = textbookinfo[0];
        //1: Copyright Year
        String cpyr = textbookinfo[1];
        //2: Contributors
        String contrib = textbookinfo[2];
        //3: Publisher
        String publisher = textbookinfo[3];
        //4: Description
        String desc = textbookinfo[4];
        //5: License
        String lic = textbookinfo[5];
        //6: ISBN13
        String isbn = textbookinfo[6];
        
        System.out.println(title+cpyr+contrib+publisher+desc+lic+isbn);

    }

}
