package mvc.employee.model;

import java.time.LocalDate;
import javafx.beans.property.*;

public class Employee {

	private IntegerProperty employeeId;
	private StringProperty firstName;
	private StringProperty lastName;
	private StringProperty email;
	private StringProperty phone;
	private ObjectProperty<LocalDate> hireDate;
	private IntegerProperty jobId;
	private IntegerProperty salary;
	private IntegerProperty managerId;
	private IntegerProperty departmentId;

	public Employee() {
		employeeId = new SimpleIntegerProperty(0);
		firstName = new SimpleStringProperty("");
		lastName = new SimpleStringProperty("");
		email = new SimpleStringProperty("");
		phone = new SimpleStringProperty("");
		hireDate = new SimpleObjectProperty<LocalDate>(LocalDate.now());
		jobId = new SimpleIntegerProperty(0);
		managerId = new SimpleIntegerProperty(0);
		departmentId = new SimpleIntegerProperty(0);
	}

	public Employee(int employeeId) {
		this();
		this.employeeId.set(employeeId);
	}

	public int getEmployeeId() {
		return this.employeeId.get();
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId.set(employeeId);
	}

	public IntegerProperty employeeIdProperty() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public StringProperty lastNameProperty() {
		return lastName;
	}

	public String getEmail() {
		return email.get();
	}

	public void setEmail(String email) {
		this.email.set(email);
	}

	public StringProperty emailProperty() {
		return email;
	}

	public String getPhone() {
		return phone.get();
	}

	public void setPhone(String phone) {
		this.phone.set(phone);
	}

	public StringProperty phoneProperty() {
		return phone;
	}

	public LocalDate getHireDate() {
		return hireDate.get();
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate.set(hireDate);
	}

	public ObjectProperty<LocalDate> hireDateProperty() {
		return hireDate;
	}

	public int getJobId() {
		return jobId.get();
	}

	public void setJobId(int jobId) {
		this.jobId.set(jobId);
	}

	public IntegerProperty jobIdProperty() {
		return jobId;
	}

	public int getSalary() {
		return salary.get();
	}

	public void setSalary(int salary) {
		this.salary.set(salary);
	}

	public IntegerProperty salaryProperty() {
		return salary;
	}

	public int getManagerId() {
		return managerId.get();
	}

	public void setManagerId(int managerId) {
		this.managerId.set(managerId);
	}

	public IntegerProperty managerIdProperty() {
		return managerId;
	}

	public int getDepartmentId() {
		return departmentId.get();
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId.set(departmentId);
	}

	public IntegerProperty departmentIdProperty() {
		return departmentId;
	}

}
