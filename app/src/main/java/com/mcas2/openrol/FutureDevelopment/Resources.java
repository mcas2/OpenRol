package com.mcas2.openrol.FutureDevelopment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mcas2.openrol.R;

public class Resources extends AppCompatActivity {
    private CardView cvResources1;
    private CardView cvResources2;
    private CardView cvResources3;
    private CardView cvResources4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        cvResources1 = findViewById(R.id.cvResources1);
        cvResources2 = findViewById(R.id.cvResources2);
        cvResources3 = findViewById(R.id.cvResources3);
        cvResources4 = findViewById(R.id.cvResources4);

        cvResources1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}