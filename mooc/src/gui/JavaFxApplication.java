package gui;

public class JavaFxApplication extends Application{
	@Override
    public void start(Stage window) {
        window.setTitle("Hello World!");
        window.show();
    }

    public static void main(String[] args) {
        launch(JavaFxApplication.class);
    }
	

}
