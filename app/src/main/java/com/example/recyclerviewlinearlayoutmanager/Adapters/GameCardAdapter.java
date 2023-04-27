package com.example.recyclerviewlinearlayoutmanager.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewlinearlayoutmanager.Models.GameCardModel;
import com.example.recyclerviewlinearlayoutmanager.R;

import java.util.ArrayList;

public class GameCardAdapter extends RecyclerView.Adapter<GameCardAdapter.viewHolder> {
    Context ctx;
    public ArrayList<GameCardModel> games;

    public GameCardAdapter(Context ctx, ArrayList<GameCardModel> games) {
        this.ctx = ctx;
        this.games = games;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holder= LayoutInflater.from(ctx).inflate(R.layout.movie_card_item,parent,false);
        return new viewHolder(holder);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        GameCardModel obj=games.get(position);
        holder.gameName.setText(obj.getGameName());
        holder.gameImage.setImageResource(obj.getGameImage());

    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public  class viewHolder extends RecyclerView.ViewHolder{
        ImageView gameImage;
        TextView gameName;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            gameImage=itemView.findViewById(R.id.gameImage);
            gameName=itemView.findViewById(R.id.textView);

//            Below Code is For OnItemTouchListener
            Context clickContext=itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    GameCardModel model= games.get(position);
                    Toast.makeText(v.getContext(),"onClick Working, Item Touched is"+model.getGameName(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
