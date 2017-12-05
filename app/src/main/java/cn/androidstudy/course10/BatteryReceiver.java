package cn.androidstudy.course10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BatteryReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();
        int current=bundle.getInt("level");//key=level是当前电量
        int total=bundle.getInt("scale");//key=scale是总电量
        //当前电量小于总电量的15%
        if(current*1.0/total<0.15){
            Toast.makeText(context, "电池电量过低，请尽快充电！", Toast.LENGTH_LONG).show();
        }
    }
}
