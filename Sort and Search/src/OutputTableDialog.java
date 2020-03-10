import BreezySwing.*;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class OutputTableDialog extends GBDialog {

	private JPanel dataLayout = addPanel(1,1,2,1);
	private JTable dataTable = null;
	private DefaultTableModel dataModel = null;
	
	private ArrayList<Comparable> list;
	
	int type = 0;
	
	public OutputTableDialog(JFrame parent, ArrayList<Comparable> arr, int type) {
		super(parent);
		list = new ArrayList<Comparable>(arr);
		
		this.type = type;
		
		display();
		
		
		switch(type) {
		case 0:
			//student
			updateColumns("Name","GPA");
			break;
		case 1:
			//employee
			updateColumns("Name","Salary");
			break;
		case 2:
			//widget
			updateColumns("ID","Units Sold");
			break;
		}
		
		displayComparables(list);
		
		setSize(400,400);
		setTitle("Output");
		setVisible(true);
	}

	private void updateColumns(String one, String two) {
		String[] columnNames = {one,two};
		dataModel.setColumnCount(0);
		dataModel.setColumnIdentifiers(columnNames);
	}
	
	private void display() {
		String[] columnNames = { "", "" };
		String[][] StudentData = { { "", "" } };

		// Set the layout mode of the data panel
		dataLayout.setLayout(new BorderLayout());

		// Create the placeholder table and put it in a scroll pane
		dataTable = new JTable(StudentData, columnNames);
		dataModel = new DefaultTableModel();
		dataModel.setColumnIdentifiers(columnNames);
		dataTable.setModel(dataModel);

		// sets the alignment
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		dataTable.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
		dataTable.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);

		// Add the scrollPane to the panel and put it in the center so it uses the full
		// panel
		JScrollPane scrollPane = new JScrollPane(dataTable);
		dataLayout.add(scrollPane, BorderLayout.CENTER);
		dataTable.disable();
	}

	private void displayComparables(ArrayList<Comparable> list) {
		dataModel.setRowCount(0);
		for (Comparable obj : list) {
			displayComparable(obj);
		}
	}

	private void displayComparable(Comparable obj) {
		String[] dataRow = new String[2];
		if (obj.getClass().equals(Student.class)) {
			dataRow[0] = ((Student) (obj)).getName();
			dataRow[1] = String.format("%.2f", ((Student) (obj)).getGpa());
		}
		if (obj.getClass().equals(Employee.class)) {
			dataRow[0] = ((Employee) (obj)).getName();
			dataRow[1] = String.format("%.2f", ((Employee) (obj)).getSalary());
		}
		if (obj.getClass().equals(Widget.class)) {
			dataRow[0] = String.format("%d", ((Widget) (obj)).getProductNumber());
			dataRow[1] = String.format("%d", ((Widget) (obj)).getNumberSold());
		}

		dataModel.addRow(dataRow);
	}

}
