package com.example.onlinelibraryproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NotificationActivity extends AppCompatActivity {

    private EditText editText;
    private Button startBtn, stopBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);

        editText = findViewById(R.id.edit_text_input);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();
                Intent serviceIntent = new Intent(NotificationActivity.this, NotificationService.class);
                serviceIntent.putExtra("inputExtra", input);

                startService(serviceIntent);
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(NotificationActivity.this, NotificationService.class);


                stopService(serviceIntent);
            }
        });
    }


//    public void startService() {
//        String input = editText.getText().toString();
//        Intent serviceIntent = new Intent(this, NotificationService.class);
//        serviceIntent.putExtra("inputExtra", input);
//
//        startService(serviceIntent);
//    }

//    public void stopService() {
//
//        Intent serviceIntent = new Intent(this, NotificationService.class);
//
//
//        stopService(serviceIntent);
//    }
}
