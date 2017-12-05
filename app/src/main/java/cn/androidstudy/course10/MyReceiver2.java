package cn.androidstudy.course10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // 自定义广播，触发时使用Toast提示
        Toast.makeText(context, "我的自定义广播", Toast.LENGTH_SHORT).show();
    }
}
