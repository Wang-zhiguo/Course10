package cn.androidstudy.course10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //如果接收到短信
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            /*在系统短信接收程序之前会被启动，如果取消广播，那么短信广播将
            不会被传播到系统的短信接收程序，也就是系统本身将不会收到短信*/
            //abortBroadcast();//取消广播，这行代码会让系统收不到短信
            StringBuilder sb=new StringBuilder();
            //短信数据捆绑在intent的Bundle中
            Bundle bundle=intent.getExtras();
            if(bundle!=null){
                //通过pdus可以获得接收到的所有短信消息
                Object[]  pdus=(Object[]) bundle.get("pdus");
                //构建短信对象数组
                SmsMessage[] messages=new SmsMessage[pdus.length];
                for(int i=0;i<=pdus.length;i++){
                    //根据pdus，把每个pdus转换成短信对象SmsMessage
                    messages[i]=SmsMessage.createFromPdu((byte[])pdus[i]);
                }
                for(SmsMessage message:messages){
                    sb.append("短信来源：");
                    sb.append(message.getDisplayOriginatingAddress());//获取短信的源地址
                    sb.append("\n----短信内容-----\n");
                    sb.append(message.getDisplayMessageBody());//获取短信的内容
                }
            }
            Toast.makeText(context, sb.toString(), Toast.LENGTH_LONG).show();//toast消息提示
        }
    }
}
