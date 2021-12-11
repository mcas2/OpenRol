package com.mcas2.openrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Dices extends AppCompatActivity {
    public EditText numDados;
    public EditText mod;
    public TextView result;
    public TextView resultHistory;
    public Button roll;
    public Button erase;
    public Button changeOp;
    public boolean isNegative;
    public String history = "Dados: ";
    public Integer [] diceFaces =  {4,6,8,10,12,20,100};
    public Integer numCaras;
    private ArrayAdapter adapter;
    Random r = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dices);

        numDados = (EditText) findViewById(R.id.numDados);

        mod = (EditText) findViewById(R.id.mod);
        result = (TextView) findViewById(R.id.result);
        resultHistory = (TextView) findViewById(R.id.resultHistory);

        roll = (Button) findViewById(R.id.rollDicesButton);
        erase = (Button) findViewById(R.id.eraseHistory);
        changeOp = (Button) findViewById(R.id.changeOperator);
        isNegative = false;

        Spinner sp = (Spinner) findViewById(R.id.sp);
        adapter = new ArrayAdapter<Integer>(this, R.layout.support_simple_spinner_dropdown_item, diceFaces);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                numCaras = (Integer) sp.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Tirada
        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = 0, diceRes, modifier;
                int limit = numCaras+1;
                modifier = Integer.parseInt(mod.getText().toString());

                if (isNegative){
                    modifier = modifier*-1;
                }

                for (int i = 0; i < Integer.parseInt(numDados.getText().toString()); i++) {
                    diceRes = r.nextInt(limit-1)+1;
                    res += (diceRes + modifier);
                    if (modifier!=0){
                        history = history.concat((diceRes+modifier)+"("+diceRes+"+"+modifier+")"+", ");
                    } else {
                        history = history.concat((diceRes+modifier)+", ");
                    }
                }
                result.setText(res+"");
                resultHistory.setText(history);

                //Toast para críticos y pifias en Aquelarre
                //if (res<(0.1*(Integer.parseInt(numDados.getText().toString())*numCaras))){
                //    Toast.makeText(Dices.this, "Crítico", Toast.LENGTH_LONG).show();
                //} else if (res>((0.9*(Integer.parseInt(numDados.getText().toString())*numCaras)))){
                //    Toast.makeText(Dices.this, "Pifia", Toast.LENGTH_LONG).show();
                //}
            }
        });

        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = "Dados: ";
                resultHistory.setText(history);
            }
        });

        changeOp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNegative){
                    isNegative = false;
                    changeOp.setText("+");
                }
                else {
                    isNegative = true;
                    changeOp.setText("-");
                }
            }
        });
    }
}