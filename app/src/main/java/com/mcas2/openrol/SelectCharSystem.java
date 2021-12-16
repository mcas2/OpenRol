package com.mcas2.openrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectCharSystem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_char_system);
    }

    public void openChar(View view) {
        Intent intent = new Intent(SelectCharSystem.this, DnDCharacters.class);
        startActivity(intent);
    }
}