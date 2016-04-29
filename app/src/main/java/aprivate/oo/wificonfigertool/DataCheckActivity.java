package aprivate.oo.wificonfigertool;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import locationmanager.DataCheckResult;
import locationmanager.HttpRequestManager;
import locationmanager.HttpResponeCallback;

public class DataCheckActivity extends AppCompatActivity {

    private final int MAC_DATA_LIMIT = 5;//默认获取 5条 上传记录


    private EditText macEditText;
    private ListView mListView;

    private ArrayList<DataCheckResult.ResultsEntity> mEntities;

    private String defaultMac;

    Handler mHandler=new Handler(){};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_check);
        defaultMac=getIntent().getStringExtra("mac");
        viewInit();
    }


    private void viewInit() {
        macEditText = (EditText) findViewById(R.id.et_mac_address);
        mListView=(ListView)findViewById(R.id.listview);
        macEditText.setText(defaultMac);
    }
//    public void uploadToService(View view){
//        HttpRequestManager.saveMacToService(getMac(), new HttpResponeCallback<DataCheckResult>() {
//            @Override
//            public void onResponeSuccess(DataCheckResult dataCheckResult) {
//                Log.i("DataCheckActivity","onResponeSuccess()");
//            }
//
//            @Override
//            public void onRequestFailure() {
//                Log.i("DataCheckActivity","onResponeFailure()");
//            }
//        });
//    }

    public void checkMacData(View view) {
        HttpRequestManager.checkData(getMac(), MAC_DATA_LIMIT, new HttpResponeCallback<DataCheckResult>() {
            @Override
            public void onResponeSuccess(DataCheckResult dataCheckResult) {
                Log.i("DataCheckActivity","onResponeSuccess()");
                mEntities=dataCheckResult.getResults();
                mMyAdapter=new MyAdapter();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mListView.setAdapter(mMyAdapter);
                    }
                });

                
            }

            @Override
            public void onRequestFailure() {

            }
        });
    }

    public String getMac() {
        if (macEditText != null) {
            return macEditText.getText().toString();
        }
        return null;
    }

    private MyAdapter mMyAdapter;
    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mEntities.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                LayoutInflater inflater=LayoutInflater.from(DataCheckActivity.this);
                convertView=(View)inflater.inflate(R.layout.listview_item,null);
            }

            TextView textView=(TextView) convertView.findViewById(R.id.time);
            textView.setText(mEntities.get(position).getCreated_at());
            textView=(TextView)convertView.findViewById(R.id.value);
            textView.setText("pm:"+mEntities.get(position).getPm2_5()+"/hum:"+mEntities.get(position).getHumidity()+"/tem:"+mEntities.get(position).getTemperature());
            return convertView;
        }
    }

}
