package com.example.moviecatalog.list_film;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviecatalog.R;

import java.util.ArrayList;

public class ListFilmAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Film>films;
    private OnItemClickListener onItemClickListener;

    public ListFilmAdapter(Context context,ArrayList<Film> films){
        this.context =context;
        this.films = films;
    }
    public void updatelist(ArrayList<Film> films){
        this.films =films;
        notifyDataSetChanged();
    }




    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film_list,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder,final int position) {
        if (holder instanceof ViewHolder) {
            final Film model =getItem(position);
            ViewHolder generic = (ViewHolder) holder;

            generic.itemTxtTitle.setText(model.getTitle());


            if (model.getOverview().length()>50){
                generic.itemTxtOverview.setText(model.getOverview().substring(0,49)+"...");
            }else {
                generic.itemTxtOverview.setText(model.getOverview());
            }
                generic.imgPoster.setImageResource(model.getPoster());
            }
        }



    @Override
    public int getItemCount() {
        return films.size() ;
    }
    public void SerOnItemClickListener(final OnItemClickListener monItemClickListener){
        this.onItemClickListener =monItemClickListener;
    }
    private Film getItem(int position){
        return films.get(position);
    }
    public interface OnItemClickListener {
        void onItemClick(View view,int position,Film film);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPoster;
        private TextView itemTxtTitle;
        private TextView itemTxtOverview;

        public ViewHolder(final View itemView){
            super(itemView);

            this.imgPoster=itemView.findViewById(R.id.foto);
            this.itemTxtTitle =itemView.findViewById(R.id.judulfilm);
            this.itemTxtOverview=itemView.findViewById(R.id.item_overview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(itemView,getAdapterPosition(),films.get(getAdapterPosition()));
                }
            });


        }
    }
}
