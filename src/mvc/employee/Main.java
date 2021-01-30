package mvc.employee;

import java.sql.Connection;
import java.util.Optional;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mvc.employee.model.dal.EmployeesDAO;
import mvc.employee.model.dal.OraConn;
import mvc.employee.view.AlertBox;
import mvc.employee.view.EmployeesController;
import mvc.employee.view.MainController;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	static private OraConn db = new OraConn();

	@Override
	public void init() {
		db.setConnection("jdbc:oracle:thin:@ora4.ii.pw.edu.pl:1521/pdb1.ii.pw.edu.pl", "XGUCIO01", "xgucio01");
	}

	public static Connection getConnection() {
		return db.getConnection();
	}

	void primaryStage_Hiding(WindowEvent e) {
//		OraConn.close();
	}

	void primaryStage_CloseRequest(WindowEvent e) {
		Optional<ButtonType> result = AlertBox.showAndWait(AlertType.CONFIRMATION, "Kończenie pracy",
				"Czy chcesz zamknąć aplikację?");
		if (result.orElse(ButtonType.CANCEL) != ButtonType.OK)
			e.consume();
	}

	@Override
	public void start(Stage primaryStage) {

		try {
			ViewLoader<AnchorPane, EmployeesController> viewLoaderEmp = new ViewLoader<>("view/Employees.fxml");
			AnchorPane anchorPane = viewLoaderEmp.getLayout();

			ViewLoader<BorderPane, MainController> viewLoaderMain = new ViewLoader<>("view/Main.fxml");
			BorderPane borderPane = viewLoaderMain.getLayout();

			borderPane.setCenter(anchorPane);
			MainController mainController = viewLoaderMain.getController();
			mainController.setStage(primaryStage);

			EmployeesController empController = viewLoaderEmp.getController();
			empController.setEmployees(new EmployeesDAO(db.getConnection()).getEmployees());

			Scene scene = new Scene(borderPane);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Pracownicy");
			primaryStage.setOnHiding(e -> primaryStage_Hiding(e));
			primaryStage.setOnCloseRequest(e -> primaryStage_CloseRequest(e));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
