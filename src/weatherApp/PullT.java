package weatherApp;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author zekart
 */
public class PullT {
    
private String temperature ;
private String wind ;
private String preassure ;
private String dampness ;
private String cloudness ;
private String city ;

public PullT(){
    try {
        Document doc = Jsoup.connect("https://www.gismeteo.ua/weather-mykolaiv-4983/").get();   //Парсинг страницы

        Elements ddElements = doc.getElementsByAttributeValue("class", "section higher"); 
        
        city = ddElements.select("span.crumb").select("a").first().text();
        temperature = ddElements.select(".temp dd.value.m_temp.c").text();                      //Елементы с тегов
        cloudness = ddElements.select("dt.png").attr("title");
        wind = ddElements.select("dd.value.m_wind.ms").text();
        preassure = ddElements.select("dd.value.m_press.torr").text();
        dampness = ddElements.select("div.wicon.hum").text().substring(0, 3);      
        
    } catch (IOException ex) {
        
    }
}

    public String getCity() {
        return city;
    }


    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getPreassure() {
        return preassure;
    }

    public void setPreassure(String preassure) {
        this.preassure = preassure;
    }

    public String getDampness() {
        return dampness;
    }

    public void setDampness(String dampness) {
        this.dampness = dampness;
    }

    public String getCloudness() {
        return cloudness;
    }

    public void setCloudness(String cloudness) {
        this.cloudness = cloudness;
    }


}
