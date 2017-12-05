package cn.androidstudy.course10;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void save(View view){
        SharedPreferences sp = getSharedPreferences(
                "config",
                MODE_PRIVATE);
        EditText editText = (EditText) findViewById(R.id.editText);
        String number = editText.getText().toString().trim();
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("number",number);
        editor.commit();
        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
    }
    public void send(View view){
        Intent intent = new Intent("wodeguangbo");
        sendBroadcast(intent);
    }
    public void openActivity(View view){
        Intent intent = new Intent(this,ReceiverActivity.class);
        startActivity(intent);
    }
    public void sendOrder(View view){
        Intent intent = new Intent("zzuli.order");
        intent.putExtra("name","hello receiver!");
        sendOrderedBroadcast(intent,//意图动作,指定action动作
                null,//receiverPermission,接收这条广播具备什么权限
                null,//resultReceiver,最终的广播接受者,广播一定会传给他
                null,//scheduler,handler对象处理广播的分发
                1,//initialCode,初始代码
                "每人发1000元过节费！",//initialData,初始数据
                null);//initialExtras,额外的数据,如果觉得初始数据不够,可以通过bundle来指定其他数据
    }
}
