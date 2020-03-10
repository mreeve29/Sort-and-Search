import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Database {

	private ArrayList<Comparable> list;

	
	public Database() {
		list = new ArrayList<Comparable>();
	}
	
	public ArrayList<Comparable> getList(){
		return list;
	}
	
	public ArrayList<Comparable> getEmployees(){
		ArrayList<Comparable> emps = new ArrayList<Comparable>();
		for(Comparable c : list) {
			if(c instanceof Employee) {
				emps.add((Employee)c); 
			}
		}
		return emps;
	}
	
	public ArrayList<Comparable> getStudents(){
		ArrayList<Comparable> students = new ArrayList<Comparable>();
		for(Comparable c : list) {
			if(c instanceof Student) {
				students.add((Student)c); 
			}
		}
		return students;
	}
	
	public ArrayList<Comparable> getWidgets(){
		ArrayList<Comparable> widgets = new ArrayList<Comparable>();
		for(Comparable c : list) {
			if(c instanceof Widget) {
				widgets.add((Widget)c); 
			}
		}
		return widgets;
	}
	
	public Comparable get(int index) {
		return list.get(index);
	}
	
	public void addStudent(Student s) {
		list.add(s);
	}
	
	public void addEmployee(Employee e) {
		list.add(e);
	}
	
	public void addWidget(Widget w) {
		list.add(w);
	}
	
}
