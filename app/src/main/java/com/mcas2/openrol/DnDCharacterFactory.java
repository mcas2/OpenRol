package com.mcas2.openrol;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.mcas2.openrol.DnDCharClasses.DnDCharacter;
import com.mcas2.openrol.DnDCharClasses.DnDWeapon;
import com.mcas2.openrol.DnDCharFragments.DnDCharFragment1;
import com.mcas2.openrol.DnDCharFragments.DnDCharFragment2;
import com.mcas2.openrol.DnDCharFragments.DnDCharFragment3;
import com.mcas2.openrol.DnDCharFragments.DnDCharFragment4;
import com.mcas2.openrol.DnDCharFragments.DnDCharFragment5;
import com.mcas2.openrol.ui.main.SectionsPagerAdapter;
import com.mcas2.openrol.databinding.ActivityDndCharactersBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;

public class DnDCharacterFactory extends AppCompatActivity {

    private DnDCharacter newCharacter = new DnDCharacter();

    private DnDCharFragment1 frag1;
    private DnDCharFragment2 frag2;
    private DnDCharFragment3 frag3;
    private DnDCharFragment4 frag4;
    private DnDCharFragment5 frag5;
    private ActivityDndCharactersBinding binding;
    private ArrayList<DnDCharacter> characters = new ArrayList<>();
    private ArrayList<DnDWeapon> weapons = new ArrayList<>();

    private EditText level;
    private EditText armorClass;
    private EditText competencia;
    private EditText initiative;
    private EditText speed;
    private EditText pgm;
    private EditText pga;
    private EditText pgt;
    private EditText dg;
    private EditText strength;
    private EditText dexterity;
    private EditText constitution;
    private EditText intelligence;
    private EditText wisdom;
    private EditText charisma;
    private EditText athletics;
    private EditText acrobatics;
    private EditText sleightOfHands;
    private EditText stealth;
    private EditText arcana;
    private EditText history;
    private EditText investigation;
    private EditText nature;
    private EditText religion;
    private EditText animalHandling;
    private EditText insight;
    private EditText medicine;
    private EditText perception;
    private EditText survival;
    private EditText deception;
    private EditText intimidation;
    private EditText performance;
    private EditText persuasion;
    private EditText magic;
    private EditText lore;
    private Spinner dndRace;
    private Spinner dndClass;
    private Switch inspiration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dnd_characters);

        //LA MOVIDA TIENE QUE VER CON ESTO
        binding = ActivityDndCharactersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), newCharacter);
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        //Básicos
        //He hecho esta prueba pero no sale nada
        level = findViewById(R.id.dndCHeditTextLevel);
        dndRace = findViewById(R.id.raceSpinnerDnD);
        dndClass = (Spinner) findViewById(R.id.classSpinnerDnD);
        armorClass = (EditText) findViewById(R.id.dndCHeditTextArmorClass);
        competencia = (EditText) findViewById(R.id.dndCHeditTextCompetencia);
        initiative = (EditText) findViewById(R.id.dndCHeditTextInitiative);
        speed = (EditText) findViewById(R.id.dndCHeditTextSpeed);
        pgm = (EditText) findViewById(R.id.dndCHeditTextPGM);
        pga = (EditText) findViewById(R.id.dndCHeditTextPGA);
        pgt = (EditText) findViewById(R.id.dndCHeditTextPGT);
        dg = (EditText) findViewById(R.id.dndCHeditTextDG);

        //Características
        strength = (EditText) findViewById(R.id.dndCHeditTextStrength);
        dexterity = (EditText) findViewById(R.id.dndCHeditTextDexterity);
        constitution = (EditText) findViewById(R.id.dndCHeditTextConstitution);
        intelligence = (EditText) findViewById(R.id.dndCHeditTextIntelligence);
        wisdom = (EditText) findViewById(R.id.dndCHeditTextWisdom);
        charisma = (EditText) findViewById(R.id.dndCHeditTextCharisma);

        //Habilidades

        athletics = (EditText) findViewById(R.id.dndCHeditTextAthletics);
        acrobatics = (EditText) findViewById(R.id.dndCHeditTextAcrobatics);
        sleightOfHands = (EditText) findViewById(R.id.dndCHeditTextSleightOfHands);
        stealth = (EditText) findViewById(R.id.dndCHeditTextStealth);
        arcana = (EditText) findViewById(R.id.dndCHeditTextArcana);
        history = (EditText) findViewById(R.id.dndCHeditTextHistory);
        investigation = (EditText) findViewById(R.id.dndCHeditTextInvestigation);
        nature = (EditText) findViewById(R.id.dndCHeditTextNature);
        religion = (EditText) findViewById(R.id.dndCHeditTextReligion);
        animalHandling = (EditText) findViewById(R.id.dndCHeditTextAnimalHandling);
        insight = (EditText) findViewById(R.id.dndCHeditTextInsight);
        medicine = (EditText) findViewById(R.id.dndCHeditTextMedicine);
        perception = (EditText) findViewById(R.id.dndCHeditTextPerception);
        survival = (EditText) findViewById(R.id.dndCHeditTextSurvival);
        deception = (EditText) findViewById(R.id.dndCHeditTextDeception);
        intimidation = (EditText) findViewById(R.id.dndCHeditTextIntimidation);
        performance = (EditText) findViewById(R.id.dndCHeditTextPerformance);
        persuasion = (EditText) findViewById(R.id.dndCHeditTextPersuasion);

        //Otros
        magic = (EditText) findViewById(R.id.editTextMagic);
        lore = (EditText) findViewById(R.id.editTextLore);
        inspiration = findViewById(R.id.dndInspirationSwitch);

        FloatingActionButton fabSave = binding.fabSave;

        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenRol context = (OpenRol) getApplicationContext();
                context.addCharacter(newCharacter);
                Toast toast = Toast.makeText(getApplicationContext(), newCharacter.getName()+" entró en los archivos.", Toast.LENGTH_SHORT);
                toast.show();
            }});
        }

    public String getData(EditText et){
        return et.getText().toString();
    }

