package com.mcas2.openrol.DnDCharFragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.mcas2.openrol.R;
import com.mcas2.openrol.ui.main.CardViewAdapter;

public class DnDCharFragment2 extends Fragment {

    private CardView cardViewAthletics;
    private CardView cardViewAcrobatics;
    private CardView cardViewSleightOfHand;
    private CardView cardViewStealth;
    private CardView cardViewArcana;
    private CardView cardViewHistory;
    private CardView cardViewInvestigation;
    private CardView cardViewNature;
    private CardView cardViewReligion;
    private CardView cardViewAnimalHandling;
    private CardView cardViewInsight;
    private CardView cardViewMedicine;
    private CardView cardViewPerception;
    private CardView cardViewSurvival;
    private CardView cardViewDeception;
    private CardView cardViewIntimidation;
    private CardView cardViewPerformance;
    private CardView cardViewPersuasion;
    AlertDialog.Builder builder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_dnd_2, container, false);

        builder = new AlertDialog.Builder(getContext());

        cardViewAthletics = (CardView) view.findViewById(R.id.cardViewAthletics);
        cardViewAcrobatics = (CardView) view.findViewById(R.id.cardViewAcrobatics);
        cardViewSleightOfHand = (CardView) view.findViewById(R.id.cardViewSleightOfHands);
        cardViewStealth = (CardView) view.findViewById(R.id.cardViewStealth);
        cardViewArcana = (CardView) view.findViewById(R.id.cardViewArcana);
        cardViewHistory = (CardView) view.findViewById(R.id.cardViewHistory);
        cardViewInvestigation = (CardView) view.findViewById(R.id.cardViewInvestigation);
        cardViewNature = (CardView) view.findViewById(R.id.cardViewNature);
        cardViewReligion = (CardView) view.findViewById(R.id.cardViewReligion);
        cardViewAnimalHandling = (CardView) view.findViewById(R.id.cardViewAnimalHandling);
        cardViewInsight = (CardView) view.findViewById(R.id.cardViewInsight);
        cardViewMedicine = (CardView) view.findViewById(R.id.cardViewMedicine);
        cardViewPerception = (CardView) view.findViewById(R.id.cardViewPerception);
        cardViewSurvival = (CardView) view.findViewById(R.id.cardViewSurvival);
        cardViewDeception = (CardView) view.findViewById(R.id.cardViewDeception);
        cardViewIntimidation = (CardView) view.findViewById(R.id.cardViewIntimidation);
        cardViewPerformance = (CardView) view.findViewById(R.id.cardViewPerformance);
        cardViewPersuasion = (CardView) view.findViewById(R.id.cardViewPersuasion);

        cardViewAcrobatics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("1").show();
            }
        });

        return view;
    }

}
