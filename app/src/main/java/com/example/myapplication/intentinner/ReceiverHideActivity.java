package com.example.myapplication.intentinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

/**
 * 隐示意图接收
 */
public class ReceiverHideActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_hide);
        Intent intent = getIntent();
        String account = intent.getStringExtra("account");
        String password = intent.getStringExtra("password");
        textView = findViewById(R.id.text_view_hide_result);
        textView.setText("账号为："+account+"，密码为："+password);
    }
}
