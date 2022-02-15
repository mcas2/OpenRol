package com.mcas2.openrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectCharSystem extends AppCompatActivity {

    private Button selCharDnD;
    private Button selCharAquelarre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_char_system);

        selCharDnD = findViewById(R.id.selCharDnD);
        selCharDnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCharSystem.this, SelectCharDnD.class);
                startActivity(intent);
            }
        });

        selCharAquelarre = findViewById(R.id.selCharAquelarre);
        selCharAquelarre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCharSystem.this, DnDCharacters.class);
                startActivity(intent);
            }
        });
    }
}