package com.example.graph;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2500);
                    startActivity(new Intent(MainActivity.this,grapg_drawable.class));
                    finish();
                    super.run();
                }catch (InterruptedException r){
                    r.printStackTrace();
                }
            }


        };
        thread.start();

    }
}
