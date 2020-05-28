package it.thewalkingthread.dbconstructor.database;


import androidx.room.Database;

import androidx.room.RoomDatabase;
import it.thewalkingthread.dbconstructor.model.PokeType;
import it.thewalkingthread.dbconstructor.model.SimplePokemon;


@Database(entities = {SimplePokemon.class}, version = 1)
public abstract class PokemonDb extends RoomDatabase {
    public abstract SimplePokemonDao simplePokemonDao();
}
