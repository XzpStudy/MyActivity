package com.example.myapplication.intentwithoperate;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;

/**
 * 调用相机拍照并返回结果
 */
public class CameraRequestActivity extends AppCompatActivity {

    Button button;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_request);
        button = findViewById(R.id.btn_camera);
        imageView = findViewById(R.id.image_camera);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.media.action.IMAGE_CAPTURE");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(1 == requestCode){
            if(Activity.RESULT_OK == resultCode && data != null){
                //用Bitmap来接收照片
                Bitmap bitmap = data.getParcelableExtra("data");
                imageView.setImageBitmap(bitmap);
            }else if(Activity.RESULT_CANCELED == resultCode){
                Toast.makeText(this,"失败",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
