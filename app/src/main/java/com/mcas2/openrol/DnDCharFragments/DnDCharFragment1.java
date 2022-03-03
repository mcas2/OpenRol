package com.mcas2.openrol.DnDCharFragments;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import java.util.Objects;

public class DnDCharFragment1 extends Fragment {
    public EditText name;
    public EditText level;
    private Map<String, EditText> editTextsCaracteristicas = new HashMap<>();
    private Map<String, EditText> editTextsAtributos = new HashMap<>();
    //private Map<String, EditText> editText = new HashMap<>();
    private Map<String, TextView> textViewsCaracteristicas = new HashMap<>();

    private DnDCharacter character;

    public DnDCharFragment1(DnDCharacter character) {
        this.character = character;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dnd_1, container, false);

        ArrayAdapter<CharSequence> classAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.dndClasses, R.layout.support_simple_spinner_dropdown_item);
        classAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> raceAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.dndRaces, R.layout.support_simple_spinner_dropdown_item);
        raceAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        //Basicos
        name = view.findViewById(R.id.dndCHeditTextName);
        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                character.setName(name.getText().toString());
            }
        });

        name.setText(character.getName());


        level = view.findViewById(R.id.dndCHeditTextLevel);
        level.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Integer numLevel = Integer.parseInt(level.getText().toString());
                character.setLevel(numLevel);
            }
        });

        level.setText(character.getLevel().toString());

        Spinner raceSpinner = (Spinner) view.findViewById(R.id.raceSpinnerDnD);
        raceSpinner.setAdapter(raceAdapter);

        raceSpinner.setSelection(character.getAttribute("race"), true);
        raceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                character.setAttribute("race", position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Spinner classSpinner = (Spinner) view.findViewById(R.id.classSpinnerDnD);
        classSpinner.setAdapter(classAdapter);

        classSpinner.setSelection(character.getAttribute("class"), true);
        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                character.setAttribute("class", position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        editTextsCaracteristicas.put("strength", view.findViewById(R.id.dndCHeditTextStrength));
        editTextsCaracteristicas.put("dexterity", view.findViewById(R.id.dndCHeditTextDexterity));
        editTextsCaracteristicas.put("constitution", view.findViewById(R.id.dndCHeditTextConstitution));
        editTextsCaracteristicas.put("intelligence", view.findViewById(R.id.dndCHeditTextIntelligence));
        editTextsCaracteristicas.put("wisdom", view.findViewById(R.id.dndCHeditTextWisdom));
        editTextsCaracteristicas.put("charisma", view.findViewById(R.id.dndCHeditTextCharisma));

        editTextsAtributos.put("armorClass", view.findViewById(R.id.dndCHeditTextArmorClass));
        editTextsAtributos.put("competencia", view.findViewById(R.id.dndCHeditTextCompetencia));
        editTextsAtributos.put("speed", view.findViewById(R.id.dndCHeditTextSpeed));
        editTextsAtributos.put("initiative", view.findViewById(R.id.dndCHeditTextInitiative));
        editTextsAtributos.put("pgm", view.findViewById(R.id.dndCHeditTextPGM));
        editTextsAtributos.put("pga", view.findViewById(R.id.dndCHeditTextPGA));
        editTextsAtributos.put("pgt", view.findViewById(R.id.dndCHeditTextPGT));

        textViewsCaracteristicas.put("strength", view.findViewById(R.id.dndCSModStrength));
        textViewsCaracteristicas.put("dexterity", view.findViewById(R.id.dndCSModDexterity));
        textViewsCaracteristicas.put("constitution", view.findViewById(R.id.dndCSModConstitution));
        textViewsCaracteristicas.put("intelligence", view.findViewById(R.id.dndCSModIntelligence));
        textViewsCaracteristicas.put("wisdom", view.findViewById(R.id.dndCSModWisdom));
        textViewsCaracteristicas.put("charisma", view.findViewById(R.id.dndCSModCharisma));

        for (String key : textViewsCaracteristicas.keySet()) {
            if (character.getAttribute(key) != 0) {
                textViewsCaracteristicas.get(key).setText(assignAbilityScore(character.getAttribute(key)).toString());
            }
        }

        for (String key : editTextsAtributos.keySet()) {
            editTextsAtributos.get(key).setText(character.getAttribute(key).toString());
            editTextsAtributos.get(key).setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == event.ACTION_UP) {
                        String numAbilityText = String.valueOf(editTextsAtributos.get(key).getText());
                        Integer numAbility = Integer.parseInt(numAbilityText);

                        character.setAttribute(key, numAbility);
                    }
                    return false;
                }
            });

        }

        for (String key : editTextsCaracteristicas.keySet()) {
            editTextsCaracteristicas.get(key).setText(character.getAttribute(key).toString());
            editTextsCaracteristicas.get(key).setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == event.ACTION_UP) {
                        String numAbilityText = String.valueOf(Objects.requireNonNull(editTextsCaracteristicas.get(key)).getText());
                        if (numAbilityText.equals("")) {
                            numAbilityText = "0";
                        }
                        Integer numAbility = Integer.parseInt(numAbilityText);
                        Integer modificador = assignAbilityScore(numAbility);
                        textViewsCaracteristicas.get(key).setText(String.valueOf(modificador));
                        character.setAttribute(key, numAbility);
                    }
                    return false;
                }
            });
        }



        for (String key : editTextsAtributos.keySet()) {
            editTextsAtributos.get(key).setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == event.ACTION_UP) {
                        String numAbilityText = String.valueOf(editTextsAtributos.get(key).getText());
                        Integer numAbility;
                        if (numAbilityText.equals("")){
                            numAbility = 0;
                        } else {
                            numAbility = Integer.parseInt(numAbilityText);
                        }

                        character.setAttribute(key, numAbility);
                    }
                    return false;
                }
            });

        }

        return view;
    }




        public Integer assignAbilityScore (Integer numAbility){
            switch (numAbility) {
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

