package com.mcas2.openrol.DnDCharFragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.mcas2.openrol.DnDCharClasses.DnDCharacter;
import com.mcas2.openrol.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DnDCharFragment2 extends Fragment {
    private Map<String, CardView> cardViewHashMap = new HashMap<>();
    private Map<String, EditText> abilities = new HashMap<>();
    private Map<String, CheckBox> competences = new HashMap<>();

    AlertDialog.Builder builder;
    Random r;

    private DnDCharacter character;

    public DnDCharFragment2(DnDCharacter character) {
        this.character = character;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_dnd_2, container, false);

        builder = new AlertDialog.Builder(getContext());
        r = new Random();

        cardViewHashMap.put("athletics", view.findViewById(R.id.cardViewAthletics));
        cardViewHashMap.put("acrobatics", view.findViewById(R.id.cardViewAcrobatics));
        cardViewHashMap.put("sleightOfHand", view.findViewById(R.id.cardViewSleightOfHands));
        cardViewHashMap.put("stealth", view.findViewById(R.id.cardViewStealth));
        cardViewHashMap.put("arcana", view.findViewById(R.id.cardViewArcana));
        cardViewHashMap.put("history", view.findViewById(R.id.cardViewHistory));
        cardViewHashMap.put("investigation", view.findViewById(R.id.cardViewInvestigation));
        cardViewHashMap.put("nature", view.findViewById(R.id.cardViewNature));
        cardViewHashMap.put("religion", view.findViewById(R.id.cardViewReligion));
        cardViewHashMap.put("animalHandling", view.findViewById(R.id.cardViewAnimalHandling));
        cardViewHashMap.put("insight", view.findViewById(R.id.cardViewInsight));
        cardViewHashMap.put("medicine", view.findViewById(R.id.cardViewMedicine));
        cardViewHashMap.put("perception", view.findViewById(R.id.cardViewPerception));
        cardViewHashMap.put("survival", view.findViewById(R.id.cardViewSurvival));
        cardViewHashMap.put("deception", view.findViewById(R.id.cardViewDeception));
        cardViewHashMap.put("intimidation", view.findViewById(R.id.cardViewIntimidation));
        cardViewHashMap.put("performance", view.findViewById(R.id.cardViewPerformance));
        cardViewHashMap.put("persuasion", view.findViewById(R.id.cardViewPersuasion));

        abilities.put("athletics", view.findViewById(R.id.dndCHeditTextAthletics));
        abilities.put("acrobatics", view.findViewById(R.id.dndCHeditTextAcrobatics));
        abilities.put("sleightOfHand", view.findViewById(R.id.dndCHeditTextSleightOfHands));
        abilities.put("stealth", view.findViewById(R.id.dndCHeditTextStealth));
        abilities.put("arcana", view.findViewById(R.id.dndCHeditTextArcana));
        abilities.put("history", view.findViewById(R.id.dndCHeditTextHistory));
        abilities.put("investigation", view.findViewById(R.id.dndCHeditTextInvestigation));
        abilities.put("nature", view.findViewById(R.id.dndCHeditTextNature));
        abilities.put("religion", view.findViewById(R.id.dndCHeditTextReligion));
        abilities.put("animalHandling", view.findViewById(R.id.dndCHeditTextAnimalHandling));
        abilities.put("insight", view.findViewById(R.id.dndCHeditTextInsight));
        abilities.put("medicine", view.findViewById(R.id.dndCHeditTextMedicine));
        abilities.put("perception", view.findViewById(R.id.dndCHeditTextPerception));
        abilities.put("survival", view.findViewById(R.id.dndCHeditTextSurvival));
        abilities.put("deception", view.findViewById(R.id.dndCHeditTextDeception));
        abilities.put("intimidation", view.findViewById(R.id.dndCHeditTextIntimidation));
        abilities.put("performance", view.findViewById(R.id.dndCHeditTextPerformance));
        abilities.put("persuasion", view.findViewById(R.id.dndCHeditTextPersuasion));

        competences.put("athletics", view.findViewById(R.id.dndCheckBoxAthletics));
        competences.put("acrobatics", view.findViewById(R.id.dndCheckBoxAcrobatics));
        competences.put("sleightOfHand", view.findViewById(R.id.dndCheckBoxSleightOfHands));
        competences.put("stealth", view.findViewById(R.id.dndCheckBoxStealth));
        competences.put("arcana", view.findViewById(R.id.dndCheckBoxArcana));
        competences.put("history", view.findViewById(R.id.dndCheckBoxHistory));
        competences.put("investigation", view.findViewById(R.id.dndCheckBoxInvestigation));
        competences.put("nature", view.findViewById(R.id.dndCheckBoxNature));
        competences.put("religion", view.findViewById(R.id.dndCheckBoxReligion));
        competences.put("animalHandling", view.findViewById(R.id.dndCheckBoxAnimalHandling));
        competences.put("insight", view.findViewById(R.id.dndCheckBoxInsight));
        competences.put("medicine", view.findViewById(R.id.dndCheckBoxMedicine));
        competences.put("perception", view.findViewById(R.id.dndCheckBoxPerception));
        competences.put("survival", view.findViewById(R.id.dndCheckBoxSurvival));
        competences.put("deception", view.findViewById(R.id.dndCheckBoxDeception));
        competences.put("intimidation", view.findViewById(R.id.dndCheckBoxIntimidation));
        competences.put("performance", view.findViewById(R.id.dndCheckBoxPerformance));
        competences.put("persuasion", view.findViewById(R.id.dndCheckBoxPersuasion));

        //Para guardar los cambios de las habilidades
        for (String key : abilities.keySet()) {
            abilities.get(key).setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        String numAbilityText = String.valueOf(abilities.get(key).getText());
                        Integer numAbility;
                        if (numAbilityText.equals("")){
                            numAbility = 0;
                        } else {
                            numAbility = Integer.valueOf(numAbilityText);
                        }
                        character.setAttribute(key, numAbility);
                    }
                }
            });
        }

        for (String key : competences.keySet()) {
            competences.get(key).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    character.setCompetences(key, competences.get(key).isChecked());
                }
            });
        }

        //Para tirar
        for (String key : cardViewHashMap.keySet()) {
            cardViewHashMap.get(key).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer habilidad;
                    if (character.getAttribute(key)==null){
                        habilidad = 0;
                    } else
                        habilidad = character.getAttribute(key);

                    if (character.getCompetences(key)){
                        Integer competencia = character.getAttribute("competencia");
                        roll20DiceCompetence(habilidad, competencia);
                    } else {
                        roll20Dice(habilidad);
                    }
                }
            });
        }


        //PARA ELIMINAR
        //cardViewAcrobatics.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        builder.setMessage("1").show();
        //    }
        //});

        return view;
    }

   public void roll20DiceCompetence (Integer habilidad, Integer competente){
       Integer diceResult = r.nextInt(20)+1;
       String resultado;
       if (habilidad!=0) {
           resultado = diceResult + "+" + habilidad + "+" + competente + " = " + (diceResult + competente + habilidad);
       } else {
           resultado = diceResult + "+" + competente + " = " + (diceResult + competente);
       }
       builder.setMessage(resultado).show();
   }

   public void roll20Dice (Integer habilidad){
       Integer diceResult = r.nextInt(20)+1;
       String resultado;
       if (habilidad!=0) {
           resultado = diceResult + "+" + habilidad + " = " + (diceResult + habilidad);
       } else {
           resultado = diceResult.toString();
       }
       builder.setMessage(resultado).show();
    }

}
