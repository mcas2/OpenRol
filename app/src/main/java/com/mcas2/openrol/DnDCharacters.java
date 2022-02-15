package com.mcas2.openrol;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mcas2.openrol.ui.main.SectionsPagerAdapter;
import com.mcas2.openrol.databinding.ActivityDndCharactersBinding;

public class DnDCharacters extends AppCompatActivity {

    private ActivityDndCharactersBinding binding;
    private EditText strength;
    private EditText dexterity;
    private EditText constitution;
    private TextView modStrength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDndCharactersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        strength = (EditText) findViewById(R.id.dndCHeditTextStrength);
        dexterity = (EditText) findViewById(R.id.dndCHeditTextDexterity);
        constitution = (EditText) findViewById(R.id.dndCHeditTextConstitution);
        modStrength = findViewById(R.id.dndCSModStrength);



        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        strength.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                int numAbility = Integer.parseInt(String.valueOf(strength.getText()));
                int modificador = assignAbilityScore(numAbility);
                modStrength.setText(String.valueOf(modificador));
                return false;
            }
        });

    }

    public int assignAbilityScore (int numAbility){
        switch (numAbility){
            case (3):
                return -4;
            case (4):
            case (5):
                return -3;
            case (6):
            case (7):
                return -2;
            case (8):
            case (9):
                return -1;
            case (10):
            case (11):
                return 0;
            case (12):
            case (13):
                return 1;
            case (14):
            case (15):
                return 2;
            case (16):
            case (17):
                return 3;
            case (18):
                return 4;
            default:
                Toast toast = Toast.makeText(getApplicationContext(), "Introduce un número entre 3 y 18", Toast.LENGTH_SHORT);
                toast.show();
                return 0;
       }
    }
}