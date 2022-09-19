package cs1331;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{
	
	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, Color.BLACK);
		
		Button button1 = new Button("Test Button");
		button1.setOnAction(
				(ActionEvent event) -> button1.setText("Test Button Pressed")
				);
		
		button1.setOnMouseEntered(
				(MouseEvent event) -> {
					button1.setScaleX(1.5);
					button1.setScaleY(1.5);
				});
		
		button1.setOnMouseExited(
				(MouseEvent event) -> {
					button1.setScaleX(.75);
					button1.setScaleY(.75);
				});
		
		
		
		root.getChildren().add(button1);
		
		stage.setHeight(500);
		stage.setWidth(500);
		
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
