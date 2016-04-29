package locationmanager;

import android.content.Context;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

/**
 * Created by zhuxiaolong on 16/3/24.
 */
public class AmapManager {


    private static final String TAG ="AmapManager" ;

    public static AmapManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new AmapManager(context);
        }

        return INSTANCE;
    }

    private static AmapManager INSTANCE;

    private AmapManager(Context context) {
        init(context);
    }

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener;
    //声明mLocationOption对象
    public AMapLocationClientOption mLocationOption = null;
    //初始化定位
    private void init(Context context) {
        mLocationClient = new AMapLocationClient(context);
    //设置定位回调监听
        mLocationListener=new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                mAMapLocation = aMapLocation;
                Log.i(TAG,  "country:  :  "+mAMapLocation.getCountry());
                Log.i(TAG,  "Province:  "+mAMapLocation.getProvince());
                Log.i(TAG,  "City:  "+mAMapLocation.getCity());
                Log.i(TAG,  "District:  "+mAMapLocation.getDistrict());
                Log.i(TAG,  "Street:  "+mAMapLocation.getStreet());
                Log.i(TAG,  "Longitude:  "+mAMapLocation.getLongitude()+ ":  ");
                Log.i(TAG,  "latitude:  "+mAMapLocation.getLatitude()+ ":  ");
                Log.i(TAG,  "address:  "+mAMapLocation.getAddress());
                Log.i(TAG,  "aoiName:  "+mAMapLocation.getAoiName());
                Log.i(TAG,  "LocationDetail:  "+mAMapLocation.getLocationDetail());
                Log.i(TAG,  "poiName:  "+mAMapLocation.getPoiName());
            }
        };
        mLocationClient.setLocationListener(mLocationListener);
    //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
    //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
    //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
    //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(false);
    //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
    //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
    //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
    //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
    //启动定位
        mLocationClient.startLocation();
    }
   private AMapLocation mAMapLocation;



//    public  String getCity(){
//        if(mAMapLocation!=null){
//            return mAMapLocation.getCity();
//        }
//        return "";
//    }
//    public  String getStreet(){
//        if(mAMapLocation!=null){
//            return mAMapLocation.getStreet();
//        }
//        return "";
//    }
//    public  String getCity(){
//        if(mAMapLocation!=null){
//            return mAMapLocation.getAddress();
//        }
//        return "";
//    }
//

}
