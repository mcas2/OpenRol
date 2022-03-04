package com.mcas2.openrol.FutureDevelopment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mcas2.openrol.DnDCharClasses.DnDCharacter;
import com.mcas2.openrol.R;
//CLASE SIN FUNCIONAMIENTO, POTENCIAL AMPLIACIÓN
public class DnDCharFragment5 extends Fragment {

    private DnDCharacter character;
    private EditText lore;

    public DnDCharFragment5(DnDCharacter character) {
        this.character = character;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dnd_5, container, false);
        lore = (EditText) view.findViewById(R.id.editTextLore);

        return view;
    }
}
