package aprivate.oo.wificonfigertool;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import locationmanager.AmapManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView) findViewById(R.id.textView_version)).setText("Version: " + getVersionName());
//        AmapManager.getInstance(this);
    }



    public void toActivityData(View view){
        Log.i("MainActivity","to Activity data");
        Intent intent=new Intent();
        intent.setClass(this,DataCheckActivity.class);
        startActivity(intent);
    }
    public void toActivityConfig(View view){
        Log.i("MainActivity","to Activity data");
        Intent intent=new Intent();
        intent.setClass(this,CustomizedActivity.class);
        startActivity(intent);
    }



    private String getVersionName() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES).versionName;
        } catch (NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "unknown";
    }
}
