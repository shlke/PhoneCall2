package com.tjgx.phonecall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_num;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_num = findViewById(R.id.ed_num);
        button = findViewById(R.id.button1);
        button.setOnClickListener(new MyOnClickListener());
    }
    class MyOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            System.out.println("按钮被点击");
            String str = et_num.getText().toString().trim();
            if("".equals(str)){
                Toast.makeText(MainActivity.this, "请输入号码？", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent();
            intent.setAction(intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+str));
            startActivity(intent);

        }
    }
}
