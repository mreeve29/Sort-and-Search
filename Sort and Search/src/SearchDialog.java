import java.util.ArrayList;

import javax.swing.*;
import BreezySwing.*;

public class SearchDialog extends GBDialog{

	private JRadioButton studentButton = addRadioButton("Student",1,1,1,1);
	private JRadioButton employeeButton = addRadioButton("Employee",1,2,1,1);
	private JRadioButton widgetButton = addRadioButton("Widget",1,3,1,1);
	
	private JRadioButton binarySearchButton = addRadioButton("Binary Search", 2, 1, 1, 1);
	private JRadioButton sequentialSearchButton = addRadioButton("Sequential Search", 2, 2, 1, 1);
	
	private JTextField searchField = addTextField("",3,1,3,1);
	
	private JButton sortButton = addButton("Search",4,1,3,1);
	
	
	private Database db;
	public void buttonClicked(JButton button) {
		String search = searchField.getText();
		if(button == sortButton) {
			if(studentButton.isSelected()) {
				if(sequentialSearchButton.isSelected()) {
					ArrayList<Comparable> arr = SortSearch.sequentialSearch(db.getStudents(), new Student(search, 0));
					if(arr.size() == 0) {
						messageBox("No results found for \"" + search + "\"");
						return;
					}
					new OutputTableDialog(null,arr,0);
					return;
				}else {
					ArrayList<Comparable> arr = SortSearch.binarySearch(SortSearch.selectionSort(db.getStudents()), new Student(search,0));
					if(arr.size() == 0) {
						messageBox("No results found for \"" + search + "\"");
						return;
					}
					new OutputTableDialog(null,arr,0);
					return;
				}
			}else if(employeeButton.isSelected()) {
				double salary;
				try {
					salary = Double.parseDouble(search);
				}catch (Exception e) {
					messageBox("Invalid salary, must be a number");
					return;
				}
				if(sequentialSearchButton.isSelected()) {
					ArrayList<Comparable> arr = SortSearch.sequentialSearch(db.getEmployees(), new Employee("", salary));
					if(arr.size() == 0) {
						messageBox("No results found for \"" + search + "\"");
						return;
					}
					new OutputTableDialog(null,arr,1);
					return;
				}else {
					ArrayList<Comparable> arr = SortSearch.binarySearch(SortSearch.selectionSort(db.getEmployees()),new Employee("", salary));
					if(arr.size() == 0) {
						messageBox("No results found for \"" + search + "\"");
						return;
					}
					new OutputTableDialog(null,arr,1);
					return;
				}
			}else if(widgetButton.isSelected()) {
				int sold;
				try {
					sold = Integer.parseInt(search);
				}catch(Exception e) {
					messageBox("Invalid number sold value, must be integer");
					return;
				}
				if(sequentialSearchButton.isSelected()) {
					ArrayList<Comparable> arr = SortSearch.sequentialSearch(db.getWidgets(), new Widget("", sold));
					if(arr.size() == 0) {
						messageBox("No results found for \"" + search + "\"");
						return;
					}
					new OutputTableDialog(null, arr, 2);
					return;
				}else {
					ArrayList<Comparable> arr = SortSearch.binarySearch(SortSearch.selectionSort(db.getWidgets()),new Widget("", sold));
					if(arr.size() == 0) {
						messageBox("No results found for \"" + search + "\"");
						return;
					}
					new OutputTableDialog(null,arr,2);
					return;
				}
			}
		}
	}
	
	public SearchDialog(JFrame parent, Database d) {
		super(parent);
		db = d;
		
		ButtonGroup typeBG = new ButtonGroup();
		typeBG.add(studentButton);
		typeBG.add(employeeButton);
		typeBG.add(widgetButton);
		
		ButtonGroup sortBG = new ButtonGroup();
		sortBG.add(binarySearchButton);
		sortBG.add(sequentialSearchButton);
		
		studentButton.setSelected(true);
		sequentialSearchButton.setSelected(true);
		
		setSize(400,400);
		setTitle("Sort");
		setVisible(true);
	}

}
