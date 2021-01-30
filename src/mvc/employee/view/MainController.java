package mvc.employee.view;

import javafx.fxml.FXML;
//import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
//import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mvc.employee.ViewLoader;

public class MainController {
	private Stage primaryStage;
	ViewLoader<AnchorPane, EmployeesController> viewLoaderEmp;

	public void setStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void setEmployeeFXML(ViewLoader<AnchorPane, EmployeesController> viewLoaderEmp) {
		this.viewLoaderEmp = viewLoaderEmp;
	}

	@FXML
	private void onAbout() {

		AlertBox.showAndWait(AlertType.INFORMATION, "Default text", "Default text 2");
	}

	@FXML
	private void onExit() {
		primaryStage.fireEvent(new WindowEvent(primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	@FXML
	private void menuItem_Close() {
		primaryStage.fireEvent(new WindowEvent(primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	@FXML
	private void menuItem_About() {
		primaryStage.fireEvent(new WindowEvent(primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

}
