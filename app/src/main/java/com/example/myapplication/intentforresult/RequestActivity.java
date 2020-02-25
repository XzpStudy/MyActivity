package com.example.myapplication.intentforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

/**
 * 请求结果
 */
public class RequestActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        textView = findViewById(R.id.text_view_request);
        button = findViewById(R.id.btn_for_result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RequestActivity.this,ResponseActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    //获取请求结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String msg = data.getStringExtra("result");
        if(1 == requestCode){
            if(2 == resultCode){
                textView.setText(msg);
            }
        }
    }
}
