package com.mcas2.openrol.DnDCharClasses;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import com.mcas2.openrol.DnDCharacterFactory;
import com.mcas2.openrol.OpenRolMain;
import com.mcas2.openrol.R;
import com.mcas2.openrol.SelectCharDnD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.Viewholder> {

    private Context context;
    private List<DnDCharacter> characterList;

    // Constructor
    public CardViewAdapter(Context context, ArrayList<DnDCharacter> characterList) throws IOException, ClassNotFoundException {
            this.context = context;
            this.characterList = characterList;
    }

    @NonNull
    @Override
    public CardViewAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // to inflate the layout for each item of recycler view.
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_dnd, parent, false);
            return new Viewholder(view);
            }



    @Override
    public void onBindViewHolder(@NonNull CardViewAdapter.Viewholder holder, int position) {
            // to set data to textview and imageview of each card layout
            DnDCharacter model = characterList.get(position);
            holder.cardViewDnDCharName.setText(model.getName());
            holder.cardViewDnDCharLevel.setText(String.valueOf(model.getLevel()));
            holder.cardViewDnDCharImage.setImageBitmap(model.getImage());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OpenRolMain main = (OpenRolMain) context.getApplicationContext();
                    main.inConstruction = main.getCharacterByPosition(holder.getAdapterPosition());
                    Intent intent = new Intent(context, DnDCharacterFactory.class);
                    context.startActivity(intent);

                }
            });
            }

    @Override
    public int getItemCount() {
            // this method is used for showing number
            // of card items in recycler view.
            return characterList.size();
            }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public static class Viewholder extends RecyclerView.ViewHolder {
        private ImageView cardViewDnDCharImage;
        private TextView cardViewDnDCharName, cardViewDnDCharLevel;

         public Viewholder(@NonNull View itemView) {
            super(itemView);
            cardViewDnDCharImage = itemView.findViewById(R.id.cardViewDnDCharImage);
            cardViewDnDCharName = itemView.findViewById(R.id.cardViewDnDCharName);
            cardViewDnDCharLevel = itemView.findViewById(R.id.cardViewDnDCharLevel);
        }
    }

}