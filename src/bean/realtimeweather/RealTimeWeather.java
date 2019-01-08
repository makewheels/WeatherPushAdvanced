/**
  * Copyright 2018 bejson.com 
  */
package bean.realtimeweather;

/**
 * Auto-generated: 2018-12-25 14:44:18
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class RealTimeWeather {

    private int code;
    private Data data;
    private String msg;
    private Rc rc;
    public void setCode(int code) {
         this.code = code;
     }
     public int getCode() {
         return code;
     }

    public void setData(Data data) {
         this.data = data;
     }
     public Data getData() {
         return data;
     }

    public void setMsg(String msg) {
         this.msg = msg;
     }
     public String getMsg() {
         return msg;
     }

    public void setRc(Rc rc) {
         this.rc = rc;
     }
     public Rc getRc() {
         return rc;
     }

}