//Integer.parseInt(level.getText().toString()),
    //dndRace.getSelectedItem().toString(),
    //dndClass.getSelectedItem().toString(),
    //Integer.parseInt(armorClass.getText().toString()),
    //Integer.parseInt(competencia.getText().toString()),
    //Integer.parseInt(initiative.getText().toString()),
    //Integer.parseInt(speed.getText().toString()),
    //Integer.parseInt(pgm.getText().toString()),
    //Integer.parseInt(pga.getText().toString()),
    //Integer.parseInt(pgt.getText().toString()),
    //dg.getText().toString(),
    //Integer.parseInt(strength.getText().toString()),
    //Integer.parseInt(dexterity.getText().toString()),
    //Integer.parseInt(constitution.getText().toString()),
    //Integer.parseInt(intelligence.getText().toString()),
    //Integer.parseInt(wisdom.getText().toString()),
    //Integer.parseInt(charisma.getText().toString()),
    //Integer.parseInt(athletics.getText().toString()),
    //Integer.parseInt(acrobatics.getText().toString()),
    //Integer.parseInt(sleightOfHands.getText().toString()),
    //Integer.parseInt(stealth.getText().toString()),
    //Integer.parseInt(arcana.getText().toString()),
    //Integer.parseInt(history.getText().toString()),
    //Integer.parseInt(investigation.getText().toString()),
    //Integer.parseInt(nature.getText().toString()),
    //Integer.parseInt(religion.getText().toString()),
    //Integer.parseInt(animalHandling.getText().toString()),
    //Integer.parseInt(insight.getText().toString()),
    //Integer.parseInt(medicine.getText().toString()),
    //Integer.parseInt(perception.getText().toString()),
    //Integer.parseInt(survival.getText().toString()),
    //Integer.parseInt(deception.getText().toString()),
    //Integer.parseInt(intimidation.getText().toString()),
    //Integer.parseInt(performance.getText().toString()),
    //Integer.parseInt(persuasion.getText().toString()),
    //inspiration.isChecked(),
    //magic.getText().toString(),
    //lore.getText().toString(),
    //weapons


        //Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
    public void saveCharacter(ArrayList<DnDCharacter> characters){
        try {
            File filename = new File(getFilesDir(),"/"+ "dnd_characters.dat");
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream os = new ObjectOutputStream(file);
            os.writeObject(characters);
            os.close();
            file.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
