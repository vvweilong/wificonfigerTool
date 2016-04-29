package locationmanager;

import android.util.Log;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import constancevalue.BaseUrl;

/**
 * Created by zhuxiaolong on 16/3/27.
 */
public class HttpRequestManager {


    private static OkHttpClient mOkHttpClient = new OkHttpClient();
    private static Gson gson = new Gson();

    public static void checkData(String mac, int limit, final HttpResponeCallback<DataCheckResult> httpResponeCallback) {
        final Request request = new Request.Builder().url(BaseUrl.getDetectorDataUrl(mac, limit)).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                if (httpResponeCallback != null) {
                    httpResponeCallback.onRequestFailure();
                }
            }
            @Override
            public void onResponse(Response response) throws IOException {
                String r=response.body().string();
                Log.i("http",r);
                if (gson != null) {
                    gson = new Gson();
                }
                DataCheckResult result = gson.fromJson(r, DataCheckResult.class);
                if (httpResponeCallback != null) {
                    httpResponeCallback.onResponeSuccess(result);
                }
            }
        });
    }


   public static void saveMacToService(String mac,final HttpResponeCallback< DataCheckResult> httpResponeCallback){
       final Request request=new Request.Builder().url("http://api.xiuxiu.release.babadeyan.com/test/xiaolong/csv/?qrcode="+mac).build();
       mOkHttpClient.newCall(request).enqueue(new Callback() {
           @Override
           public void onFailure(Request request, IOException e) {
               if (httpResponeCallback != null) {
                   httpResponeCallback.onRequestFailure();
               }
           }

           @Override
           public void onResponse(Response response) throws IOException {
               String r=response.body().string();
               Log.i("http",r);
               if (gson != null) {
                   gson = new Gson();
               }
               DataCheckResult result = gson.fromJson(r, DataCheckResult.class);
               if (httpResponeCallback != null) {
                   httpResponeCallback.onResponeSuccess(result);
               }
           }
       });

   }


}
