package weatherApp;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;


/**
 *
 * @author zekart
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Label dampLabel;
    @FXML
    private Label windLabel;
    @FXML
    private Label presLabel;
    @FXML
    private ImageView image;
    @FXML
    private Label cloudLabel;    
    @FXML
    private Label timeLabel; 
    @FXML
    private Label periodLabel;
    @FXML
    private GridPane dataTable;
    @FXML
    private Slider sliderTime;
    
    private String time = null;

    private void imagePast(String cl){
            Image img = new Image("images/"+cl+".png"); 
            image.setImage(img);        //Уст. изображение
        }
      
    private void timePast(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM.dd.yyyy HH:mm:ss ");
        LocalDateTime now = LocalDateTime.now();
        time = dtf.format(now);
        timeLabel.setText("Обнов.: "+time); //Показ даты обновления
    }   
    
    public void startApp() {
        PullT pt = new PullT();      
        //Данные с класса PullT, после парсинга
        
        label.setText(pt.getTemperature());
        cloudLabel.setText(pt.getCloudness());
        dampLabel.setText(pt.getDampness());
        windLabel.setText(pt.getWind());
        presLabel.setText(pt.getPreassure());
        timePast();
        imagePast(pt.getCloudness());
        System.out.println(pt.getCity());
        DbConnector db = new DbConnector(pt.getCity(),pt.getTemperature(),time);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        startApp();

        Platform.runLater(new Runnable() {
          @Override public void run() {
                Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.minutes(10), (ActionEvent event) -> {
                    startApp();
                }));
            fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
            fiveSecondsWonder.play();
          }
        });

    }    
    
}
