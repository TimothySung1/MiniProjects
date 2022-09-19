import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
//import javafx.application.Application;
import javafx.stage.*;

public class Main extends Application{
	
	
	@Override
	public void start(Stage stage) {
		//Stage stage = new Stage();
		/*
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		
		//---------------------stages stuff vvvvvv
		/*
		Group root = new Group();
		Scene scene = new Scene(root, Color.BLACK);
		
		Image icon = new Image("garf.jpg");
		stage.setTitle("Demo Program");
		stage.getIcons().add(icon);
		stage.setWidth(420);
		stage.setHeight(420);
		stage.setResizable(false);
		//stage.setX(50);
		//stage.setY(50);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("You can't escape unless you press q");
		stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
		
		stage.setScene(scene);
		stage.show();
		*/
		
		//---------------------scene stuff and drawing
		Group root2 = new Group();
		Scene scene2 = new Scene(root2, 600, 600, Color.LIGHTSKYBLUE);
		Stage stage2 = new Stage();
		
		Text text = new Text();
		text.setText("example text");
		text.setX(50);
		text.setY(50);
		text.setFont(Font.font("Verdana", 50));
		text.setFill(Color.GREEN);
		
		Line line = new Line();
		line.setStartX(200);
		line.setStartY(200);
		line.setEndX(500);
		line.setEndY(200);
		line.setStrokeWidth(5);
		line.setStroke(Color.RED);
		line.setOpacity(0.5);
		line.setRotate(45);
		
		Rectangle rectangle = new Rectangle();
		rectangle.setX(100);
		rectangle.setY(100);
		rectangle.setWidth(100);
		rectangle.setHeight(100);
		//can do more
		
		Polygon triangle = new Polygon();
		triangle.getPoints().setAll(
				200.0, 200.0,
				300.0, 300.0,
				200.0, 300.0
				);
		triangle.setFill(Color.YELLOWGREEN);
		
		Circle circle = new Circle();
		circle.setCenterX(350);
		circle.setCenterY(350);
		circle.setRadius(50);
		circle.setFill(Color.BURLYWOOD);
		
		Image image = new Image("abacus.jpg");
		ImageView imageView = new ImageView(image);
		imageView.setX(400);
		imageView.setY(400);
		
		root2.getChildren().add(text);
		root2.getChildren().add(line);
		root2.getChildren().add(rectangle);
		root2.getChildren().add(triangle);
		root2.getChildren().add(circle);
		root2.getChildren().add(imageView);
		
		
		//----------------------------------------event handling
		Button b1 = new Button();
		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Button 1 pressed");
			}
		});
		
		root2.getChildren().add(b1);
		
		stage2.setScene(scene2);
		stage2.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
