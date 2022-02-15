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

import com.mcas2.openrol.R;

public class DnDCharFragment1 extends Fragment {
    private EditText strength;
    private EditText dexterity;
    private EditText constitution;
    private EditText intelligence;
    private EditText wisdom;
    private EditText charisma;
    private TextView modStrength;
    private TextView modDexterity;
    private TextView modConstitucion;
    private TextView modIntelligence;
    private TextView modWisdom;
    private TextView modCharisma;

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

        raceSpinner.setAdapter(raceAdapter);

        strength = (EditText) view.findViewById(R.id.dndCHeditTextStrength);
        dexterity = (EditText) view.findViewById(R.id.dndCHeditTextDexterity);
        constitution = (EditText) view.findViewById(R.id.dndCHeditTextConstitution);
        intelligence = (EditText) view.findViewById(R.id.dndCHeditTextIntelligence);
        wisdom = (EditText) view.findViewById(R.id.dndCHeditTextWisdom);
        charisma = (EditText) view.findViewById(R.id.dndCHeditTextCharisma);
        modStrength = view.findViewById(R.id.dndCSModStrength);
        modDexterity = view.findViewById(R.id.dndCSModDexterity);
        modConstitucion = view.findViewById(R.id.dndCSModConstitution);
        modIntelligence = view.findViewById(R.id.dndCSModIntelligence);
        modWisdom = view.findViewById(R.id.dndCSModWisdom);
        modCharisma = view.findViewById(R.id.dndCSModCharisma);

        strength.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String numAbilityText = String.valueOf(strength.getText());
                Integer numAbility = Integer.parseInt(numAbilityText);
                Integer modificador = assignAbilityScore(numAbility);
                modStrength.setText(String.valueOf(modificador));
            }
        });

        dexterity.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String numAbilityText = String.valueOf(dexterity.getText());
                Integer numAbility = Integer.parseInt(numAbilityText);
                Integer modificador = assignAbilityScore(numAbility);
                modDexterity.setText(String.valueOf(modificador));
            }
        });

        constitution.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String numAbilityText = String.valueOf(constitution.getText());
                Integer numAbility = Integer.parseInt(numAbilityText);
                Integer modificador = assignAbilityScore(numAbility);
                modConstitucion.setText(String.valueOf(modificador));
            }
        });

        intelligence.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String numAbilityText = String.valueOf(intelligence.getText());
                Integer numAbility = Integer.parseInt(numAbilityText);
                Integer modificador = assignAbilityScore(numAbility);
                modIntelligence.setText(String.valueOf(modificador));
            }
        });

        wisdom.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String numAbilityText = String.valueOf(wisdom.getText());
                Integer numAbility = Integer.parseInt(numAbilityText);
                Integer modificador = assignAbilityScore(numAbility);
                modWisdom.setText(String.valueOf(modificador));
            }
        });

        charisma.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String numAbilityText = String.valueOf(charisma.getText());
                Integer numAbility = Integer.parseInt(numAbilityText);
                Integer modificador = assignAbilityScore(numAbility);
                modCharisma.setText(String.valueOf(modificador));
            }
        });

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
