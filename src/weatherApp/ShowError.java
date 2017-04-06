/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherApp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javafx.scene.control.Alert;

/**
 *
 * @author zekart
 */
public class ShowError {
    public boolean b = true;
            
            
    public ShowError() {
                try {
                InetAddress address = InetAddress.getByName("www.gismeteo.ua");
                System.out.println("Name: " + address.getHostName());
                System.out.println("Addr: " + address.getHostAddress());
                System.out.println("Reach: " + address.isReachable(3000));
            }
        catch (UnknownHostException e) {
                System.err.println("Unable to www.gismeteo.ua");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Ошибка соединения");
                alert.setHeaderText("Нету связи с www.gismeteo.ua. Ошибка в подключении");
                alert.setContentText("Проверьте сетевое подключение и запустите приложение!");

                alert.showAndWait();
                b = false;
        }
        catch (IOException e) {
                System.err.println("Unable to reach www.gismeteo.ua");
        }
    }
                        

}
