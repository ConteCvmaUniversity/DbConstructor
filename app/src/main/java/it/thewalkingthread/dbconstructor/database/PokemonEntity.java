package it.thewalkingthread.dbconstructor.database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;


@Entity
public class PokemonEntity implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="pokeId")
    int idPoke;

    @ColumnInfo(name="name")
    String name;

    @ColumnInfo(name="type_1")
    String firstType;

    @ColumnInfo(name="type_2")
    String secondType;

    //PARCELABLE
    protected PokemonEntity(Parcel in) {
        idPoke = in.readInt();
        name = in.readString();
        firstType = in.readString();
        secondType = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idPoke);
        dest.writeString(name);
        dest.writeString(firstType);
        dest.writeString(secondType);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PokemonEntity> CREATOR = new Creator<PokemonEntity>() {
        @Override
        public PokemonEntity createFromParcel(Parcel in) {
            return new PokemonEntity(in);
        }

        @Override
        public PokemonEntity[] newArray(int size) {
            return new PokemonEntity[size];
        }
    };

    //END PARCELABLE
    public int getIdPoke() {
        return idPoke;
    }

    public void setIdPoke(int idPoke) {
        this.idPoke = idPoke;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getType(int slot) {
        if (slot == 1)
            return firstType;

        else
            return secondType;
    }

    public void setType(String type,int slot) {

        if (slot == 1)
            this.firstType = type;

        else
            this.secondType = type;
    }



    public PokemonEntity(){

    }


}



