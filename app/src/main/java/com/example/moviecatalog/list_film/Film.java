package com.example.moviecatalog.list_film;

import android.os.Parcel;
import android.os.Parcelable;



public class Film implements Parcelable {

    public Film(){

    }

    public String getTitle() {
        return title;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }


    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Integer getPoster() {
        return poster;
    }

    public void setPoster(Integer poster) {
        this.poster = poster;
    }



    public Film(String title, String overview, Integer poster){
        this.title =title;
        this.overview =overview;
        this.poster =poster ;
    }


    private String title;
    private String overview;
    private Integer poster;





    protected Film(Parcel in) {
        this.title =in.readString();
        this.overview=in.readString();
        this.poster=(Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.overview);
        dest.writeValue(this.poster);
    }
}
