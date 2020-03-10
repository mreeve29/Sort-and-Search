import javax.swing.*;
import BreezySwing.*;

public class SortSearchGUI extends GBFrame{

	private JButton addButton = addButton("Add",1,1,1,1);
	private JButton sortButton = addButton("Sort",2,1,1,1);
	private JButton searchButton = addButton("Search",3,1,1,1);
	
	private Database db;
	
	public void buttonClicked(JButton button) {
		if(button == addButton) {
			new AddDialog(this, db);
		}else if(button == sortButton) {
			new SortDialog(this,db);
		}else if(button == searchButton) {
			
		}
	}
	
	
	public SortSearchGUI() {
		
		db = new Database();
		
		setSize(400,400);
		setTitle("Sort and Search");
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SortSearchGUI();
	}
}
