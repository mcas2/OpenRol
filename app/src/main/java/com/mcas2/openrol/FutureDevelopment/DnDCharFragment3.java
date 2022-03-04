package com.mcas2.openrol.FutureDevelopment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mcas2.openrol.DnDCharClasses.DnDCharacter;
import com.mcas2.openrol.R;
//CLASE SIN FUNCIONAMIENTO, POTENCIAL AMPLIACIÓN
public class DnDCharFragment3 extends Fragment {

    private DnDCharacter character;

    public DnDCharFragment3(DnDCharacter character) {
        this.character = character;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_dnd_3, container, false);



        FloatingActionButton fabCC = view.findViewById(R.id.createCCWeapon);
        fabCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }
}
