package it.thewalkingthread.dbconstructor.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SimplePokemon implements Parcelable {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "url")
    String url;

    protected SimplePokemon(Parcel in) {

        name = in.readString();
        url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SimplePokemon> CREATOR = new Creator<SimplePokemon>() {
        @Override
        public SimplePokemon createFromParcel(Parcel in) {
            return new SimplePokemon(in);
        }

        @Override
        public SimplePokemon[] newArray(int size) {
            return new SimplePokemon[size];
        }
    };



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    SimplePokemon (){

    }

}
