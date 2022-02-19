package com.mcas2.openrol;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mcas2.openrol.DnDCharClasses.CardViewAdapter;
import com.mcas2.openrol.DnDCharClasses.DnDCharModelCardView;

import java.util.ArrayList;


public class SelectCharDnD extends AppCompatActivity{

    private ArrayList<DnDCharModelCardView> dndCharModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_char_dnd);
        RecyclerView dndCharRecyclerView = findViewById(R.id.selectCharDnDRV);

        // here we have created new array list and added data to it.
        // Arraylist for storing data
        dndCharModelArrayList = new ArrayList<>();
        dndCharModelArrayList.add(new DnDCharModelCardView("Personaje 1", 4, R.drawable.knight_coloured));
        dndCharModelArrayList.add(new DnDCharModelCardView("Personaje 2", 3, R.drawable.knight_coloured));
        dndCharModelArrayList.add(new DnDCharModelCardView("Personaje 3", 1, R.drawable.knight_coloured));
        dndCharModelArrayList.add(new DnDCharModelCardView("Personaje 4", 45, R.drawable.knight_coloured));
        dndCharModelArrayList.add(new DnDCharModelCardView("Personaje 5", 4, R.drawable.knight_coloured));
        dndCharModelArrayList.add(new DnDCharModelCardView("Personaje 6", 4, R.drawable.knight_coloured));
        dndCharModelArrayList.add(new DnDCharModelCardView("Personaje 7", 21, R.drawable.knight_coloured));

        // we are initializing our adapter class and passing our arraylist to it.
        CardViewAdapter cardViewAdapter = new CardViewAdapter(this, dndCharModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        dndCharRecyclerView.setLayoutManager(linearLayoutManager);
        dndCharRecyclerView.setAdapter(cardViewAdapter);
    }
}