package com.example.moviecatalog.list_film;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviecatalog.R;
import com.example.moviecatalog.detail_film.Detail_film;

import java.util.ArrayList;

public class ListFilm extends AppCompatActivity {
    public static final String SELECTED_FILM = "selected_film" ;
    private RecyclerView recyclerView;
    private ListFilmAdapter filmAdapter;
    private ArrayList<Film> listlist =new ArrayList<>();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_film);
        findView();
        setadapter();
    }

    private void findView() {
        recyclerView =(RecyclerView) findViewById(R.id.recycler_view);

    }

    private void setadapter(){
        listlist.add(new Film(getResources().getString(R.string.joker),getString(R.string.overview_joker),(R.drawable.poster_joker)));
        listlist.add(new Film(getResources().getString(R.string.dora),getString(R.string.overview_dora),(R.drawable.poster_dora)));
        listlist.add(new Film(getResources().getString(R.string.lion_king),getString(R.string.overview_lion),(R.drawable.poster_lionking)));
        listlist.add(new Film(getResources().getString(R.string.a_star_is_born),getString(R.string.overview_a_star_is_born),(R.drawable.poster_a_star)));
        listlist.add(new Film(getResources().getString(R.string.Aquaman),getString(R.string.overview_Aquaman),(R.drawable.poster_aquaman)));
        listlist.add(new Film(getResources().getString(R.string.Avengers_Infinity_War),getString(R.string.overview_Avengers_Infinity_War),(R.drawable.poster_avengerinfinity)));
        listlist.add(new Film(getResources().getString(R.string.Bird_Box),getString(R.string.overview_Bird_Box),(R.drawable.poster_birdbox)));
        listlist.add(new Film(getResources().getString(R.string.Bohemian_Rhapsody),getString(R.string.overview_Bohemian_Rhapsody),(R.drawable.poster_bohemian)));
        listlist.add(new Film(getResources().getString(R.string.Bumblebee),getString(R.string.overview_Bumblebee),(R.drawable.poster_bumblebee)));
        listlist.add(new Film(getResources().getString(R.string.Creed_II),getString(R.string.overview_Creed_II),(R.drawable.poster_creed)));
        listlist.add(new Film(getResources().getString(R.string.Once_Upon_a_Deadpool),getString(R.string.overview_Once_Upon_a_Deadpool),(R.drawable.poster_deadpool)));
        listlist.add(new Film(getResources().getString(R.string.How_to_Train_Your_Dragon_The_Hidden_World),getString(R.string.overview_How_to_Train_Your_Dragon_The_Hidden_World),(R.drawable.poster_dragon)));
        listlist.add(new Film(getResources().getString(R.string.Dragon_ball),getString(R.string.overview_Dragon_ball),(R.drawable.poster_dragonball)));
        listlist.add(new Film(getResources().getString(R.string.glass),getString(R.string.hunter_killer),(R.drawable.poster_hunterkiller)));
        listlist.add(new Film(getResources().getString(R.string.Marry_popins),getString(R.string.overview_Marry_popins),(R.drawable.poster_marrypopins)));
        listlist.add(new Film(getResources().getString(R.string.Mortal_Engine),getString(R.string.overview_Mortal_Engine),(R.drawable.poster_mortalengine)));
        listlist.add(new Film(getResources().getString(R.string.Preman),getString(R.string.overview_Preman),(R.drawable.poster_preman)));
        listlist.add(new Film(getResources().getString(R.string.Robin_hood),getString(R.string.overview_Robin_hood),(R.drawable.poster_robinhood)));
        listlist.add(new Film(getResources().getString(R.string.Spiderman),getString(R.string.overview_Spiderman),(R.drawable.poster_spiderman)));
        listlist.add(new Film(getResources().getString(R.string.the_girl),getString(R.string.overview_the_girl),(R.drawable.poster_thegirl)));
        listlist.add(new Film(getResources().getString(R.string.the_mule),getString(R.string.the_mule),(R.drawable.poster_themule)));
        listlist.add(new Film(getResources().getString(R.string.venom),getString(R.string.overview_venom),(R.drawable.poster_venom)));

        filmAdapter =new ListFilmAdapter(ListFilm.this,listlist);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager =new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(filmAdapter);

        filmAdapter.SerOnItemClickListener(new ListFilmAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Film film) {
                Intent moveDetail =new Intent(ListFilm.this, Detail_film.class);
                moveDetail.putExtra(ListFilm.SELECTED_FILM,film);
                startActivity(moveDetail);
            }
        });
    }
}
