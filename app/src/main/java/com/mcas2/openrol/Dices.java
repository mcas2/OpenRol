package com.mcas2.openrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
    public ImageButton roll;
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

        roll = (ImageButton) findViewById(R.id.rollDicesButton);
        Animation rollAnim = (Animation) AnimationUtils.loadAnimation(this, R.anim.rotate);
        roll.setAnimation(rollAnim);

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

        int defaultDice = 5; // it correspondes to d20
        sp.setSelection(defaultDice, true);


        //Tirada
        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation rollDiceAnim = (Animation) AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                roll.setAnimation(rollDiceAnim);

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