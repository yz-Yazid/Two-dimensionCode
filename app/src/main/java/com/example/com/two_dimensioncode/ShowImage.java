package com.example.com.two_dimensioncode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ShowImage extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        init();
        button.setOnClickListener(this);
    }

    private void init() {
        button = (Button) findViewById(R.id.button1);
        imageView = (ImageView) findViewById(R.id.image);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                Intent intent = getIntent();
                String url = intent.getStringExtra("twocode");
                if ("".equals(url)) {
                    Log.i("ShowActivity","没有相对应的二维码信息!");
                }else {
                    Bitmap bitmap = ZXingUtils.createQRImage(url, imageView.getWidth(), imageView.getHeight());
                    imageView.setImageBitmap(bitmap);
                    Log.i("ShowActivity","生成二维码成功!");
                }
                break;
        }
    }
}
