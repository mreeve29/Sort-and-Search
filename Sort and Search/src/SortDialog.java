import java.util.ArrayList;

import javax.swing.*;
import BreezySwing.*;

public class SortDialog extends GBDialog{

	private JRadioButton studentButton = addRadioButton("Student",1,1,1,1);
	private JRadioButton employeeButton = addRadioButton("Employee",1,2,1,1);
	private JRadioButton widgetButton = addRadioButton("Widget",1,3,1,1);
	
	private JRadioButton selectionSortButton = addRadioButton("Selection Sort", 2, 1, 1, 1);
	private JRadioButton insertionSortButton = addRadioButton("Insertion Sort", 2, 2, 1, 1);
	
	private JButton sortButton = addButton("Sort",3,1,1,3);
	
	
	private Database db;
	public void buttonClicked(JButton button) {
		if(button == sortButton) {
			if(studentButton.isSelected()) {
				if(insertionSortButton.isSelected()) {
					ArrayList<Comparable> arr = SortSearch.insertionSort(db.getStudents());
					if(arr.size() == 0) {
						messageBox("There are no students entered");
						return;
					}
					new OutputTableDialog(null,arr,0);
					return;
				}else {
					ArrayList<Comparable> arr = SortSearch.selectionSort(db.getStudents());
					if(arr.size() == 0) {
						messageBox("There are no students entered");
						return;
					}
					new OutputTableDialog(null,arr,0);
					return;
				}
			}else if(employeeButton.isSelected()) {
				if(insertionSortButton.isSelected()) {
					ArrayList<Comparable> arr = SortSearch.insertionSort(db.getEmployees());
					if(arr.size() == 0) {
						messageBox("There are no employees entered");
						return;
					}
					new OutputTableDialog(null,arr, 1);
					return;
				}else {
					ArrayList<Comparable> arr = SortSearch.selectionSort(db.getEmployees());
					if(arr.size() == 0) {
						messageBox("There are no employees entered");
						return;
					}
					new OutputTableDialog(null,arr, 1);
					return;
				}
			}else if(widgetButton.isSelected()) {
				if(insertionSortButton.isSelected()) {
					ArrayList<Comparable> arr = SortSearch.insertionSort(db.getWidgets());
					if(arr.size() == 0) {
						messageBox("There are no widgets entered");
						return;
					}
					new OutputTableDialog(null,arr, 2);
					return;
				}else {
					ArrayList<Comparable> arr = SortSearch.selectionSort(db.getWidgets());
					if(arr.size() == 0) {
						messageBox("There are no widgets entered");
						return;
					}
					new OutputTableDialog(null,arr, 2);
					return;
				}
			}
		}
	}
	
	public SortDialog(JFrame parent, Database d) {
		super(parent);
		db = d;
		
		ButtonGroup typeBG = new ButtonGroup();
		typeBG.add(studentButton);
		typeBG.add(employeeButton);
		typeBG.add(widgetButton);
		
		ButtonGroup sortBG = new ButtonGroup();
		sortBG.add(selectionSortButton);
		sortBG.add(insertionSortButton);
		
		studentButton.setSelected(true);
		insertionSortButton.setSelected(true);
		
		setSize(400,400);
		setTitle("Sort");
		setVisible(true);
	}

}
