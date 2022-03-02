package com.mcas2.openrol;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mcas2.openrol.DnDCharClasses.CardViewAdapter;
import com.mcas2.openrol.DnDCharClasses.DnDCharacter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SelectCharDnD extends AppCompatActivity{

    private FloatingActionButton fabAddCharacter;
    private CardViewAdapter cardViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OpenRolMain context = (OpenRolMain) getApplicationContext();
        context.setSelector(this);
        List<DnDCharacter> characters = context.getCharacters();

        setContentView(R.layout.activity_select_char_dnd);
        RecyclerView dndCharRecyclerView = findViewById(R.id.selectCharDnDRV);

        fabAddCharacter = findViewById(R.id.fabAddCharacter);

        fabAddCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenRolMain main = (OpenRolMain) getApplicationContext();
                main.inConstruction = null;
                Intent intent = new Intent(SelectCharDnD.this, DnDCharacterFactory.class);
                startActivity(intent);
            }
        });

        // we are initializing our adapter class and passing our arraylist to it.
        try {
            cardViewAdapter = new CardViewAdapter(this, (ArrayList<DnDCharacter>) characters);
        } catch (IOException | ClassNotFoundException e) {
            Log.e("", Log.getStackTraceString(e));
        }

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        dndCharRecyclerView.setLayoutManager(linearLayoutManager);
        dndCharRecyclerView.setAdapter(cardViewAdapter);

    }

    public void informNewCharacter() {
        cardViewAdapter.notifyDataSetChanged();
    }
}