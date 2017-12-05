package cn.androidstudy.course10;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ReceiverActivity extends AppCompatActivity {
    IntentFilter filter;
    MyReceiver3 receiver3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        filter = new IntentFilter("wodeguangbo");
        receiver3 = new MyReceiver3();

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver3,filter);//注册广播
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver3);//解除注册，必须的（否则，报错）
    }
    //发送按钮的事件处理
    public void send(View view){
        Intent intent = new Intent("wodeguangbo");
        sendBroadcast(intent);
    }
}
