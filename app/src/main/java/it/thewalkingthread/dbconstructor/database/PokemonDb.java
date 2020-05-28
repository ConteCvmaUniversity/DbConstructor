package it.thewalkingthread.dbconstructor.database;


import androidx.room.Database;

import androidx.room.RoomDatabase;
import it.thewalkingthread.dbconstructor.model.PokeType;


@Database(entities = {PokemonEntity.class, PokeType.class}, version = 1)
public abstract class PokemonDb extends RoomDatabase {
    public abstract PokemonDao pokemonDao();
}
