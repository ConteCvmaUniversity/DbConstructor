package it.thewalkingthread.dbconstructor.database;


import androidx.room.Database;

import androidx.room.RoomDatabase;



@Database(entities = {PokemonEntity.class,PokeTypeEntity.class}, version = 1)
public abstract class PokemonDb extends RoomDatabase {
    public abstract PokemonDao pokemonDao();
}
