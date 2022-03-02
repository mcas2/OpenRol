package com.mcas2.openrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SelectCharSystem extends AppCompatActivity {

    private Button selCharDnD;
    private Button selCharAquelarre;
    private Button selCharASOIAF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_char_system);

        selCharDnD = findViewById(R.id.selCharDnD);
        selCharAquelarre = findViewById(R.id.selCharAquelarre);
        selCharASOIAF = findViewById(R.id.selCharASOIAF);

        selCharDnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCharSystem.this, SelectCharDnD.class);
                startActivity(intent);
            }
        });

        selCharAquelarre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastDevelopment();
            }
        });

        selCharASOIAF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastDevelopment();
            }
        });
    }

    private void toastDevelopment() {
        Toast toast = Toast.makeText(getApplicationContext(), "Sistema en desarrollo. Esperen actualizaciones.", Toast.LENGTH_SHORT);
    }
}