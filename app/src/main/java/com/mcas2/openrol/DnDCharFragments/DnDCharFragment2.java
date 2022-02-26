package com.mcas2.openrol.DnDCharFragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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



        cardViewAcrobatics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("1").show();
            }
        });

        return view;
    }

   // public String roll20Dice (int bonificador, int competente){
   //     int result = r.nextInt(20)+1;
//
   //     return result;
   // }

}
