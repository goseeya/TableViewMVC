package mvc.employee.model.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mvc.employee.model.Employee;

public class EmployeesDAO {

	Connection connection;
	SQLException ex;

	public SQLException getSQLException() {
		return ex;
	}

	public EmployeesDAO(Connection connection) {
		this.connection = connection;
	}

	public ObservableList<Employee> getEmployees() {

		ObservableList<Employee> employees = FXCollections.observableArrayList();
		try (Statement statement = connection.createStatement();) {
			String query = "SELECT * FROM EMPLOYEES";
//
//			String query = "SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME, E.EMAIL , E.PHONE_NUMBER, E.HIRE_DATE, E.JOB_ID, E.SALARY, E.COMMISSION_PCT, " 
//					+ "(SELECT E1.FIRST_NAME || ' ' || E1.LAST_NAME FROM EMPLOYEES E1 WHERE E1.EMPLOYEE_ID = E.MANAGER_ID), "
//			        + "(SELECT DEPARTMENT_NAME || ' ' || E FROM DEPARTMENTS D1 WHERE D1.DEPARTMENT_ID = E.EMPLOYEE_ID), "
//					+ "DEPARTMENT_ID FROM EMPLOYEES";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				employees.add(rs2Employee(resultSet));
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return employees;
	}


	private Employee rs2Employee(ResultSet resultSet) {
		Employee emp = new Employee();
		try {
			int col = 1;
			emp.setEmployeeId(resultSet.getInt(col++));
			emp.setFirstName(resultSet.getNString(col++));
			emp.setLastName(resultSet.getNString(col++));
			emp.setEmail(resultSet.getNString(col++));
			emp.setPhone(resultSet.getNString(col++));
			emp.setHireDate(resultSet.getDate(col++).toLocalDate());
			emp.setJobId(resultSet.getInt(col++));
			emp.setSalary(resultSet.getInt(col++));
			col++;
			emp.setManagerId(resultSet.getInt(col++));
			emp.setDepartmentId(resultSet.getInt(col++));
		} catch (SQLException ex) {
			this.ex = ex;
		}
		return emp;
	}
}