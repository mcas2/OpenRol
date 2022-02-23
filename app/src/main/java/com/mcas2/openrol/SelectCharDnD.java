package com.mcas2.openrol;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mcas2.openrol.DnDCharClasses.CardViewAdapter;
import com.mcas2.openrol.DnDCharClasses.DnDCharacter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class SelectCharDnD extends AppCompatActivity{

    private ArrayList<DnDCharacter> characters = new ArrayList<>();
    private FloatingActionButton fabAddCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_char_dnd);
        RecyclerView dndCharRecyclerView = findViewById(R.id.selectCharDnDRV);

        fabAddCharacter = findViewById(R.id.fabAddCharacter);

        fabAddCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCharDnD.this, DnDCharacters.class);
                startActivity(intent);
            }
        });

        // here we have created new array list and added data to it.
        // Arraylist for storing data
        //dndCharModelArrayList = new ArrayList<>();
        //dndCharModelArrayList.add(new DnDCharModelCardView("Personaje 1", 4, R.drawable.knight_coloured));

        // we are initializing our adapter class and passing our arraylist to it.
        CardViewAdapter cardViewAdapter = null;
        try {
            cardViewAdapter = new CardViewAdapter(this, loadCharacters());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        dndCharRecyclerView.setLayoutManager(linearLayoutManager);
        dndCharRecyclerView.setAdapter(cardViewAdapter);

    }

    public ArrayList<DnDCharacter> loadCharacters() throws IOException, ClassNotFoundException {
        File filename = new File(getFilesDir(),"/"+ "dnd_characters.dat");
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
        ArrayList<DnDCharacter> characters = (ArrayList<DnDCharacter>) is.readObject();
        is.close();
        return characters;
    }
}