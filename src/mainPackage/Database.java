package mainPackage;

import javax.swing.*;
import java.awt.*;

public class Database extends JFrame{
	
	private static final long serialVersionUID = -5670146755581220793L;

	static int numberOfRecords;
	JLabel databaseDisplay;
	static JTable dataTable;
	static String[][] myData;
	public Database() {
		//frame properties
		this.setTitle("Database");
		this.setSize(300,200);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		
		//initialize datasets
		String[] columnData = {"username","password"};
		myData = new String[10][2];
		numberOfRecords = 0;
		//textDisplay
		databaseDisplay = new JLabel("Storage!");
		databaseDisplay.setFont(new Font("MV Boli",Font.PLAIN,20));
		databaseDisplay.setBounds(100, 0, 150, 25);
		
		//data
		dataTable = new JTable(myData,columnData);
		dataTable.setBounds(0,30,300,300);
		dataTable.setEnabled(false);
		JScrollPane sp = new JScrollPane(dataTable);
		sp.setBounds(0,30,285,300);
		
		
		this.add(databaseDisplay);
		this.add(sp);
		this.setVisible(true);
	}
	public static void addItem(String username, char[] password) {		
		myData[numberOfRecords][0] = username;
		myData[numberOfRecords][1] = String.valueOf(password);
		numberOfRecords++;
		dataTable.repaint();	
	}
	public static void initData() {
		for(int i=0;i<numberOfRecords;i++) {
			myData[i][0]="";
			myData[i][1]="";
		}
		numberOfRecords=0;
		dataTable.repaint();
	}
	public static boolean isValid(String userName) {
		for(int i =0;i<numberOfRecords;i++) {
			if(myData[i][0].equals(userName)) {
				return true;
			}
		}
		return false;
	}
	public static boolean isValid(String userName, String password) {
		for(int i =0;i<numberOfRecords;i++) {
			if(myData[i][0].equals(userName)) {
				if(myData[i][1].equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
}
