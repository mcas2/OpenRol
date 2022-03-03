package com.mcas2.openrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDices (View view) {
        Intent intent = new Intent(MainActivity.this, Dices.class);
        startActivity(intent);
    }

    public void openSelectChar(View view) {
        Intent intent = new Intent(MainActivity.this, SelectCharSystem.class);
        startActivity(intent);
    }

    public void openResources(View view) {
       Intent intent = new Intent(MainActivity.this, Resources.class);
       startActivity(intent);
    }
}