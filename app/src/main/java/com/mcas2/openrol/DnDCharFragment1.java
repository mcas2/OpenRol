package com.mcas2.openrol;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DnDCharFragment1 extends Fragment {
    private String [] classes = {"A","B"};
    private String [] races = {"Enano","Elfo", "Mediano", "Humano", "Dracónido", "Gnomo"};
    private ArrayAdapter classAdapter;
    private ArrayAdapter raceAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_dnd_1, container, false);

        Spinner classSpinner = (Spinner) view.findViewById(R.id.classSpinnerDnD);
        classAdapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item);
        classAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        classSpinner.setAdapter(classAdapter);

        Spinner raceSpinner = (Spinner) view.findViewById(R.id.raceSpinnerDnD);
        raceAdapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item);
        raceAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        raceSpinner.setAdapter(raceAdapter);
        return view;
    }
}
