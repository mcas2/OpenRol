package com.mcas2.openrol.DnDCharClasses;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        Integer heroClass = model.getAttribute("class");
        Integer classId = getHeroClassId(heroClass);

        //Colocar imágenes en función de la clase
        if (model.getImageDefault()==null){
            model.setImage(BitmapFactory.decodeResource(context.getResources(), classId));
            holder.cardViewDnDCharImage.setImageBitmap(model.getImage());
        } else {
            holder.cardViewDnDCharImage.setImageBitmap(model.getImageDefault());
        }


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


    private Integer getHeroClassId(Integer heroClass) {
        switch (heroClass) {
            case (0):
                return R.drawable.barbarian;
            case (1):
                return R.drawable.bard;
            case (2):
                return R.drawable.witch;
            case (3):
                return R.drawable.priest;
            case (4):
                return R.drawable.druid;
            case (5):
                return R.drawable.ranger;
            case (6):
                return R.drawable.knight;
            case (7):
                return R.drawable.sorcerer;
            case (8):
                return R.drawable.wizard;
            case (9):
                return R.drawable.monk;
            case (10):
                return R.drawable.knight_coloured;
            case (11):
                return R.drawable.rogue;
            default:
                return R.drawable.knight_coloured;
        }
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