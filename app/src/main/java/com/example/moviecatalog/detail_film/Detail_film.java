package com.example.moviecatalog.detail_film;

import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.moviecatalog.R;
import com.example.moviecatalog.list_film.Film;
import com.example.moviecatalog.list_film.ListFilm;

public class Detail_film extends AppCompatActivity {
    private TextView texttitle,textoveview;
    private ImageView imagefilm;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);
        texttitle=findViewById(R.id.text_title);
        textoveview=findViewById(R.id.text_overview);
        imagefilm=findViewById(R.id.imagefilm);
        Film filmModel =getIntent().getParcelableExtra(ListFilm.SELECTED_FILM);
        texttitle.setText(filmModel.getTitle());
        textoveview.setText(filmModel.getOverview());
        imagefilm.setImageResource(filmModel.getPoster());
        setTitle(filmModel.getTitle());

    }
}
