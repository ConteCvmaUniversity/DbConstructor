package it.thewalkingthread.dbconstructor.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PokeType implements Parcelable{
    public PokeType(){

    }

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

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "typeName")
    private
    String name;

    @ColumnInfo(name = "url")
    private
    String url;

    protected PokeType(Parcel in) {
        name = in.readString();
        url = in.readString();
    }

    public static final Parcelable.Creator<PokeType> CREATOR = new Parcelable.Creator<PokeType>() {
        @Override
        public PokeType createFromParcel(Parcel in) {
            return new PokeType(in);
        }

        @Override
        public PokeType[] newArray(int size) {
            return new PokeType[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
    }
}
