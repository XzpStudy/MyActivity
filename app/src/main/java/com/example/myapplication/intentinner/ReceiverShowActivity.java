package com.example.myapplication.intentinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

/**
 * 显示意图接收
 */
public class ReceiverShowActivity extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_show);
        Intent intent = getIntent();
        String account = intent.getStringExtra("account");
        String password = intent.getStringExtra("password");
        textView = findViewById(R.id.text_view_show_result);
        textView.setText("账号为："+account+"，密码为："+password);
    }
}
