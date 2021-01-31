package mvc.employee.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class EmployeeEditController {

	@FXML
	private Button save;

	private Stage employeeEditStage;

	@FXML
	void initialize() {

	}

	@FXML
	void onSave(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("SAVE TITLE");
		alert.setContentText(save.getText());
		alert.show();
		employeeEditStage.close();

	}

	@FXML
	void onSomething(ActionEvent event) {

	}

	@FXML
	void onClose(ActionEvent event) {
		employeeEditStage.close();
	}

	public void setEmployeeEditStage(Stage employeeEditStage) {
		this.employeeEditStage = employeeEditStage;
	}
}
