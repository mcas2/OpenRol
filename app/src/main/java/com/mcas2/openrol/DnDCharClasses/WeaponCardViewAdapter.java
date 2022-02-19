package com.mcas2.openrol.DnDCharClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mcas2.openrol.R;

import java.util.ArrayList;

public class WeaponCardViewAdapter extends RecyclerView.Adapter<WeaponCardViewAdapter.Viewholder> {

    private Context context;
    private ArrayList<DnDWeapon> dndWeapons = new ArrayList<>();

    // Constructor
    public WeaponCardViewAdapter(Context context, ArrayList<DnDWeapon> dndWeapons) {
        this.context = context;
        this.dndWeapons = dndWeapons;
    }

    @NonNull
    @Override
    public WeaponCardViewAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_weapon_dnd, parent, false);
        return new Viewholder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull WeaponCardViewAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        DnDWeapon model = dndWeapons.get(position);
        //holder.cvWeaponIcon.setImageResource(model.getIcon());
        holder.cvWeaponName.setText(String.valueOf(model.getWeaponName()));
        holder.cvWeaponProperties.setText(model.getProperties());
        holder.cvDices.setText(model.getDices());
        holder.cvDiceFaces.setText(model.getDiceFaces());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return dndWeapons.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public static class Viewholder extends RecyclerView.ViewHolder {
        private ImageView cvWeaponIcon;
        private EditText cvWeaponName, cvWeaponProperties;
        private EditText cvDices, cvDiceFaces;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            cvWeaponIcon = itemView.findViewById(R.id.dndWeaponIcon);
            cvWeaponName = itemView.findViewById(R.id.dndWeaponName);
            cvWeaponProperties = itemView.findViewById(R.id.dndWeaponProperties);
            cvDices = itemView.findViewById(R.id.dndWeaponDices);
            cvDiceFaces = itemView.findViewById(R.id.dndWeaponDiceFaces);
        }
    }
}