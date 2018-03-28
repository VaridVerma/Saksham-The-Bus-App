package com.example.varidverma.saksham;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initAll();
    }

    void initAll(){
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button2:
                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
                break;
            case R.id.button:
                Intent intent2 = new Intent(MainActivity.this, Home.class);
                startActivity(intent2);
        }
    }
}
