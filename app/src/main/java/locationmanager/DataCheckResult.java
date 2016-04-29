package locationmanager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuxiaolong on 16/3/28.
 */
public class DataCheckResult {


    /**
     * count : 164446
     * next : http://api.xiuxiub.babadeyan.com/rest/api/detectors/?limit=3&mac_address=ACCF233C8B22&offset=3
     * previous : null
     * results : [{"url":"http://api.xiuxiub.babadeyan.com/rest/api/detectors/426870/","created_at":"2016-03-26T10:22:21Z","version":"1.0.1","mac_address":"ACCF233C8B22","pm2_5":13,"carbon_dioxide":0,"temperature":22.54,"humidity":24.85},{"url":"http://api.xiuxiub.babadeyan.com/rest/api/detectors/426869/","created_at":"2016-03-26T10:22:19Z","version":"1.0.1","mac_address":"ACCF233C8B22","pm2_5":13,"carbon_dioxide":0,"temperature":22.54,"humidity":24.89},{"url":"http://api.xiuxiub.babadeyan.com/rest/api/detectors/426868/","created_at":"2016-03-26T10:22:17Z","version":"1.0.1","mac_address":"ACCF233C8B22","pm2_5":14,"carbon_dioxide":0,"temperature":22.57,"humidity":24.82}]
     */

    private int count;
    private String next;
    private String previous;
    /**
     * url : http://api.xiuxiub.babadeyan.com/rest/api/detectors/426870/
     * created_at : 2016-03-26T10:22:21Z
     * version : 1.0.1
     * mac_address : ACCF233C8B22
     * pm2_5 : 13
     * carbon_dioxide : 0
     * temperature : 22.54
     * humidity : 24.85
     */

    private ArrayList<ResultsEntity> results;

    public void setCount(int count) {
        this.count = count;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }


    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public Object getPrevious() {
        return previous;
    }

    public ArrayList<ResultsEntity> getResults() {
        return results;
    }

    public static class ResultsEntity {
        private String url;
        private String created_at;
        private String version;
        private String mac_address;
        private int pm2_5;
        private int carbon_dioxide;
        private double temperature;
        private double humidity;

        public void setUrl(String url) {
            this.url = url;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public void setMac_address(String mac_address) {
            this.mac_address = mac_address;
        }

        public void setPm2_5(int pm2_5) {
            this.pm2_5 = pm2_5;
        }

        public void setCarbon_dioxide(int carbon_dioxide) {
            this.carbon_dioxide = carbon_dioxide;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public String getUrl() {
            return url;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getVersion() {
            return version;
        }

        public String getMac_address() {
            return mac_address;
        }

        public int getPm2_5() {
            return pm2_5;
        }

        public int getCarbon_dioxide() {
            return carbon_dioxide;
        }

        public double getTemperature() {
            return temperature;
        }

        public double getHumidity() {
            return humidity;
        }
    }
}
