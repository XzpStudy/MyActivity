package com.example.myapplication.intentinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

/**
 * 应用内通过显式和隐式跳转
 */
public class SendMessageActivity extends AppCompatActivity {

    private Button buttonShow;
    private Button buttonHide;
    private EditText editTextAccount;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        buttonShow = findViewById(R.id.btn_send_show);
        buttonHide = findViewById(R.id.btn_send_hide);
        editTextAccount = findViewById(R.id.edit_text_account);
        editTextPassword = findViewById(R.id.edit_text_password);
    }

    /**
     * 设置监听事件
     */
    private void initListener() {
         //通过显式意图跳转
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SendMessageActivity.this, ReceiverShowActivity.class);
                String account = editTextAccount.getText().toString().trim();
                if(TextUtils.isEmpty(account)){
                    Toast.makeText(SendMessageActivity.this,"账号不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                String password = editTextPassword.getText().toString().trim();
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(SendMessageActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                intent.putExtra("account",account);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });

        //通过隐式意图跳转，需要添加action和category，在AndroidManifest.xml文件对应的Activity中查看
        buttonHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.myapplication.LOGIN");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                String account = editTextAccount.getText().toString().trim();
                if(TextUtils.isEmpty(account)){
                    Toast.makeText(SendMessageActivity.this,"账号不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                String password = editTextPassword.getText().toString().trim();
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(SendMessageActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                intent.putExtra("account",account);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
    }
}
