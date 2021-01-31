package mvc.employee.view;

import java.time.LocalDate;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import mvc.employee.model.Employee;

public class EmployeesController {

	// TableView, TableColumn
	@FXML
	private TableView<Employee> employeeTable;

	@FXML
	private TableColumn<Employee, Integer> employeeIdColumn;

	@FXML
	private TableColumn<Employee, String> firstNameColumn;

	@FXML
	private TableColumn<Employee, String> lastNameColumn;

	@FXML
	private TableColumn<Employee, String> emailColumn;

	@FXML
	private TableColumn<Employee, String> phoneNameColumn;
//
//	@FXML
//	private TableColumn<Employee, LocalDate> hireDateColumn;

	@FXML
	private TableColumn<Employee, String> hireDateAsStrColumn;

	@FXML
	private TableColumn<Employee, Integer> jobIdColumn;

	@FXML
	private TableColumn<Employee, Integer> salaryColumn;

	@FXML
	private TableColumn<Employee, Integer> managerIdColumn;

	@FXML
	private TableColumn<Employee, Integer> departmentIdColumn;

	// Label
	@FXML
	private Label employeeIdLabel;

	@FXML
	private Label firstNameLabel;

	@FXML
	private Label lastNameLabel;

	@FXML
	private Label emailLabel;

	@FXML
	private Label phoneNameLabel;

	@FXML
	private Label hireDateLabel;

	@FXML
	private Label jobIdLabel;

	@FXML
	private Label salaryLabel;

	@FXML
	private Label managerIdLabel;

	@FXML
	private Label departmentIdLabel;

	@FXML
	private void initialize() {
		employeeTable.setTableMenuButtonVisible(true);

		employeeIdColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty().asObject());

		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());

		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

		emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

		phoneNameColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());

		hireDateAsStrColumn.setCellValueFactory(cellData -> cellData.getValue().hireDateProperty().asString());

		jobIdColumn.setCellValueFactory(cellData -> cellData.getValue().jobIdProperty().asObject());

		salaryColumn.setCellValueFactory(cellData -> cellData.getValue().salaryProperty().asObject());

		managerIdColumn.setCellValueFactory(cellData -> cellData.getValue().managerIdProperty().asObject());

		departmentIdColumn.setCellValueFactory(cellData -> cellData.getValue().departmentIdProperty().asObject());

		// set fields value
		updateEmployee(null);

		// listen to selected row change
		employeeTable.getSelectionModel().selectedItemProperty()
				.addListener((observble, oldValue, newValue) -> updateEmployee(newValue));
	}

	public void setEmployees(ObservableList<Employee> olEmployees) {

		employeeTable.getItems().clear();
		employeeTable.setItems(olEmployees);

		// select the first row in table if not empty
		if (!employeeTable.getItems().isEmpty()) {
			employeeTable.getSelectionModel().select(0);
		}

	}

	public void updateEmployee(Employee emp) {
		if (emp != null) {
			employeeIdLabel.setText(Integer.toString(emp.getEmployeeId()));
			firstNameLabel.setText(emp.getFirstName());
			lastNameLabel.setText(emp.getLastName());
			emailLabel.setText(emp.getEmail());
			phoneNameLabel.setText(emp.getPhone());
			hireDateLabel.setText(emp.getHireDate().toString());
			jobIdLabel.setText(Integer.toString(emp.getJobId()));
			salaryLabel.setText(Integer.toString(emp.getSalary()));
			managerIdLabel.setText(Integer.toString(emp.getManagerId()));
			departmentIdLabel.setText(Integer.toString(emp.getDepartmentId()));
		} else {
			employeeIdLabel.setText("");
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			emailLabel.setText("");
			phoneNameLabel.setText("");
			hireDateLabel.setText("");
			jobIdLabel.setText("");
			salaryLabel.setText("");
			managerIdLabel.setText("");
			departmentIdLabel.setText("");
		}
	}

	@FXML
	private void deleteEmployee() {
		int selIdx = employeeTable.getSelectionModel().getSelectedIndex();
		if (selIdx > 0)
			employeeTable.getItems().remove(selIdx);
	}

	private Stage employeesStage;

	@FXML
	public void setEmployeesStage(Stage employeesStage) {
		// TODO Auto-generated method stub
		this.employeesStage = employeesStage;

	}
}
