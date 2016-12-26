package com.example.com.two_dimensioncode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        button.setOnClickListener(this);
    }

    private void init() {
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Intent intent = new Intent(MainActivity.this,ShowImage.class);
                String url = editText.getText().toString().trim();
                if ("".equals(url)){
                    Log.i("MainActivity","二维码信息为空!");
                }else {
                    intent.putExtra("twocode",url);
                    startActivity(intent);
                    Log.i("MainActivity","二维码信息已经传过去!");
                }
                break;
        }
    }
}
