package com.mcas2.openrol;

import android.Manifest;
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

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.mcas2.openrol.DnDCharClasses.DnDCharacter;
import com.mcas2.openrol.DnDCharClasses.DnDWeapon;
import com.mcas2.openrol.ui.main.SectionsPagerAdapter;
import com.mcas2.openrol.databinding.ActivityDndCharactersBinding;

import org.json.JSONArray;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DnDCharacterFactory extends AppCompatActivity {

    private DnDCharacter newCharacter = new DnDCharacter();
    private static final int CODIGO_PERMISOS_CAMARA = 1;
    private ActivityResultLauncher<Intent> myARL;

    private ActivityDndCharactersBinding binding;
    //private ArrayList<DnDCharacter> characters = new ArrayList<>();
    private ArrayList<DnDWeapon> weapons = new ArrayList<>();

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

        //Otros
        inspiration = findViewById(R.id.dndInspirationSwitch);

        FloatingActionButton fabSave = binding.fabSave;

        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenRolMain context = (OpenRolMain) getApplicationContext();
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


    public void onPause () {
        OpenRolMain context = (OpenRolMain) getApplicationContext();

        try {
            File file = new File(Environment.getExternalStorageDirectory(), "dnd_characters.json");
            FileWriter fw = new FileWriter(file);
            JSONArray ja = new JSONArray();

            for (DnDCharacter character : context.characters){
                ja.put(character.serialize());
            }

            fw.write(ja.toString());
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onPause();
    }
}
