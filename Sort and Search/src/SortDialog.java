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
					messageBox(SortSearch.insertionSort(db.getStudents()).toString());
					return;
				}else {
					messageBox(SortSearch.selectionSort(db.getStudents()).toString());
					return;
				}
			}else if(employeeButton.isSelected()) {
				if(insertionSortButton.isSelected()) {
					messageBox(SortSearch.insertionSort(db.getEmployees()).toString());
					return;
				}else {
					messageBox(SortSearch.selectionSort(db.getEmployees()).toString());
					return;
				}
			}else if(widgetButton.isSelected()) {
				if(insertionSortButton.isSelected()) {
					messageBox(SortSearch.insertionSort(db.getWidgets()).toString());
					return;
				}else {
					messageBox(SortSearch.selectionSort(db.getWidgets()).toString());
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
