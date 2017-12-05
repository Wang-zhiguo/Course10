package cn.androidstudy.course10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver5 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        String data = getResultData();
        System.out.println("-------"+data);
        setResultData("每人发1500元过节费！");
        abortBroadcast();
    }
}
