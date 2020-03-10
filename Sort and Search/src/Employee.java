
public class Employee implements Comparable<Employee> {

	private String name;
	private double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee o) {
		double difference = getSalary() - o.getSalary();
		if(difference < 0) {
			return -1;
		}else if(difference > 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public String toString() {
		return getName() + " - $" + getSalary();
	}

}
