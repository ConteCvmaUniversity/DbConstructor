package it.thewalkingthread.dbconstructor.database;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import it.thewalkingthread.dbconstructor.model.SimplePokemon;

@Dao
public interface SimplePokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<SimplePokemon> pokemons);

}
