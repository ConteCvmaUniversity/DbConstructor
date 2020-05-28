package it.thewalkingthread.dbconstructor.database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PokeTypeEntity implements Parcelable {

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

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "typeName")
    private
    String name;

    @ColumnInfo(name = "url")
    private
    String url;

    protected PokeTypeEntity(Parcel in) {
        name = in.readString();
        url = in.readString();
    }

    public static final Creator<PokeTypeEntity> CREATOR = new Creator<PokeTypeEntity>() {
        @Override
        public PokeTypeEntity createFromParcel(Parcel in) {
            return new PokeTypeEntity(in);
        }

        @Override
        public PokeTypeEntity[] newArray(int size) {
            return new PokeTypeEntity[size];
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
