/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherApp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author zekart
 */
public class MainClass extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        ShowError error = new ShowError();
        
        if (error.b == true) {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);            

            stage.show();
            
        }else{
                    
            stage.setOnCloseRequest((WindowEvent t) -> {
                Platform.exit();
                System.exit(0);
            });
        }

        


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);

    }
    
}
