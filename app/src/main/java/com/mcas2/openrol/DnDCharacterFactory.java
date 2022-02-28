package com.mcas2.openrol;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

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

public class DnDCharacterFactory extends AppCompatActivity {

    private DnDCharacter newCharacter = new DnDCharacter();
    private static final int CODIGO_PERMISOS_CAMARA = 1;
    private ActivityResultLauncher<Intent> myARL;



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
    private EditText lore;
    private Spinner dndRace;
    private Spinner dndClass;
    private Switch inspiration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDndCharactersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), newCharacter);
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        //Básicos
        //STRINGS
        dndRace = findViewById(R.id.raceSpinnerDnD);
        dndClass = (Spinner) findViewById(R.id.classSpinnerDnD);
        dg = (EditText) findViewById(R.id.dndCHeditTextDG);

        //INTEGER
        armorClass = findViewById(R.id.dndCHeditTextArmorClass);
        competencia = findViewById(R.id.dndCHeditTextCompetencia);
        level = findViewById(R.id.dndCHeditTextLevel);
        speed = findViewById(R.id.dndCHeditTextSpeed);
        pgm = findViewById(R.id.dndCHeditTextPGM);
        pga = findViewById(R.id.dndCHeditTextPGA);
        pgt = findViewById(R.id.dndCHeditTextPGT);

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
        inspiration = findViewById(R.id.dndInspirationSwitch);

        FloatingActionButton fabSave = binding.fabSave;

        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenRol context = (OpenRol) getApplicationContext();
                context.addCharacter(newCharacter);
                Toast toast = Toast.makeText(getApplicationContext(), newCharacter.getName() + " entró en los archivos.", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        myARL = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            Bundle bundle = result.getData().getExtras();
                            Bitmap imagen = (Bitmap) bundle.get("data");
                            newCharacter.setImage(imagen);
                        }
                    }
                });
    }

    //Cámara


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dnd_charsheet_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.camera) {
            takePhoto();
        }
        return super.onOptionsItemSelected(item);
    }

    private void takePhoto() {
        int checkPermissions = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (checkPermissions == PackageManager.PERMISSION_GRANTED){
            implicitCameraIntent();
        } else { //Si no se ha hecho, solicito los permisos.
            Log.i("Mensaje:", "No se tiene acceso a la cámara");
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, CODIGO_PERMISOS_CAMARA);
        }
    }

    public void implicitCameraIntent(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager())!=null) myARL.launch(intent);
        else Log.i("Mensaje:", "Error con la cámara");
    }



    public String getData(EditText et){
        return et.getText().toString();
    }




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
