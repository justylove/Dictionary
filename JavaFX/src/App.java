import java.util.Stack;
import javafx.event.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class App extends Application  { 
    Scene scene, scene2;
    @Override
    public void start(Stage stage) throws Exception
    {
        Button button = new Button("Hello world");
        Button button2 = new Button("Hello world2");
        VBox vBox = new VBox(20);
        scene = new Scene(vBox, 200, 200);
        button.setOnAction(e->stage.setScene(scene2));
        vBox.getChildren().add(button);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button2);
        button2.setOnAction(e -> stage.setScene(scene));
        scene2 = new Scene(stackPane, 200, 200);
        stage.setScene(scene);
        stage.show();
        
        

        
    } 
  
    public static void main(String args[]) 
    {
        launch(args); 
    } 
} 