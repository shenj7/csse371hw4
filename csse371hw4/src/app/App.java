import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import app.DatabaseConnectionService;

public class App {
	private String serverUsername = null;
	private String serverPassword = null;
	private DatabaseConnectionService dbService = null;

	
	public void runApplication(){
		this.serverUsername = "user371";
		this.serverPassword = "user371";
		this.dbService = new DatabaseConnectionService("titan.csse.rose-hulman.edu", "ResearchReferenceManager");

	}
	
	
	
}

