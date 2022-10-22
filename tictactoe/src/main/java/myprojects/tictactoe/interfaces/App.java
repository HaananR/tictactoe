package myprojects.tictactoe.interfaces;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    private static final String RELATIVE_LOCAL = "/myprojects/tictactoe/";

    @Override
    public void start(Stage stage) throws IOException {
    	
        scene = new Scene(loadFXML("GUI.fxml"));
        setStyleSheet("GUIStyleSheet.css");
        
        stage.setScene(scene);
        stage.show();
        
    }

  /*********************************************************************************************************
   * This method allows you to switch between scenes. Simply use the following code in the controller class:  
   		* App.setRoot("NameOfFXML.fxml");
   ********************************************************************************************************/
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    static void setStyleSheet(String styleSheet) {
    	
    	String folder = "css/";
    	String cssFile = RELATIVE_LOCAL+folder+styleSheet;
    	
    	scene.getStylesheets().add(App.class.getResource(cssFile).toExternalForm());
    	
    }

    private static Parent loadFXML(String fxml) throws IOException {
    	
    	String folder = "fxml/";
    	String fxmlFile = RELATIVE_LOCAL+folder+fxml;
    	
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxmlFile));
        
        return fxmlLoader.load();
        
    }

    public static void main(String[] args) {
        launch();
    }

}