package com.mcas2.openrol.DnDCharFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mcas2.openrol.DnDCharClasses.DnDCharacter;
import com.mcas2.openrol.R;

import java.util.HashMap;
import java.util.Map;

public class DnDCharFragment1 extends Fragment {
    public EditText name;
    private Map<String, EditText> editTextsCaracteristicas = new HashMap<>();
    //private Map<String, EditText> editText = new HashMap<>();
    private Map<String, TextView> textViews = new HashMap<>();

    private DnDCharacter character;

    public DnDCharFragment1(DnDCharacter character) {
        this.character = character;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_dnd_1, container, false);

        Spinner classSpinner = (Spinner) view.findViewById(R.id.classSpinnerDnD);
        ArrayAdapter<CharSequence> classAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.dndClasses, R.layout.support_simple_spinner_dropdown_item);
        classAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        classSpinner.setAdapter(classAdapter);

        Spinner raceSpinner = (Spinner) view.findViewById(R.id.raceSpinnerDnD);
        ArrayAdapter<CharSequence> raceAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.dndRaces, R.layout.support_simple_spinner_dropdown_item);
        raceAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        //Basicos
        name = view.findViewById(R.id.dndCHeditTextName);
        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    character.setName(name.getText().toString());
                }
            }
        });

        //Lo que ya estaba
        raceSpinner.setAdapter(raceAdapter);

        editTextsCaracteristicas.put("strength", view.findViewById(R.id.dndCHeditTextStrength));
        editTextsCaracteristicas.put("dexterity", view.findViewById(R.id.dndCHeditTextDexterity));
        editTextsCaracteristicas.put("constitution", view.findViewById(R.id.dndCHeditTextConstitution));
        editTextsCaracteristicas.put("intelligence", view.findViewById(R.id.dndCHeditTextIntelligence));
        editTextsCaracteristicas.put("wisdom", view.findViewById(R.id.dndCHeditTextWisdom));
        editTextsCaracteristicas.put("charisma", view.findViewById(R.id.dndCHeditTextCharisma));

        textViews.put("strength", view.findViewById(R.id.dndCSModStrength));
        textViews.put("dexterity", view.findViewById(R.id.dndCSModDexterity));
        textViews.put("constitution", view.findViewById(R.id.dndCSModConstitution));
        textViews.put("intelligence", view.findViewById(R.id.dndCSModIntelligence));
        textViews.put("wisdom", view.findViewById(R.id.dndCSModWisdom));
        textViews.put("charisma", view.findViewById(R.id.dndCSModCharisma));


        for (String key : editTextsCaracteristicas.keySet()) {
            editTextsCaracteristicas.get(key).setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        String numAbilityText = String.valueOf(editTextsCaracteristicas.get(key).getText());
                        Integer numAbility = Integer.parseInt(numAbilityText);
                        Integer modificador = assignAbilityScore(numAbility);
                        textViews.get(key).setText(String.valueOf(modificador));
                        // clave
                        character.setAttribute(key, numAbility);
                    }
                }
            });
        }

        return view;
    }



    public Integer assignAbilityScore (Integer numAbility){
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
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Introduce un número entre 3 y 18", Toast.LENGTH_SHORT);
                toast.show();
                return 0;
        }
    }
}
