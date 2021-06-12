package com.example.archeologiewebservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class FranceAdapter extends RecyclerView.Adapter<FranceAdapter.HeroViewHolder> {


    private List<France> franceList;
    private Context context;

    private static int currentPosition = 20;

    public FranceAdapter(List<France> franceList, Context context) {
        this.franceList = franceList;
        this.context = context;
    }

    @Override
    public com.example.archeologiewebservice.FranceAdapter.HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout_sites, parent, false);
        return new com.example.archeologiewebservice.FranceAdapter.HeroViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final com.example.archeologiewebservice.FranceAdapter.HeroViewHolder holder, final int position) {
        France wine = franceList.get(position);
        holder.textViewLambertX.setText(wine.getLambert_X());
        holder.textViewLambertY.setText(wine.getLambert_Y());
        holder.textViewRegion.setText(wine.getRegion());
        holder.textViewDepartement.setText(wine.getDepartement());
        holder.textViewCommune.setText(wine.getCommune());
        holder.textViewNomDuSite.setText(wine.getNom_du_site());
        holder.textViewDateDebut.setText(wine.getDate_debut());
        holder.textViewDateFin.setText(wine.getDate_fin());
        holder.textViewPeriodes.setText(wine.getPeriodes());
        holder.textViewThemes.setText(wine.getThemes());
        holder.textViewTypeIntervention.setText(wine.getType_intervention());


        //toggling visibility
        holder.linearLayout.setVisibility(View.VISIBLE);



        holder.textViewNomDuSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getting the position of the item to expand it
                currentPosition = position;

                //reloding the list
                notifyDataSetChanged();
            }
        });


    }


    @Override
    public int getItemCount() {
        return franceList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {


        TextView textViewLambertX, textViewLambertY, textViewRegion, textViewDepartement, textViewCommune, textViewNomDuSite, textViewDateDebut, textViewDateFin, textViewPeriodes, textViewThemes, textViewTypeIntervention;
        LinearLayout linearLayout;

        HeroViewHolder(View itemView) {
            super(itemView);

//            id des champs dans list_layout_sites
            textViewLambertX = (TextView) itemView.findViewById(R.id.textViewLambertX);
            textViewLambertY = (TextView) itemView.findViewById(R.id.textViewLambertY);
            textViewRegion = (TextView) itemView.findViewById(R.id.textViewRegion);
            textViewDepartement = (TextView) itemView.findViewById(R.id.textViewDepartement);
            textViewCommune = (TextView) itemView.findViewById(R.id.textViewCommune);
            textViewNomDuSite = (TextView) itemView.findViewById(R.id.textViewNomDuSite);
            textViewDateDebut = (TextView) itemView.findViewById(R.id.textViewDateDebut);
            textViewDateFin = (TextView) itemView.findViewById(R.id.textViewDateFin);
            textViewPeriodes = (TextView) itemView.findViewById(R.id.textViewPeriodes);
            textViewThemes = (TextView) itemView.findViewById(R.id.textViewThemes);
            textViewTypeIntervention = (TextView) itemView.findViewById(R.id.textViewTypeIntervention);


            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
