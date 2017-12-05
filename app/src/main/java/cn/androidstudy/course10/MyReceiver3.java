package cn.androidstudy.course10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver3 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast toast = Toast.makeText(context, "动态定义广播", Toast.LENGTH_SHORT);
        //指定Toast显示的位置，两个参数为百分比，第一个为水平，第二个为垂直
        toast.setMargin(0.0f, 0.5f);
        toast.show();
    }
}
