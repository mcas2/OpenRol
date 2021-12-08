package com.mcas2.openrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Dices extends AppCompatActivity {
    public EditText numDados;
    public EditText numCaras;
    public TextView result;
    public TextView resultHistory;
    public Button roll;
    public Button erase;
    String history = "Dados: ";
    Random r = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dices);

        numDados = (EditText) findViewById(R.id.numDados);
        numCaras = (EditText) findViewById(R.id.numCaras);
        result = (TextView) findViewById(R.id.result);
        resultHistory = (TextView) findViewById(R.id.resultHistory);
        roll = (Button) findViewById(R.id.rollDicesButton);
        erase = (Button) findViewById(R.id.eraseHistory);


        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = 0, diceRes;
                int limit = Integer.parseInt(numCaras.getText().toString())+1;

                for (int i = 0; i < Integer.parseInt(numDados.getText().toString()); i++) {
                    diceRes = r.nextInt(limit-1)+1;
                    res += diceRes;
                    history = history.concat(diceRes+",");
                }
                result.setText(res+"");
                resultHistory.setText(history);
            }
        });

        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = "Dados: ";
                resultHistory.setText(history);
            }
        });
    }
}