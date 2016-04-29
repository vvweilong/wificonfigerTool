package constancevalue;

/**
 * Created by zhuxiaolong on 16/3/27.
 */
public class BaseUrl {

    private static final String getDetectorData="http://api.xiuxiub.babadeyan.com/rest/api/detectors/?mac_address=";


    /**
    * @param mac
     * @param limit 数据数量
    * */
    public static String getDetectorDataUrl(String mac,int limit){
        return getDetectorData+mac+"&limit="+limit;
    }


}
