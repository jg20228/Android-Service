package org.wc.movieapp0818;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etTitle;
    private Button btnStart, btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initObject();
        initListener();
    }

    private void initObject(){
        etTitle = findViewById(R.id.et_title);
        btnStart=findViewById(R.id.btn_play);
        btnFinish=findViewById(R.id.btn_stop);
    }

    private void initListener(){
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String musicName = etTitle.getText().toString();
                Intent intent = new Intent(MainActivity.this, MyService.class);
                intent.putExtra("musicName",musicName);
                //서비스 실행하는 방법
                startService(intent);
            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Service 실행할땐 항상 intent가 필요함
                Intent intent = new Intent(MainActivity.this, MyService.class);
                stopService(intent);
            }
        });
    }
}