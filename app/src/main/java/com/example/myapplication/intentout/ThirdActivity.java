package com.example.myapplication.intentout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class ThirdActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    /**
     * 显式意图跳转第三方应用
     * @param view
     */
    public void skipShowIntent(View view){
        Intent intent = new Intent();
        //这里举个例子，因为不同机型的浏览器包名可能不同，请根据具体情况而定
        intent.setClassName("com.android.browser","com.android.browser.BrowserActivity");
        startActivity(intent);
    }

    /**
     * 隐式意图跳转第三方应用
     * @param view
     */
    public void skipHideIntent(View view){
        Intent intent = new Intent();
        //这里举个例子，Action、Category和Package视情况而定
        intent.setAction("com.android.action.SEARCH");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setPackage("com.android.browser");
        startActivity(intent);
    }
}
