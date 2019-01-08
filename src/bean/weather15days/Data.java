/**
  * Copyright 2018 bejson.com 
  */
package bean.weather15days;
import java.util.List;

/**
 * Auto-generated: 2018-12-25 14:33:41
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Data {

    private City city;
    private List<Forecast> forecast;
    public void setCity(City city) {
         this.city = city;
     }
     public City getCity() {
         return city;
     }

    public void setForecast(List<Forecast> forecast) {
         this.forecast = forecast;
     }
     public List<Forecast> getForecast() {
         return forecast;
     }

}