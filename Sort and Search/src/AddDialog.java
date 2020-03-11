import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import BreezySwing.*;

public class AddDialog extends GBDialog {

	//elements
	private JLabel addLabel = addLabel("Add Student:",1,1,3,1);
	
	private ButtonGroup studentTypeBG = new ButtonGroup();
	private JRadioButton studentButton = addRadioButton("Student",2,1,1,1);
	private JRadioButton employeeButton = addRadioButton("Employee",2,2,1,1);
	private JRadioButton widgetButton = addRadioButton("Widget",2,3,1,1);
	
	private JLabel nameLabel = addLabel("Name:",3,1,2,1);
	private JTextField nameField = addTextField("",3,3,2,1);
	
	private JLabel dataLabel = addLabel("GPA(0-5):",4,1,2,1);
	private JTextField dataField = addTextField("",4,3,2,1);
	
	private JButton addButton = addButton("Add Student",7,3,2,1);
	private JButton cancelButton = addButton("Cancel",7,1,1,1);
	
	//class objects
	private Database db;
	
	public void buttonClicked(JButton button) {
		if(button == addButton) {
			
			//check if name is blank
			String name = nameField.getText();
			if(name.isEmpty() || isBlank(name)) {
				messageBox("Empty name");
				return;
			}
			
			if(studentButton.isSelected()) {
				double gpa = 0;
				try{
					gpa = Double.parseDouble(dataField.getText());
				}catch (Exception e) {
					messageBox("Invalid gpa");
					return;
				}
				
				if(gpa < 0 || gpa > 5) {
					messageBox("Gpa bust be between 0 and 5");
					return;
				}
				
				db.addStudent(new Student(name,gpa));
				
			}else if(employeeButton.isSelected()){
				double salary = 0;
				try{
					salary = Double.parseDouble(dataField.getText());
				}catch (Exception e) {
					messageBox("Invalid salary");
					return;
				}
				
				if (salary < 0) {
					messageBox("Salary cannot be negative");
					return;
				}
				
				db.addEmployee(new Employee(name, salary));
				
			}else if(widgetButton.isSelected()){
				int sold = 0;
				try{
					sold = Integer.parseInt(dataField.getText());
				}catch (Exception e) {
					messageBox("Invalid salary");
					return;
				}
				
				if (sold < 0) {
					messageBox("Amount sold cannot be negative");
					return;
				}
				
				if(name.length() != 3) {
					messageBox("Invalid code, must be 3 digits");
					return;
				}
				
				int code = 0;
				
				try {
					code = Integer.parseInt(name);
				}catch(Exception e) {
					messageBox("Invalid code, must be 3 digits");
					return;
				}
				
				if(code < 0 ) {
					messageBox("Cannot be negative");
					return;
				}
				
				db.addWidget(new Widget(name,sold));
			}
			
			setDlgCloseIndicator("ADDED");
			dispose();
		}else if(button == cancelButton) {
			dispose();
		}
	}
	
	//error checking helper method
	private boolean isBlank(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(!Character.isWhitespace(s.charAt(i))) return false;
		}
		return true;
	}
	
	//event listener that changes what fields are visible depending on the type of person selected
	private ChangeListener cl = new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			JRadioButton source = (JRadioButton) e.getSource();
			
			if(source == studentButton && studentButton.isSelected()) {
				nameLabel.setText("Name:");
				dataLabel.setText("GPA(0-5):");
				addButton.setText("Add Student");
				addLabel.setText("Add Student:");
			}else if(source == employeeButton && employeeButton.isSelected()){
				nameLabel.setText("Name:");
				dataLabel.setText("Salary:");
				addButton.setText("Add Employee");
				addLabel.setText("Add Employee:");
			}else if(source == widgetButton && widgetButton.isSelected()) {
				nameLabel.setText("ID:");
				dataLabel.setText("Amount Sold:");
				addButton.setText("Add Widget");
				addLabel.setText("Add Widget:");
				
			}
			
		}
	};
	
	//constructor
	public AddDialog(JFrame parent, Database d) {
		super(parent);
		studentTypeBG.add(studentButton);
		studentTypeBG.add(employeeButton);
		studentTypeBG.add(widgetButton);
		
		employeeButton.addChangeListener(cl);
		widgetButton.addChangeListener(cl);
		studentButton.addChangeListener(cl);
		
		studentButton.setSelected(true);
		
		db = d;
		
		this.setSize(550,400);
		this.setTitle("Add Person");
		this.setVisible(true);
		
	}

}
