package cn.androidstudy.course10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        //获取拨打电话的号码
        String outcallnumber = getResultData();
        System.out.println("outcallnumber:"+outcallnumber);
        SharedPreferences sp = context.getSharedPreferences("config",
                Context.MODE_PRIVATE);
        String number = sp.getString("number","");
        System.out.println("number:"+number);
        System.out.println("---------11111------------");
        if (outcallnumber.equals(number)){
            setResultData(null);//挂机
            System.out.println("---------22222------------");
        }
    }
}
