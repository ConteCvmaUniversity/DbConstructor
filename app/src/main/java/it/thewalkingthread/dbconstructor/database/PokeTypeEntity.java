package it.thewalkingthread.dbconstructor.database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class PokeTypeEntity implements Parcelable {
    protected PokeTypeEntity(Parcel in) {
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
    }

    //@ColumnInfo
}
