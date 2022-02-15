package com.mcas2.openrol;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mcas2.openrol.ui.main.CardViewAdapter;
import com.mcas2.openrol.DnDCharModelCardView;

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
        dndCharModelArrayList.add(new DnDCharModelCardView("Tipo", 4, R.drawable.knight_coloured));
        dndCharModelArrayList.add(new DnDCharModelCardView("Señor", 3, R.drawable.knight_coloured));
        dndCharModelArrayList.add(new DnDCharModelCardView("Crack", 1, R.drawable.knight_coloured));
        dndCharModelArrayList.add(new DnDCharModelCardView("El Manin", 45, R.drawable.knight_coloured));
        dndCharModelArrayList.add(new DnDCharModelCardView("Hola", 4, R.drawable.knight_coloured));
        dndCharModelArrayList.add(new DnDCharModelCardView("aAaA", 4, R.drawable.knight_coloured));
        dndCharModelArrayList.add(new DnDCharModelCardView("King Gusano", 21, R.drawable.knight_coloured));

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